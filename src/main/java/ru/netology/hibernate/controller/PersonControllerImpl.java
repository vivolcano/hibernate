package ru.netology.hibernate.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.netology.hibernate.domain.Person;
import ru.netology.hibernate.service.PersonService;

import java.util.Objects;

import static java.lang.String.format;

/**
 * Реализация api для работы с сотрудниками {@link PersonController}
 *
 * @author Viktor_Loskutov
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RestController
public class PersonControllerImpl implements PersonController {

    PersonService personService;

    public ResponseEntity<Person> get(Long id) {
        var result = personService.get(id);
        return ResponseEntity.ok().body(result);
    }

    public ResponseEntity<Person> add(Person person, UriComponentsBuilder componentsBuilder) {
        var result = personService.add(person);
        var uri = componentsBuilder.path(
                format("persons/%s", result.getId())).buildAndExpand(result).toUri();
        return ResponseEntity.created(uri).body(result);
    }

    public ResponseEntity<Person> update(Person person, Long id) {
        if (!Objects.equals(id, person.getId())) {
            throw new IllegalArgumentException(
                    format("id=%s: expected same as %s", person.getId(), id));
        }
        var result = personService.update(person);
        return ResponseEntity.ok().body(result);
    }

    public ResponseEntity<Void> delete(Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/methods/check")
    @PreAuthorize("#username == authentication.principal.username")
    public String checkUser(String username) {
        return "User checked!";
    }
}