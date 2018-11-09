package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.FrequenzeDao;
import dto.FrequenzeDTO;
import ejbInterfaces.FrequenzeejbLocal;
import ejbInterfaces.FrequenzeejbRemote;
import utility.Converter;


@Stateless
@LocalBean
public class Frequenzeejb implements FrequenzeejbRemote, FrequenzeejbLocal {

    
    public Frequenzeejb() {}

    public boolean insertFrequenze (int idImp, int idEdiz) {
    	
    	return FrequenzeDao.insertFrequenze(idImp, idEdiz);
    }
    
    public boolean deleteFrequenzeById (int id) {
    	
    	return FrequenzeDao.deleteFrequenzeById(id);
    }
    
    public boolean deleteFrequenzeByIdSede (int idSede){
    	return FrequenzeDao.deleteFrequenzeBySede(idSede);
    }		
    
    public boolean deleteFrequenzeByIdCorso (int idCorso) {
    	
    	return FrequenzeDao.deleteFrequenzeByCorso(idCorso);
    }
    
    public boolean deleteFrequenzeByIdDocente (int idDocente) {
    	
    	return FrequenzeDao.deleteFrequenzeByDocente(idDocente);
    }
    
    public FrequenzeDTO selectFrequenzeById (int id) {
    	
    	return Converter.convertFrequenze(FrequenzeDao.selectFrequenzeById(id));
    }
    
    public ArrayList<FrequenzeDTO> selectAllFrequenze() {
    	
    	return Converter.convertFrequenzeList(FrequenzeDao.selectAllFrequenze());
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
