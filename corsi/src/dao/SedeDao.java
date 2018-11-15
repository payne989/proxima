package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import modelJpa.Sede;

public class SedeDao {

	private EntityManager em;
	
	public SedeDao(EntityManager em) {
		super();
		this.em = em;
	}
    
	public SedeDao() {
		super();
	}

	public boolean insertSede(Sede sed) {

		try {
			em.persist(sed);
		} catch (Exception e) {
			
			e.printStackTrace();
			}

		return true;

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

	public boolean updateSede(Sede sed) {

		try {
			em.merge(sed);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return true;

	}

	public ArrayList<Sede> selectSedeByNome(String nomeSede) {

		TypedQuery<Sede> qry = em.createQuery("SELECT sed FROM SEDE sed WHERE sed.nome LIKE :nome", Sede.class);
		qry.setParameter("nome","%"+ nomeSede + "%");

		return new ArrayList<Sede>(qry.getResultList());

	}

	public Sede selectSedeById(int id) {
		
		try {
			return em.find(Sede.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Sede> selectAllSede()  {

		TypedQuery<Sede> qry = em.createQuery("SELECT sed FROM SEDE sed ", Sede.class);
		

		return new ArrayList<Sede>(qry.getResultList());
	
	}
}
