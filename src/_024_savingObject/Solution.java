package _024_savingObject;

/* 
Сохраняем объект в БД
***
Add private fields to the public class TimeClassid (Long),instant (Instant)AndzonedDateTime(ZonedDateTime).
The TimeClass class must have the @Entity and @Table annotations (table name time_table, schema - test).
All fields must have getters and setters.
All fields must have appropriate annotations.
By the fieldidThe @Id annotation must be present .
By the fieldinstantthere must be a @Column annotation that specifies the column name "instant".
By the fieldzonedDateTimethere must be a @Basic annotation and a @Column annotation specifying the column name "zoned_time".
In the main method of the Solution class , you should create an object of the TimeClass class and, using setters, set the values ​​forid,InstantAndZonedDateTime.
For the id setter, use any value.
For the Instant setter, use the static method ofEpochSecond with any value.
For the ZonedDateTime setter, use the static method now , which must be passed the static systemDefault method of the ZoneId class .
Using the getSessionFactory method, the main method should start a transaction, save a TimeClass object, and commit it.
*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Properties;

import static java.time.Instant.ofEpochSecond;

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        TimeClass timeClass = new TimeClass();
        timeClass.setId(1L);
        timeClass.setInstant(Instant.ofEpochSecond(12));
        timeClass.setZonedDateTime(ZonedDateTime.now(ZoneId.systemDefault()));

        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(sessionFactory);
        transaction.commit();

        session.close();
        sessionFactory.close();

    }

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");

        SessionFactory sessionFactory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(TimeClass.class)
                .buildSessionFactory();

        return sessionFactory;
    }
}
