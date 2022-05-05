package ru.netology.hibernate.controller;

import static java.lang.String.format;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import ru.netology.hibernate.domain.Person;
import ru.netology.hibernate.service.PersonService;

import java.util.List;
import java.util.Objects;

/**
 * api для работы с пользователями
 *
 * @author Viktor_Loskutov
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RequestMapping("/persons")
@RestController
public class PersonController {

    PersonService personService;

    @GetMapping("{id}")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        var result = personService.get(id);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping
    public ResponseEntity<Person> add(@RequestBody Person person, UriComponentsBuilder componentsBuilder) {
        var result = personService.add(person);
        var uri = componentsBuilder.path(format("persons/%s", result.getId())).buildAndExpand(result).toUri();
        return ResponseEntity.created(uri).body(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> update(@RequestBody Person person, @PathVariable("id") Long id) {
        if (!Objects.equals(id, person.getId())) {
            throw new IllegalArgumentException(format("id=%s: expected same as %s", person.getId(), id));
        }
        var result = personService.update(person);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<Person>> getPersonsByCity(String city) {
        var result = personService.getPersonsByCity(city);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/by-age")
    public ResponseEntity<List<Person>> getPersonsByAge(int age) {
        var result = personService.getPersonsByAge(age);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/by-name-surname")
    public ResponseEntity<List<Person>> getPersonsByNameSurname(String name, String surname) {
        var result = personService.getPersonsByNameSurname(name, surname);
        return ResponseEntity.ok().body(result);
    }
}