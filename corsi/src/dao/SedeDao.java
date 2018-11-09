package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.Sede;

public class SedeDao {

	public static boolean insertSede(String nomeSede, String indirizzo, String citta) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "INSERT INTO sede (nomeSede,indirizzo,citta) VALUES (?,?,?)";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, nomeSede);
			preparedStatement.setString(2, indirizzo);
			preparedStatement.setString(3, citta);

			preparedStatement.executeUpdate();

			return true;

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static boolean deleteSede(int id) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			FrequenzeDao.deleteFrequenzeBySede(id);
		
			EdizioneDao.deleteEdizioneByIdSede(id);
						
			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "DELETE FROM sede WHERE id = ?";
			
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

	public static boolean updateSede(String nomeSede, String indirizzo, String citta, int id) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "UPDATE sede SET nomeSede = ?, indirizzo = ?, citta = ? WHERE id = ? ";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, nomeSede);
			preparedStatement.setString(2, indirizzo);
			preparedStatement.setString(3, citta);
			preparedStatement.setInt(4, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException | NamingException e) {
			
			e.printStackTrace();
			return false;
		}

	}

	public static ArrayList<Sede> selectSedeByNome(String nomeSede) {

		ArrayList<Sede> sedeList = new ArrayList<Sede>();

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "SELECT * FROM sede WHERE nomesede = ?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, "%" + nomeSede + "%");

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {

				Sede sed = new Sede();

				sed.setId(res.getInt(res.getString("id")));
				sed.setNomeSede(res.getString("nomesede"));
				sed.setIndirizzo(res.getString("indirizzo"));
				sed.setCitta(res.getString("citta"));

				sedeList.add(sed);

				System.out.println(sed);

			}
			return sedeList;

		} catch (SQLException | NamingException e) {
			
			e.printStackTrace();
			return null;
		}

	}

	public static Sede selectSedeById(int id) {

		Sede sed = new Sede();

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "SELECT * FROM sede WHERE id = ?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, id);

			ResultSet res = preparedStatement.executeQuery();

			if (res.next()) {
				sed.setId(id);
				sed.setNomeSede(res.getString("nomesede"));
				sed.setIndirizzo(res.getString("indirizzo"));
				sed.setCitta(res.getString("citta"));
				System.out.println(sed);

				return sed;
			} else
				return null;
		}

		catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<Sede> selectAllSede()  {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			ArrayList<Sede> sedList = new ArrayList<Sede>();

			
				String qry = "SELECT * FROM sede";

				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);
				
				ResultSet res = preparedStatement.executeQuery();

				while (res.next()) {

					Sede sed = new Sede();

					sed.setId(res.getInt("id"));
					sed.setNomeSede(res.getString("nomesede"));
					sed.setIndirizzo(res.getString("indirizzo"));
					sed.setCitta(res.getString("citta"));
					
					sedList.add(sed);

					System.out.println(sed);

}
				return sedList;
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
