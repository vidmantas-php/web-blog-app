package lt.web.demo.services;

import java.math.BigDecimal;
import java.util.List;

import lt.web.demo.controller.ItemNotFoundException;
import lt.web.demo.entities.Item;
import lt.web.demo.repositories.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Product was not found"));
        return item;
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item createOrUpdateItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Page<Item> getAllItemsPaginated(int pageNumber, BigDecimal itemValue) {
        Pageable pageable = PageRequest.of(pageNumber, 8);
        if (itemValue != null) {
            return itemRepository.getAllByItemValue(itemValue, pageable);
        }
        return itemRepository.findAll(pageable);
    }
}
