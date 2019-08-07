/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Aluno;

/**
 *
 * @author luish
 */
public class AlunoDAO implements DAO<Aluno> {

    @Override
    public List<Aluno> listar() throws DadosException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Aluno> lista = new ArrayList<Aluno>();

        try {
            String sql = "SELECT * FROM ALUNOS";
            Connection conexao = ConexaoBD.getConexao();
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            while (resultado.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(resultado.getInt(1));
                aluno.setMatricula(resultado.getInt(2));
                aluno.setNome(resultado.getString(3));
                lista.add(aluno);
            }
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar alunos!");
        }

        return lista;

    }

    @Override
    public List<Aluno> incluir(Aluno entidade) throws DadosException {
        try {
            String sql = "INSERT INTO ALUNOS(MATRICULA, NOME) VALUES(?,?)";
            Connection conexao = ConexaoBD.getConexao();
            PreparedStatement comando = conexao.preparedStatement(sql);
            comando.setInt(1, aluno.getMatricula());
            comando.setString(2, aluno.getNome());
            comando.executeUpdate();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao incluir aluno!");
        }
        return null;

    }

    @Override
    public void alterar(Aluno entidade) throws DadosException {
        try {
            String sql = "UPDATE ALUNOS SET MATRICULA=?, NOME=? WHERE ID=?";
            Connection conexao = ConexaoBD.getConexao();
            PreparedStatement comando = conexao.preparedStatement(sql);
            comando.setInt(1, aluno.getMatricula());
            comando.setString(2, aluno.getNome());
            comando.setInt(3, aluno.getId());
            comando.executeUpdate();
        } catch {
            throw new DadosException("Erro ao alterar aluno!");
            
        }
     }

    @Override
    public void excluir(Aluno entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno consultar(int id) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
