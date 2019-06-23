package dao;

import model.Setor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SetorDAO {

    private DataSource dataSource;

    public SetorDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Setor> readAllSetor(){
        try{
            String SQL = "SELECT * FROM SETOR";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Setor> lista = new ArrayList<Setor>();

            while(rs.next()){

                Setor set = new Setor();
                set.setIdsetor(rs.getInt("IDSETOR"));
                set.setNome(rs.getString("NOME"));
                lista.add(set);
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
