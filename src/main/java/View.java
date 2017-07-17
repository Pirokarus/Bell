package main.java;

import main.java.Model.Model;
import main.java.Model.data.Contact;
import main.java.Model.data.Group;

import java.util.Scanner;
import java.util.Set;

public class View {

    private Model model;
    private Set<Contact> contactSet;
    private Set<Group> groupSet;

    public View(){

        model = new Model();

        contactSet = model.getContactSet();
        groupSet = model.getGroupSet();

        Scanner in = new Scanner(System.in);
        int req = 0;

        while (true) {
            if (req == 0) {
                    System.out.println(" Выберите номер запроса");
                    System.out.println("1 Создание контакта\n" +
                            "2 Редактирование контакта\n" +
                            "3 Удаление контакта\n" +
                            "4 Назначение группы контакту (лейбл)\n" +
                            "5 Удаление группы у контакта\n" +
                            "6 Просмотр информации о контактах\n" +
                            "7 Просмотр контактов определенной группы\n" +
                            "8 Просмотр списка всех групп\n" +
                            "9 Добавление новой группы\n" +
                            "10 Удаление группы\n" +
                            "11 Редактирование группы\n" +
                            "12 Сохранить и выйти");
                    req = in.nextInt();
            }

            if(req == 1){
                addContact();
                req = 0;
                saveModel();
                continue;
            }

            if(req == 2){
                redContact();
                req = 0;
                saveModel();
                continue;
            }

            if(req == 3){
                delContact();
                req = 0;
                saveModel();
                continue;
            }

            if(req == 4){
                addContactGroup();
                req = 0;
                saveModel();
                continue;
            }

            if(req == 5){
                delContactGroup();
                req = 0;
                saveModel();
                continue;
            }

            if(req == 6){
                System.out.println(contactSet);
                req = 0;
                saveModel();
                continue;
            }

            if(req == 7){
                showGroupContact();
                req = 0;
                saveModel();
                continue;
            }

            if(req == 8){
                System.out.println(groupSet);
                req = 0;
                saveModel();
                continue;
            }

            if(req == 9){
                addGroup();
                req = 0;
                saveModel();
                continue;
            }

            if(req == 10){
                delGroup();
                req = 0;
                saveModel();
                continue;
            }

            if(req == 11){
                redGroup();
                req = 0;
                saveModel();
                continue;
            }

            if(req == 12){
                saveModel();
                break;
            }
        }
    }

    public void addContact(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.print("Введите фамилию: ");
        String lustName = in.nextLine();
        System.out.print("Введите номер: ");
        String number = in.nextLine();
        contactSet.add(new Contact(name,lustName,number));
    }

    public void redContact(){
        Scanner in = new Scanner(System.in);
        System.out.print("Выберите индекс контакта: ");
        System.out.println(contactSet);
        int id = in.nextInt();
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.print("Введите фамилию: ");
        String lustName = in.nextLine();
        System.out.print("Введите номер: ");
        String number = in.nextLine();

        for (Contact contact:contactSet){
            if(id == contact.getId()){
                contact.setFirstName(name);
                contact.setLastName(lustName);
                contact.setNumber(number);
            }
        }
    }

    public void delContact(){
        Scanner in = new Scanner(System.in);
        System.out.println(contactSet);
        System.out.print("Выберите индекс контакта: ");

        int id = in.nextInt();

        for (Contact contact:contactSet){
            if(id == contact.getId()){
                contactSet.remove(contact);
            }
        }
    }

    public void addContactGroup(){
        Scanner in = new Scanner(System.in);
        System.out.println(contactSet);
        System.out.print("Выберите индекс контакта: ");

        int idC = in.nextInt();
        System.out.println(groupSet);
        System.out.print("Выберите индекс группы: ");

        int idG = in.nextInt();

        for (Contact contact:contactSet){
            if (contact.getId() == idC){
                for (Group group:groupSet){
                    if(group.getId() == idG){
                        contact.setGroup(group);
                    }
                }
            }
        }
    }

    public void delContactGroup(){
        Scanner in = new Scanner(System.in);
        System.out.println(contactSet);
        System.out.print("Выберите индекс контакта: ");

        int id = in.nextInt();

        for (Contact contact:contactSet){
            if (contact.getId() == id){
                contact.setGroup(null);
            }
        }
    }

    public void showGroupContact(){
        Scanner in = new Scanner(System.in);
        System.out.println(groupSet);
        System.out.print("Выберите индекс группы: ");

        int idG = in.nextInt();

        for (Contact contact:contactSet){
            if(contact.getGroup().getId() == idG){
                System.out.println(contact);
            }
        }
    }

    public void addGroup(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название: ");
        String name = in.nextLine();
        groupSet.add(new Group(name));
    }

    public void delGroup(){
        Scanner in = new Scanner(System.in);
        System.out.println(groupSet);
        System.out.print("Выберите индекс группы: ");
        int id = in.nextInt();

        for (Group group:groupSet){
            if (group.getId() == id){
                groupSet.remove(group);
            }
        }
    }

    public void redGroup(){
        Scanner in = new Scanner(System.in);
        System.out.println(groupSet);
        System.out.print("Выберите индекс группы: ");
        int id = in.nextInt();
        System.out.println("Выберите название: ");
        String name = in.nextLine();

        for (Group group:groupSet){
            if (group.getId() == id){
                group.setName(name);
            }
        }
    }

    public void saveModel(){
        this.model.setContactSet(contactSet);
        this.model.setGroupSet(groupSet);
        this.model.save();
    }
}
