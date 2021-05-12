package srcs.log;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Log
 *
 */
@Entity
public class Log implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //genere automatiquement la clé primaire id
	private Integer id;
	
	private DateLog datelog;
	private String level;
	private String nameClasse;
	private String message;
	private Machine machine;
	private static final long serialVersionUID = 1L;

	public Log() {}   
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public DateLog getDatelog() {
		return this.datelog;
	}

	public void setDatelog(DateLog datelog) {
		this.datelog = datelog;
	}   
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}   
	public String getNameClasse() {
		return this.nameClasse;
	}

	public void setNameClasse(String nameClasse) {
		this.nameClasse = nameClasse;
	}   
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}   
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "ID") // id de la machine
	public Machine getMachine() {
		return this.machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", datelog=" + datelog + ", level=" + level + ", nameClasse=" + nameClasse
				+ ", message=" + message + ", machine=" + machine + "]";
	}
 
	
}
