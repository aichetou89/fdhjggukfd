package metier.liu.projet2024;

public class Auteur {
	private String IDauteur;
	private String nom;
	private String prenom;
	private String adresse;
	private String region;
	
	public Auteur() {
		super();
	}

	public Auteur(String iDauteur, String nom, String prenom, String adresse, String region) {
		super();
		IDauteur = iDauteur;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.region = region;
	}

	public String getIDauteur() {
		return IDauteur;
	}

	public void setIDauteur(String iDauteur) {
		IDauteur = iDauteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Auteur [IDauteur=" + IDauteur + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", region=" + region + "]";
	}
	
	
	
	

}
