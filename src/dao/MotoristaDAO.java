package dao;

import model.Motorista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MotoristaDAO {

    private DataSource dataSource;

    public MotoristaDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Motorista> readAllMotorista(){
        try{
            String SQL = "SELECT * FROM MOTORISTA";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Motorista> lista = new ArrayList<Motorista>();

            while(rs.next()){

                Motorista mot = new Motorista();
                mot.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                mot.setCnh(rs.getString("CNH"));
                mot.setMultas(rs.getInt("MULTAS"));
                mot.setValidade(rs.getDate("VALIDADE"));
                lista.add(mot);
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
