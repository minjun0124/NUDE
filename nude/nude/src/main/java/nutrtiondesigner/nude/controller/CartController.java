package nutrtiondesigner.nude.controller;

import lombok.RequiredArgsConstructor;
import nutrtiondesigner.nude.model.dto.CartInsertDto;
import nutrtiondesigner.nude.model.dto.CartItemDto;
import nutrtiondesigner.nude.model.dto.CartListDto;
import nutrtiondesigner.nude.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity getCarts(){
        CartListDto cartList = cartService.getUserCart();

        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

}
