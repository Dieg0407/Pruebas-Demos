package com.amd.dbf;

import com.amd.dbf.beans.Cpaf0001;
import com.amd.dbf.beans.Cpaf0050;
import com.amd.dbf.dao.GeneradorConexiones;
import com.amd.dbf.dao.dbf.DaoCpaf0001;
import com.amd.dbf.dao.dbf.DaoCpaf0050;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;

import java.io.FileInputStream;
import java.io.File;
import java.sql.Connection;
import java.util.List;

public class Aplicacion {
    //PARA REALIZAR LAS CONEXIONES DEBEN DE CAMBIAR LA CLASE GENERADORCONEXIONES
    //EN LA CARPETA RECURSOS ESTAN LOS SCRIPTS PARA MYSQL Y POSTGRES
    //SI SOLO TIENEN MYSQL BORREN LA PARTE DE POSTGRES EN LAS FUNCIONES
    public static void main(String... args) throws Exception{


        System.out.println("EJEMPLO CPAF0001");
        ejemploCpaf0001();

        System.out.println("EJEMPLO CPAF0050");
        ejemploCpaf0050();

    }

    private static void ejemploCpaf0001() throws Exception{
        //Muestra los registros de CPAF 0001
        DaoCpaf0001 dao = new DaoCpaf0001();
        List<Cpaf0001> registros = dao.listarRegistros();
        registros.forEach( r -> System.out.println(r.toString()));

        System.out.println();
        System.out.println("Mysql");
        //Insertar en Mysql
        try(Connection connection = GeneradorConexiones.generarConexionLocal("mysql")){
            com.amd.dbf.dao.mysql.DaoCpaf0001 daoMysql = new com.amd.dbf.dao.mysql.DaoCpaf0001(connection);

            /*
            * forEach es equivalente a for(Cpaf0001 registro : registros){...}
            * forEach es equivalente a for(int i = 0 ; i < registro.size() ; i++){....}
            * */
            registros.forEach(r -> {
                if( daoMysql.insertRegistro(r) )
                    System.out.println("Ingreso el registro :: " + r.toString() );
                else
                    System.out.println("Fallo el registro :: " + r.toString() );
            });

            System.out.println();
            System.out.println("Nuevos registros en Mysql");
            registros = daoMysql.listarRegistros();
            registros.forEach( r -> System.out.println(r.toString()));

            //Para borrar usar esta parte del codigo
            /*
            registros.forEach(r -> {
                if( daoMysql.borrarRegistro(r) >= 0 )
                    System.out.println("Borrado el registro :: " + r.toString() );
                else
                    System.out.println("Fallo el borrado del registro :: " + r.toString() );
            });


            System.out.println();
            System.out.println("Registros sobrantes en Mysql");
            registros = daoMysql.listarRegistros();
            registros.forEach( r -> System.out.println(r.toString()));
            */
        }

        System.out.println();
        System.out.println("Postgres");
        //Insertar en Postgres
        try(Connection connection = GeneradorConexiones.generarConexionLocal("postgres")){
            com.amd.dbf.dao.mysql.DaoCpaf0001 daoPostgres = new com.amd.dbf.dao.mysql.DaoCpaf0001(connection);

            /*
             * forEach es equivalente a for(Cpaf0001 registro : registros){...}
             * forEach es equivalente a for(int i = 0 ; i < registro.size() ; i++){....}
             * */
            registros.forEach(r -> {
                if( daoPostgres.insertRegistro(r) )
                    System.out.println("Ingreso el registro :: " + r.toString() );
                else
                    System.out.println("Fallo el registro :: " + r.toString() );
            });

            System.out.println();
            System.out.println("Nuevos registros en Postgres");
            registros = daoPostgres.listarRegistros();
            registros.forEach( r -> System.out.println(r.toString()));

            //Para borrar usar esta parte del codigo
            /*
            registros.forEach(r -> {
                if( daoPostgres.borrarRegistro(r) >= 0 )
                    System.out.println("Borrado el registro :: " + r.toString() );
                else
                    System.out.println("Fallo el borrado del registro :: " + r.toString() );
            });


            System.out.println();
            System.out.println("Registros sobrantes en Postgres");
            registros = daoPostgres.listarRegistros();
            registros.forEach( r -> System.out.println(r.toString()));
            */
        }
    }
    private static void ejemploCpaf0050() throws Exception{
        //Muestra los registros de CPAF 0001
        DaoCpaf0050 dao = new DaoCpaf0050();
        List<Cpaf0050> registros = dao.listarRegistros();
        registros.forEach( r -> System.out.println(r.toString()));

        try(Connection connection = GeneradorConexiones.generarConexionLocal("mysql")){
            com.amd.dbf.dao.mysql.DaoCpaf0050 daoMysql = new com.amd.dbf.dao.mysql.DaoCpaf0050(connection);


            if(daoMysql.insertVariosRegistro(registros)){
                System.out.println("Registro exitoso");
            }
            else
                System.out.println("Hubo un error");



            System.out.println();
            System.out.println("Nuevos registros en Mysql");
            registros = daoMysql.listarRegistros();
            registros.forEach( r -> System.out.println(r.toString()));

            //Para borrar usar esta parte del codigo
            /*
            registros.forEach(r -> {
                if( daoMysql.borrarRegistro(r) >= 0 )
                    System.out.println("Borrado el registro :: " + r.toString() );
                else
                    System.out.println("Fallo el borrado del registro :: " + r.toString() );
            });


            System.out.println();
            System.out.println("Registros sobrantes en Mysql");
            registros = daoMysql.listarRegistros();
            registros.forEach( r -> System.out.println(r.toString()));
            */
        }

        System.out.println();
        System.out.println("Postgres");
        //Insertar en Postgres
        try(Connection connection = GeneradorConexiones.generarConexionLocal("postgres")){
            com.amd.dbf.dao.mysql.DaoCpaf0050 daoPostgres = new com.amd.dbf.dao.mysql.DaoCpaf0050(connection);

            if(daoPostgres.insertVariosRegistro(registros)){
                System.out.println("Registro exitoso");
            }
            else
                System.out.println("Hubo un error");


            System.out.println();
            System.out.println("Nuevos registros en Postgres");
            registros = daoPostgres.listarRegistros();
            registros.forEach( r -> System.out.println(r.toString()));

            //Para borrar usar esta parte del codigo
            /*
            registros.forEach(r -> {
                if( daoPostgres.borrarRegistro(r) >= 0 )
                    System.out.println("Borrado el registro :: " + r.toString() );
                else
                    System.out.println("Fallo el borrado del registro :: " + r.toString() );
            });


            System.out.println();
            System.out.println("Registros sobrantes en Postgres");
            registros = daoPostgres.listarRegistros();
            registros.forEach( r -> System.out.println(r.toString()));
            */
        }

    }



