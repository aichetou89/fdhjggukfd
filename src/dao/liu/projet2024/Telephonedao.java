package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet2024.Dbconnection;
import metier.liu.projet2024.Bibliotheque;
import metier.liu.projet2024.Livre;
import metier.liu.projet2024.Telephone;

public class Telephonedao implements dao<Telephone>  {
	//Variable de connection
	private Connection connection = null;
	//Conteneur de requete
	private Statement stmt = null;
	//Model
	private Telephone telephone = null;
	//requete
	private String requete = null;
	//initialisation des variables
	public Telephonedao() {
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


	
	public Telephone get(int id) {
		//requete
		requete="select * from Telephone where numero ="+ id +";";
		try {
			//recuperer le resultat
			ResultSet rs = stmt.executeQuery(requete);
			
			//stocker le resultat dans l'objet telephone
			rs.next();
			int numero = rs.getInt(1);
			String type = rs.getString(2);
			String idauteur = rs.getString(3);
			
			
			
			telephone = new Telephone(numero, type , idauteur );
			//affichage du telephone
			System.out.println(telephone.toString());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//retour de l'instance telephone
		return telephone;
		
		
	}

	@Override
	public List<Telephone> getAll() {
		//creer une liste
				ArrayList<Telephone> liste = new ArrayList<>();
						//requete
				requete="select * from Telephone ";
				try {
					//recuperer le resultat
					ResultSet rs = stmt.executeQuery(requete);
					
					//stocker le resultat dans l'objet telephone
					while(rs.next()) {
					int numero = rs.getInt(1);
					String type = rs.getString(2);
					String idauteur = rs.getString(3);
					telephone = new Telephone(numero, type,idauteur);
					liste.add(telephone);
					//affichage du telephone
					System.out.println(telephone.toString());
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				//retour de l'instance telephone
				return liste;
				
			
	}

	@Override
	public void save(Telephone t) {
		// requete
				requete ="Insert into Telephone values('" + t.getNumero() + "' , '" + t.getType() + "' , '" +t.getIdauteur()+"')"; 
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
	public void update(Telephone t, String[] params) {
		// requete
		requete ="Update Telephone SET type = '" + params[0] + "' where numero ='" + t.getNumero()+"'";
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
	public void delete(Telephone t) {
		// requete
		requete ="Delete from Telephone where numero = " + t.getNumero();
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
		public Telephone get(String id) {
			// TODO Auto-generated method stub
			return null;
		}
		public static void main(String[] args) {
			Telephonedao tel = new Telephonedao();
			Telephone tel11 = new Telephone(123123,"Mobile","11");
			tel.save(tel11);
			
					
		}
		
	}

		
	
