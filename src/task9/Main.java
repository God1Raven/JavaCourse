package task9;

import task9.entity.Person;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static entity.Person.saveTo;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "/src/Main.java";
        Scanner sc = new Scanner(System.in);
        File file = new File("java.io.FileInputStream@3f99bd52");

        System.out.println("Вы хотите загрузить или сохранить файл? Нажмите [l/s]");
        String loadOrSave = sc.nextLine();

        if(loadOrSave.equalsIgnoreCase("s")){
            System.out.println("Напишите айди пользователя");
            int id  = sc.nextInt();
            sc.nextLine();
            System.out.println("Напишите имя пользователя");
            String name = sc.nextLine();
            System.out.println("Напишите фамилию пользователя");
            String lastName = sc.nextLine();
            System.out.println("Напишите email пользователя");
            String email = sc.nextLine();

            entity.Person person = new entity.Person(id);
            person.setName(name);
            person.setLastName(lastName);
            person.setEmail(email);
            System.out.println("Укажите путь до файла");
            String scPath = sc.nextLine();
            if (scPath.equalsIgnoreCase(path)){
                file.createNewFile();
                saveTo(file, person);
            } else {
                System.out.println("Что то пошло не так, а что я тебе не скажу");
            }
        }
        else if(loadOrSave.equalsIgnoreCase("l")){
            System.out.println("Укажите путь до файла");
            String scPath = sc.nextLine();
            if (scPath.equalsIgnoreCase(path)){
                Person person = Person.loadFrom(file);
                System.out.println("Person: id: " + person.getId() + ", name: " + person.getName() + ", lastname: " + person.getLastName() + ", email: " + person.getEmail());
            } else if (!file.exists()){
                System.out.println("Не правильный путь, или такого файла не существует");
            }
        }
    }
}