package own.login.repository;

import own.login.domain.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class DbItemRepository implements ItemRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public Item save(Item item) {
        em.persist(item);
        return item;
    }

    @Override
    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

    @Override
    @Transactional
    public Item update(Item item) {
        Item findItem = em.find(Item.class, item.getId());
        findItem.setItem(item);
        return findItem;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        em.createQuery("delete from Item i where i.id = :id").setParameter("id", id);
        // 궁금증 : remove는 1차 캐시에 들어있는 것을 삭제하는 것인지?
    }
}
