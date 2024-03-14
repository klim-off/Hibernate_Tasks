package _006_Dialect;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/* 
task0906
***
Add code to the main method to further configure the SessionFactory.
 Specify the dialect "org.hibernate.dialect.MySQL8Dialect" and enable display of executed SQL queries.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.SHOW_SQL,"true");

        //напишите тут ваш код


        SessionFactory sessionFactory = new Configuration()
                .setProperties(properties)
                .buildSessionFactory();
    }
}
