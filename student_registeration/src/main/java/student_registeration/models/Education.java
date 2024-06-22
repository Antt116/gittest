package student_registeration.models;

import java.util.Objects;

public class Education {
	private int eid;
	private String ename;
	
	public Education() {
		
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eid,ename);//attr values twe pw mhr code htote lite tr
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;//memory
		}if(obj==null) {
			return false;
		}
		if(getClass()!=obj.getClass()) {
			return false;
		}
		Education other=(Education)obj;
		return Objects.equals(eid, other.getEid()) && Objects.equals(ename, other.getEname());
	}

}
