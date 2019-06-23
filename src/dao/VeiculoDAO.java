package dao;

import model.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO {

    private DataSource dataSource;

    public VeiculoDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Veiculo> readAllVeiculo(){
        try{
            String SQL = "SELECT * FROM VEICULO";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Veiculo> lista = new ArrayList<Veiculo>();

            while(rs.next()){

                Veiculo vec = new Veiculo();
                vec.setPlaca(rs.getString("PLACA"));
                vec.setAnofab(rs.getInt("ANOFAB"));
                vec.setId_marca(rs.getInt("ID_MARCA"));
                vec.setId_modelo(rs.getInt("ID_MODELO"));
                vec.setLocal_uf(rs.getString("LOCAL_UF"));
                vec.setLocal_cep(rs.getString("LOCAL_CEP"));

                lista.add(vec);
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
