package _037_joinFetch;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
task1404
***
In the getTasks method, get the session from MySessionFactory.getSessionFactory() .

Write a query in hql to get a list of Tasks sorted by deadline.

ObjectsTaskload together with child objects using join fetch in an hql request.

As a result, there should be no duplicates. The getTasks method should return the resulting list.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<Task> tasks = getTasks();
        tasks.forEach(System.out::println);
    }

    public static List<Task> getTasks() {
        //напишите тут ваш код
      try (Session session = MySessionFactory.getSessionFactory().openSession()) {
          String hql = "select distinct task from Task t left join fetch t.employee order by t.deadline ";
          Query<Task> query = session.createQuery(hql, Task.class);
          return null; //query.list();
      }

    }
}