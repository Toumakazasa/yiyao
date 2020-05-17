package entity;
//药品实体类
public class physic {
    private int ypid;
    private String ypname;
    private int tid;
    private double ypjp;
    private double ypsp;
    private int ypbzq;
    private String ypms;
    private String ypgg;
    
    
	@Override
	public String toString() {
		return "physic [ypid=" + ypid + ", ypname=" + ypname + ", tid=" + tid + ", ypjp=" + ypjp + ", ypsp=" + ypsp
				+ ", ypbzq=" + ypbzq + ", ypms=" + ypms + ", ypgg=" + ypgg + "]";
	}
	public int getYpid() {
		return ypid;
	}
	public void setYpid(int ypid) {
		this.ypid = ypid;
	}
	public String getYpname() {
		return ypname;
	}
	public void setYpname(String ypname) {
		this.ypname = ypname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public double getYpjp() {
		return ypjp;
	}
	public void setYpjp(double ypjp) {
		this.ypjp = ypjp;
	}
	public double getYpsp() {
		return ypsp;
	}
	public void setYpsp(double ypsp) {
		this.ypsp = ypsp;
	}
	public int getYpbzq() {
		return ypbzq;
	}
	public void setYpbzq(int ypbzq) {
		this.ypbzq = ypbzq;
	}
	public String getYpms() {
		return ypms;
	}
	public void setYpms(String ypms) {
		this.ypms = ypms;
	}
	public String getYpgg() {
		return ypgg;
	}
	public void setYpgg(String ypgg) {
		this.ypgg = ypgg;
	}
    
}
