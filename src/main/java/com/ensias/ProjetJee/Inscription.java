package com.ensias.ProjetJee;

import com.ensias.beans.User;
import com.ensias.dao.DAOUser;
import com.ensias.dao.DaoFactory;
import com.ensias.Forms.InsricptionForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Inscription  extends HttpServlet {
    public static String ROOT = "/WEB-INF/";
    public static String JSP = "inscription.jsp";
    public static String AFTER_LOGGING = "/ensiasdocs/home";
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
        InsricptionForm form = new InsricptionForm(this.daoUser);
        User utilisateur =  form.inscrireUtilisateur(req);

        req.setAttribute("user",utilisateur);;
        
       
        req.setAttribute("form",form);

        this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(req,resp);

    }
}
