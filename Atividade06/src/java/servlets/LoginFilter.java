/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
* @author luish
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if (session.getAttribute("autenticado") != null
                || req.getRequestURI().equals(req.getContextPath() + "/login")) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

}
