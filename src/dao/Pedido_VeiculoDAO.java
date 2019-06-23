package dao;

import model.Pedido_Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pedido_VeiculoDAO {
    private DataSource dataSource;

    public Pedido_VeiculoDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Pedido_Veiculo> readAllPedido_Veiculo(){
        try{
            String SQL = "SELECT * FROM PEDIDO";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Pedido_Veiculo> lista = new ArrayList<Pedido_Veiculo>();

            while(rs.next()){

                Pedido_Veiculo ped = new Pedido_Veiculo();
                ped.setId_pedido(rs.getInt("ID_PEDIDO"));
                ped.setPlaca(rs.getString("PLACA"));

                lista.add(ped);
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
