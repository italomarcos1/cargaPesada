package dao;

import model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    private DataSource dataSource;

    public ClienteDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Cliente> readAllCliente(){
        try{
            String SQL = "SELECT * FROM CLIENTE";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Cliente> lista = new ArrayList<Cliente>();

            while(rs.next()){

                Cliente cli = new Cliente();
                cli.setIdcliente(rs.getString("IDCLIENTE"));
                cli.setNome(rs.getString("NOME"));
                cli.setTelefone(rs.getString("TELEFONE"));
                cli.setUf(rs.getString("UF"));
                cli.setCep(rs.getString("CEP"));
                cli.setCidade(rs.getString("CIDADE"));
                cli.setBairro(rs.getString("BAIRRO"));
                cli.setRua(rs.getString("RUA"));
                cli.setNumero(rs.getInt("NUMERO"));
                cli.setCompl(rs.getString("COMPL"));

                lista.add(cli);
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
