package Lessons.Lesson9.HW9;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class HW9 {

    private static Connection connection;
    private static Statement statement;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException |SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }
    public static void disconnect(){
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

    public static void buildTable(Class cl) throws SQLException {
        if(!cl.isAnnotationPresent(Table.class)){
            throw new RuntimeException("@Table missed");
        }
        Map<Class,String> map = new HashMap<>();
        map.put(int.class, "INTEGER");
        map.put(String.class, "TEXT");
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(((Table)cl.getAnnotation(Table.class)).title());
        stringBuilder.append(" (");
        Field[] fields = cl.getDeclaredFields();
        for(Field f : fields){
            if(f.isAnnotationPresent(Column.class)){
                stringBuilder.append(f.getName())
                        .append(" ")
                        .append(map.get(f.getType()))
                        .append(", ");
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(");");
        statement.executeUpdate(stringBuilder.toString());
    }
    public static void main(String[] args) {
        try {
            connect();
            buildTable(Cat.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }
}