    private static void convertirDbfABean(String nombre){

        DBFReader reader = null;
        try{
            ClassLoader classLoader = Aplicacion.class.getClassLoader();

            //reader = new DBFReader(classLoader.getResourceAsStream("data/"+nombre+".dbf"));
            System.out.println(new File("data/"+nombre+".dbf").getAbsolutePath());

            reader = new DBFReader(new FileInputStream("data/"+nombre+".dbf"));
            int numberOfFields = reader.getFieldCount();

            for (int i = 0; i < numberOfFields; i++) {
                DBFField field = reader.getField(i);
                String fieldName = field.getName().toLowerCase();

                while( fieldName.indexOf('_') != -1){
                    int idx = fieldName.indexOf('_');
                    String fLetter = fieldName.substring(idx+1,idx+2).toUpperCase();
                    fieldName = fieldName.substring(0,idx) + fLetter + fieldName.substring(idx+2);
                }
                String type;
                switch (field.getType().getCharCode()){
                    case 'C':
                        type = "String";
                        break;
                    case 'N':
                        type = "BigDecimal";
                        break;
                    case 'F':
                        type = "BigDecimal";
                        break;
                    case 'L':
                        type = "Boolean";
                        break;
                    case 'D':
                        type = "Date";
                        break;
                    case 'Y':
                        type = "BigDecimal";
                        break;
                    case 'I':
                        type = "Integer";
                        break;
                    case 'T':
                        type = "Date";
                        break;
                    case '@':
                        type = "Date";
                        break;
                    case '+':
                        type = "Integer";
                        break;
                    case 'M':
                        type = "byte[]";
                        break;
                    case 'B':
                        type = "byte[]";
                        break;
                    case 'W':
                        type = "byte[]";
                        break;
                    case 'G':
                        type = "byte[]";
                        break;
                    case 'P':
                        type = "byte[]";
                        break;
                    case 'Q':
                        type = "byte[]";
                        break;
                    case 'V':
                        type = "String";
                        break;
                    case 'O':
                        type = "Double";
                        break;
                    default:
                        type = null;
                        break;
                }
                if(type != null) {
                    /*
                    String var = "cpaf0050.set"+String.valueOf(fieldName.charAt(0)).toUpperCase()+fieldName.substring(1);

                    System.out.println(
                            String.format("%s(registro.get%s(\"%s\"));",
                            var,
                            type.equals("byte[]")?"Bytes":type,
                            field.getName()));
                    */
                    /*
                    String var2 = "nuevoRegistro.get"+String.valueOf(fieldName.charAt(0)).toUpperCase()+fieldName.substring(1);

                    System.out.println(
                            String.format("pst.set%s(i++,%s());",
                                    type.equals("byte[]")?"Bytes":type,
                                    var2,
                                    field.getName()));
                                    */

                    System.out.println(String.format("private %s %s;",
                            type, fieldName));

                }
            }

        }
        catch (Exception e){
            e.printStackTrace(System.err);
        }
    }

