package srcs.log;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Machine
 *
 */
@Entity

public class Machine implements Serializable {

	   
	@Id
	private Integer id;
	private String nomMachine;
	private static final long serialVersionUID = 1L;

	public Machine() {
	//	super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNomMachine() {
		return this.nomMachine;
	}

	public void setNomMachine(String nomMachine) {
		this.nomMachine = nomMachine;
	}
   
}
