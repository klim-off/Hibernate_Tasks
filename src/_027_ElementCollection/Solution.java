package _027_ElementCollection;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

/* 
Расстановка аннотаций
***
There is an entity class Author , the author can have articlesarticles. Add annotations before the fieldarticlesin the Author class so that the program correctly processes data from tables:

table author with columns id, first_name, last_name, full_name;
table author_article with columns author_id, article.

*/

public class Solution {

    public static void main(String[] args) {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            Query<Author> query = session.createQuery("from Author", Author.class);
            List<Author> authors = query.list();

            authors.forEach(author -> {
                Set<String> articles = author.getArticles();
                if (articles.size() > 0) {
                    System.out.println(author.getFullName() + ":");
                    articles.forEach(System.out::println);
                }
            });
        }
    }
}