package com.project.model.dao;

import com.project.model.data.Base;

import java.io.*;

public class SimpleDAO implements AbstractDAO {         //DAO выполняющее сериализацию и десериализацию в файл

    @Override
    public void saveBase(Base base) {                   //Функция сериализации

        ClassLoader classLoader = getClass().getClassLoader();
        String contactPath = classLoader.getResource("base.out").getFile();

        try(FileOutputStream contactFileOutputStream = new FileOutputStream(contactPath);
            ObjectOutputStream conOOS = new ObjectOutputStream(contactFileOutputStream)){
            conOOS.writeObject(base);
        }catch (Exception e){
        }
    }

    @Override
    public Base getBase() {                             //Функция десериализации

        ClassLoader classLoader = getClass().getClassLoader();
        String contactPath = classLoader.getResource("base.out").getFile();

        Base base;
        try(FileInputStream contactFileInputStream = new FileInputStream(contactPath);
            ObjectInputStream conOIS = new ObjectInputStream(contactFileInputStream)){
            base = (Base) conOIS.readObject();
        }catch (Exception e){
            base = new Base();
        }

        return base;
    }
}
