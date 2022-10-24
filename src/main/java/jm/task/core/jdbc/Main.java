package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Рокки", "Бальбо", (byte) 20);
        userDao.saveUser("Кик", "Бутовски", (byte) 25);
        userDao.saveUser("Дональд", "Трамп", (byte) 31);
        userDao.saveUser("Мухаммед", "Али", (byte) 38);

        List<User> printList = userDao.getAllUsers();
        printList.forEach(System.out :: println);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
