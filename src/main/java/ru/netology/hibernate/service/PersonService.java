package ru.netology.hibernate.service;

import ru.netology.hibernate.domain.Person;

import java.util.List;

/**
 * Сервис для работы с пользователями
 *
 * @author Viktor_Loskutov
 */
public interface PersonService {

    /**
     * Получение информации по пользователю
     *
     * @param id Идентификатор пользователя
     * @return dto пользователя
     */
    Person get(Long id);

    /**
     * Добавление нового пользователя
     *
     * @param person с параметрами для создания пользователя
     * @return пользователь
     */
    Person add(Person person);

    /**
     * Обновление пользователя
     *
     * @param person с параметрами для обновления пользователя
     * @return пользователь
     */
    Person update(Person person);

    /**
     * Удаление пользователя
     *
     * @param id Идентификатор пользователя
     */
    boolean delete(Long id);

    /**
     * Получение информации по пользователю(ям) из выбранного города
     *
     * @param city город пользователя
     * @return список пользователей
     */
    List<Person> getPersonsByCity(String city);

    /**
     * Получение информации по пользователю(ям)
     * с возрастом меньше переданного и отсортированы по возрастанию
     *
     * @param age возраст пользователя
     * @return список пользователей
     */
    List<Person> getPersonsByAge(int age);

    /**
     * Получение информации по пользователю(ям) с выбранными фамилией и именем
     *
     * @param name имя пользователя
     * @param surname фамилия пользователя
     *
     * @return список пользователей
     */
    List<Person> getPersonsByNameSurname(String name, String surname);
}