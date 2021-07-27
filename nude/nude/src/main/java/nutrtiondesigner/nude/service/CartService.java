package nutrtiondesigner.nude.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nutrtiondesigner.nude.model.domain.*;
import nutrtiondesigner.nude.model.dto.*;
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
    public void insertCart(CartInsertDto cartInsertDto) {
        User user = userService.getMyUserWithAuthorities().get();
        log.info("testestest : " + cartInsertDto.getItemCode());
        Item item = itemService.getByCode(cartInsertDto.getItemCode());

        int quantity = cartInsertDto.getQuantity();
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
        Page<ItemDetailDto> itemList = cartItems.map(c -> new ItemDetailDto(c.getItem(), c.getQuantity()));

        CartListDto cartList = new CartListDto(cart.getCode(), itemList.getContent(), cart.getPrice());

        return cartList;
    }

    public void updateCartItem(UpdateCartDto updateCartDto) {
        CartItem cartItem = cartItemRepository.findByCartCodeAndItemCode(updateCartDto.getCartcode(), updateCartDto.getItemcode()).orElse(null);
        cartItem.updateQuantity(updateCartDto.getQuantity());
    }

    public void deleteCartItem(DeleteCartDto deleteCartDto) {
        cartItemRepository.deleteAllByCartCodeAndItemCodes(deleteCartDto.getCartcode(), deleteCartDto.getItemcodes());
    }
}
