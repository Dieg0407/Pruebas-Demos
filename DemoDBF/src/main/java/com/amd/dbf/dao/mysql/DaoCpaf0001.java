package com.amd.dbf.dao.mysql;

import com.amd.dbf.beans.Cpaf0001;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCpaf0001 {
    private Connection connection;
    public DaoCpaf0001(Connection connection){
        this.connection = connection;
    }

    /**
     * Retorna una lista con los registros en la BD
     * @return
     */
    public List<Cpaf0001> listarRegistros(){
        List<Cpaf0001> registros;

        try(Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery("select * from cpaf0001")){
            registros = new ArrayList<>();
            while (rs.next()){
                Cpaf0001 cpaf0001 = new Cpaf0001();
                cpaf0001.setDbfCon(rs.getString("DBF_CON"));
                cpaf0001.setDesCon(rs.getString("DES_CON"));
                cpaf0001.setVarCon(rs.getString("VAR_CON"));
                registros.add(cpaf0001);
            }
        }
        catch (SQLException e){
            registros = null;
            e.printStackTrace(System.err);
        }

        return registros;
    }

    /**
     * Retorna true si el registro fue exitoso o false si hubo un error
     * @return
     */
    public boolean insertRegistro(Cpaf0001 nuevoRegistro){
        boolean retorno = false;

        //CADA '?' representa un parametro que se debe setear en orden con
        //la familia de metodos set de la clase PreparedStatement
        try(PreparedStatement pst = this.connection.prepareStatement(
                "INSERT INTO cpaf0001 (DBF_CON,DES_CON,VAR_CON) VALUES (?,?,?) ")){
            pst.setString(1,nuevoRegistro.getDbfCon());
            pst.setString(2,nuevoRegistro.getDesCon());
            pst.setString(3,nuevoRegistro.getVarCon());

            pst.executeUpdate();

            retorno = true;
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return retorno;
    }

    /**
     * Deberia debolver 1 si es que no hay datos repetidos
     * Generalmente se usa la llave primaria en la condicion
     * @param registro
     * @return
     */
    public int borrarRegistro(Cpaf0001 registro){
        int retorno = -1;
        //CADA '?' representa un parametro que se debe setear en orden con
        //la familia de metodos set de la clase PreparedStatement
        try(PreparedStatement pst = this.connection.prepareStatement(
                "DELETE FROM cpaf0001 WHERE DBF_CON = ? AND DES_CON = ? AND VAR_CON = ?")){
            pst.setString(1,registro.getDbfCon());
            pst.setString(2,registro.getDesCon());
            pst.setString(3,registro.getVarCon());

            retorno = pst.executeUpdate();//ESTO ME DICE CUANTOS REGISTROS FUERON AFECTADOS

        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return retorno;
    }

    //EL UPDATE ES SIMILAR
}
