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

public class Auteurdao implements dao<Auteur>{
	//Variable de connection
		private Connection connection = null;
		//Conteneur de requete
		private Statement stmt = null;
		//Model
		private Auteur auteur = null;
		//requete
		private String requete = null;
		
		//initialisation des variables
		public Auteurdao() {
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
	public Auteur get(String id) {
		//requete
		requete="select * from Auteur where idauteur ="+ id +";";
		try {
			//recuperer le resultat
			ResultSet rs = stmt.executeQuery(requete);
			
			//stocker le resultat dans l'objet auteur
			rs.next();
			String idauteur = rs.getString(1);
			String nom = rs.getString(2);
			String prenom = rs.getString(3);
			String adresse = rs.getString(4);
			String region = rs.getString(5);
			
			
			auteur = new Auteur(idauteur, nom, prenom,adresse,region );
			//affichage de l'auteur
			System.out.println(auteur.toString());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//retour de l'instance auteur
		return auteur;
		
	}

	@Override
	public List<Auteur> getAll() {
		//creer une liste
				ArrayList<Auteur> liste = new ArrayList<>();
						//requete
				requete="select * from Auteur ";
				try {
					//recuperer le resultat
					ResultSet rs = stmt.executeQuery(requete);
					
					//stocker le resultat dans l'objet auteur
					while(rs.next()) {
					String idauteur = rs.getString(1);
					String nom = rs.getString(2);
					String prenom = rs.getString(3);
					String adresse = rs.getString(4);
					String region = rs.getString(5);
					auteur = new Auteur(idauteur, nom,prenom,adresse,region );
					liste.add(auteur);
					//affichage de l'auteur
					System.out.println(auteur.toString());
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				//retour de la liste
				return liste;
				
			
	}

	@Override
	public void save(Auteur t) {
		// requete
				requete ="Insert into Auteur values('" + t.getIDauteur() + "' , '" + t.getNom() + "' , '" + t.getPrenom() + "' ,'" + t.getAdresse()+"','"+t.getRegion()+"')";
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
	public void update(Auteur t, String[] params) {
		// requete
		requete ="Update Auteur SET nom = '" + params[0] + "', prenom='" + params[1] + "',adresse='" + params[2] +"',region='" + params[3] +"' where idauteur = '" + t.getIDauteur()+ "'";
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
	public void delete(Auteur t) {
		// requete
		requete ="Delete from  Auteur where idauteur = " + t.getIDauteur();
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
	Auteurdao aut = new Auteurdao();
	Auteur aut11 = new Auteur("11","Med","Hassen"," Rue des livres,Boghe","Trarza");
	//aut.save(aut11);
	//aut.getAll();
}
}
	
