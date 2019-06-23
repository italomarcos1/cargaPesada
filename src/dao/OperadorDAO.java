package dao;

import model.Operador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperadorDAO {

    private DataSource dataSource;

    public OperadorDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Operador> readAllOperador(){
        try{
            String SQL = "SELECT * FROM OPERADOR";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Operador> lista = new ArrayList<Operador>();

            while(rs.next()){

                Operador opr = new Operador();
                opr.setId_setor(rs.getInt("ID_SETOR"));
                opr.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                lista.add(opr);

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
