package _017_sessionSave;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* 
task1101
***
Save the created object in the database (use the save method ) and assign the result to the field id1,
 disconnect the object from the session (use the evict method ) and again use the save method to save
  the same object in the database and assign the result to the field id2.
  Run the program and
make sure that before and after disconnection the id of the object in the database is different ( id1 == id2
returns false ).
*/

public class Solution {
    public static long id1;
    public static long id2;

    public static void main(String[] args) throws Exception {
        Animal animal = new Animal();
        animal.setName("Murka");
        animal.setAge(5);
        animal.setFamily("Cats");
        try {
            SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //напишите тут ваш код


            id1 = (Long) session.save(animal);
            session.evict(animal);
            id2 = (Long)session.save(animal);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(id1 == id2);
    }
}