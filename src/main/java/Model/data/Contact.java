package main.java.Model.data;

import main.java.exceptions.MyNotPhoneNumberException;

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

    public Contact(String firstName, String number) throws MyNotPhoneNumberException {
        this.firstName = firstName;
        setNumber(number);
    }

    public Contact(String firstName, String lastName, String number) throws MyNotPhoneNumberException {
        this.firstName = firstName;
        this.lastName = lastName;
        setNumber(number);
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

    public void setNumber(String number) throws MyNotPhoneNumberException {
        char[] nimChar = number.toCharArray();
        for (char c:nimChar){
            if(!(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'||c=='+')){
                throw new MyNotPhoneNumberException();
            }
        }
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
