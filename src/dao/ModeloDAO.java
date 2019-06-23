package dao;

import model.Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloDAO {

    private DataSource dataSource;

    public ModeloDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Modelo> readAllModelo(){
        try{
            String SQL = "SELECT * FROM MODELO";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Modelo> lista = new ArrayList<Modelo>();

            while(rs.next()){

                Modelo mod = new Modelo();
                mod.setIdmodelo(rs.getInt("IDMODELO"));
                mod.setNome(rs.getString("NOME"));

                lista.add(mod);
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
