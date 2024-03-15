package _019_getLoadFind;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* 
task1103
***
Try to get an Animal class object with id + 1 from the database. Use the object's get(), load() and find() methodssession.
Write the result in the fieldsanimalGet,animalLoadAndanimalFindrespectively.
Run the program and make sure that the field valuesanimalGetAndanimalFindare null and the valueanimalLoadnot equal to null
*/

public class Solution {
    public static Animal animalGet;
    public static Animal animalLoad;
    public static Animal animalFind;

    public static void main(String[] args) throws Exception {
        Animal animalCat = new Animal();
        animalCat.setName("Murka");
        animalCat.setAge(5);
        animalCat.setFamily("Cats");

        try {
            SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            long id = (long) session.save(animalCat);
            //напишите тут ваш код
            animalGet = session.get(Animal.class, id + 1);
            animalLoad = session.load(Animal.class, id + 1);
            animalFind = session.find(Animal.class, id + 1);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(animalGet == null);
        System.out.println(animalLoad != null);
        System.out.println(animalFind == null);
    }
}