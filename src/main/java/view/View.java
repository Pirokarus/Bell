package main.java.view;

import main.java.model.Model;
import main.java.model.data.Contact;
import main.java.model.data.Group;
import main.java.exceptions.MyNotPhoneNumberException;

import java.util.Scanner;
import java.util.Set;

public class View {

    private Model model;

    public View(){                                  //Основная функция визуализации

        model = new Model();                        //Инициализация модели

        Scanner in = new Scanner(System.in);
        ViewEnum req = ViewEnum.o;                  //Инициализация перечиления команд

        while (true) {
            if(req == ViewEnum.l){                  //Команда выхода из программы
                saveModel();
                break;
            }
            else {
                switch (req) {
                    case o:                         //Команда на вывод меню (команда по умолчанию)

                        System.out.println(" Выберите букву запроса");
                        System.out.println("a Создание контакта\n" +
                                "b Редактирование контакта\n" +
                                "c Удаление контакта\n" +
                                "d Назначение группы контакту (лейбл)\n" +
                                "e Удаление группы у контакта\n" +
                                "f Просмотр информации о контактах\n" +
                                "g Просмотр контактов определенной группы\n" +
                                "h Просмотр списка всех групп\n" +
                                "i Добавление новой группы\n" +
                                "j Удаление группы\n" +
                                "k Редактирование группы\n" +
                                "l Выйти");
                        req = ViewEnum.valueOf(in.nextLine());
                        break;

                    case a:                         //Команда добавления контакта

                        addContact();
                        req = ViewEnum.o;
                        saveModel();
                        continue;

                    case b:                         //Команда редактирования контакта

                        redContact();
                        req = ViewEnum.o;
                        saveModel();
                        continue;

                    case c:                         //Команда удаления контакта

                        delContact();
                        req = ViewEnum.o;
                        saveModel();
                        continue;

                    case d:                         //Команда назначения группы контакту

                        addContactGroup();
                        req = ViewEnum.o;
                        saveModel();
                        continue;

                    case e:                         //Команда удаления группы у контакта

                        delContactGroup();
                        req = ViewEnum.o;
                        saveModel();
                        continue;

                    case f:                         //Команда отображения всех контактов

                        System.out.println(model.getContactSet());
                        req = ViewEnum.o;
                        continue;

                    case g:                         //Команда отображения контактов определённой группы
                        showGroupContact();
                        req = ViewEnum.o;
                        continue;

                    case h:                         //Команда отображения всех групп

                        System.out.println(model.getGroupSet());
                        req = ViewEnum.o;
                        continue;

                    case i:                         //Команда добавления новой группы

                        addGroup();
                        req = ViewEnum.o;
                        saveModel();
                        continue;

                    case j:                         //Команда удаления группы

                        delGroup();
                        req = ViewEnum.o;
                        saveModel();
                        continue;

                    case k:                         //Команда редактирования группы

                        redGroup();
                        req = ViewEnum.o;
                        saveModel();
                        continue;
                }
            }
        }
    }


    public void addContact(){                       //Функция добавления контакта

        try {                                       //Проверка кастомного исключения на проверку на номер телефона
            Scanner in = new Scanner(System.in);
            System.out.print("Введите имя: ");
            String name = in.nextLine();
            System.out.print("Введите фамилию: ");
            String lustName = in.nextLine();
            System.out.print("Введите номер: ");
            String number = in.nextLine();
            Set<Contact> contactSet = model.getContactSet();
            contactSet.add(new Contact(name, lustName, number));
            model.setContactSet(contactSet);
        }
        catch (MyNotPhoneNumberException e){
            System.out.println("Введите корректный номер");
        }
    }

    public void redContact(){                       //Функция редактирования контакта

        try {                                       //Проверка кастомного исключения на проверку на номер телефона

            Set<Contact> contactSet = model.getContactSet();
            Scanner in = new Scanner(System.in);
            System.out.print("Выберите индекс контакта: ");
            System.out.println(model.getContactSet());
            int id = in.nextInt();
            String next = in.nextLine();
            System.out.print("Введите имя: ");
            String name = in.nextLine();
            System.out.print("Введите фамилию: ");
            String lustName = in.nextLine();
            System.out.print("Введите номер: ");
            String number = in.nextLine();

            for (Contact contact : contactSet) {
                if (id == contact.getId()) {
                    contact.setFirstName(name);
                    contact.setLastName(lustName);
                    contact.setNumber(number);
                }
            }
            model.setContactSet(contactSet);
        }
        catch (MyNotPhoneNumberException e){
            System.out.println("Введите корректный номер");
        }
    }

    public void delContact(){                       //Функция удаления контакта

        Set<Contact> contactSet = model.getContactSet();
        Scanner in = new Scanner(System.in);
        System.out.println(contactSet);
        System.out.print("Выберите индекс контакта: ");

        int id = in.nextInt();

        Contact rContact = null;

        for (Contact contact:contactSet){
            if(id == contact.getId()){
                rContact = contact;
            }
        }
        if (rContact != null) {
            contactSet.remove(rContact);
        }
        model.setContactSet(contactSet);
    }

    public void addContactGroup(){                  //Функция назначения группы контакту

        Set<Contact> contactSet = model.getContactSet();
        Set<Group> groupSet = model.getGroupSet();
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
        model.setContactSet(contactSet);
    }

    public void delContactGroup(){                   //Функция удаления группы у контакта

        Set<Contact> contactSet = model.getContactSet();
        Scanner in = new Scanner(System.in);
        System.out.println(contactSet);
        System.out.print("Выберите индекс контакта: ");

        int id = in.nextInt();

        for (Contact contact:contactSet){
            if (contact.getId() == id){
                contact.setGroup(null);
            }
        }
        model.setContactSet(contactSet);
    }

    public void showGroupContact(){                 //Функция отображения всех контактов заданной группы

        Set<Contact> contactSet = model.getContactSet();
        Set<Group> groupSet = model.getGroupSet();
        Scanner in = new Scanner(System.in);
        System.out.println(groupSet);
        System.out.print("Выберите индекс группы: ");

        int idG = in.nextInt();

        for (Contact contact:contactSet){
            if(contact.getGroup() != null) {
                if (contact.getGroup().getId() == idG){
                    System.out.println(contact);
                }
            }
        }
    }

    public void addGroup(){                         //Функция создания новой группы

        Set<Group> groupSet = model.getGroupSet();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название: ");
        String name = in.nextLine();
        groupSet.add(new Group(name));
        model.setGroupSet(groupSet);
    }

    public void delGroup(){                         //Функция удаления группы

        Set<Group> groupSet = model.getGroupSet();
        Set<Contact> contactSet = model.getContactSet();
        Scanner in = new Scanner(System.in);
        System.out.println(groupSet);
        System.out.print("Выберите индекс группы: ");
        int id = in.nextInt();

        for (Group group:groupSet){
            if (group.getId() == id){
                groupSet.remove(group);
            }
        }

        for (Contact contact:contactSet){
            if(contact.getGroup() != null) {
                if (contact.getGroup().getId() == id) {
                    contact.setGroup(null);
                }
            }
        }
        model.setContactSet(contactSet);
        model.setGroupSet(groupSet);
    }

    public void redGroup(){                         //Функция редактирования группы

        Set<Group> groupSet = model.getGroupSet();
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
        model.setGroupSet(groupSet);
    }

    public void saveModel(){                        //Функция сохранения модели в файл

        this.model.save();
    }
}