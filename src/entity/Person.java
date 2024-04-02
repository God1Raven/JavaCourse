package entity;

import java.io.*;
import java.util.Scanner;

public class Person {
    private final int  id;
    private String name;
    private String lastName;
    private String email;
    public Person(int id, String name, String lastName, String email){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
    public Person(int id) {
        this.id = id;
    }

    public static void saveTo(File file, Person person){
        try(FileInputStream outputStream = new FileInputStream(file)){
            try (PrintWriter writer = new PrintWriter(outputStream.toString())){
                writer.println(person.id);
                writer.println(person.name);
                writer.println(person.lastName);
                writer.println(person.email);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Person loadFrom (File file){
        try (FileInputStream inputStream = new FileInputStream(file)) {
            try (Scanner scanner = new Scanner(inputStream)) {
                Person person = new Person(Integer.parseInt(scanner.nextLine()));
                person.name = scanner.nextLine();
                person.lastName = scanner.nextLine();
                person.email = scanner.nextLine();
                return person;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
