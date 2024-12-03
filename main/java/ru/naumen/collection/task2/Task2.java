package ru.naumen.collection.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно реализовать метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 *
 * См. {@link User}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task2
{

    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        //ArrayList - добавление элемента за O(1)
        //Поиск тут не нужен, поэтому все хорошо
        List<User> foundDuplicatesUsers = new ArrayList<>();
        //Выбираем HashSet из-за оптимального поиска элемента
        //Создание O(n), где n - количество элементов в коллекции collB
        Set<User> hashSetB = new HashSet<>(collB);
        for (User user : collA) { // Все классы, имплементирующие интерфейс Collection итерируются за O(n)
            // Для более точного сравнения 2х объектов, нужно переопределить методы equals и hashCode у объекта User.
            if (hashSetB.contains(user)) { //Сравнение за O(1)
                foundDuplicatesUsers.add(user); //Добавление элемента O(1)
            }
        }
        //Итог - сложность всего алгоритма O(n)
        return foundDuplicatesUsers;
    }
}
