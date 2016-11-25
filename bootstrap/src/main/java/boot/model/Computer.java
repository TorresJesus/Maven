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

@Entity(name="computers")
public class Computer implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (length=50)
	private String type;
	@Column (length=50)
	private String model;
	@Column (length=30)
	private String processor;
	
	private boolean enable;
	public Computer(String type, String model, String processor, boolean enable) {
		super();
		
		this.type = type;
		this.model = model;
		this.processor = processor;
		this.enable = enable;
	}
	
	public Computer(){
		this("","","",false);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", type=" + type + ", model=" + model + ", processor=" + processor + ", enable="
				+ enable + "]";
	}
	
	
}
