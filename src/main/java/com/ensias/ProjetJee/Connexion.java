package com.ensias.ProjetJee;

import com.ensias.beans.User;
import com.ensias.dao.DAOUser;
import com.ensias.dao.DaoFactory;
import com.ensias.Filters.AuthFilter;
import com.ensias.Forms.ConnexionForm;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Connexion extends HttpServlet {
    public static String ROOT = "/WEB-INF/";
    public static String JSP = "connexion.jsp";
    public static String AFTER_LOGGING = "/ensiasdocs/home";
    private static final String ATT_DAO_FACTORY = "daofactory";
    private DAOUser daoUser = null;
    @Override
    public void init() throws ServletException {
        super.init();
        //Get the Dao
        daoUser = ((DaoFactory) this.getServletContext().getAttribute(ATT_DAO_FACTORY)).getDaoUser();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	//Check if user is Authenticated
    	if(req.getSession().getAttribute("user")!=null) resp.sendRedirect(AFTER_LOGGING);
    	else {//Send the login page
    		this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(req,resp);
    	}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnexionForm form = new ConnexionForm(daoUser);
        //Create user from form
        User utilisateur = form.inscrireUtilisateur(req);
        
        HttpSession session = req.getSession();
        req.setAttribute("form",form);
        req.setAttribute("user",utilisateur);
        
        if(form.getErrors().isEmpty()){
        	//Authenticate user
            session.setAttribute("user",utilisateur);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(60 * 60 * 24 * 365);
            resp.addCookie(cookie);
            //Check if user is redirected from auther pages
            if(session.getAttribute(AuthFilter.WantedPage) != null) { AFTER_LOGGING = (String)session.getAttribute(AuthFilter.WantedPage);session.setAttribute(AuthFilter.WantedPage,null);}
            resp.sendRedirect(AFTER_LOGGING);
            AFTER_LOGGING = "/ensiasdocs/home";
        }
        else {
        	this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(req, resp);
        };
        
        

    }
}
