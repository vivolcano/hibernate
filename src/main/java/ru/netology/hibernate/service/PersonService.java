package ru.netology.hibernate.service;

import ru.netology.hibernate.domain.Person;

/**
 * Сервис для работы с сотрудниками
 *
 * @author Viktor_Loskutov
 */
public interface PersonService {

    /**
     * Получение информации по сотруднику
     *
     * @param id Идентификатор сотрудника
     * @return сотрудник
     */
    Person get(Long id);

    /**
     * Добавление нового сотрудника
     *
     * @param person с параметрами для создания сотрудника
     * @return сотрудник
     */
    Person add(Person person);

    /**
     * Обновление сотрудника
     *
     * @param person с параметрами для обновления сотрудника
     * @return сотрудник
     */
    Person update(Person person);

    /**
     * Удаление сотрудник
     *
     * @param id Идентификатор сотрудника
     */
    boolean delete(Long id);
}