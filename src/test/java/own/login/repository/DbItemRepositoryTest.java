package own.login.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import own.login.domain.Item;


import java.util.List;


@SpringBootTest
class DbItemRepositoryTest {

    @Autowired
    private DbItemRepository itemRepository;

    @AfterEach
    void after() {
        itemRepository.deleteAll();
    }

    @Test
    void findById() {

        // given
        Item item = new Item();
        item.setName("item1");
        Item savedItem = itemRepository.save(item);

        // when
        Item findItem = itemRepository.findById(savedItem.getId());

        // then
        Assertions.assertThat(findItem.getName()).isEqualTo(savedItem.getName());
    }


    @Test
    void findAll() {

        // given
        Item item = new Item();
        item.setName("item1");
        Item item2 = new Item();

        // when
        itemRepository.save(item);
        itemRepository.save(item2);
        List<Item> items = itemRepository.findAll();

        //then
        Assertions.assertThat(items.size()).isEqualTo(2);

    }

    @Test
    void update() {

        // given
        Item item = new Item();
        item.setName("item1");
        Item savedItem = itemRepository.save(item);

        // when
        savedItem.setName("newName");
        Item updatedItem = itemRepository.update(savedItem);

        // then
        Assertions.assertThat(updatedItem.getName()).isEqualTo("newName");

    }

    @Test
    void delete() {

        // given
        Item item = new Item();
        item.setName("item1");
        Item savedItem = itemRepository.save(item);

        // when
        itemRepository.delete(savedItem.getId());
        Item findItem = itemRepository.findById(savedItem.getId());

        // then
        Assertions.assertThat(findItem).isNull();
    }
}