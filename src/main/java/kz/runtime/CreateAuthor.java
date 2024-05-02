package kz.runtime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import kz.runtime.CentralFactory;
import kz.runtime.entity.Author;

import java.util.Scanner;

public class CreateAuthor {

    public static void createAuthor(){
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();

        Scanner scan = new Scanner(System.in);
        System.out.println("Ведите имя автора");
        String name = scan.nextLine();
        System.out.println("Введите фамилию");
        String lastname = scan.nextLine();

        try {
            manager.getTransaction().begin();
            Author author = new Author();
            author.setName(name);
            author.setLastname(lastname);
            manager.persist(author);

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        manager.close();
        factory.close();


    }
}
