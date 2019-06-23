package dao;

import model.Pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PedidoDAO {

    private DataSource dataSource;

    public PedidoDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Pedido> readAllPedido(){
        try{
            String SQL = "SELECT * FROM PEDIDO";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Pedido> lista = new ArrayList<Pedido>();

            while(rs.next()){

                Pedido ped = new Pedido();
                ped.setIdpedido(rs.getInt("IDPEDIDO"));
                ped.setFrete(rs.getFloat("NOME"));
                ped.setId_produto(rs.getInt("ID_PRODUTO"));
                ped.setId_cliente(rs.getString("ID_CLIENTE"));

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
