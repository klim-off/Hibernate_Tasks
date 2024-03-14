package _003_SessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/* 
task003
Add code to configure the SessionFactory to the main method and specify the Animal entity class in the configuration .
When configuring as a driver, you must use "com.mysql.jdbc.Driver" , URL "jdbc:mysql://localhost:3306/test" ,
dialect "org.hibernate.dialect.MySQLDialect" , user "root" and the same password.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");

        SessionFactory sessionFactory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(Animal.class)
                .buildSessionFactory();

    }
}