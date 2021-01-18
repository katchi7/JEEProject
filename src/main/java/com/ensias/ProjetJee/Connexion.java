package com.ensias.ProjetJee;

import beans.User;
import com.ensias.Forms.ConnexionForm;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Connexion extends HttpServlet {
    public static String ROOT = "/WEB-INF/";
    public static String JSP = "connexion.jsp";
    public static String AFTER_LOGGING = "/";
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	if(req.getSession().getAttribute("user")!=null) resp.sendRedirect(AFTER_LOGGING);
    	else {
    		this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(req,resp);
    	}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnexionForm form = new ConnexionForm();
        User utilisateur = form.inscrireUtilisateur(req);
        HttpSession session = req.getSession();
        req.setAttribute("form",form);
        req.setAttribute("user",utilisateur);
        if(form.getErrors().isEmpty()){
        	System.out.println("User PASSWORD : "+utilisateur.getPassword()+" USER PASSWORD HASH256 : "+ utilisateur.getPasswordAsHash());
            session.setAttribute("user",utilisateur);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(60 * 60 * 24 * 365);
            resp.addCookie(cookie);
        }
        
        resp.sendRedirect(AFTER_LOGGING);

    }
}
