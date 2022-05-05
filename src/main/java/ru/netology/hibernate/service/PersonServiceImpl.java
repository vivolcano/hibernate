package ru.netology.hibernate.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.hibernate.domain.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.Optional;

import static java.lang.String.format;

/**
 * Реализация сервиса для работы с сотрудниками {@link PersonService}
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
                .orElseThrow(() -> new RuntimeException(
                        format("Сотрудник %s не найден!", id)));
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
                .orElseThrow(() -> new RuntimeException(
                        format("Сотрудник %s не найден!", person.getId())));
    }

    @Override
    public boolean delete(Long id) {
        personRepository.deleteById(id);
        return true;
    }

    private Person setPerson(Person person, Person updatePerson) {
        return person.setId(updatePerson.getId())
                .setName(updatePerson.getName())
                .setSurname(updatePerson.getSurname())
                .setAge(updatePerson.getAge())
                .setCityOfLiving(updatePerson.getCityOfLiving())
                .setPhoneNumber(updatePerson.getPhoneNumber());
    }
}