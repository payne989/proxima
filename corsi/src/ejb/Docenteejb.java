package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.DocenteDao;
import dto.DocenteDTO;
import ejbInterfaces.DocenteejbLocal;
import ejbInterfaces.DocenteejbRemote;
import utility.Converter;


@Stateless
@LocalBean
public class Docenteejb implements DocenteejbRemote, DocenteejbLocal {

   
    public Docenteejb() {}

    public boolean insertDocente (String nome, String cognome, String cf){
		
    	return DocenteDao.insertDocente(nome, cognome, cf);
    	
    }

    public boolean deleteDocente (int id) {
    	
    	return DocenteDao.deleteDocente(id);
    }
    
    public boolean updateDocente (String nome, String cognome, String cf, int id) {
    	
    	return DocenteDao.updateDocente(nome, cognome, cf, id);
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
