package com.amd.dbf.dao.dbf;

import com.amd.dbf.Aplicacion;
import com.amd.dbf.beans.Cpaf0001;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFWriter;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.File;

public class DaoCpaf0001 implements Comparator<Cpaf0001> {

    private DBFReader dbfReader;

    //Solo deberían almacenar todos los registros en memoria si son pocos
    //Si son muchos mejor trabajarlo abriendo el archivo cada vez que sea necesario
    private List<Cpaf0001> registros;

    public DaoCpaf0001() {
    }

    public List<Cpaf0001> listarRegistros() throws Exception{
        ClassLoader classLoader = Aplicacion.class.getClassLoader();

        //Si no lo tienen en recursos, aqui debe ir la path relativo
        DBFReader dbfReader = new DBFReader(new FileInputStream("data/cpaf0001.dbf"));
        //Si esta en recursos se usa esta linea de codigo
        //DBFReader dbfReader = new DBFReader(classLoader.getResourceAsStream("data/cpaf0001.dbf"));

        DBFRow registro;

        this.registros = new ArrayList<>();

        System.gc();

        while((registro = dbfReader.nextRow()) != null){
            Cpaf0001 cpaf0001 = new Cpaf0001();
            cpaf0001.setDbfCon(registro.getString("DBF_CON"));
            cpaf0001.setDesCon(registro.getString("DES_CON"));
            cpaf0001.setVarCon(registro.getString("VAR_CON"));

            this.registros.add(cpaf0001);
        }

        dbfReader.close();

        return registros;
    }

    /*
     *
     * Probe el insert y parece que no funciona de forma adecuada tampoco
     *
     *
     */
    //UPDATE Y DELETE PARECEN NO ESTAR SOPORTADOS EN ESE DRIVER

    //Este metodo sirve para ordenar la lista
    //Puedes comparar por cualquier campo del Bean Cpaf0001
    //Preferiblemente las cadenas y numeros, los campos memos representados con
    //byte[] no deberían ser comparados
    @Override
    public int compare(Cpaf0001 o1, Cpaf0001 o2) {
        return o1.getDbfCon().compareTo(o2.getDbfCon()) ;
    }
}
