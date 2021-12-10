package Lessons.Lesson9;

import java.sql.*;

public class Lesson9_1 {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) throws Exception {
        try{
            connect();


        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            disconect();
        }
    }

    private static void extracted2() throws SQLException {
        statement.executeUpdate("UPDATE students SET score = 80 WHERE id=1;");
    }

    private static void extracted1() throws SQLException {
        statement.executeUpdate("INSERT INTO students (name,score) VALUES ('Bob3',100);");
    }

    private static void extracted() {
        try(ResultSet rs = statement.executeQuery("SELECT * FROM students;");) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt("score"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void connect() throws SQLException{
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException |SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }
    public static void disconect(){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
