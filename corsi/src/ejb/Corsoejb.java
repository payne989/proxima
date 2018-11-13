package ejb;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.CorsoDao;
import dto.CorsoDTO;
import ejbInterfaces.CorsoejbLocal;
import ejbInterfaces.CorsoejbRemote;
import modelJpa.Corso;
import utility.Converter;


@Stateless
@LocalBean
public class Corsoejb implements CorsoejbRemote, CorsoejbLocal {

	
	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
    
    public Corsoejb() {}

    public boolean insertCorso (String nome) {
    	
    	
    	Corso co = new Corso();
    	CorsoDao cdao = new CorsoDao(em);
    	
    	co.setNome(nome);
    	
    	cdao.insertCorso(co);
    
    	return true;
    }
    	
    public boolean deleteCorso(int id) {
    	
    	return CorsoDao.deleteCorso(id);
    	
}
    
    public boolean updateCorso(CorsoDTO corso) {
    	
    	Corso co = new Corso();
    	CorsoDao cdao = new CorsoDao(em);
    	
    	co.setId(corso.getId());
    	co.setNome(corso.getNome());
    	
    	cdao.updateCorso(co);
    	
		return false;
    	
    }

    public ArrayList<CorsoDTO> selectCorsoByNome (String nome) {
		
    	return Converter.convertCorsoList(CorsoDao.selectCorsoByNome(nome));
    	}
    
    public CorsoDTO selectCorsoById (int id) {
    	
    	return Converter.convertCorso(CorsoDao.selectCorsoById(id));
    }

    public ArrayList<CorsoDTO> selectAllCorso () {
    	
    	return Converter.convertCorsoList(CorsoDao.selectAllCorso());
    }







}

























