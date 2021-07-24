package nutrtiondesigner.nude.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nutrtiondesigner.nude.model.dto.ItemDto;
import nutrtiondesigner.nude.model.form.ItemUpLoadForm;
import nutrtiondesigner.nude.service.ItemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Value("${spring.servlet.multipart.location}")
    String filePath;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity upload(ItemUpLoadForm upLoadForm) throws Exception {
        itemService.upload(upLoadForm);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity categoryItem(@PathVariable("category") String category) {
        Page<ItemDto> itemDtoPage = itemService.getCategoryItems(category);

        return new ResponseEntity<>(itemDtoPage.getContent(), HttpStatus.OK);
    }


}
