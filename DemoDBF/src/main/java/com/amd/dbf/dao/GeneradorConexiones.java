package com.amd.dbf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GeneradorConexiones {
    //Mysql
    private static String ipMysql = "localhost";
    private static String puertoMysql  = "3306";
    private static String bdMysql = "testDbf";
    private static String usuarioMysql = "root";
    private static String passwordMysql = "1234";

    //Postgres
    private static String ipPostgres = "localhost";
    private static String puertoPostgres = "5432";
    private static String bdPostgres = "testDbf";
    private static String usuarioPostgres = "postgres";
    private static String passwordPostgres = "1234";

    public static Connection generarConexionLocal(String tipo) throws SQLException {
        String jdbcUrl;
        Connection connection;

        switch (tipo){
        case "mysql":
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                jdbcUrl = String.format("jdbc:mysql://%s:%s/%s",
                    ipMysql, puertoMysql, bdMysql);
                connection = DriverManager.getConnection(jdbcUrl,usuarioMysql,passwordMysql);
            break;
        case "postgres":
            DriverManager.registerDriver(new org.postgresql.Driver());
                jdbcUrl = String.format("jdbc:postgresql://%s:%s/%s",
                        ipPostgres, puertoPostgres, bdPostgres);

            connection = DriverManager.getConnection(jdbcUrl,usuarioPostgres,passwordPostgres);
            break;
        default:
            connection = null;
            break;
        }

        return connection;
    }

}
