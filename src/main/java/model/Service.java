package main.java.model;

import main.java.model.dao.AbstractDAO;
import main.java.model.dao.SimpleDAO;
import main.java.model.data.Base;
import main.java.model.data.Contact;
import main.java.model.data.Group;

import java.util.HashSet;
import java.util.Observer;

public class Service {

    private AbstractDAO dao;

    public Base downloadData(){                     //Извличение данных

        dao = new SimpleDAO();
        Base base = dao.getBase();
        Contact.setId_count(dao.getBase().getContactId());
        Group.setId_count(dao.getBase().getGroupId());
        if (base.getContactSet() == null){
            base.setContactSet(new HashSet<>());
            Contact.setId_count(0);
        }
        if (base.getGroupSet() == null){
            base.setGroupSet(new HashSet<>());
            Contact.setId_count(0);
        }
        return base;
    }

    public void save(Base base){                                 //Функция сохранения во внешнюю БД
        base.setContactId(Contact.getId_count());
        base.setGroupId(Group.getId_count());
        dao.saveBase(base);
    }

}
