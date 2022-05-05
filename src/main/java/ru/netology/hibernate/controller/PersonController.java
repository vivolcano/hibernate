package ru.netology.hibernate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.netology.hibernate.domain.Person;

import javax.annotation.security.RolesAllowed;

/**
 * api для работы с сотрудниками
 *
 * @author Viktor_Loskutov
 */
@RequestMapping("/persons")
public interface PersonController {

    @Secured("ROLE_READ")
    @GetMapping("get/{id}")
    ResponseEntity<Person> get(@PathVariable Long id);

    @RolesAllowed("ROLE_WRITE")
    @PostMapping("add")
    ResponseEntity<Person> add(@RequestBody Person person, UriComponentsBuilder componentsBuilder);

    @RolesAllowed("ROLE_WRITE")
    @PutMapping("update/{id}")
    ResponseEntity<Person> update(@RequestBody Person person, @PathVariable("id") Long id);

    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    @DeleteMapping("delete/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @GetMapping("/methods/check")
    @PreAuthorize("#username == authentication.principal.username")
    String checkUser(String username);
}