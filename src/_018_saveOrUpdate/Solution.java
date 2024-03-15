package _018_saveOrUpdate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* 
task1102
***
Save the objectanimalCatin the database using the save method of the objectsession,
 then call the saveOrUpdate method on the objects animalCat And animalDog.
  Run the program and make sure that the database contains only two records
   (the saveOrUpdate method for the object animalDog worked like save ,
 but for the object animalCat— as update ).
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Animal animalCat = new Animal();
        animalCat.setName("Murka");
        animalCat.setAge(5);
        animalCat.setFamily("Cats");

        Animal animalDog = new Animal();
        animalDog.setName("Barsik");
        animalDog.setAge(3);
        animalDog.setFamily("Dogs");

        try {
            SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //напишите тут ваш код
            session.save(animalCat);
            session.saveOrUpdate(animalDog);
            session.saveOrUpdate(animalCat);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}