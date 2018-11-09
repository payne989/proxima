package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.Frequenze;

public class FrequenzeDao {
	
	public static boolean insertFrequenze (int idImp, int idEdiz) {
		
		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "INSERT INTO frequenze (idimp,idedizione) VALUES (?,?)";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, idImp);
			preparedStatement.setInt(2, idEdiz);

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}

	public static boolean deleteFrequenzeById (int id) {
		
		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "DELETE FROM frequenze WHERE id=?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

			
			return true;

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			}
		
	}

	public static boolean deleteFrequenzeBySede (int idSede) {
		
		
			try {
				Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

				java.sql.PreparedStatement preparedStatement = null;

				String insertTableSQL = "Delete FROM frequenze WHERE idedizione IN (SELECT FROM edizione WHERE idsede=?)";

				preparedStatement = con.prepareStatement(insertTableSQL);

				preparedStatement.setInt(1, idSede);

				preparedStatement.executeUpdate();
				
			} catch (SQLException | NamingException e) {
				
				e.printStackTrace();
			}

			
			return true;
			
		}
	
	public static boolean deleteFrequenzeByCorso (int idCorso) {
		
		
		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "Delete FROM frequenze WHERE idedizione IN (SELECT FROM edizione WHERE idcorso=?)";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, idCorso);

			preparedStatement.executeUpdate();
			
		} catch (SQLException | NamingException e) {
			
			e.printStackTrace();
		}

		
		return true;
		
	}

	public static boolean deleteFrequenzeByDocente (int idDocente) {
		
		
		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "Delete FROM frequenze WHERE idedizione IN (SELECT FROM edizione WHERE iddocente=?)";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, idDocente);

			preparedStatement.executeUpdate();
			
		} catch (SQLException | NamingException e) {
			
			e.printStackTrace();
		}

		
		return true;
		
	}

	public static ArrayList<Frequenze> selectAllFrequenze()  {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			ArrayList<Frequenze> freqList = new ArrayList<Frequenze>();

			
				String qry = "SELECT * FROM frequenze";

				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);
				
				ResultSet res = preparedStatement.executeQuery();

				while (res.next()) {

					Frequenze freq = new Frequenze();

					freq.setId(res.getInt("id"));
					freq.setId(res.getInt("idimp"));
					freq.setId(res.getInt("idedione"));
					freqList.add(freq);

					System.out.println(freq);

}
				return freqList;
				
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Frequenze selectFrequenzeById(int id) {

		Frequenze freq = new Frequenze();

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "SELECT * FROM frequenze WHERE id = ?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, id);

			ResultSet res = preparedStatement.executeQuery();

			if (res.next()) {
				freq.setId(id);
				freq.setIdEdiz(res.getInt("idedizione"));
				freq.setIdImp(res.getInt("idimp"));
				System.out.println(freq);

				return freq;
			} else
				return null;
		}

		catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	

}
