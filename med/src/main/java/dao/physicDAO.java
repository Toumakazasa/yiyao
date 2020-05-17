package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.physic;
import util.DBUtils;

//鑽搧琛ㄧ殑澧炲垹鏀规煡
public class  physicDAO {
      //澧炲姞
	public void save(physic physic) {
		Connection conne=null;
		PreparedStatement prep=null;
		int ypid=physic.getYpid();
		String ypname=physic.getYpname();
		int tid=physic.getTid();
		double ypjp=physic.getYpjp();
		double ypsp=physic.getYpsp();
		int ypbzq=physic.getYpbzq();
		String ypms=physic.getYpms();
		String ypgg=physic.getYpgg();
		
		try {
			conne=DBUtils.getConnection();
			String sql="insert into tb_yp values(null,?,?,?,?,?,?,?)";
			prep=conne.prepareStatement(sql);
			prep.setString(1,ypname);
			prep.setInt(2, tid);
			prep.setDouble(3, ypjp);
			prep.setDouble(4, ypsp);
			prep.setInt(5, ypbzq);
			prep.setString(6, ypms);
			prep.setString(7, ypgg);
			
			
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conne, prep, null);
		}
	}
	
	//鍒犻櫎
	  public void delete(int ypid) {
		Connection coone=null;
		PreparedStatement prep=null;
		try {
			coone=DBUtils.getConnection();
			String sql="delete from tb_yp where ypid=?";
			prep=coone.prepareStatement(sql);
			prep.setInt(1,ypid);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(coone, prep, null);
		}
	}
	
	 
	  //鏌ヨ鎵�鏈夎嵂鍝�
		public  List<physic> finall() throws Exception  {
			List<physic> physics=new ArrayList<physic>();
			Connection conne=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
				conne=DBUtils.getConnection();
				String sql="select * from tb_yp";
				prep=conne.prepareStatement(sql);
				rs=prep.executeQuery();
				while (rs.next()) {
					int ypid=rs.getInt("ypid");
					String ypname=rs.getString("ypname");
					int tid=rs.getInt("tid");
					double ypjp=rs.getDouble("ypjp");
					double ypsp=rs.getDouble("ypsp");
					int ypbzq=rs.getInt("ypbzq");
					String ypms=rs.getString("ypms");
					String ypgg=rs.getString("ypgg");
					 physic physic=new physic();
	               physic.setYpid(ypid);
	               physic.setYpname(ypname);
	               physic.setTid(tid);
	               physic.setYpjp(ypjp);
	               physic.setYpsp(ypsp);
	               physic.setYpbzq(ypbzq);
	               physic.setYpms(ypms);
	               physic.setYpgg(ypgg);
	               physics.add(physic);
				}
				
			} catch (Exception e) {
	          e.printStackTrace();
	          throw e;
			}finally {
				DBUtils.close(conne, prep, rs);
			}
			return physics;
		}
		
		
		//鏌ヨ鎸囧畾缂栧彿锛屽悕绉帮紝绫诲埆
		public List<physic> assgin(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
			request.setCharacterEncoding("utf-8");
			List<physic> physics=new ArrayList<physic>();
			Connection coone=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
		   String ypids=request.getParameter("ypid");
			String ypnames=request.getParameter("ypname");
			String tids=request.getParameter("tid");
			System.out.println("ypid:"+ypids+"ypname:"+ypnames+"tid:"+tids);
			try {
				coone=DBUtils.getConnection();
				String sql="select * from tb_yp where 1=1";
				if(ypids!="") {
					sql+=" and ypid="+ypids;
				}
				if(ypnames!="") {
					sql+=" and  ypname='"+ypnames+"'";
				}
				if(tids!="") {
					sql+=" and tid="+tids;
				}
				prep=coone.prepareStatement(sql);
				rs=prep.executeQuery();
				
				while (rs.next()) {
					int ypid=rs.getInt("ypid");
					String ypname=rs.getString("ypname");
					int tid=rs.getInt("tid");
					double ypjp=rs.getDouble("ypjp");
					double ypsp=rs.getDouble("ypsp");
					int ypbzq=rs.getInt("ypbzq");
				   String ypms=rs.getString("ypms");
				   String ypgg=rs.getString("ypgg"); 
					System.out.println("ypid:"+ypid+"ypname"+ypname+"tid"+tid+"ypjp"+ypjp+"ypsp"+ypsp+"ypms"+ypms+"ypgg"+ypgg);
					physic physic=new physic();
					physic.setYpid(ypid);
				   physic.setYpname(ypname);
				   physic.setTid(tid);
				   physic.setYpbzq(ypbzq);
				   physic.setYpms(ypms);
				   physic.setYpgg(ypgg);
               physics.add(physic);			   
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(coone, prep, rs);
			}
			return physics;
		}
		
		//淇敼
		public void updata(physic p) {
			Connection coone=null;
			PreparedStatement prep=null;
			int a=0;
			try {
				coone=DBUtils.getConnection();
				String sql="update tb_yp set ypname=? and tid=? and  ypjp=? and ypsp=?  and ypbzq=? and ypms=? and ypgg=? where ypid=?";
				prep=coone.prepareStatement(sql);
				prep.setString(1, p.getYpname());
				prep.setInt(2, p.getTid());
				prep.setDouble(3, p.getYpjp());
				prep.setDouble(4, p.getYpsp());
				prep.setInt(5, p.getYpbzq());
				prep.setString(6, p.getYpms());
		   	prep.setString(7, p.getYpgg());
			   prep.setInt(8, p.getYpid());
			   System.out.println(p.getYpname()+p.getTid()+p.getYpjp()+p.getYpsp()+p.getYpbzq()+p.getYpms()+p.getYpgg()+p.getYpid()+("鎴�11"));
			   a= prep.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
	
}

















