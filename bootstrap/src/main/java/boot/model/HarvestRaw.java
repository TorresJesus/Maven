package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="harvest_raw")
public class HarvestRaw implements Serializable{

	//private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=50)
	private String site;
	@Column(length=50)
	private String station;
	@Temporal(TemporalType.DATE)
	@Column(name="sampledate")
	private Date sampleDate;
	@Column(length=50)
	private String variable;
	private boolean flag;
	
	public HarvestRaw(String site, String station, Date sampleDate, String variable, boolean flag) {
		super();
		
		this.site = site;
		this.station = station;
		this.sampleDate = sampleDate;
		this.variable = variable;
		this.flag = flag;
	}
	
	public HarvestRaw(){
		this("","", new Date(),"",false);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public Date getSampleDate() {
		return sampleDate;
	}

	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "HarvestRaw [id=" + id + ", site=" + site + ", station=" + station + ", sampleDate=" + sampleDate
				+ ", variable=" + variable + ", flag=" + flag + "]";
	}
	
	
	
	
}
