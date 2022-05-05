package ru.netology.hibernate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.netology.hibernate.domain.Person;

/**
 * api для работы с сотрудниками
 *
 * @author Viktor_Loskutov
 */
@RequestMapping("/persons")
public interface PersonController {

    @GetMapping("get/{id}")
    ResponseEntity<Person> get(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Person> add(@RequestBody Person person, UriComponentsBuilder componentsBuilder);

    @PutMapping("{id}")
    ResponseEntity<Person> update(@RequestBody Person person, @PathVariable("id") Long id);

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}