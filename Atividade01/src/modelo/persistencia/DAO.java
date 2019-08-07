/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.util.List;

/**
 *
 * @author luish
 * @param <T>
 */
public interface DAO<T> {
    List<T> listar() throws DadosException;
    
    void incluir(T entidade) throws DadosException;

    void alterar(T entidade) throws DadosException;

    void excluir(T entidade) throws DadosException;

    T consultar(int id) throws DadosException;

}
