package kz.runtime;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        while(isTrue){
            System.out.println("Выберите действие");
            System.out.println("1 - создать автора");
            System.out.println("2 - создать книгу");
            System.out.println("3 - найти книгу");
            System.out.println("4 - удалить автора");
            System.out.println("5 - выйти");

            int num = Integer.parseInt(scanner.nextLine());

            switch (num){
                case 1:
                    kz.runtime.CreateAuthor.createAuthor();
                    break;

                case 2:
                    CreateBooks.createBooks();
                    break;

                case 3:
                    Find.findByName();
                    break;
                    
                case 4:
                    Delete.delete();
                    break;

                case 5:
                    isTrue=false;

                default:
                    System.out.println("Введите число из списка");
                    break;

            }

        }
    }

}