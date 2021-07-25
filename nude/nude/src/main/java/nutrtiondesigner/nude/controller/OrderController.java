package nutrtiondesigner.nude.controller;

import lombok.RequiredArgsConstructor;
import nutrtiondesigner.nude.model.dto.OrderInsertDto;
import nutrtiondesigner.nude.model.dto.OrderListDto;
import nutrtiondesigner.nude.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity insertOrder(@RequestBody OrderInsertDto orderInsertDto) {
        orderService.insertOrder(orderInsertDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity orderList() {
        List<OrderListDto> orderList = orderService.getOrderList();

        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

}
