package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import model.Corso;

public class CorsoDao {

	private EntityManager em;

	public CorsoDao() {
		super();
	}

	public CorsoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public boolean insertCorso(modelJpa.Corso co) {

		try {
			em.persist(co);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public static boolean deleteCorso(int id) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			EdizioneDao.deleteEdizioneByIdCorso(id);

			FrequenzeDao.deleteFrequenzeByCorso(id);

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "DELETE FROM corso WHERE id=?";

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

	public boolean updateCorso(modelJpa.Corso co) {

		try {
			em.merge(co);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return true;
	}

	public static ArrayList<Corso> selectCorsoByNome(String nome) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			ArrayList<Corso> corsoList = new ArrayList<Corso>();

			String qry = "SELECT * FROM corso WHERE nome=?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setString(1, "%" + nome + "%");

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {

				Corso cor = new Corso();

				cor.setId(res.getInt("id"));
				cor.setNome(res.getString("nome"));

				corsoList.add(cor);

				System.out.println(cor);

			}
			return corsoList;
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<Corso> selectAllCorso() {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			ArrayList<Corso> corsoList = new ArrayList<Corso>();

			String qry = "SELECT * FROM corso";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {

				Corso cor = new Corso();

				cor.setId(res.getInt("id"));
				cor.setNome(res.getString("nome"));

				corsoList.add(cor);

				System.out.println(cor);

			}
			return corsoList;
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Corso selectCorsoById(int id) {

		Corso cor = new Corso();

		try {

			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/corsi")).getConnection();

			String qry = "SELECT * FROM corso WHERE id=?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setInt(1, id);

			ResultSet res = preparedStatement.executeQuery();

			if (res.next()) {
				cor.setId(id);
				cor.setNome(res.getString("nome"));

				System.out.println(cor);

			}

		} catch (Exception e) {
			System.err.println("errore");

			e.printStackTrace();
		}
		return cor;

	}
}
