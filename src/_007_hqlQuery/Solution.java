package _007_hqlQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;

/* 
task1001
 get the session from MySessionFactory.getSessionFactory() .
 Write a query in HQL to get the smth column from the employee table .
Filter the values by age > 18, sort by smth and remove duplicates.
Print the values to the console, each on a new line.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
       try( Session session = MySessionFactory.getSessionFactory().openSession()){
           String hql = "select distinct smth from Employee e where e.age > 18";
           Query<String> query = session.createQuery(hql);
           for (String s : query.list()) {
           System.out.println(s);
           }
       }


    }
}