package nutrtiondesigner.nude.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nutrtiondesigner.nude.model.domain.*;
import nutrtiondesigner.nude.model.dto.item.ItemDto;
import nutrtiondesigner.nude.model.dto.item.ItemInsertDto;
import nutrtiondesigner.nude.model.dto.cart.CartListDto;
import nutrtiondesigner.nude.model.dto.cart.DeleteCartDto;
import nutrtiondesigner.nude.model.dto.cart.UpdateCartDto;
import nutrtiondesigner.nude.repository.CartItemRepository;
import nutrtiondesigner.nude.repository.CartRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CartService {

    private final UserService userService;
    private final ItemService itemService;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    /**
     * @Transactional 필요.
     * 메소드를 수행하는 동안 Transaction을 유지해야
     * 1차 캐시를 통해 변경감지를 사용할 수 있다.
     */
    public void insertCart(ItemInsertDto itemInsertDto) {
        User user = userService.getMyUserWithAuthorities().get();
        log.info("testestest : " + itemInsertDto.getItemCode());
        Item item = itemService.getByCode(itemInsertDto.getItemCode());

        int quantity = itemInsertDto.getQuantity();
        int insertPrice = item.getPrice() * quantity;

        Optional<Cart> cartOptional = cartRepository.findByUserId(user.getId());
        Cart cart = cartOptional.get();
        cart.changePrice(cart.getPrice() + insertPrice);
        CartItem cartItem = new CartItem(cart, item, quantity);
        cartItemRepository.save(cartItem);
    }

    @Transactional(readOnly = true)
    public CartListDto getUserCart() {
        User user = userService.getMyUserWithAuthorities().get();
        Cart cart = cartRepository.findByUserId(user.getId()).get();

        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<CartItem> cartItems = cartRepository.findFetchJoinItemByCode(cart.getCode(), pageRequest);
        Page<ItemDto> itemList = cartItems.map(c -> new ItemDto(c.getItem(), c.getQuantity()));

        CartListDto cartList = new CartListDto(cart.getCode(), itemList.getContent(), cart.getPrice());

        return cartList;
    }

    public void updateCartItem(UpdateCartDto updateCartDto) {
        CartItem cartItem = cartItemRepository.findByCartCodeAndItemCode(updateCartDto.getCartCode(), updateCartDto.getItemCode()).orElse(null);
        cartItem.updateQuantity(updateCartDto.getQuantity());
    }

    public void deleteCartItem(DeleteCartDto deleteCartDto) {
        cartItemRepository.deleteAllByCartCodeAndItemCodes(deleteCartDto.getCartCode(), deleteCartDto.getItemCodes());
    }
}
