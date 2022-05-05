package ru.netology.hibernate.service;

import static java.lang.String.format;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.hibernate.domain.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

/**
 * Реализация сервиса для работы с пользователями (ru.netology.hibernate.service.PersonService)
 *
 * @author Viktor_Loskutov
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    @Override
    @Transactional(readOnly = true)
    public Person get(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(format("Пользователь %s не найден!", id)));
    }

    @Override
    public Person add(Person person) {
        return Optional.of(person)
                .map(personRepository::save)
                .orElseThrow(() -> new RuntimeException("Что-то произошло"));
    }

    @Override
    public Person update(Person person) {
        return Optional.of(person)
                .map(Person::getId)
                .map(personRepository::getById)
                .map(value -> setPerson(value, person))
                .map(personRepository::save)
                .orElseThrow(() -> new RuntimeException(format("Пользователь %s не найден!", person.getId())));
    }

    private Person setPerson(Person person, Person updatePerson) {
        return person
                .setId(updatePerson.getId())
                .setName(updatePerson.getName())
                .setSurname(updatePerson.getSurname())
                .setAge(updatePerson.getAge())
                .setCityOfLiving(updatePerson.getCityOfLiving())
                .setPhoneNumber(updatePerson.getPhoneNumber());
    }

    @Override
    public boolean delete(Long id) {
        personRepository.deleteById(id);
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> getPersonsByCity(String city) {
        return Optional.of(personRepository.findByCityOfLiving(city))
                .filter(personList -> !personList.isEmpty())
                .orElseThrow(() -> new RuntimeException(format("Пользователей из г. \"%s\" не найдено!", city)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> getPersonsByAge(int age) {
        return Optional.of(personRepository.findByAgeLessThanOrderByAge(age))
                .filter(personList -> !personList.isEmpty())
                .orElseThrow(() -> new RuntimeException(format("Пользователей младше %s лет не найдено!", age)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> getPersonsByNameSurname(String name, String surname) {
        return Optional.of(personRepository.findByNameAndSurname(name, surname))
                .filter(personList -> !personList.isEmpty())
                .orElseThrow(() -> new RuntimeException(format("Пользователей с именем %s и фамилией %s не найдено!", name, surname)));
    }
}