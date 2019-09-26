/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.AlunoBO;
import modelo.NegocioException;
import modelo.entidades.Aluno;

/**
 *
* @author luish
 */
@ManagedBean
@RequestScoped
public class AlunoMB {

    private Aluno aluno = new Aluno();

    public AlunoMB() {
    }

    public List<Aluno> listar() throws NegocioException {
        AlunoBO bo = new AlunoBO();

        return bo.listar();

    }

    public String incluir() {

        return "cadastro";
    }

    public String salvar() throws NegocioException {

        AlunoBO bo = new AlunoBO();
        if(aluno.getId() > 0){
            bo.alterar(aluno);
        }else bo.incluir(aluno);

        

        return "lista";
    }

    public String alterar() throws NegocioException {

        AlunoBO bo = new AlunoBO();

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        aluno.setId(Integer.valueOf(id));

        aluno = bo.consultar(aluno);

        return "cadastro";

    }
    
    public String excluir() throws NegocioException{
        
        AlunoBO bo = new AlunoBO();
        
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        aluno.setId(Integer.valueOf(id));
        
        bo.excluir(aluno);
        
        return "lista?faces-redirect=true";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
