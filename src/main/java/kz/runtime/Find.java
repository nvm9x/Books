package kz.runtime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import kz.runtime.entity.Author;

import java.util.List;
import java.util.Scanner;

public class Find {
    public static void findByName(){
        //запросить имя автора и по имени найти все книги
        //select typedquery
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();
        Scanner scan = new Scanner(System.in);
        TypedQuery<Author> authorTypedQuery = manager.createQuery("select c from Author c", Author.class);
        List<Author> authorsLists=authorTypedQuery.getResultList();
        System.out.println("Выберите автора книги");
        for(int i=0;i<authorsLists.size();i++){
            System.out.print(authorsLists.get(i).getId() + " - ");
            System.out.print(authorsLists.get(i).getName() + " ");
            System.out.println(authorsLists.get(i).getLastname());

        }

        System.out.println("Введите id автора");
        int authorId = Integer.parseInt(scan.nextLine());
        Author authorManager = manager.find(Author.class, authorId);

        TypedQuery<Author> typedQuery = manager.createQuery("select c from Author c where c.name=?1", Author.class);
        typedQuery.setParameter(1,authorManager.getName());
        List<Author> a =typedQuery.getResultList();
        for (int i=0;i<a.size();i++){
            System.out.println(a.get(i).getAut_booksList().get(i).getBooks().getName());
        }

    }

}
