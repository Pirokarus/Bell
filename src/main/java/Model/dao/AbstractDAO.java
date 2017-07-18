package main.java.model.dao;

import main.java.model.data.Base;

public interface AbstractDAO {          //Интерфейс с основными функциями всех будущих возможных DAO
    void saveBase(Base base);
    Base getBase();
}
