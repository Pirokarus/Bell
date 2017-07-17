package main.java.Model.dao;

import main.java.Model.data.Base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SimpleDAO implements AbstractDAO {
    @Override
    public void saveBase(Base base) {
        ClassLoader classLoader = getClass().getClassLoader();
        String contactPath = classLoader.getResource("base.out").getFile();
        try{
            FileOutputStream contactFileOutputStream = new FileOutputStream(contactPath);
            ObjectOutputStream conOOS = new ObjectOutputStream(contactFileOutputStream);
            conOOS.writeObject(base);
            conOOS.flush();
            conOOS.close();
        }catch (Exception e){
        }
    }

    @Override
    public Base getBase() {
        ClassLoader classLoader = getClass().getClassLoader();
        String contactPath = classLoader.getResource("base.out").getFile();

        Base base;
        try{
            FileInputStream contactFileInputStream = new FileInputStream(contactPath);
            ObjectInputStream conOIS = new ObjectInputStream(contactFileInputStream);
            base = (Base) conOIS.readObject();
        }catch (Exception e){
            base = new Base();
        }

        return base;
    }
}
