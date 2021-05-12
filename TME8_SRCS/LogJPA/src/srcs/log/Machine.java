package srcs.log;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Machine
 *
 */
@Entity

public class Machine implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	private List<Log> logs;
	
	private static final long serialVersionUID = 1L;

	public Machine() {
		logs = new ArrayList<>();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@OneToMany(mappedBy = "machine")
	public List<Log> getLogs() {
		return logs;
	}
	
	public void setLogs(Log log) {
		this.logs.add(log);
	}
	
	
	@Override
	public String toString() {
		return "Machine [id=" + id + ", nom=" + nom + "]";
	}
   
}
