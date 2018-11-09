 package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.Edizione;

public class EdizioneDao {

	public static boolean deleteEdizioneById(int id) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			FrequenzeDao.deleteFrequenzeById(id);
			
			String insertTableSQL = "DELETE FROM edizione WHERE id=?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

			System.out.println("Corso cancellato con successo");
			return true;

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public static boolean deleteEdizioneByIdSede(int idSede) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "DELETE FROM edizione WHERE idsede=?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, idSede);

			preparedStatement.executeUpdate();

			System.out.println("Corso cancellato con successo");
			return true;

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static boolean deleteEdizioneByIdCorso(int idCorso) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "DELETE FROM edizione WHERE idcorso=?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, idCorso);

			preparedStatement.executeUpdate();

			System.out.println("Edizione cancellata con successo");
			return true;

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public static boolean deleteEdizioneByIdDocente(int idDocente) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "DELETE FROM edizione WHERE iddocente=?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, idDocente);

			preparedStatement.executeUpdate();

			System.out.println("Corso cancellato con successo");
			return true;

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public static boolean updateEdizione(int id, int idCorso, int idSede, int idDocente, Date dataIn, Date dataFin) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "UPDATE frequenze SET idcorso = ? , idsede = ?, iddocente = ?, datain = ?, datafin = ? WHERE id = ?";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, idCorso);
			preparedStatement.setInt(2, idSede);
			preparedStatement.setInt(3, idDocente);
			preparedStatement.setDate(4, dataIn);
			preparedStatement.setDate(5, dataFin);
			preparedStatement.setInt(6, id);

			preparedStatement.executeUpdate();

			return true;

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}

	}

	public static boolean insertEdizione(int idCorso, int idSede, int idDocente, Date dataIn, Date dataFin) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "INSERT INTO edizione (idcorso,idsede,iddocente,datain,datafin) VALUES (?,?,?,?,?)";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, idCorso);
			preparedStatement.setInt(2, idSede);
			preparedStatement.setInt(3, idDocente);
			preparedStatement.setDate(4, dataIn);
			preparedStatement.setDate(5, dataFin);

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Corso inserito con successo");

		return false;

	}

	public static Edizione selectEdizioneById(int id) {

		Edizione ed = new Edizione();

		try {

			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			String qry = "SELECT * FROM edizione WHERE id=?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setInt(1, id);

			ResultSet res = preparedStatement.executeQuery();

			if (res.next()) {
				ed.setId(id);
				ed.setIdCorso(res.getInt("idcorso"));
				ed.setIdSede(res.getInt("idsede"));
				ed.setIdDocente(res.getInt("iddocente"));
				ed.setDataIn(res.getDate("datain"));
				ed.setDataFin(res.getDate("datafin"));

				System.out.println(ed);

			}

		} catch (Exception e) {
			System.err.println("errore");

			e.printStackTrace();
		}
		return ed;

	}

	public static ArrayList<Edizione> selectAllEdizione()  {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			ArrayList<Edizione> edizList = new ArrayList<Edizione>();

			
				String qry = "SELECT * FROM edizione";

				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);
				
				ResultSet res = preparedStatement.executeQuery();

				while (res.next()) {

					Edizione ediz = new Edizione();

					ediz.setId(res.getInt("id"));
					ediz.setIdCorso(res.getInt("idcorso"));
					ediz.setIdSede(res.getInt("idsede"));
					ediz.setIdDocente(res.getInt("idDocente"));
					edizList.add(ediz);

					System.out.println(ediz);

}
				return edizList;
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}




}
