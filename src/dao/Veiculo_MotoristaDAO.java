package dao;

import model.Veiculo_Motorista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Veiculo_MotoristaDAO {

    private DataSource dataSource;

    public Veiculo_MotoristaDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Veiculo_Motorista> readAllVeiculo_Motorista(){
        try{
            String SQL = "SELECT * FROM VEICULO_MOTORISTA";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Veiculo_Motorista> lista = new ArrayList<Veiculo_Motorista>();

            while(rs.next()){

                Veiculo_Motorista vmt = new Veiculo_Motorista();
                vmt.setId_motorista(rs.getInt("ID_MOTORISTA"));
                vmt.setId_placa(rs.getString("ID_PLACA"));
                lista.add(vmt);

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
