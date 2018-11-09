package ejb;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import dao.SedeDao;
import dto.SedeDTO;
import ejbInterfaces.SedeejbLocal;
import ejbInterfaces.SedeejbRemote;
import utility.Converter;


@Stateless
@LocalBean
public class Sedeejb implements SedeejbRemote, SedeejbLocal {

    
    public Sedeejb() {}

    public boolean insertSede (String nome, String indirizzo,String citta) {
		
    	return SedeDao.insertSede(nome, indirizzo, citta);
    	}

    public boolean deleteSede (int id){
    	
    	return SedeDao.deleteSede(id);
    }

    public boolean updateSede (String nome, String indirizzo,String citta, int id){
    	
    	return SedeDao.updateSede(nome, indirizzo, citta, id);
    }
    
    public ArrayList<SedeDTO> selectAllSede () {
    	
    	return Converter.convertSedeList(SedeDao.selectAllSede());
    }

    public ArrayList<SedeDTO> selectSedeByNome (String nomeSede) {
    	
    	return Converter.convertSedeList(SedeDao.selectSedeByNome(nomeSede));
    }
    
    public SedeDTO selectSedeById (int id) {
    	
    	return Converter.convertSede(SedeDao.selectSedeById(id));
    }
}
