package own.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import own.login.domain.Item;
import own.login.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item findById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item update(Item item) {
        return itemRepository.update(item);
    }

    public void delete(Long id) {
        itemRepository.delete(id);
    }

//    deleteAll는 컨트롤러에서 사용하지 못하도록 할 것이므로 구현 X
}
