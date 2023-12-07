package com.mvc.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.detailsBean;
import com.mvc.dao.detDAO;



/**
 * Servlet implementation class detServlet
 */
@WebServlet("/detServlet")
public class detServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static detDAO dao;
	private int detID;
	private String forward;
	private static String LIST = "customerList.jsp";
	private static String EDIT = "custEdit.jsp";
	private static String ADD = "customerSupp.jsp";
	
	
	public detServlet() {
		super();
		dao = new detDAO();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listDetails")) {
			forward = LIST;
			request.setAttribute("dets", detDAO.getAll());
		}
		
		if(action.equalsIgnoreCase("editDetails")) {
			forward = EDIT;		
			detID = Integer.parseInt(request.getParameter("detailsID"));    	        	        	       	      	       	                
	        request.setAttribute("db", detDAO.getDetailsById(detID));
		}
		
		if(action.equalsIgnoreCase("deleteDetails")) {
			forward = LIST;
			detID = Integer.parseInt(request.getParameter("detailsID"));  
			dao.deleteDetails(detID);
			request.setAttribute("dets", detDAO.getAll());    
		}
		
		if(action.equalsIgnoreCase("addDetails")) {
			forward = ADD;
			request.setAttribute("dets", detDAO.getAll());	   
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dateString = request.getParameter("date");

		detailsBean db = new detailsBean();
		
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		Date dt;
        java.sql.Date sqlDate;

        try {
            dt = d.parse(dateString);
            sqlDate = new java.sql.Date(dt.getTime());
            db.setDate(sqlDate);
        } catch (ParseException ex) {
            Logger.getLogger(detServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		db.setName(request.getParameter("name"));
		db.setPhone(request.getParameter("phone"));
		db.setEmail(request.getParameter("email"));
		db.setQty(Integer.parseInt(request.getParameter("qty")));
		db.setPrice(Double.parseDouble(request.getParameter("price")));
		db.setDelivery(request.getParameter("delivery"));
		db.setMessage(request.getParameter("message"));
		
		String detID = request.getParameter("detailsID");
		
		if(detID ==null || detID.isEmpty()) {
	    	dao.add(db);
		}
		else {
			db.setDetailsID(Integer.parseInt(detID));
			dao.editDetails(db);
		}
		
		request.setAttribute("dets", detDAO.getAll());
	    RequestDispatcher view = request.getRequestDispatcher("customerList.jsp");
        view.forward(request, response);
	}

}