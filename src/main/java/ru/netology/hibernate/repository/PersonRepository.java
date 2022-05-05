package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.domain.Person;

/**
 * PersonRepository
 *
 * @author Viktor_Loskutov
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}