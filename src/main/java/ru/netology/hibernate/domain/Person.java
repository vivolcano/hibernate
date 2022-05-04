package ru.netology.hibernate.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Представление сущности пользователя в системе
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
     * Имя пользователя
     */
    @Id
    @Column(nullable = false)
    String name;

    /**
     * Фамилия пользователя
     */
    @Id
    @Column(nullable = false)
    String surname;

    /**
     * Возраст пользователя
     */
    @Id
    @Column(nullable = false)
    int age;

    /**
     * Телефон пользователя
     */
    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    /**
     * Город проживания пользователя
     */
    @Column(name = "city_of_living", nullable = false)
    String cityOfLiving;
}