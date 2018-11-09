package ejb;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import dao.CorsoDao;
import dto.CorsoDTO;
import ejbInterfaces.CorsoejbLocal;
import ejbInterfaces.CorsoejbRemote;
import utility.Converter;


@Stateless
@LocalBean
public class Corsoejb implements CorsoejbRemote, CorsoejbLocal {

    
    public Corsoejb() {}

    public boolean insertCorso (String nome) {
    	
    	System.out.println("Corso_ejb.insertCorso nome:"+nome);
    	
    	return CorsoDao.insertCorso(nome);
    }
    	
    public boolean deleteCorso(int id) {
    	
    	return CorsoDao.deleteCorso(id);
    	
}
    
    public boolean updateCorso(String nome) {
    	
    	return CorsoDao.updateCorso(nome);
    	
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

























