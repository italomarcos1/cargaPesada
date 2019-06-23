package dao;

import model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    private DataSource dataSource;

    public ProdutoDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Produto> readAllProduto(){
        try{
            String SQL = "SELECT * FROM PRODUTO";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Produto> lista = new ArrayList<Produto>();

            while(rs.next()){

                Produto prd = new Produto();
                prd.setIdproduto(rs.getInt("IDPRODUTO"));
                prd.setNome(rs.getString("NOME"));
                prd.setPreco(rs.getFloat("PRECO"));
                prd.setPeso(rs.getFloat("PESO"));
                prd.setAltura(rs.getFloat("ALTURA"));
                prd.setLargura(rs.getFloat("LARGURA"));

                lista.add(prd);
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
