package dao;

import model.Tipo_Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tipo_FuncionarioDAO {

    private DataSource dataSource;

    public Tipo_FuncionarioDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Tipo_Funcionario> readAllTipo_Funcionario(){
        try{
            String SQL = "SELECT * FROM TIPO_FUNCIONARIO";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Tipo_Funcionario> lista = new ArrayList<Tipo_Funcionario>();

            while(rs.next()){

                Tipo_Funcionario tpf = new Tipo_Funcionario();
                tpf.setIdtipo_funcionario(rs.getInt("IDTIPO_FUNCIONARIO"));
                tpf.setNome(rs.getString("NOME"));

                lista.add(tpf);
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
