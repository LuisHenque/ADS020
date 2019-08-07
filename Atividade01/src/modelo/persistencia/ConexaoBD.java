/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luish
 */
public class ConexaoBD {

    private static Connection conexao;

    public static Connection getConexao() throws DadosException {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost/db_desktop", "root", "");
            } catch (ClassNotFoundException ex) {
                throw new DadosException("Erro ao carregar JDBC!");
            } catch (SQLException ex) {
                throw new DadosException("Erro ao conectar MySQL!");
            }
        }
        return conexao;
    }//fim do método
}
