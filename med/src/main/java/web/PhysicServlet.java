package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepotDAO;
import dao.PersonDAO;
import dao.physicDAO;
import entity.Depot;
import entity.Person;
import entity.physic;


public class PhysicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURI();
		String path=url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		/**
		 * 药品表
		 */
		if("/list".equals(path)) {
			physicDAO dao=new physicDAO();
			try {
				List<physic> physics=dao.finall();
				//转发到list.jsp  
				request.setAttribute("physic",physics);
				RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				//step1.绑定数据到请求对象上
				 request.setAttribute("error","系统繁忙，稍后重试" );
					//step2.获得一个转发器
				 request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
			
		}else if ("/addyp".equals(path)) {
			request.setCharacterEncoding("utf-8");
        	//增加
			/*int ypid=Integer.parseInt(request.getParameter("ypid"));*/
        	String ypname=request.getParameter("ypname");
    		int tid=Integer.parseInt(request.getParameter("tid"));
    		double ypjp=Double.parseDouble(request.getParameter("ypjp"));
    		double ypsp=Double.parseDouble(request.getParameter("ypsp"));
    		int ypbzq=Integer.parseInt(request.getParameter("ypbzq"));
    		String ypms=request.getParameter("ypms");
    		String ypgg=request.getParameter("ypgg");
    		//将用户信息插入到数据库
        	physicDAO dao=new physicDAO();
        	try {
				physic physic=new physic();
			   physic.setYpname(ypname);
			   physic.setTid(tid);
			   physic.setYpjp(ypjp);
			   physic.setYpsp(ypsp);
			   physic.setYpbzq(ypbzq);
			   physic.setYpms(ypms);
			   physic.setYpgg(ypgg);
			   dao.save(physic);
				//重定向到用户列表
				response.sendRedirect("list.doc");
				
			} catch (Exception e) {
				e.printStackTrace();
				
				request.setAttribute("error",
						"系统繁忙，稍后重试");
				request.getRequestDispatcher("error.jsp")
				.forward(request, response);
			}
		}else if ("/del".equals(path)) {
			 request.setCharacterEncoding("utf-8");
				//删除指定id的用户
			    String ypid=request.getParameter("ypid");
			    physicDAO dao=new physicDAO();
			    try {
					dao.delete(Integer.parseInt(ypid));
					//重定向
					response.sendRedirect("list.doc");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}else if ("/assgin".equals(path)) {
			physicDAO dao=new physicDAO();
			List<physic> physics=dao.assgin(request, response);
		   System.out.println(physics);
			//转发
		   request.setAttribute("physic",physics);
			RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
		}else if ("/updatayp".equals(path)) {
			request.setCharacterEncoding("utf-8");
			physicDAO dao=new physicDAO();
			physic p=new physic();
		  /* int ypid=Integer.parseInt(request.getParameter("ypid"));
			System.out.println(ypid+"222");*/
			String ypname=request.getParameter("ypname");
			int tid=Integer.parseInt(request.getParameter("tid"));
			double ypjp=Double.parseDouble(request.getParameter("ypjp"));
			double ypsp=Double.parseDouble(request.getParameter("ypsp"));
			int ypbzq=Integer.parseInt(request.getParameter("ypbzq"));
			String ypms=request.getParameter("ypms");
			String ypgg=request.getParameter("ypgg");
			/*p.setYpid(ypid);*/
			p.setYpname(ypname);
			p.setTid(tid);
			p.setYpjp(ypjp);
			p.setYpsp(ypsp);
			p.setYpbzq(ypbzq);
			p.setYpms(ypms);
			p.setYpgg(ypgg);
			dao.updata(p);
			response.sendRedirect("list.doc");
		}
		
		
	    /**
	     * 员工表
	     */
		else if("/emp".equals(path)) {
		PersonDAO dao=new PersonDAO();
			try {
			List<Person> persons=dao.finall();
				//转发到list.jsp  
				request.setAttribute("persons",persons);
				RequestDispatcher rd=request.getRequestDispatcher("emp.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				//step1.绑定数据到请求对象上
				 request.setAttribute("error","系统繁忙，稍后重试" );
					//step2.获得一个转发器
				 request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else if ("/addemp".equals(path)) {
			request.setCharacterEncoding("utf-8");
        	//增加
			
        	String ecode=request.getParameter("ecode");
    		String ename=request.getParameter("ename");
    		String esfz=request.getParameter("esfz");
    		String etel=request.getParameter("etel");
    		int  gender=Integer.parseInt(request.getParameter("gender"));
    		String birthday=request.getParameter("birthday");
    		String eaddress=request.getParameter("eaddress");
    		String etype=request.getParameter("etype");
    		System.out.println("ecode:"+ecode+"ename:"+ename+"esfz:"+esfz+"etel:"+etel+"gender:"+gender+"birthday"+birthday+"etype:"+etype);
    		//将用户信息插入到数据库
        PersonDAO dao=new PersonDAO();
        	try {
				Person person=new Person();
				person.setEcode(ecode);
				person.setEname(ename);
				person.setEsfz(esfz);
				person.setEtel(etel);
				person.setGender(gender);
				person.setBirthday(birthday);
				person.setEaddress(eaddress);
				person.setEtype(etype);
				dao.save(person);
				//重定向到用户列表
				response.sendRedirect("emp.doc");
				
			} catch (Exception e) {
				e.printStackTrace();
				
				request.setAttribute("error",
						"系统繁忙，稍后重试");
				request.getRequestDispatcher("error.jsp")
				.forward(request, response);
			}
		}else if ("/delemp".equals(path)) {
			 request.setCharacterEncoding("utf-8");
				//删除指定id的用户
			    String eid=request.getParameter("eid");
			   PersonDAO dao=new PersonDAO();
			    try {
					dao.delete(Integer.parseInt(eid));
					//重定向
					response.sendRedirect("emp.doc");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}else if ("/assginemp".equals(path)) {
			PersonDAO dao=new PersonDAO();
			List<Person> persons =dao.assginemp(request, response);
		   System.out.println(persons);
			//转发
		   request.setAttribute("persons",persons);
			RequestDispatcher rd=request.getRequestDispatcher("emp.jsp");
			rd.forward(request, response);
		}
		
		
		/**
		 * 仓库表
		 */
		
		else if ("/depot".equals(path)) {
			DepotDAO dao=new DepotDAO();
			try {
			List<Depot> depots=dao.finall();
			//转发到list.jsp  
			System.out.println(depots);
			request.setAttribute("depots",depots);
			RequestDispatcher rd=request.getRequestDispatcher("depot.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			//step1.绑定数据到请求对象上
			 request.setAttribute("error","系统繁忙，稍后重试" );
				//step2.获得一个转发器
			 request.getRequestDispatcher("error.jsp").forward(request, response);
		     }
	    }else if ("/adddepot".equals(path)) {
	    	request.setCharacterEncoding("utf-8");
        	//增加
		 String 	ckname=request.getParameter("ckname");
       String ckaddress=request.getParameter("ckaddress");
    		
    		//将用户信息插入到数据库
         DepotDAO dao=new DepotDAO();
        	try {
        		Depot depot=new Depot();  
        		depot.setCkname(ckname);
				depot.setCkaddress(ckaddress);
				dao.save(depot);
				//重定向到用户列表
				response.sendRedirect("depot.doc");
				
			} catch (Exception e) {
				e.printStackTrace();
				
				request.setAttribute("error",
						"系统繁忙，稍后重试");
				request.getRequestDispatcher("error.jsp")
				.forward(request, response);
			}
		}else if ("/deldepot".equals(path)) {
			 request.setCharacterEncoding("utf-8");
				//删除指定id的用户
			    String ckid=request.getParameter("ckid");
			   PersonDAO dao=new PersonDAO();
			    try {
					dao.delete(Integer.parseInt(ckid));
					//重定向
					response.sendRedirect("depot.doc");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}else if ("/assgindepot".equals(path)) {
			DepotDAO dao=new DepotDAO();
			List<Depot> depots=dao.assgin(request, response);
		   System.out.println(depots);
			//转发
		   request.setAttribute("depots",depots);
			RequestDispatcher rd=request.getRequestDispatcher("depot.jsp");
			rd.forward(request, response);
		}
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
