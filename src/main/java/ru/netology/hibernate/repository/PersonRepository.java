package ru.netology.hibernate.repository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * PersonRepository
 *
 * @author Viktor_Loskutov
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Repository
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Person> findPersonsByCity(String city) {
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
                .setParameter("city", city)
                .getResultList();
    }
}