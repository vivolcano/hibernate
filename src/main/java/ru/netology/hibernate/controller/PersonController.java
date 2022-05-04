package ru.netology.hibernate.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.domain.Person;
import ru.netology.hibernate.service.PersonService;

import java.util.List;

/**
 * api для работы с пользователями
 *
 * @author Viktor_Loskutov
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RequestMapping
@RestController
public class PersonController {

    PersonService personService;

    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Person>> getPersons(String city) {
        var result = personService.getPersonsByCity(city);
        return ResponseEntity.ok().body(result);
    }
}