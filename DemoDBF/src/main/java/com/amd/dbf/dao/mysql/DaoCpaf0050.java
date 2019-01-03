package com.amd.dbf.dao.mysql;

import com.amd.dbf.beans.Cpaf0050;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCpaf0050 {

    private Connection connection;
    public DaoCpaf0050(Connection connection){
        this.connection = connection;
    }

    /**
     * Retorna una lista con los registros en la BD
     * @return
     */
    public List<Cpaf0050> listarRegistros(){
        List<Cpaf0050> registros;

        try(Statement st = this.connection.createStatement();
            ResultSet registro = st.executeQuery("select * from cpaf0050")){
            registros = new ArrayList<>();
            while (registro.next()){
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
                registros.add(cpaf0050);
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
    public boolean insertRegistro(Cpaf0050 nuevoRegistro){
        boolean retorno = false;

        //CADA '?' representa un parametro que se debe setear en orden con
        //la familia de metodos set de la clase PreparedStatement
        try(PreparedStatement pst = this.connection.prepareStatement(
                "INSERT INTO cpaf0050(\n" +
                        "\tcod_suc, cod_act, ant_act, des_act, fin_act, sgr_act, sig_act, vhi_act, vli_act, vta_act, vre_act, vrp_act, vtd_act, vid_act, fal_act, fud_act, fdp_act, vut_act, vum_act, fum_act, vuv_act, fuv_act, cta_act, cco_act, lge_act, uor_act, per_act, est_act, tin_act, ndi_act, din_act, pro_act, cap_act, ca1_act, ca2_act, ser_act, sum_act, fba_act, his_act, tdb_act, ndb_act, tab_act, obb_act, edo_act, flg_act, seg_act, fen_act, ftd_act, clases, servic, oricod, tipregul, codtipsnt, actcurso, kfw, dimen, donador)\n" +
                        "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")){

            int i = 1;
            pst.setString(i++,nuevoRegistro.getCodSuc());
            pst.setString(i++,nuevoRegistro.getCodAct());
            pst.setString(i++,nuevoRegistro.getAntAct());
            pst.setString(i++,nuevoRegistro.getDesAct());
            pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFinAct()));
            pst.setString(i++,nuevoRegistro.getSgrAct());
            pst.setString(i++,nuevoRegistro.getSigAct());
            pst.setBigDecimal(i++,nuevoRegistro.getVhiAct());
            pst.setBigDecimal(i++,nuevoRegistro.getVliAct());
            pst.setBigDecimal(i++,nuevoRegistro.getVtaAct());
            pst.setBigDecimal(i++,nuevoRegistro.getVreAct());
            pst.setBigDecimal(i++,nuevoRegistro.getVrpAct());
            pst.setBigDecimal(i++,nuevoRegistro.getVtdAct());
            pst.setBigDecimal(i++,nuevoRegistro.getVidAct());
            pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFalAct()));
            pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFudAct()));
            pst.setBigDecimal(i++,nuevoRegistro.getFdpAct());
            pst.setBigDecimal(i++,nuevoRegistro.getVutAct());
            pst.setBigDecimal(i++,nuevoRegistro.getVumAct());
            pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFumAct()));
            pst.setBigDecimal(i++,nuevoRegistro.getVuvAct());
            pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFuvAct()));
            pst.setString(i++,nuevoRegistro.getCtaAct());
            pst.setString(i++,nuevoRegistro.getCcoAct());
            pst.setString(i++,nuevoRegistro.getLgeAct());
            pst.setString(i++,nuevoRegistro.getUorAct());
            pst.setString(i++,nuevoRegistro.getPerAct());
            pst.setString(i++,nuevoRegistro.getEstAct());
            pst.setString(i++,nuevoRegistro.getTinAct());
            pst.setString(i++,nuevoRegistro.getNdiAct());
            pst.setString(i++,nuevoRegistro.getDinAct());
            pst.setString(i++,nuevoRegistro.getProAct());
            pst.setString(i++,nuevoRegistro.getCapAct());
            pst.setString(i++,nuevoRegistro.getCa1Act());
            pst.setString(i++,nuevoRegistro.getCa2Act());
            pst.setString(i++,nuevoRegistro.getSerAct());
            pst.setString(i++,nuevoRegistro.getSumAct());
            pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFbaAct()));
            pst.setBytes(i++,nuevoRegistro.getHisAct());
            pst.setString(i++,nuevoRegistro.getTdbAct());
            pst.setString(i++,nuevoRegistro.getNdbAct());
            pst.setBigDecimal(i++,nuevoRegistro.getTabAct());
            pst.setString(i++,nuevoRegistro.getObbAct());
            pst.setString(i++,nuevoRegistro.getEdoAct());
            pst.setBoolean(i++,nuevoRegistro.getFlgAct());
            pst.setString(i++,nuevoRegistro.getSegAct());
            pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFenAct()));
            pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFtdAct()));
            pst.setBigDecimal(i++,nuevoRegistro.getClases());
            pst.setBigDecimal(i++,nuevoRegistro.getServic());
            pst.setBigDecimal(i++,nuevoRegistro.getOricod());
            pst.setString(i++,nuevoRegistro.getTipregul());
            pst.setString(i++,nuevoRegistro.getCodtipsnt());
            pst.setBigDecimal(i++,nuevoRegistro.getActcurso());
            pst.setBigDecimal(i++,nuevoRegistro.getKfw());
            pst.setString(i++,nuevoRegistro.getDimen());
            pst.setString(i++,nuevoRegistro.getDonador());

            pst.executeUpdate();

            retorno = true;
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return retorno;
    }

    /**
     * Retorna true si el registro fue exitoso o false si hubo un error
     * Este es para casos donde hubiesen muchos registros
     * @return
     */
    public boolean insertVariosRegistro(List<Cpaf0050> nuevosRegistros){
        boolean retorno = false;

        //CADA '?' representa un parametro que se debe setear en orden con
        //la familia de metodos set de la clase PreparedStatement
        try(PreparedStatement pst = this.connection.prepareStatement(
                "INSERT INTO cpaf0050(\n" +
                        "\tcod_suc, cod_act, ant_act, des_act, fin_act, sgr_act, sig_act, vhi_act, vli_act, vta_act, vre_act, vrp_act, vtd_act, vid_act, fal_act, fud_act, fdp_act, vut_act, vum_act, fum_act, vuv_act, fuv_act, cta_act, cco_act, lge_act, uor_act, per_act, est_act, tin_act, ndi_act, din_act, pro_act, cap_act, ca1_act, ca2_act, ser_act, sum_act, fba_act, his_act, tdb_act, ndb_act, tab_act, obb_act, edo_act, flg_act, seg_act, fen_act, ftd_act, clases, servic, oricod, tipregul, codtipsnt, actcurso, kfw, dimen, donador)\n" +
                        "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")){

            for(Cpaf0050 nuevoRegistro : nuevosRegistros){
                int i = 1;

                pst.setString(i++,nuevoRegistro.getCodSuc());
                pst.setString(i++,nuevoRegistro.getCodAct());
                pst.setString(i++,nuevoRegistro.getAntAct());
                pst.setString(i++,nuevoRegistro.getDesAct());
                pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFinAct()));
                pst.setString(i++,nuevoRegistro.getSgrAct());
                pst.setString(i++,nuevoRegistro.getSigAct());
                pst.setBigDecimal(i++,nuevoRegistro.getVhiAct());
                pst.setBigDecimal(i++,nuevoRegistro.getVliAct());
                pst.setBigDecimal(i++,nuevoRegistro.getVtaAct());
                pst.setBigDecimal(i++,nuevoRegistro.getVreAct());
                pst.setBigDecimal(i++,nuevoRegistro.getVrpAct());
                pst.setBigDecimal(i++,nuevoRegistro.getVtdAct());
                pst.setBigDecimal(i++,nuevoRegistro.getVidAct());
                pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFalAct()));
                pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFudAct()));
                pst.setBigDecimal(i++,nuevoRegistro.getFdpAct());
                pst.setBigDecimal(i++,nuevoRegistro.getVutAct());
                pst.setBigDecimal(i++,nuevoRegistro.getVumAct());
                pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFumAct()));
                pst.setBigDecimal(i++,nuevoRegistro.getVuvAct());
                pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFuvAct()));
                pst.setString(i++,nuevoRegistro.getCtaAct());
                pst.setString(i++,nuevoRegistro.getCcoAct());
                pst.setString(i++,nuevoRegistro.getLgeAct());
                pst.setString(i++,nuevoRegistro.getUorAct());
                pst.setString(i++,nuevoRegistro.getPerAct());
                pst.setString(i++,nuevoRegistro.getEstAct());
                pst.setString(i++,nuevoRegistro.getTinAct());
                pst.setString(i++,nuevoRegistro.getNdiAct());
                pst.setString(i++,nuevoRegistro.getDinAct());
                pst.setString(i++,nuevoRegistro.getProAct());
                pst.setString(i++,nuevoRegistro.getCapAct());
                pst.setString(i++,nuevoRegistro.getCa1Act());
                pst.setString(i++,nuevoRegistro.getCa2Act());
                pst.setString(i++,nuevoRegistro.getSerAct());
                pst.setString(i++,nuevoRegistro.getSumAct());
                pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFbaAct()));
                pst.setBytes(i++,nuevoRegistro.getHisAct());
                pst.setString(i++,nuevoRegistro.getTdbAct());
                pst.setString(i++,nuevoRegistro.getNdbAct());
                pst.setBigDecimal(i++,nuevoRegistro.getTabAct());
                pst.setString(i++,nuevoRegistro.getObbAct());
                pst.setString(i++,nuevoRegistro.getEdoAct());
                pst.setBoolean(i++,nuevoRegistro.getFlgAct());
                pst.setString(i++,nuevoRegistro.getSegAct());
                pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFenAct()));
                pst.setDate(i++,convertUtilToSql(nuevoRegistro.getFtdAct()));
                pst.setBigDecimal(i++,nuevoRegistro.getClases());
                pst.setBigDecimal(i++,nuevoRegistro.getServic());
                pst.setBigDecimal(i++,nuevoRegistro.getOricod());
                pst.setString(i++,nuevoRegistro.getTipregul());
                pst.setString(i++,nuevoRegistro.getCodtipsnt());
                pst.setBigDecimal(i++,nuevoRegistro.getActcurso());
                pst.setBigDecimal(i++,nuevoRegistro.getKfw());
                pst.setString(i++,nuevoRegistro.getDimen());
                pst.setString(i++,nuevoRegistro.getDonador());

                pst.executeUpdate();

                System.out.println("ingresado "+ nuevoRegistro.toString());
            }
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
    public int borrarRegistro(Cpaf0050 registro){
        int retorno = -1;
        //CADA '?' representa un parametro que se debe setear en orden con
        //la familia de metodos set de la clase PreparedStatement
        try(PreparedStatement pst = this.connection.prepareStatement(
                "DELETE FROM cpaf0050 WHERE COD_ACT = ? ")){
            pst.setString(1,registro.getCodAct());

            retorno = pst.executeUpdate();//ESTO ME DICE CUANTOS REGISTROS FUERON AFECTADOS

        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return retorno;
    }

    private java.sql.Date convertUtilToSql(java.util.Date uDate) {

        if(uDate == null)
            return null;

        java.sql.Date sDate = new java.sql.Date(uDate.getTime());

        return sDate;

    }


}
