package nutrtiondesigner.nude.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nutrtiondesigner.nude.model.domain.Category;
import nutrtiondesigner.nude.model.domain.CategoryItem;
import nutrtiondesigner.nude.model.domain.Item;
import nutrtiondesigner.nude.model.dto.item.ItemDto;
import nutrtiondesigner.nude.model.form.ItemUpLoadForm;
import nutrtiondesigner.nude.repository.CategoryItemRepository;
import nutrtiondesigner.nude.repository.CategoryRepository;
import nutrtiondesigner.nude.repository.ItemRepository;
import nutrtiondesigner.nude.util.FileUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryItemRepository categoryItemRepository;

    @Transactional
    public void upload(ItemUpLoadForm upLoadForm) throws IOException {
        String imgPath = FileUtil.uploadImage(upLoadForm.getImg());
        Item item = upLoadForm.toEntity(imgPath);

        itemRepository.save(item);

        Category category = categoryRepository.findByName(upLoadForm.getCategory());
        CategoryItem categoryItem = new CategoryItem(category, item);
        categoryItemRepository.save(categoryItem);

    }

    @Transactional
    public void modItem(ItemUpLoadForm changeForm) throws IOException {
        String imgPath = FileUtil.uploadImage(changeForm.getImg());
        Item changeItem = changeForm.toEntity(imgPath);

        Item item = itemRepository.findById(changeForm.getItemCode()).orElse(null);

        item.updateInfo(changeItem);

        categoryItemRepository.deleteAllByItemCode(item.getCode());

        Category category = categoryRepository.findByName(changeForm.getCategory());
        CategoryItem categoryItem = new CategoryItem(category, item);
        categoryItemRepository.save(categoryItem);
    }

    public Page<ItemDto> getCategoryItems(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);

        PageRequest pageRequest = PageRequest.of(0, 15/*, Sort.by(Sort.Direction.DESC, "item_code")*/);
        Page<CategoryItem> categoryItems = itemRepository.findByCategory(category.getCode(), pageRequest);
        Page<ItemDto> itemDtoPage = categoryItems.map(c -> new ItemDto(c.getItem(), categoryName));

        return itemDtoPage;
    }

    public Page<ItemDto> getBestItems() {
        PageRequest pageRequest = PageRequest.of(0, 15, Sort.by(Sort.Direction.DESC, "rating"));
        Page<Item> bestItems = itemRepository.findAll(pageRequest);
        Page<ItemDto> itemDtoPage = bestItems.map(i -> new ItemDto(i));

        return itemDtoPage;
    }

    public Page<ItemDto> getNewItems() {
        PageRequest pageRequest = PageRequest.of(0, 15, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Item> newItems = itemRepository.findAllByCreatedDateBetween(LocalDateTime.now().minusDays(7), LocalDateTime.now(), pageRequest);
        Page<ItemDto> itemDtoPage = newItems.map(i -> new ItemDto(i));

        return itemDtoPage;
    }

    public Item getByCode(Long code) {
        return itemRepository.findById(code).orElse(null);
    }
}
