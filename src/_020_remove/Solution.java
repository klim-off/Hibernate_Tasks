package _020_remove;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* 
task1104
***
Write the code for deleting an object animalRemove using the remove() method . Run the program
and make sure that before deletion the object was not equal to null , and after deletion it was equal to null .
*/

public class Solution {
    public static Animal animalCat = new Animal();
    public static Animal animalMouse = new Animal();
    public static Animal animalRemove;

    public static void main(String[] args) throws Exception {
        animalCat.setId(1L);
        animalCat.setName("Tom");
        animalCat.setAge(5);
        animalCat.setFamily("Cats");

        animalMouse.setId(2L);
        animalMouse.setName("Jerry");
        animalMouse.setAge(3);
        animalMouse.setFamily("Mice");

        try {
            SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(animalCat);
            session.persist(animalMouse);
            animalRemove = session.find(Animal.class, 1L);
            System.out.println(animalRemove == null);
            //напишите тут ваш код
            session.remove(animalRemove);

            animalRemove = session.find(Animal.class, 1L);
            System.out.println(animalRemove == null);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}