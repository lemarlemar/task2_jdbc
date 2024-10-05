//package jm.task.core.jdbc.dao;
//import jm.task.core.jdbc.model.User;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import static jm.task.core.jdbc.util.Util.connection;
//
//
//public class UserDaoJDBCImpl implements UserDao {
//    public UserDaoJDBCImpl() {
//
//    }
//
//
//    public void createUsersTable() {
//        String SQL = "CREATE TABLE IF NOT EXISTS users (" + "id SERIAL PRIMARY KEY," + "name VARCHAR(50),"
//                + "lastName VARCHAR(50)," + "age SMALLINT)";
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            preparedStatement.executeUpdate();
//            System.out.println("Table is created");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    public void dropUsersTable() {
//        String SQL = "DROP TABLE users";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            preparedStatement.executeUpdate();
//            System.out.println("Table is dropped");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String SQL = "INSERT INTO users (name, lastName, age) VALUES(?, ?, ?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//            System.out.println("User saved successfully");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void removeUserById(long id) {
//        String SQL = "DELETE FROM users WHERE id=?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//            System.out.println("User removed successfully");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public List<User> getAllUsers() {
//        String SQL = "SELECT * FROM users";
//        ResultSet resultSet = null;
//        List<User> users = new ArrayList<>();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                User user = new User();
//                long id = resultSet.getLong("id");
//                user.setId(resultSet.getLong("id"));
//                String name = resultSet.getString("name");
//                user.setName(name);
//                String lastName = resultSet.getString("lastName");
//                user.setLastName(lastName);
//                byte age = resultSet.getByte("age");
//                user.setAge(age);
//                users.add (user);
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException ignored) {}
//            }
//        }
//        users.forEach(user -> System.out.println(user));
//        return users;
//
//    }
//
//    public void cleanUsersTable() {
//        String SQL = "TRUNCATE TABLE users";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            preparedStatement.executeUpdate();
//            System.out.println("Table is cleaned");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
