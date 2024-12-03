package ru.naumen.collection.task2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Пользователь
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class User {
    private String username;
    private String email;
    private byte[] passwordHash;

    //Переопределяем методы hashCode и equals для более точного сравнения двух объектов.

    /**
     * Сравнивает 2 объекта User по полям.
     * @param object объект с которым нужно сравнить
     * @return true - объекты полностью идентичны (все поля одинаковые),
     * false - в обратном случае
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        User user = (User) object;
        return username.equals(user.username)
                && email.equals(user.email)
                && Arrays.equals(passwordHash, user.passwordHash);
    }

    /**
     * Возвращает значение хэш-кода для этого объекта.
     * Хэш-код рассчитывается на основе полей username, email и passwordHash.
     * @return значение хэш-кода для этого объекта
     */
    @Override
    public int hashCode() {
        final int simpleNumber = 971; // Простое число для уменьшения вероятности коллизии.
        int hash = Objects.hash(username, email);
        hash = simpleNumber * hash + Arrays.hashCode(passwordHash);
        return hash;
    }
}
