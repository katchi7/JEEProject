package com.ensias.ProjetJee;

import beans.User;
import com.ensias.Forms.ConnexionForm;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Connexion extends HttpServlet {
    public static String ROOT = "/WEB-INF/";
    public static String JSP = "connexion.jsp";
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnexionForm form = new ConnexionForm();
        User utilisateur = form.inscrireUtilisateur(req);
        HttpSession session = req.getSession();

        req.setAttribute("form",form);
        req.setAttribute("user",utilisateur);
        if(form.getErrors().isEmpty()) session.setAttribute("user",utilisateur);

        this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(req,resp);

    }
}
