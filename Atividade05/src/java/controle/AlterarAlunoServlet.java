/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AlunoBO;
import modelo.NegocioException;
import modelo.entidades.Aluno;

/**
 *
* @author luish
 */
@WebServlet(name = "AlterarAlunoServlet", urlPatterns = {"/aluno/alterar"})
public class AlterarAlunoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Aluno aluno = new Aluno();

        int id = Integer.parseInt(request.getParameter("id"));
        aluno.setId(id);
        AlunoBO bo = new AlunoBO();

        try {
          aluno =  bo.consultar(aluno);
        } catch (NegocioException e) {
            throw new ServletException("", e);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro de Alunos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Alterar Aluno</h1>");
            out.println("<form action=\"/Atividade05/aluno/alterar\" method=\"post\">");
            
            out.println("<input type=\"hidden\" name=\"id\" value=\"" + aluno.getId() + "\"/>");
            out.println("<div>");
            out.println("<label>Matrícula:</label>");
            out.println("<input type=\"text\" name=\"matricula\" size=\"15\" value=\"" + aluno.getMatricula() + "\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Nome:</label>");
            out.println("<input type=\"text\" name=\"nome\" size=\"30\" value=\"" + aluno.getNome() + "\">");
            out.println("</div>");
            out.println("<input type=\"submit\" value=\"Salvar\"/>");
            out.println("<a href=\"/Atividade05/aluno\">Desistir</a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Aluno aluno = new Aluno();

        aluno.setId(Integer.parseInt(request.getParameter("id")));
        aluno.setMatricula(Integer.parseInt(request.getParameter("matricula")));
        aluno.setNome(request.getParameter("nome"));

        AlunoBO bo = new AlunoBO();

        try {
            bo.alterar(aluno);
        } catch (NegocioException e) {
            throw new ServletException("", e);
        }
        
        response.sendRedirect(request.getContextPath()+"/aluno");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
