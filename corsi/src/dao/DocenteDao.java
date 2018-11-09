package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Docente;


public class DocenteDao {

	public static boolean insertDocente(String nome, String cognome, String cf) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "INSERT INTO docente (nome,cognome,cf) VALUES (?,?,?)";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cognome);
			preparedStatement.setString(3, cf);

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static boolean deleteDocente(int id) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			EdizioneDao.deleteEdizioneByIdDocente(id);
			
			FrequenzeDao.deleteFrequenzeByDocente(id);
			
			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "DELETE FROM docente WHERE id=?";

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

	public static boolean updateDocente(String nome, String cognome, String cf, int id) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "UPDATE docente SET nome = ?, cognome = ?, cf = ? WHERE id = ? ";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cognome);
			preparedStatement.setString(3, cf);
			preparedStatement.setInt(4, id);

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}

	}

	public static Docente selectDocenteByCf(String cf) {

		Docente doc = new Docente();

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "SELECT * FROM docente WHERE cf = ?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, cf);

			ResultSet res = preparedStatement.executeQuery();

			if (res.next()) {
				doc.setId(res.getInt("id"));
				doc.setNome(res.getString("nome"));
				doc.setCognome(res.getString("cognome"));
				doc.setCf(cf);

				System.out.println(doc);

				return doc;
			} else
				return null;
		}

		catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public static Docente selectDocenteById(int id) {

		Docente doc = new Docente();

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "SELECT * FROM docente WHERE id = ?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, id);

			ResultSet res = preparedStatement.executeQuery();

			if (res.next()) {
				doc.setId(id);
				doc.setNome(res.getString("nome"));
				doc.setCognome(res.getString("cognome"));
				doc.setCf(res.getString("cf"));

				System.out.println(doc);

				return doc;
			} else
				return null;
		}

		catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<Docente> selectAllDocente()  {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			ArrayList<Docente> docList = new ArrayList<Docente>();

			
				String qry = "SELECT * FROM docente";

				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);
				
				ResultSet res = preparedStatement.executeQuery();

				while (res.next()) {

					Docente doc = new Docente();

					doc.setId(res.getInt("id"));
					doc.setNome(res.getString("nome"));
					doc.setCognome(res.getString("cognome"));
					doc.setCf(res.getString("cf"));
					docList.add(doc);

					System.out.println(doc);

}
				return docList;
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
