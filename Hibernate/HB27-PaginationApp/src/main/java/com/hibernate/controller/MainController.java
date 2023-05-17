package com.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import com.hibernate.dto.BankAccountDTO;
import com.hibernate.service.BankAccountServiceImpl;
import com.hibernate.service.IBankAccountService;


@WebServlet("/get")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private IBankAccountService service =null ;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new BankAccountServiceImpl();
	}
  
    public MainController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageSize = 0; 
		int pageNo = 0;
		List<BankAccountDTO> listDtos = null;
		long pageCount = 0L;
		String targetPage = null;
		RequestDispatcher rDispatcher = null;
		HttpSession session = null;
		
		String value = request.getParameter("s1");
		session = request.getSession(true);
		
		if (value.equalsIgnoreCase("generatereport")) {
			// Get Value From Button
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			System.out.println("PageSize ::= "+pageSize);
			pageNo = 1;
			
			if (session!=null) {
				session.setAttribute("pageSize", pageSize);
			}
			
		}else {
			// Getting the Value from hyperlink
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			if (session!=null) {
				pageSize = (int) session.getAttribute("pageSize");
				
			}
		}
		
		
		
		try {
		 
		 pageCount = service.fetchPageCount(pageSize);
		 listDtos = service.fetchPageData(pageSize, pageNo);
		 
		 request.setAttribute("accountList", listDtos);
		 request.setAttribute("pageCount", pageCount);
		 request.setAttribute("pageSize", pageSize);
		 request.setAttribute("pageNo", pageNo);
		 targetPage = "./report.jsp";
		 
		}catch (HibernateException e) {
             e.printStackTrace();
             targetPage = "./errorjsp";
             
		}catch (Exception e) {
			e.printStackTrace();
			targetPage = "./errorjsp";
		}
		
		request.setAttribute("list",listDtos );
		rDispatcher = request.getRequestDispatcher(targetPage);
		rDispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
