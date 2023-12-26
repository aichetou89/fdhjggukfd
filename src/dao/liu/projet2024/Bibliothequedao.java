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

public class Bibliothequedao implements dao<Bibliotheque>{
	//Variable de connection
	private Connection connection = null;
	//Conteneur de requete
	private Statement stmt = null;
	//Model
	private Bibliotheque bibliotheque = null;
	//requete
	private String requete = null;
	
	//initialisation des variables
	public Bibliothequedao() {
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
	public Bibliotheque get(String id) {
		//requete
				requete="select * from Bibliotheque where idbib ="+ id +";";
				try {
					//recuperer le resultat
					ResultSet rs = stmt.executeQuery(requete);
					
					//stocker le resultat dans l'objet bibliotheque
					rs.next();
					String idbib = rs.getString(1);
					String nom = rs.getString(2);
					String emplacement = rs.getString(3);
					
					
					bibliotheque = new Bibliotheque(idbib, nom, emplacement );
					//affichage de la bibliotheque
					System.out.println(bibliotheque.toString());
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				//retour de l'instance bibliotheque
				return bibliotheque;
				
				
		
	}

	@Override
	public List<Bibliotheque> getAll() {
		//creer une liste
		ArrayList<Bibliotheque> liste = new ArrayList<>();
				//requete
		requete="select * from Bibliotheque ";
		try {
			//recuperer le resultat
			ResultSet rs = stmt.executeQuery(requete);
			
			//stocker le resultat dans l'objet bibliotheque
			while(rs.next()) {
			String idbib = rs.getString(1);
			String nom = rs.getString(2);
			String emplacement = rs.getString(3);
			bibliotheque = new Bibliotheque(idbib, nom, emplacement );
			liste.add(bibliotheque);
			//affichage de la bibliotheque
			System.out.println(bibliotheque.toString());
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//retour de l'instance bibliotheque
		return liste;
		
	
	}

	@Override
	public void save(Bibliotheque t) {
		// requete
		requete ="Insert into Bibliotheque values('" + t.getIdbib() + "' , '" + t.getNom() + "' , '" + t.getEmplacement() + "')";
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
	public void update(Bibliotheque t, String[] params) {
		
		// requete
				requete ="Update Bibliotheque SET nom = '" + params[1] + "', emplacement ='" + params[2] + "' where idbib ='" + t.getIdbib()+"'";
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
	public void delete(Bibliotheque t) {
		
		// requete
				requete ="Delete from  Bibliotheque where idbib = " + t.getIdbib();
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
//	Bibliothequedao bib = new Bibliothequedao();
//	Bibliotheque bib11 = new Bibliotheque("11","Bibliotheque de village","Boghe");
//	bib.save(bib11);
    //bib.update(bib11,new String[] {"Bibliotheque centrale","Nouakchott"});
	//bib.get("11");
	//bib.delete(bib11);
	//bib.getAll();
	
	
	System.out.println("Test get by id");
	new Bibliothequedao().get("11");
	new Bibliothequedao().save(new Bibliotheque("12", "bibliotheque liu","nktt"));
	new Bibliothequedao().getAll();
	String[] params={new Auteur().getIDauteur(),"bibkio fst","ndb"};
	new Bibliothequedao().update(new Bibliothequedao().get("12"), params);
	new Bibliothequedao().getAll();
	new Bibliothequedao().delete(new Bibliothequedao().get("12"));
	new Bibliothequedao().getAll();
}
}
