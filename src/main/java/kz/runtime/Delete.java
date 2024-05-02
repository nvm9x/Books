package kz.runtime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import kz.runtime.entity.Author;

import java.util.List;
import java.util.Scanner;

public class Delete {
  public static void delete(){



        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();

        System.out.println("Удалить автора");
        TypedQuery<Author> authorTypedQuery = manager.createQuery("select c from Author c ", Author.class);
        List<Author> authorList = authorTypedQuery.getResultList();
        for (int i = 0; i < authorList.size(); i++) {
            System.out.print(authorList.get(i).getId()+" - ");
            System.out.print(authorList.get(i).getName()+" ");
            System.out.println(authorList.get(i).getLastname());

        }

        Scanner scanner = new Scanner(System.in);
        int authorId = Integer.parseInt(scanner.nextLine());
        Author author = manager.find(Author.class,authorId);
        for (int i = 0; i < author.getAut_booksList().size(); i++) {

            System.out.println(author.getAut_booksList().get(i).getBooks().getName());
            manager.remove(author.getAut_booksList().get(i));
            manager.remove(author);

        }

        }



    }

