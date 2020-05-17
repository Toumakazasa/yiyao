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

import entity.Person;
import entity.physic;
import util.DBUtils;

//鍛樺伐琛ㄧ殑澧炪�佸垹銆佹敼銆佹煡
public class PersonDAO {
   //澧炲姞
	public void save(Person person) {
		Connection conne=null;
		PreparedStatement prep=null;
		
		String code=person.getEcode();
		String ename=person.getEname();
		String esfz=person.getEsfz();
		String etel=person.getEsfz();
		int gender=person.getGender();
		String birthday=person.getBirthday();
		String eaddress=person.getEaddress();
		String etype=person.getEtype();
		try {
			conne=DBUtils.getConnection();
			String sql="insert into tb_emp values(null,?,?,?,?,?,?,?,?)";
			prep=conne.prepareStatement(sql);
			prep.setString(1,code);
			prep.setString(2, ename);
			prep.setString(3, esfz);
			prep.setString(4, etel);
			prep.setInt(5, gender);
			prep.setString(6, birthday);
			prep.setString(7, eaddress);
			prep.setString(8, etype);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conne, prep, null);
		}
	}
	
	//鍒犻櫎
	 public void delete(int eid) {
			Connection coone=null;
			PreparedStatement prep=null;
			try {
				coone=DBUtils.getConnection();
				String sql="delete from tb_emp where eid=?";
				prep=coone.prepareStatement(sql);
				prep.setInt(1,eid);
				prep.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(coone, prep, null);
			}
		}
	
	 //鏌ヨ鎵�鏈夌敤鎴�
		public  List<Person> finall() throws Exception  {
			List<Person> persons=new ArrayList<Person>();
			Connection conne=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
				conne=DBUtils.getConnection();
				String sql="select * from tb_emp";
				prep=conne.prepareStatement(sql);
				rs=prep.executeQuery();
				while (rs.next()) {
					int eid=rs.getInt("eid");
					String ecode=rs.getString("ecode");
					String ename=rs.getString("ename");
					String esfz=rs.getString("esfz");
					String etel=rs.getString("etel");
					int gender=rs.getInt("gender");
					String birthday=rs.getString("birthday");
					String eaddress=rs.getString("eaddress");
					String etype=rs.getString("etype");
	              Person person=new Person();
	              person.setEid(eid);
	              person.setEcode(ecode);
	              person.setEname(ename);
	              person.setEsfz(esfz);
	              person.setEtel(etel);
	              person.setGender(gender);
	              person.setBirthday(birthday);
	              person.setEaddress(eaddress);
	              person.setEtype(etype);
	              persons.add(person);
	              
				}
				
			} catch (Exception e) {
	          e.printStackTrace();
	          throw e;
			}finally {
				DBUtils.close(conne, prep, rs);
			}
			return persons;
		}
		
		//鏌ヨ鎸囧畾鍛樺伐濮撳悕銆佺被鍒�
				public List<Person> assginemp(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
					request.setCharacterEncoding("utf-8");
					List<Person> persons=new ArrayList<Person>();
					Connection coone=null;
					PreparedStatement prep=null;
					ResultSet rs=null;
					Person Person=new Person();
				   String enames=request.getParameter("ename");
					String etypes=request.getParameter("etype");
					System.out.println("enames:"+enames+"etypes:"+etypes);
					
					try {
						coone=DBUtils.getConnection();
						String sql="select * from tb_emp where 1=1";
						if(enames!="") {
							sql+=" and ename='"+enames+"'";
						}
						
						if(etypes!="") {
							sql+=" and etype='"+etypes+"'";
						}
						prep=coone.prepareStatement(sql);
						rs=prep.executeQuery();
						
						while (rs.next()) {
							int eid=rs.getInt("eid");
							String ecode=rs.getString("ecode");
							String ename=rs.getString("ename");
							String esfz=rs.getString("esfz");
							String etel=rs.getString("etel");
							int gender=rs.getInt("gender");
							String birthday=rs.getString("gender");
							String eaddress=rs.getString("eaddress");
							String etype=rs.getString("etype");
			              Person person=new Person();
			              person.setEid(eid);
			              person.setEcode(ecode);
			              person.setEname(ename);
			              person.setEsfz(esfz);
			              person.setEtel(etel);
			              person.setGender(gender);
			              person.setBirthday(birthday);
			              person.setEaddress(eaddress);
			              person.setEtype(etype);
			              persons.add(person);		   
						
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						DBUtils.close(coone, prep, rs);
					}
					return persons;
				}
				
			
		}
		
		
		
		
		
		
		
		
		
		

















