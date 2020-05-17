package entity;
//员工表
public class Person {
    private int eid;
    private String ecode;
    private String ename;
    private String esfz;
    private String etel;
    private int gender;
    private String birthday;
    private String eaddress;
    private String etype;
    
    
	@Override
	public String toString() {
		return "Person [eid=" + eid + ", ecode=" + ecode + ", ename=" + ename + ", esfz=" + esfz + ", etel=" + etel
				+ ", gender=" + gender + ", birthday=" + birthday + ", eaddress=" + eaddress + ", etype=" + etype + "]";
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsfz() {
		return esfz;
	}
	public void setEsfz(String esfz) {
		this.esfz = esfz;
	}
	public String getEtel() {
		return etel;
	}
	public void setEtel(String etel) {
		this.etel = etel;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
    
    
}
