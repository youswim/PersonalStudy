package own.login.repository;

import org.springframework.stereotype.Repository;
import own.login.domain.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
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
        String jpql = "delete from Item i where i.id = :id";
        em.createQuery(jpql).setParameter("id", id).executeUpdate();
    }

    @Override
    @Transactional
    public void deleteAll() {
        String jpql = "delete from Item i";
        em.createQuery(jpql).executeUpdate();
    }
}
