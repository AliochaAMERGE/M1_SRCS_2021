package srcs.log;

import java.io.Serializable;

public class DateLog implements Serializable {

	private int annee;
	private int mois;
	private int jour;
	private int heure;
	private int minute;
	private int seconde;
	private int milliseconde;

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSeconde() {
		return seconde;
	}

	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}

	public int getMilliseconde() {
		return milliseconde;
	}

	public void setMilliseconde(int milliseconde) {
		this.milliseconde = milliseconde;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + heure;
		result = prime * result + jour;
		result = prime * result + milliseconde;
		result = prime * result + minute;
		result = prime * result + mois;
		result = prime * result + seconde;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateLog other = (DateLog) obj;
		if (annee != other.annee)
			return false;
		if (heure != other.heure)
			return false;
		if (jour != other.jour)
			return false;
		if (milliseconde != other.milliseconde)
			return false;
		if (minute != other.minute)
			return false;
		if (mois != other.mois)
			return false;
		if (seconde != other.seconde)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DateLog [annee=" + annee + ", mois=" + mois + ", jour=" + jour + ", heure=" + heure + ", minute="
				+ minute + ", seconde=" + seconde + ", milliseconde=" + milliseconde + "]";
	}

}
