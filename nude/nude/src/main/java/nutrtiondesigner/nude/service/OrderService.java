package nutrtiondesigner.nude.service;

import lombok.RequiredArgsConstructor;
import nutrtiondesigner.nude.model.domain.Item;
import nutrtiondesigner.nude.model.domain.OrderItem;
import nutrtiondesigner.nude.model.domain.Orders;
import nutrtiondesigner.nude.model.domain.User;
import nutrtiondesigner.nude.model.dto.item.ItemDto;
import nutrtiondesigner.nude.model.dto.item.ItemInsertDto;
import nutrtiondesigner.nude.model.dto.order.*;
import nutrtiondesigner.nude.repository.ItemRepository;
import nutrtiondesigner.nude.repository.OrderItemRepository;
import nutrtiondesigner.nude.repository.OrdersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;
    private final UserService userService;

    @Transactional
    public void insertOrder(OrderInsertDto orderInsertDto) {
        User user = userService.getMyUserWithAuthorities().get();
        Orders orders = new Orders(user, orderInsertDto.getPrice());
        ordersRepository.save(orders);

        /**
         * TODO: 아래와 같이 코드를 짜면 쿼리가 여러번 수행됨.
         * 어떻게 개선할 수 있을까? 조회쿼리 때문에 벌크성 쿼리도 수행할 수 없다.
         */
        List<ItemInsertDto> codeList = orderInsertDto.getCodeList();
        for (ItemInsertDto order : codeList) {
            Item item = itemRepository.findById(order.getItemCode()).orElse(null);
            OrderItem orderItem = new OrderItem(orders, item, order.getQuantity());
            orderItemRepository.save(orderItem);
        }
    }

    public List<OrderListDto> getOrderList() {
        User user = userService.getMyUserWithAuthorities().get();
        PageRequest pageRequest = PageRequest.of(0, 4);
        Page<Orders> ordersList = ordersRepository.findByUserId(user.getId(), pageRequest);

        Page<OrderListDto> ordersDtoList = ordersList.map(o -> new OrderListDto(o));

        return ordersDtoList.getContent();
    }

    public OrderDetailDto getOrderDetail(Long ordercode) {
        User user = userService.getMyUserWithAuthorities().get();
        Orders orders = ordersRepository.findByCodeAndUserId(ordercode, user.getId()).orElse(null);
        PageRequest pageRequest = PageRequest.of(0, 4);
        Page<OrderItem> orderItems = orderItemRepository.findFetchJoinByOrderCode(ordercode, pageRequest);

        Page<ItemDto> itemList = orderItems.map(o -> new ItemDto(o.getItem(), o.getQuantity()));

        OrderDetailDto orderDetailDto = new OrderDetailDto(orders, itemList);

        return orderDetailDto;
    }

    @Transactional
    public void updateOrderStatus(OrderStatusDto orderStatusDto) {
        Orders orders = ordersRepository.findById(orderStatusDto.getOrderCode()).orElse(null);
        orders.updateStatus(orderStatusDto);
    }
}