    private static void convertirDbfATablaMysql(String nombre){

        DBFReader reader = null;
        try{
            ClassLoader classLoader = Aplicacion.class.getClassLoader();

            reader = new DBFReader(classLoader.getResourceAsStream("data/"+nombre+".dbf"));


            int numberOfFields = reader.getFieldCount();

            System.out.println("create table "+nombre.toLowerCase()+" (");
            for (int i = 0; i < numberOfFields; i++) {
                DBFField field = reader.getField(i);

                String type;

                switch (field.getType().getCharCode()){
                    case 'C':
                        type = "varchar("+field.getLength()+")";
                        break;
                    case 'N':
                        type = "numeric("+field.getLength()+","+field.getDecimalCount()+")";
                        break;
                    case 'F':
                        type = "numeric("+field.getLength()+","+field.getDecimalCount()+")";
                        break;
                    case 'L':
                        type = "boolean";
                        break;
                    case 'D':
                        type = "date";
                        break;
                    case 'Y':
                        type = "numeric("+field.getLength()+","+field.getDecimalCount()+")";
                        break;
                    case 'I':
                        type = "int";
                        break;
                    case 'T':
                        type = "date";
                        break;
                    case '@':
                        type = "date";
                        break;
                    case '+':
                        type = "integer";
                        break;
                    case 'M':
                        type = "Blob";
                        break;
                    case 'B':
                        type = "Blob";
                        break;
                    case 'W':
                        type = "Blob";
                        break;
                    case 'G':
                        type = "Blob";
                        break;
                    case 'P':
                        type = "Blob";
                        break;
                    case 'Q':
                        type = "Blob";
                        break;
                    case 'V':
                        type = "varchar("+field.getLength()+")";
                        break;
                    case 'O':
                        type = "numeric("+field.getLength()+","+field.getDecimalCount()+")";
                        break;
                    default:
                        type = null;
                        break;
                }
                if(type != null) {
                    System.out.println(String.format("%s %s,",
                            field.getName(), type));
                }

            }
            System.out.println(");");

        }
        catch (Exception e){
            e.printStackTrace(System.err);
        }
    }

    private static void convertirDbfATablaPostgres(String nombre){

        DBFReader reader = null;
        try{
            ClassLoader classLoader = Aplicacion.class.getClassLoader();

            reader = new DBFReader(classLoader.getResourceAsStream("data/"+nombre+".dbf"));


            int numberOfFields = reader.getFieldCount();

            System.out.println("create table "+nombre.toLowerCase()+" (");
            for (int i = 0; i < numberOfFields; i++) {
                DBFField field = reader.getField(i);

                String type;

                switch (field.getType().getCharCode()){
                    case 'C':
                        type = "varchar("+field.getLength()+")";
                        break;
                    case 'N':
                        type = "numeric("+field.getLength()+","+field.getDecimalCount()+")";
                        break;
                    case 'F':
                        type = "numeric("+field.getLength()+","+field.getDecimalCount()+")";
                        break;
                    case 'L':
                        type = "boolean";
                        break;
                    case 'D':
                        type = "date";
                        break;
                    case 'Y':
                        type = "numeric("+field.getLength()+","+field.getDecimalCount()+")";
                        break;
                    case 'I':
                        type = "int";
                        break;
                    case 'T':
                        type = "date";
                        break;
                    case '@':
                        type = "date";
                        break;
                    case '+':
                        type = "integer";
                        break;
                    case 'M':
                        type = "BYTEA";
                        break;
                    case 'B':
                        type = "BYTEA";
                        break;
                    case 'W':
                        type = "BYTEA";
                        break;
                    case 'G':
                        type = "BYTEA";
                        break;
                    case 'P':
                        type = "BYTEA";
                        break;
                    case 'Q':
                        type = "BYTEA";
                        break;
                    case 'V':
                        type = "varchar("+field.getLength()+")";
                        break;
                    case 'O':
                        type = "numeric("+field.getLength()+","+field.getDecimalCount()+")";
                        break;
                    default:
                        type = null;
                        break;
                }
                if(type != null) {
                    System.out.println(String.format("%s %s,",
                            field.getName(), type));
                }

            }
            System.out.println(");");

        }
        catch (Exception e){
            e.printStackTrace(System.err);
        }
    }

}
