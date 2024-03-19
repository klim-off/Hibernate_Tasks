package _047_removalViaCriteriaAPI;

/* 
Удаление через Criteria API

Using the Criteria API, in the deleteEmployeeById method , delete the object Employee from the database by his id.

To do this, in the deleteEmployeeById method you will need:

Create objectSession, initializing it by calling the getSessionFactory method , and opening a session.
Call the getCriteriaBuilder method on the Session class object .
Call the createCriteriaDelete method on an object of the CriteriaBuilder class with the required parameter.
For objects of the CriteriaDelete class , call the from and where methods with the required parameters.
Call the equal method on an object of the CriteriaBuilder class with the required parameter.
Call the get method of an object of the Root class with the necessary parameters.
Call the beginTransaction method on an object of the Session class .
Call the createQuery (with the required parameter) and executeUpdate methods on the Session class object .
Call the commit method on an object of the Transaction class .
*/

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Solution {

    public static void main(String[] args) {
        EmployeeFactory.initEmployees();
        deleteEmployeeById(2L);
    }

    public static void deleteEmployeeById(long id) {
        //напишите тут ваш код
        try(Session session = MySessionFactory.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Employee> criteriaDelete = builder.createCriteriaDelete(Employee.class);
            Root<Employee> root = criteriaDelete.from(Employee.class);
            criteriaDelete.where(builder.equal(root.get("id"), id));

            Transaction transaction = session.beginTransaction();
            session.createQuery(criteriaDelete).executeUpdate();
            transaction.commit();
        }
    }
}
