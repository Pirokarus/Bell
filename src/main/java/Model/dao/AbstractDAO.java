package main.java.Model.dao;

import main.java.Model.data.Base;
import main.java.Model.data.Contact;

import java.util.Set;

public interface AbstractDAO {
    void saveBase(Base base);
    Base getBase();
}
