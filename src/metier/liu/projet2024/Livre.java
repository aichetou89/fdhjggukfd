package metier.liu.projet2024;

public class Livre {
	private String ISBN;
	private String titre;
	private String idauteur;
	
	public Livre() {
		super();
	}

	public Livre(String iSBN, String titre, String idauteur) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		this.idauteur = idauteur;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getIdauteur() {
		return idauteur;
	}

	public void setAuteur(String auteur) {
		this.idauteur = idauteur;
	}

	@Override
	public String toString() {
		return "Livre [ISBN=" + ISBN + ", titre=" + titre + ", idauteur=" + idauteur + "]";
	}
	
	
	
	
	

}
