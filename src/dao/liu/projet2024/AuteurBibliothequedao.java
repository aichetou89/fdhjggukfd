package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet2024.Dbconnection;
import metier.liu.projet2024.AuteurBibliotheque;
import metier.liu.projet2024.Bibliotheque;

public class AuteurBibliothequedao implements dao<AuteurBibliotheque> {
	//Variable de connection
		private Connection connection = null;
		//Conteneur de requete
		private Statement stmt = null;
		//Model
		private AuteurBibliotheque auteurbibliotheque = null;
		//requete
		private String requete = null;
		
		//initialisation des variables
		public AuteurBibliothequedao() {
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
	
	public AuteurBibliotheque get(String idauteur, String idbib) {
		//requete
		requete="select * from AuteurBibliotheque where idauteur ='"+ idauteur +"'"
				+ "  and idbib = '" + idbib+ "'"; 
		try {
			//recuperer le resultat
			ResultSet rs = stmt.executeQuery(requete);
			
			//stocker le resultat dans l'objet 
			rs.next();
			String idauteur1 = rs.getString(1);
			String idbib1 = rs.getString(2);
			
			auteurbibliotheque = new AuteurBibliotheque(idauteur, idbib );
			//affichage de auteurbibliotheque
			System.out.println(auteurbibliotheque.toString());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//retour de l'instance auteurbibliotheque
		return auteurbibliotheque;
		
		
	}

	@Override
	public List<AuteurBibliotheque> getAll() {
	
			//creer une liste
			ArrayList<AuteurBibliotheque> liste = new ArrayList<>();
					//requete
			requete="select * from AuteurBibliotheque ";
			try {
				//recuperer le resultat
				ResultSet rs = stmt.executeQuery(requete);
				
				//stocker le resultat dans l'objet auteurbibliotheque
				while(rs.next()) {
				String idbib = rs.getString(1);
				String idauteur = rs.getString(2);
				
				auteurbibliotheque = new AuteurBibliotheque(idauteur,  idbib);
				liste.add(auteurbibliotheque);
				//affichage de auteurbibliotheque
				System.out.println(auteurbibliotheque.toString());
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			//retour de l'instance auteurbibliotheque
			return liste;
	}

	@Override
	public void save(AuteurBibliotheque t) {
		// requete
				requete ="Insert into AuteurBibliotheque values('" + t.getIdauteur() + "' , '" + t.getIdbib() + "')";
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
	public void update(AuteurBibliotheque t, String[] params) {
//		// requete
		//requete ="Update AuteurBibliotheque SET idauteur = '" + params[0] + "', emplacement ='" + params[1] + "' where idbib ='" + t.getIdbib()+"'";
//		//afficher la requete
//		System.out.println(requete);
//		//recuperer le resultat
//		try {
//			int rs = stmt.executeUpdate(requete);
//			if(rs!=0)
//				System.out.println("modification effectueé");
//			else 
//				System.out.println("erreur de modification");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
	}

	@Override
	public void delete(AuteurBibliotheque t) {
			
			// requete
					requete ="Delete from  AuteurBibliotheque where idauteur = '" + t.getIdauteur() + "'and idbib = '" + t.getIdbib()+"'";
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

	@Override
	public AuteurBibliotheque get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		AuteurBibliothequedao Autbib = new AuteurBibliothequedao();
		AuteurBibliotheque Autbib11 = new AuteurBibliotheque("11","11");
		//Autbib.save(Autbib11);
		//Autbib.getAll();
	}
	}



