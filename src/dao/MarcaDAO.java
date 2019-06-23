package dao;

import model.Marca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarcaDAO {

    private DataSource dataSource;

    public MarcaDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Marca> readAllMarca(){
        try{
            String SQL = "SELECT * FROM MARCA";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Marca> lista = new ArrayList<Marca>();

            while(rs.next()){

                Marca mar = new Marca();
                mar.setIdmarca(rs.getInt("IDMARCA"));
                mar.setNome(rs.getString("NOME"));

                lista.add(mar);
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
