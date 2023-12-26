package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet2024.Dbconnection;
import metier.liu.projet2024.Auteur;
import metier.liu.projet2024.Bibliotheque;
import metier.liu.projet2024.Livre;

public class Livredao implements dao<Livre> {
	//Variable de connection
			private Connection connection = null;
			//Conteneur de requete
			private Statement stmt = null;
			//Model
			private Livre livre = null;
			//requete
			private String requete = null;
			//initialisation des variables
			public Livredao() {
				//une connection a la base de donnees
				try {
			connection = Dbconnection.getConnection();
			//conteneur de requete
			stmt =connection.createStatement();
			}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}

	@Override
	public Livre get(String id) {
		//requete
		requete="select * from Livre where ISBN ="+ id +";";
		try {
			//recuperer le resultat
			ResultSet rs = stmt.executeQuery(requete);
			
			//stocker le resultat dans l'objet Livre
			rs.next();
			String ISBN = rs.getString(1);
			String Titre = rs.getString(2);
			String idauteur = rs.getString(3);
			
			
			livre = new Livre(ISBN, Titre, idauteur );
			//affichage du livre
			System.out.println(livre.toString());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//retour de l'instance livre
		return livre;
		
		
	}

	@Override
	public List<Livre> getAll() {
		//creer une liste
				ArrayList<Livre> liste = new ArrayList<>();
						//requete
				requete="select * from Livre ";
				try {
					//recuperer le resultat
					ResultSet rs = stmt.executeQuery(requete);
					
					//stocker le resultat dans l'objet livre
					while(rs.next()) {
					String ISBN = rs.getString(1);
					String Titre= rs.getString(2);
					String idauteur = rs.getString(3);
					livre = new Livre(ISBN, Titre, idauteur );
					liste.add(livre);
					//affichage du livre
					System.out.println(livre.toString());
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				//retour de l'instance livre
				return liste;
				
			
	}

	@Override
	public void save(Livre t) {
		// requete
		requete ="Insert into Livre values('" + t.getISBN() + "' , '" + t.getTitre() + "' , '" + t.getIdauteur() + "')";
			//afficher la requete
		System.out.println(requete);
		//recuperer le resultat
		try {
			int rs = stmt.executeUpdate(requete);
			if(rs!=0)
				System.out.println("insertion effectueé");
			else 
				System.out.println("erreur d'insertion");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

		
	

	@Override
	public void update(Livre t, String[] params) {
		// requete
		requete ="Update Livre SET Titre = '" + params[0] + "', idauteur ='" + params[1] + "' where ISBN ='" + t.getISBN()+"'";
		//afficher la requete
		System.out.println(requete);
		//recuperer le resultat
		try {
			int rs = stmt.executeUpdate(requete);
			if(rs!=0)
				System.out.println("modification effectueé");
			else 
				System.out.println("erreur de modification");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Livre t) {
		// requete
		requete ="Delete from Livre where ISBN = " + t.getISBN();
		//afficher la requete
		System.out.println(requete);
		//recuperer le resultat
		try {
			int rs = stmt.executeUpdate(requete);
			if(rs!=0)
				System.out.println("suppression effectueé");
			else 
				System.out.println("erreur de suppression");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		Livredao liv = new Livredao();
		Livre liv11 = new Livre("111222","Voyages a travers le savoir","11");
		//liv.save(liv11);
	}

}
