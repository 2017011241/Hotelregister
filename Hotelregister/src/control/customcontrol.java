package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dao.RoomDao;
import hotel.model.Custom;
import hotel.model.Room;
import util.DBBean;

public class customcontrol extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException 
	{ 
		doPost(request,response); 
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("GBK");
		String actionUrl=request.getServletPath();
		if(actionUrl.equals("/set.action"))
		{
			
			int id=Integer.valueOf(request.getParameter("customid"));
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String settime=request.getParameter("settime");
			String livetime=request.getParameter("livetime");
			int roomid=Integer.valueOf(request.getParameter("roomid"));
			RoomDao db=new RoomDao();
			CustomDao bue=new CustomDao();
			int result=db.Insert(id, name, phone, settime, livetime, roomid);
			bue.updateforcustom(String.valueOf(id), name, phone, settime, livetime, roomid);
			int result1=db.Updateforinsert(id, roomid);
			if(result==1&&result1==1)
			{
				request.getRequestDispatcher("successfull.jsp") .forward(request,response);
			}
			else
			{
				request.getRequestDispatcher("filureseting.jsp") .forward(request,response);
			}
		}
		else if(actionUrl.equals("/select.action"))
		{
			System.out.println("success select");
			RoomDao db=new RoomDao();
			ArrayList<Room> list=db.getUserList(); 
			request.setAttribute("list",list); 
			request.getRequestDispatcher("selectRoom.jsp") .forward(request,response);
		}
		else if(actionUrl.equals("/selectCus.action"))
		{
			String id=request.getParameter("customid");
			CustomDao cus=new CustomDao();
			ArrayList<Custom> list=cus.getUserList(id); 
			if(list.isEmpty())
			{
				request.getRequestDispatcher("fulireupdate.jsp") .forward(request,response);
			}
			else
			{
				request.setAttribute("list",list); 
				request.getRequestDispatcher("selectCustom.jsp") .forward(request,response);
			}
		}
		else if(actionUrl.equals("/selectCusforall.action"))
		{
			CustomDao cus=new CustomDao();
			ArrayList<Custom> list=cus.getAlluser(); 
			request.setAttribute("list",list); 
			request.getRequestDispatcher("selectCustomforall.jsp") .forward(request,response);
		}
		else if(actionUrl.equals("/update.action"))
		{
			String customid=request.getParameter("customid");
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String settime=request.getParameter("settime");
			String livetime=request.getParameter("livetime");
			int roomid=Integer.valueOf(request.getParameter("roomid"));
			int lastroomid=Integer.valueOf(request.getParameter("lastroomid"));
			System.out.println(customid+"\n");
			System.out.println(name+"\n");
			System.out.println(phone+"\n");
			System.out.println(settime+"\n");
			System.out.println(livetime+"\n");
			System.out.println(roomid+"\n");
			CustomDao customdao=new CustomDao();
			RoomDao roomdao=new RoomDao();
			int result=customdao.updateforcustom(customid, name, phone, settime, livetime, roomid);
			int result1=roomdao.Updateforcustom(customid, roomid, lastroomid);
			if(result==1)
			{
				ArrayList<Custom> list=customdao.getAlluser();
				request.setAttribute("list",list); 
				request.getRequestDispatcher("selectCustomforall.jsp") .forward(request,response);
			}
		}
		else if(actionUrl.equals("/selectCusforlive.action"))
		{
			String id=request.getParameter("customid");
			CustomDao cus=new CustomDao();
			ArrayList<Custom> list=cus.getUserList(id); 
			if(list.isEmpty())
			{
				request.getRequestDispatcher("fulirelive.jsp") .forward(request,response);
			}
			else
			{
				request.setAttribute("list",list); 
				request.getRequestDispatcher("livesubmit.jsp") .forward(request,response);
			}
		}
		else if(actionUrl.equals("/live.action"))
		{
			String id=request.getParameter("customid");
			CustomDao cus=new CustomDao();
			cus.DeleteCustom(id);
			RoomDao db=new RoomDao();
			ArrayList<Room> list=db.getUserList(); 
			request.setAttribute("list",list);
			request.getRequestDispatcher("selectRoom.jsp") .forward(request,response);
		}
	}
}
