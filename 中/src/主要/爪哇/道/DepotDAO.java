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

import entity.Depot;
import util.DBUtils;

//浠撳簱琛ㄧ殑澧炪�佸垹銆佹敼銆佹煡
public class DepotDAO {
     //澧炲姞
	public void save(Depot depot) {
		Connection conne=null;
		PreparedStatement prep=null;
		int ckid=depot.getCkid();
		String ckname=depot.getCkname();
		String ckaddress=depot.getCkaddress();
		try {
			conne=DBUtils.getConnection();
			String sql="insert into tb_ck value(null,?,?)";
			prep=conne.prepareStatement(sql);
			prep.setString(1, ckname);
			prep.setString(2, ckaddress);
			
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conne, prep, null);
		}
	}
	
	//鍒犻櫎
	public void delete(int ckid) {
		Connection conne=null;
		PreparedStatement prep=null;
		try {
			conne=DBUtils.getConnection();
			String sql="delete from tb_ck where ckid=?";
			prep=conne.prepareStatement(sql);
			prep.setInt(1, ckid);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conne, prep, null);
		}
	}
	
	//鏌ヨ鎵�鏈�
	public List<Depot> finall() {
		List<Depot> depots=new ArrayList<Depot>();
		Connection conne=null;
		PreparedStatement prep=null;
	   ResultSet rs=null;
	   try {
		conne=DBUtils.getConnection();
		String sql="select * from tb_ck";
		prep=conne.prepareStatement(sql);
		rs=prep.executeQuery();
		while (rs.next()) {
			int ckid=rs.getInt("ckid");
			String ckname=rs.getString("ckname");
			String ckaddress=rs.getString("ckaddress");
			System.out.println("ckid:"+ckid+"ckname:"+ckname+"ckaddress"+ckaddress);
			Depot depot=new Depot();
			depot.setCkid(ckid);
			depot.setCkname(ckname);
			depot.setCkaddress(ckaddress);
			depots.add(depot);
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBUtils.close(conne, prep, rs);
	}
		return  depots;
	}
	
    //鏌ヨ鎸囧畾浠撳簱鍚嶇О
	public List<Depot> assgin(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
	 request.setCharacterEncoding("utf-8");
		List<Depot> depots=new ArrayList<Depot>();
		Connection conne=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		String cknames=request.getParameter("ckname");
		try {
			conne=DBUtils.getConnection();
			String sql="select * from tb_ck where 1=1";
			if(cknames!="") {
				sql+=" and ckname='"+cknames+"'";
			}
			prep=conne.prepareStatement(sql);
			rs=prep.executeQuery();
			while (rs.next()) {
				int ckid=rs.getInt("ckid");
				String ckname=rs.getString("ckname");
				String ckaddress=rs.getString("ckaddress");
				System.out.println("ckid:"+ckid+"ckname:"+ckname+"ckaddress:"+ckaddress);
				Depot depot=new Depot();
				depot.setCkid(ckid);
				depot.setCkname(ckname);
				depot.setCkaddress(ckaddress);
			   depots.add(depot);
			}
			
			
		} catch (SQLException e) {
         e.printStackTrace();
		}
		
		return depots;
	}
	
	
}
