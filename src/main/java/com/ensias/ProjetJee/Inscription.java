package com.ensias.ProjetJee;

import beans.User;
import com.ensias.Forms.InsricptionForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Inscription  extends HttpServlet {
    public static String ROOT = "/WEB-INF/";
    public static String JSP = "inscription.jsp";
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
        InsricptionForm form = new InsricptionForm();
        User utilisateur =  form.inscrireUtilisateur(req);

        req.setAttribute("user",utilisateur);
       
        req.setAttribute("form",form);

        this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(req,resp);

    }
}
