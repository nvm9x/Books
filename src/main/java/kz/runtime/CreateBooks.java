package kz.runtime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import kz.runtime.entity.Author;
import kz.runtime.entity.AuthorBooks;
import kz.runtime.entity.Books;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CreateBooks {

    public static void createBooks(){
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название книги");
        String book_name=scan.nextLine();
        System.out.println("Введите дату публикации");
        LocalDate published = LocalDate.parse(scan.nextLine());


        try {
            manager.getTransaction().begin();
            Books books = new Books();
            books.setName(book_name);
            books.setPublished(published);
            manager.persist(books);



            System.out.println("Введите количество авторов книги");
            int authorCount = Integer.parseInt(scan.nextLine());
            TypedQuery<Author> authorTypedQuery = manager.createQuery("select c from Author c", Author.class);
            List<Author> authorsLists=authorTypedQuery.getResultList();
            System.out.println("Выберите автора книги");
            for(int i=0;i<authorsLists.size();i++){
                System.out.print(authorsLists.get(i).getId() + " - ");
                System.out.print(authorsLists.get(i).getName() + " ");
                System.out.println(authorsLists.get(i).getLastname());

            }

            for (int i =0;i<authorCount;i++) {
                System.out.println("Введите id автора");
                int authorId = Integer.parseInt(scan.nextLine());
                Author authorManager = manager.find(Author.class, authorId);

                while (authorManager == null) {
                    System.out.println("Введите верный ID");
                    authorId = Integer.parseInt(scan.nextLine());
                    authorManager = manager.find(Author.class, authorId);
                }

                System.out.println(authorManager.getName());
                AuthorBooks authorBooks = new AuthorBooks();
                authorBooks.setBooks(books);
                authorBooks.setAuthor(authorManager);
                manager.persist(authorBooks);
            }

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        manager.close();
        factory.close();


    }

}
