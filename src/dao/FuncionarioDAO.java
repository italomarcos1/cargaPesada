package dao;

import model.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {

    private DataSource dataSource;

    public FuncionarioDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Funcionario> readAllTipo_Funcionario(){
        try{
            String SQL = "SELECT * FROM TIPO_FUNCIONARIO";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

            while(rs.next()){

                Funcionario tpf = new Funcionario();
                tpf.setIdfuncionario(rs.getInt("IDFUNCIONARIO"));
                tpf.setNome(rs.getString("NOME"));
                tpf.setSexo(rs.getString("SEXO"));
                tpf.setTelefone(rs.getString("TELEFONE"));
                tpf.setDate(rs.getDate("DATAENT"));
                tpf.setHoras(rs.getInt("HORAS"));
                tpf.setId_tipo_funcionario(rs.getInt("ID_TIPO_FUNCIONARIO"));
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
