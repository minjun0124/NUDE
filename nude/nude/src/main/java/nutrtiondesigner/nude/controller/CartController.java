package nutrtiondesigner.nude.controller;

import lombok.RequiredArgsConstructor;
import nutrtiondesigner.nude.model.dto.CartInsertDto;
import nutrtiondesigner.nude.model.dto.CartListDto;
import nutrtiondesigner.nude.model.dto.UpdateCartDto;
import nutrtiondesigner.nude.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity insertCart(@RequestBody CartInsertDto cartInsertDto){
        cartService.insertCart(cartInsertDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity cartsList(){
        CartListDto cartList = cartService.getUserCart();

        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity updateCartItem(@RequestBody UpdateCartDto updateCartDto){
        cartService.updateCartItem(updateCartDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
