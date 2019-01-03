package com.amd.dbf.dao.dbf;

import com.amd.dbf.Aplicacion;
import com.amd.dbf.beans.Cpaf0050;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoCpaf0050 {
    private DBFReader dbfReader;

    //Solo deberían almacenar todos los registros en memoria si son pocos
    //Si son muchos mejor trabajarlo abriendo el archivo cada vez que sea necesario
    private List<Cpaf0050> registros;

    public DaoCpaf0050() {
    }

    public List<Cpaf0050> listarRegistros() throws Exception{
        ClassLoader classLoader = Aplicacion.class.getClassLoader();

        //Si no lo tienen en recursos, aqui debe ir la path relativo
        DBFReader dbfReader = new DBFReader(new FileInputStream("data/cpaf0050.dbf"));
        //Si esta en recursos se usa esta linea de codigo
        //DBFReader dbfReader = new DBFReader(classLoader.getResourceAsStream("data/cpaf0001.dbf"));

        DBFRow registro;

        this.registros = new ArrayList<>();

        System.gc();

        while((registro = dbfReader.nextRow()) != null){
            Cpaf0050 cpaf0050 = new Cpaf0050();
            cpaf0050.setCodSuc(registro.getString("COD_SUC"));
            cpaf0050.setCodAct(registro.getString("COD_ACT"));
            cpaf0050.setAntAct(registro.getString("ANT_ACT"));
            cpaf0050.setDesAct(registro.getString("DES_ACT"));
            cpaf0050.setFinAct(registro.getDate("FIN_ACT"));
            cpaf0050.setSgrAct(registro.getString("SGR_ACT"));
            cpaf0050.setSigAct(registro.getString("SIG_ACT"));
            cpaf0050.setVhiAct(registro.getBigDecimal("VHI_ACT"));
            cpaf0050.setVliAct(registro.getBigDecimal("VLI_ACT"));
            cpaf0050.setVtaAct(registro.getBigDecimal("VTA_ACT"));
            cpaf0050.setVreAct(registro.getBigDecimal("VRE_ACT"));
            cpaf0050.setVrpAct(registro.getBigDecimal("VRP_ACT"));
            cpaf0050.setVtdAct(registro.getBigDecimal("VTD_ACT"));
            cpaf0050.setVidAct(registro.getBigDecimal("VID_ACT"));
            cpaf0050.setFalAct(registro.getDate("FAL_ACT"));
            cpaf0050.setFudAct(registro.getDate("FUD_ACT"));
            cpaf0050.setFdpAct(registro.getBigDecimal("FDP_ACT"));
            cpaf0050.setVutAct(registro.getBigDecimal("VUT_ACT"));
            cpaf0050.setVumAct(registro.getBigDecimal("VUM_ACT"));
            cpaf0050.setFumAct(registro.getDate("FUM_ACT"));
            cpaf0050.setVuvAct(registro.getBigDecimal("VUV_ACT"));
            cpaf0050.setFuvAct(registro.getDate("FUV_ACT"));
            cpaf0050.setCtaAct(registro.getString("CTA_ACT"));
            cpaf0050.setCcoAct(registro.getString("CCO_ACT"));
            cpaf0050.setLgeAct(registro.getString("LGE_ACT"));
            cpaf0050.setUorAct(registro.getString("UOR_ACT"));
            cpaf0050.setPerAct(registro.getString("PER_ACT"));
            cpaf0050.setEstAct(registro.getString("EST_ACT"));
            cpaf0050.setTinAct(registro.getString("TIN_ACT"));
            cpaf0050.setNdiAct(registro.getString("NDI_ACT"));
            cpaf0050.setDinAct(registro.getString("DIN_ACT"));
            cpaf0050.setProAct(registro.getString("PRO_ACT"));
            cpaf0050.setCapAct(registro.getString("CAP_ACT"));
            cpaf0050.setCa1Act(registro.getString("CA1_ACT"));
            cpaf0050.setCa2Act(registro.getString("CA2_ACT"));
            cpaf0050.setSerAct(registro.getString("SER_ACT"));
            cpaf0050.setSumAct(registro.getString("SUM_ACT"));
            cpaf0050.setFbaAct(registro.getDate("FBA_ACT"));
            cpaf0050.setHisAct(registro.getBytes("HIS_ACT"));
            cpaf0050.setTdbAct(registro.getString("TDB_ACT"));
            cpaf0050.setNdbAct(registro.getString("NDB_ACT"));
            cpaf0050.setTabAct(registro.getBigDecimal("TAB_ACT"));
            cpaf0050.setObbAct(registro.getString("OBB_ACT"));
            cpaf0050.setEdoAct(registro.getString("EDO_ACT"));
            cpaf0050.setFlgAct(registro.getBoolean("FLG_ACT"));
            cpaf0050.setSegAct(registro.getString("SEG_ACT"));
            cpaf0050.setFenAct(registro.getDate("FEN_ACT"));
            cpaf0050.setFtdAct(registro.getDate("FTD_ACT"));
            cpaf0050.setClases(registro.getBigDecimal("CLASES"));
            cpaf0050.setServic(registro.getBigDecimal("SERVIC"));
            cpaf0050.setOricod(registro.getBigDecimal("ORICOD"));
            cpaf0050.setTipregul(registro.getString("TIPREGUL"));
            cpaf0050.setCodtipsnt(registro.getString("CODTIPSNT"));
            cpaf0050.setActcurso(registro.getBigDecimal("ACTCURSO"));
            cpaf0050.setKfw(registro.getBigDecimal("KFW"));
            cpaf0050.setDimen(registro.getString("DIMEN"));
            cpaf0050.setDonador(registro.getString("DONADOR"));
            this.registros.add(cpaf0050);
        }

        dbfReader.close();

        return registros;
    }
}
