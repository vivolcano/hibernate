package ru.netology.hibernate.domain;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Представление сущности сотрудника в системе
 *
 * @author Viktor_Loskutov
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "persons")
public class Person implements Serializable {

    private static final long serialVersionUID = -7931737332647464539L;

    /**
     * Уникальный идентификатор сотрудника
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    /**
     * Фамилия сотрудника
     */
    @Column(nullable = false)
    String name;

    /**
     * Фамилия сотрудника
     */
    @Column(nullable = false)
    String surname;

    /**
     * Возраст сотрудника
     */
    @Column(nullable = false)
    Integer age;

    /**
     * Телефон сотрудника
     */
    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    /**
     * Город проживания сотрудника
     */
    @Column(name = "city_of_living", nullable = false)
    String cityOfLiving;
}