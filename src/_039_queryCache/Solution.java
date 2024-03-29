package _039_queryCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/* 
Кеш запросов
	Changes should only be made to the clearCache method.
•	The clearCache method should clear the cache of the factory.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Employee director1;
        Employee director2;

        try (SessionFactory sessionFactory = MySessionFactory.getSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Query<Employee> query1 = session.createQuery("from Employee where smth = 'director'", Employee.class);
                query1.setCacheable(true);
                director1 = query1.uniqueResult();
            }

            clearCache(sessionFactory);

            try (Session session = sessionFactory.openSession()) {
                Query<Employee> query2 = session.createQuery("from Employee where smth = 'director'", Employee.class);
                query2.setCacheable(true);
                director2 = query2.uniqueResult();
            }

            System.out.println(director1);
            System.out.println(director2);
        }
    }

    public static void clearCache(SessionFactory factory) {
        //напишите тут ваш код
        factory.getCache().evictAllRegions();

    }
}