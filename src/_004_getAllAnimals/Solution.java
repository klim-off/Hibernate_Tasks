package _004_getAllAnimals;

import java.util.List;

/* 
Все имена
***
Add code to the getAllAnimals method to create (open) a session and get all the animals from the database.
 Don't forget to close the session when you are done with it or an exception occurs.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        AnimalManager animalManager = new AnimalManager();
        List<Animal> animals = animalManager.getAllAnimals();

        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
    }
}
