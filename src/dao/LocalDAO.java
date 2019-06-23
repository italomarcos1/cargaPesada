package dao;

import model.Local;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalDAO {

    private DataSource dataSource;

    public LocalDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }


    public ArrayList<Local> readAllLocal(){
        try{
            String SQL = "SELECT * FROM LOCAL";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Local> lista = new ArrayList<Local>();

            while(rs.next()){

                Local loc = new Local();
                loc.setUf(rs.getString("UF"));
                loc.setCep(rs.getString("CEP"));
                loc.setCidade(rs.getString("CIDADE"));
                loc.setBairro(rs.getString("BAIRRO"));
                loc.setRua(rs.getString("RUA"));
                loc.setNumero(rs.getInt("NUMERO"));
                loc.setCompl(rs.getString("COMPL"));

                lista.add(loc);
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
