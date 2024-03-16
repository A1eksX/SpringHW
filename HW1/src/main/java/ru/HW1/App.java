package ru.HW1;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException

    {
        Person person = new Person("Александр", "Иванов", 48);

        try(FileOutputStream outputStream = new FileOutputStream("textFile.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream))
        {
            objectOutputStream.writeObject(person);
            System.out.println("Объект Person был сериализован");
        }

        try(FileInputStream fileInputStream = new FileInputStream("textFile.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))

        {
            person = (Person)objectInputStream.readObject();
            System.out.println("Объект Person был десериализован");
        }

    }
}
