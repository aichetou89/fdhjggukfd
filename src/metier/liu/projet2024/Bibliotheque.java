package metier.liu.projet2024;

public class Bibliotheque {
	private String idbib;
	private String nom;
	private String emplacement;
	
	public Bibliotheque() {
		super();
	}

	public Bibliotheque(String idbib, String nom, String emplacement) {
		super();
		this.idbib = idbib;
		this.nom = nom;
		this.emplacement = emplacement;
	}

	public String getIdbib() {
		return idbib;
	}

	public void setIdbib(String idbib) {
		this.idbib = idbib;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	@Override
	public String toString() {
		return "Bibliotheque [idbib=" + idbib + ", nom=" + nom + ", emplacement=" + emplacement + "]";
	}
	
	
	

}
