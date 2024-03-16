package _033_OneToOne;

import _033_OneToOne.entities.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
OneToOne
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            Query<Address> query = session.createQuery("from Address", Address.class);
            List<Address> addresses = query.getResultList();

            for (Address address : addresses) {
                System.out.println(address.getUser().getFullName());
            }
        }
    }
}
