package metier.liu.projet2024;

public class AuteurBibliotheque {
	private String idauteur;
	private String idbib;
	
	public AuteurBibliotheque() {
		super();
	}

	public AuteurBibliotheque(String idauteur, String idbib) {
		super();
		this.idauteur = idauteur;
		this.idbib = idbib;
	}

	public String getIdauteur() {
		return idauteur;
	}

	public void setIdauteur(String idauteur) {
		this.idauteur = idauteur;
	}

	public String getIdbib() {
		return idbib;
	}

	public void setIdbib(String idbib) {
		this.idbib = idbib;
	}

	@Override
	public String toString() {
		return "AuteurBibliotheque [idauteur=" + idauteur + ", idbib=" + idbib + "]";
	}
	
	
	
	

}
