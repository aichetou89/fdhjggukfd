package metier.liu.projet2024;

public class Telephone {
	private int numero;
	private String type;
	private String idauteur;
	public Telephone() {
		super();
	}
	public Telephone(int numero, String type,String idauteur) {
		super();
		this.numero = numero;
		this.type = type;
		this.idauteur = idauteur;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
		
	}
	
	public String getIdauteur() {
		return idauteur;
	}
	public void setIdauteur(String idauteur) {
		this.idauteur = idauteur;
	}
	@Override
	public String toString() {
		return "Telephone [numero=" + numero + ", type=" + type + ", idauteur=" + idauteur + "]";
	}
	
	
	
	
	

}
