package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import modelJpa.Docente;

public class DocenteDao {

	private EntityManager em;

	public DocenteDao(EntityManager em) {
		super();
		this.em = em;
	}

	public DocenteDao() {
		super();
	}

	public boolean insertDocente(Docente doc) {

		try {
			em.persist(doc);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;
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

	public boolean updateDocente(Docente doc) {

		try {
			em.merge(doc);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
	}

	public Docente selectDocenteBycf(String cf) {

		TypedQuery<Docente> qry = em.createQuery("SELECT doc FROM DOCENTE doc WHERE doc.cf = :codfisc", Docente.class);
		qry.setParameter("codfisc", cf);

		Docente doc = (qry.getSingleResult());

		return doc;
	}

	public Docente selectDocenteById(int id) {

		try {
			return em.find(Docente.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Docente> selectAllDocente() {

		TypedQuery<Docente> qry = em.createQuery("SELECT doc FROM DOCENTE doc ", Docente.class);
		

		return new ArrayList<Docente>(qry.getResultList());
		
	}
}
