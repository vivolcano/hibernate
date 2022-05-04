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
     * Получение информации по сотруднику(ам) из выбранного города
     *
     * @param city город пользователя
     * @return список пользователей
     */
    List<Person> getPersonsByCity(String city);
}