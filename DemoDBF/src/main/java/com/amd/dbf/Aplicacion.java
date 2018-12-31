package com.amd.dbf;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;

public class Aplicacion {
    public static void main(String...args){
        DBFReader reader = null;
        try{
            ClassLoader classLoader = Aplicacion.class.getClassLoader();

            reader = new DBFReader(classLoader.getResourceAsStream("data/cpaf0000.dbf"));

            int numberOfFields = reader.getFieldCount();

            for (int i = 0; i < numberOfFields; i++) {
                DBFField field = reader.getField(i);
                System.out.print(field.getName()+"|");
            }

            Object[] rowObjects;

            System.out.println();
            System.out.println();

            while ((rowObjects = reader.nextRecord()) != null) {

                for (int i = 0; i < rowObjects.length; i++) {
                    System.out.print(rowObjects[i]+"|");
                }
                System.out.println();
            }

        }
        catch (Exception e){
            e.printStackTrace(System.err);
        }
    }
}
