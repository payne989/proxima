 package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import model.Edizione;
import modelJpa.Corso;
import modelJpa.Docente;
import modelJpa.Sede;

public class EdizioneDao {
	
	private EntityManager em;
	
	public EdizioneDao(EntityManager em) {
		super();
		this.em = em;
	}

	public EdizioneDao() {
		super();
	}

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
	
	public boolean updateEdizione(int id, int idSede, int idDocente, Date dataIn, Date dataFin) {

		modelJpa.Edizione ed = em.find(modelJpa.Edizione.class,id);
    	
		ed.setDatain(dataIn);
		ed.setDatafin(dataFin);
		
		Docente d = em.find(Docente.class, idDocente);
		ed.setDocente(d);
		
		Sede s = em.find(Sede.class, idSede);
		ed.setSede(s);
		
		try {
			em.merge(ed);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return true;
	} 
	
	public boolean insertEdizione (int idCorso,int idSede, int idDocente, Date dataIn, Date dataFin) {
		
		modelJpa.Edizione ed = new modelJpa.Edizione();
    	
		ed.setDatain(dataIn);
		ed.setDatafin(dataFin);
		
		Corso c = em.find(Corso.class, idCorso);		
		ed.setCorso(c);
		
		Docente d = em.find(Docente.class, idDocente);
		ed.setDocente(d);
		
		Sede s = em.find(Sede.class, idSede);
		ed.setSede(s);
		try {
			em.persist(ed);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return true;
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
