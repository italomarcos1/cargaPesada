package dao;

import model.Categoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CategoriaDAO {

    private DataSource dataSource;

    public CategoriaDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Categoria> readAllCategoria(){
        try{
            String SQL = "SELECT * FROM CATEGORIA";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Categoria> lista = new ArrayList<Categoria>();

            while(rs.next()){

                Categoria cat = new Categoria();
                cat.setIdcategoria(rs.getInt("IDCATEGORIA"));
                cat.setNome(rs.getString("NOME"));

                lista.add(cat);
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
