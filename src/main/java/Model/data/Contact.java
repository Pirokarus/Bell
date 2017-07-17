package main.java.Model.data;

import java.io.Serializable;

public class Contact implements Serializable{

    private static int id_count;
    private int id;
    private String firstName;
    private String lastName;
    private String number;
    private Group group;

    {
        id = id_count;
        ++id_count;
    }

    public Contact(String firstName, String number) {
        this.firstName = firstName;
        this.number = number;
    }

    public Contact(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public static int getId_count() {
        return id_count;
    }

    public static void setId_count(int id_count) {
        Contact.id_count = id_count;
    }

    @Override
    public String toString() {
        return  "Индекс: " + id +
                ", Имя: '" + firstName + '\'' +
                ", Фамилия: '" + lastName + '\'' +
                ", Номер: '" + number + '\'' +
                ", Группа: " + group + "\n";
    }


}
