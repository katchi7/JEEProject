package com.ensias.ProjetJee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensias.beans.Event;
import com.ensias.beans.User;
import com.ensias.dao.DaoEvent;
import com.ensias.dao.DaoFactory;


public class Calendrier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ATT_DAO_FACTORY = "daofactory";
	public static String TODO_FORM =  "TODO_FORM_SRC";
	DaoEvent daoEvent;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calendrier() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        super.init();
        //Get the Dao
        daoEvent = ((DaoFactory) this.getServletContext().getAttribute(ATT_DAO_FACTORY)).getDaoEvent();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		ArrayList<Event> evs = daoEvent.findUserEvents(user.getId());
		request.setAttribute("events", evs);
		session.setAttribute("TODO_FORM_SRC", "/ensiasdocs/calendrier");
		this.getServletContext().getRequestDispatcher("/WEB-INF/calendrier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
