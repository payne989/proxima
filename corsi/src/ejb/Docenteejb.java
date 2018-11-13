package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.CorsoDao;
import dao.DocenteDao;
import dto.CorsoDTO;
import dto.DocenteDTO;
import ejbInterfaces.DocenteejbLocal;
import ejbInterfaces.DocenteejbRemote;
import modelJpa.Corso;
import modelJpa.Docente;
import utility.Converter;


@Stateless
@LocalBean
public class Docenteejb implements DocenteejbRemote, DocenteejbLocal {

	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
	
    public Docenteejb() {}

    public boolean insertDocente (String nome, String cognome, String cf) {
    	
    	
    	Docente doc = new Docente();
    	DocenteDao ddao = new DocenteDao(em);
    	
    	doc.setNome(nome);
    	doc.setCognome(cognome);
    	doc.setCf(cf);
    	
    	ddao.insertDocente(doc);
    
    	return true;
    }

    public boolean deleteDocente (int id) {
    	
    	return DocenteDao.deleteDocente(id);
    }
    
    public boolean updateCorso(DocenteDTO docente) {
    	
    	Docente doc = new Docente();
    	DocenteDao docdao = new DocenteDao(em);
    	
    	doc.setId(docente.getId());
    	doc.setNome(docente.getNome());
    	doc.setCognome(docente.getCognome());
    	doc.setCf(docente.getCf());
    	
    	docdao.updateDocente(doc);
    	
		return false;
}

    public DocenteDTO selectDocenteById(int id) {
    	
    	return Converter.convertDocente(DocenteDao.selectDocenteById(id));
    }

    public DocenteDTO selectDocenteByCf(String cf) {
    	
    	return Converter.convertDocente(DocenteDao.selectDocenteByCf(cf)); 
    }

    public ArrayList<DocenteDTO> selectAllDocente() {
    	
    	return Converter.convertDocenteList(DocenteDao.selectAllDocente());
    }
}
