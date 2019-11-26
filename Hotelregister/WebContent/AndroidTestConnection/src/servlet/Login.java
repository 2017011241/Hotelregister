package servlet;

import java.io.IOException;
import com.google.gson.*;
import java.io.PrintWriter;
import Dao.BusinessDao;
import model.Business;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.UserDAO;
import model.User;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        //取出URL中的账号密码参数
	        String phoneNumber = request.getParameter(User.PHONENUMBER);
	        String passWord = request.getParameter(User.PASSWORD);
	        UserDAO userDAO = new UserDAO();
	        //验证过程
	        if (userDAO.isLoginOK(phoneNumber, passWord)) {
	            out.println("OK");
	        }else {
	            out.println("Wrong");
	        }

	        out.flush();
	        out.close();
//		 BusinessDao businessDao = new BusinessDao();
//		 int i = 0;
//		  i = businessDao.addBusiness();
//		  System.out.println(i);
//		 System.out.print("lihang");
		 
//		 PrintWriter out = response.getWriter();
//		 
//		 String tel = request.getParameter(User.PHONENUMBER);
//		 String passWord = request.getParameter(User.PASSWORD);
//		 
//		 Business business = new Business();
//		 
//		 BusinessDao businessDao = new BusinessDao();
//		 
//		 business = businessDao.findBusinessByTel(tel);
//		 if(tel.equals(business.getTel()) && passWord.equals(business.getPassword())) {
//			 out.println("OK");
//		 }
//		 else {
//			 out.print("Wrong");
//		 }
		 
//		 PrintWriter out = response.getWriter();
//		 Business business = new Business();
//		 business.setTel(request.getParameter(User.PHONENUMBER));
//		 business.setPassword(request.getParameter(User.PASSWORD));
//		 BusinessDao businessDao = new BusinessDao();
//		 if(businessDao.checkLogin(business)) {
//			 out.println("OK");
//		 }
//		 else {
//			 out.print("Wrong");
//		 }
	}	

}
