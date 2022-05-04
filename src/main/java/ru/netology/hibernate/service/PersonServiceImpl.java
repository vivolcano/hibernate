package ru.netology.hibernate.service;

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

    @Transactional(readOnly = true)
    @Override
    public List<Person> getPersonsByCity(String city) {
        return Optional.of(personRepository.findPersonsByCity(city))
                .filter(personList -> !personList.isEmpty())
                .orElseThrow(() -> new RuntimeException(String.format("Пользователей из г. \"%s\" не найдено!", city)));
    }
}