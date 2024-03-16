package ru.HW1;

import java.io.*;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException

    {
        Person person = new Person("Александр", "Иванов", 48);

//        Gson gson = new Gson();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();        // Создает экземпляр Gson


        String jsonString = gson.toJson(person);
        System.out.println("Converting Person object to JSON string:\n" + jsonString);

        Person pers = gson.fromJson(jsonString, Person.class);
        System.out.println("\nConverting JSON string to Person object:\n"
                + pers.toString());


    }
}

