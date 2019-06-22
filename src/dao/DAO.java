package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class DAO {
    private DataSource dataSource;

    public DAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Cliente> readAllCliente(){
        try{
            String SQL = "SELECT * FROM CLIENTE";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Cliente> lista = new ArrayList<Cliente>();

            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setIdcliente(rs.getInt("IDCLIENTE"));
                cli.setNome(rs.getString("NOME"));
                cli.setTelefone(rs.getString("TELEFONE"));
                cli.setId_tipo_cliente(rs.getString("ID_TIPO_CLIENTE"));
                cli.setLocal_ceṕ(rs.getString("LOCAL_CEP"));
                cli.setLocal_uf(rs.getString("LOCAL_UF"));
                lista.add(cli);
            }
            ps.close();
            return lista;
        }
        catch (SQLException ex){
            System.err.println("Erro ao recuperar os dados."+ex.getMessage());
        }
        catch (Exception ex){
            System.err.println("Erro geral."+ex.getMessage());
        }
        return null;
    }

    public ArrayList<Carga> readAllCarga(){
        try{
            String SQL = "SELECT * FROM CARGA";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Carga> lista = new ArrayList<Carga>();

            while(rs.next()){
                Carga str = new Carga();
                str.setLotenum(rs.getInt("LOTENUM"));
                str.setPesoliq (rs.getFloat("PESOLIQ"));
                str.setLocal_ceṕ(rs.getString("LOCAL_CEP"));
                str.setLocal_uf(rs.getString("LOCAL_UF"));
                str.setVeiculo_placa(rs.getString("VEICULO_PLACA"));
                str.setVeiculo_prefixo(rs.getString("VEICULO_PREFIXO"));
                lista.add(str);
            }
            ps.close();
            return lista;
        }
        catch (SQLException ex){
            System.err.println("Erro ao recuperar os dados."+ex.getMessage());
        }
        catch (Exception ex){
            System.err.println("Erro geral."+ex.getMessage());
        }
        return null;
    }

    public ArrayList<Local> readAllLocal(){
        try{
            String SQL = "SELECT * FROM LOCAL";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Local> lista = new ArrayList<Local>();

            while(rs.next()){
                Local str = new Local();
                str.setUf(rs.getString("LOCAL_UF"));
                str.setBairro(rs.getString("BAIRRO"));
                str.setCidade(rs.getString("CIDADE"));
                str.setCep(rs.getString("CEP"));
                str.setCompl(rs.getString("COMPL"));

                lista.add(str);
            }
            ps.close();
            return lista;
        }
        catch (SQLException ex){
            System.err.println("Erro ao recuperar os dados."+ex.getMessage());
        }
        catch (Exception ex){
            System.err.println("Erro geral."+ex.getMessage());
        }
        return null;
    }

    public ArrayList<Veiculo> readAllVeiculo(){
        try{
            String SQL = "SELECT * FROM VEICULO";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Veiculo> lista = new ArrayList<Veiculo>();

            while(rs.next()){
                Veiculo str = new Veiculo();
                str.setPlaca(rs.getString("PLACA"));
                str.setPrefixo(rs.getString("PREFIXO"));
                str.setMarca(rs.getString("MARCA"));
                str.setModelo(rs.getString("MODELO"));
                str.setNumreg(rs.getString("NUMREG"));
                str.setPesobruto(rs.getFloat("PESOBRUTO"));
                str.setAnofab(rs.getInt("ANOFAB"));
                str.setAnoativ(rs.getInt("ANOATIV"));
                str.setTara(rs.getFloat("TARA"));
                str.setEixos(rs.getString("EIXOS"));
                str.setKm(rs.getInt("KM"));
                str.setManut(rs.getString("MANUT"));
                str.setId_tipo_veiculo(rs.getInt("ID_TIPO_VEICULO"));
                lista.add(str);
            }
            ps.close();
            return lista;
        }
        catch (SQLException ex){
            System.err.println("Erro ao recuperar os dados."+ex.getMessage());
        }
        catch (Exception ex){
            System.err.println("Erro geral."+ex.getMessage());
        }
        return null;
    }

    public ArrayList<Tipo_Cliente> readAllTipo_Cliente(){
        try{
            String SQL = "SELECT * FROM TIPO_CLIENTE";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Tipo_Cliente> lista = new ArrayList<Tipo_Cliente>();

            while(rs.next()){
                Tipo_Cliente str = new Tipo_Cliente();
                str.setId_tipo_cliente(rs.getInt("ID_TIPO_CLIENTE"));
                str.setNome(rs.getString("NOME"));
                str.setNumcad(rs.getString("NUMCAD"));
                lista.add(str);
            }
            ps.close();
            return lista;
        }
        catch (SQLException ex){
            System.err.println("Erro ao recuperar os dados."+ex.getMessage());
        }
        catch (Exception ex){
            System.err.println("Erro geral."+ex.getMessage());
        }
        return null;
    }

    public ArrayList<Tipo_Veiculo> readAllTipo_Veiculo(){
        try{
            String SQL = "SELECT * FROM TIPO_VEICULO";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Tipo_Veiculo> lista = new ArrayList<Tipo_Veiculo>();

            while(rs.next()){
                Tipo_Veiculo str = new Tipo_Veiculo();
                str.setId_tipo_veiculo(rs.getInt("ID_TIPO_VEICULO"));
                str.setNome(rs.getString("NOME"));
                lista.add(str);
            }
            ps.close();
            return lista;
        }
        catch (SQLException ex){
            System.err.println("Erro ao recuperar os dados."+ex.getMessage());
        }
        catch (Exception ex){
            System.err.println("Erro geral."+ex.getMessage());
        }
        return null;
    }

}
