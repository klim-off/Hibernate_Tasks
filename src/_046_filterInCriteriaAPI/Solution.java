package _046_filterInCriteriaAPI;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/* 
Фильтр результата в Criteria API

Using the Criteria API,
 write a query that will select all records from the animal_table table with a field value family, not equal to null.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Animal> results = new ArrayList<>();
        try {
            SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(new Animal("Tom", 5, "Cat"));
            session.saveOrUpdate(new Animal("Jerry", 3, "Mouse"));
            session.saveOrUpdate(new Animal("Spike", 7, null));
            transaction.commit();
            //напишите тут ваш код
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Animal> critQuery = criteriaBuilder.createQuery(Animal.class);
            Root<Animal> root = critQuery.from(Animal.class);

            critQuery.select(root).where(criteriaBuilder.isNotNull(root.get("family")));

           Query<Animal> query = session.createQuery(critQuery);
            results = query.getResultList();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        results.forEach(System.out::println);
    }
}