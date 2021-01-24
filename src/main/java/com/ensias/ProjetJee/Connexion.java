package com.ensias.ProjetJee;

import com.ensias.beans.User;
import com.ensias.dao.DAOUser;
import com.ensias.dao.DaoFactory;
import com.ensias.Forms.ConnexionForm;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Connexion extends HttpServlet {
    public static String ROOT = "/WEB-INF/";
    public static String JSP = "connexion.jsp";
    public static String AFTER_LOGGING = "/";
    private static final String ATT_DAO_FACTORY = "daofactory";
    private DAOUser daoUser = null;
    @Override
    public void init() throws ServletException {
        super.init();
        daoUser = ((DaoFactory) this.getServletContext().getAttribute(ATT_DAO_FACTORY)).getDaoUser();
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
        ConnexionForm form = new ConnexionForm(daoUser);
        User utilisateur = form.inscrireUtilisateur(req);
        HttpSession session = req.getSession();
        req.setAttribute("form",form);
        req.setAttribute("user",utilisateur);
        if(form.getErrors().isEmpty()){
        	
            session.setAttribute("user",utilisateur);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(60 * 60 * 24 * 365);
            resp.addCookie(cookie);
            resp.sendRedirect(AFTER_LOGGING);
        }
        else {
        	this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(req, resp);
        }
        
        

    }
}
