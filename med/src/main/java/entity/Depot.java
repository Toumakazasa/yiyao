package entity;

public class Depot {
   private int ckid;
   private String ckname;
   private String ckaddress;
public int getCkid() {
	return ckid;
}
public void setCkid(int ckid) {
	this.ckid = ckid;
}
public String getCkname() {
	return ckname;
}
public void setCkname(String ckname) {
	this.ckname = ckname;
}
public String getCkaddress() {
	return ckaddress;
}
public void setCkaddress(String ckaddress) {
	this.ckaddress = ckaddress;
}
@Override
public String toString() {
	return "Depot [ckid=" + ckid + ", ckname=" + ckname + ", ckaddress=" + ckaddress + "]";
}
   
   
   
}
