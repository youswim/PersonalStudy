package own.login.repository;

import own.login.domain.Item;
import own.login.domain.Member;

import java.util.List;

public interface ItemRepository {

    // 생성
    public Item save(Item item);

    // 조회
    public Item findById(Long id);
    public List<Item> findAll();

    // 수정
    public Item update(Item item);

    // 삭제
    public void delete(Long id);
}
