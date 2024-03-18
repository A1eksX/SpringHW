package ru.HW1;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;


public class Person implements Serializable {
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("age")
    private int age;


    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {

    }

    // region Задание 1
    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append(firstName)
                .append(lastName)
                .append(age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(firstName, that.firstName)
                .append(lastName, that.lastName)
                .append(age, that.age)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(firstName)
                .append(lastName)
                .append(age)
                .toHashCode();
    }
    // endregion
}
