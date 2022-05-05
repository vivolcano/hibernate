package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.domain.Person;

import java.util.List;

/**
 * PersonRepository
 *
 * @author Viktor_Loskutov
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);

    List<Person> findByAgeLessThanOrderByAge(@Param("age") int age);

    List<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    Person findPersonById(Long id);
}