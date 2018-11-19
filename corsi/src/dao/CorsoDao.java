package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import modelJpa.Corso;

public class CorsoDao {

	private EntityManager em;

	public CorsoDao() {
		super();
	}

	public CorsoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public boolean insertCorso(Corso co) {

		try {
			em.persist(co);
		} catch (Exception e) {
			
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
			
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateCorso(Corso co) {

		try {
			em.merge(co);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
	}

	public ArrayList<Corso> selectCorsoByNome(String nome) {

		TypedQuery<Corso> qry = em.createQuery("SELECT cor FROM CORSO cor WHERE cor.nome LIKE :nome", Corso.class);
		
		qry.setParameter("nome","%"+ nome + "%");

		return new ArrayList<Corso>(qry.getResultList());
	}
	
	public ArrayList<Corso> selectAllCorso() {

		TypedQuery<Corso> qry = em.createQuery("SELECT cor FROM CORSO cor ", Corso.class);
		

		return new ArrayList<Corso>(qry.getResultList());
		
		
	}

	public Corso selectCorsoById(int id) {

		try {
			return em.find(modelJpa.Corso.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
}
