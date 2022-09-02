package own.login.service;

import own.login.domain.Item;

import java.util.List;

public interface ItemService {

    public Item save(Item item);

    public Item findById(Long id);

    public List<Item> findAll();

    public Item update(Item item);

    public void delete(Long id);
}
