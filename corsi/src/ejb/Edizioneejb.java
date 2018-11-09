package ejb;

import java.sql.Date;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.EdizioneDao;
import dto.EdizioneDTO;
import ejbInterfaces.EdizioneejbLocal;
import ejbInterfaces.EdizioneejbRemote;
import utility.Converter;


@Stateless
@LocalBean
public class Edizioneejb implements EdizioneejbRemote, EdizioneejbLocal {

    public Edizioneejb() {}

    public boolean insertEdizione(int idCorso,int idSede, int idDocente, Date dataIn, Date dataFin) {
    	
    	return EdizioneDao.insertEdizione(idCorso, idSede, idDocente, dataIn, dataFin);
    }
    
    public boolean deleteEdizioneById(int id){
    	
    	return EdizioneDao.deleteEdizioneById(id);
    }
    
    public boolean deleteEdizioneByIdSede (int idSede) {
    	
    	return EdizioneDao.deleteEdizioneByIdSede(idSede);
    }

    public boolean deleteEdizioneByIdDocente (int idDocente) {
    	
    	return EdizioneDao.deleteEdizioneByIdDocente(idDocente);
    }

    public boolean deleteEdizioneByIdCorso (int idCorso) {
    	
    	return EdizioneDao.deleteEdizioneByIdCorso(idCorso);
    }

    public boolean updateEdizione(int id, int idCorso,int idSede, int idDocente, Date dataIn, Date dataFin) {
    	
    	return EdizioneDao.updateEdizione(id, idCorso, idSede, idDocente, dataIn, dataFin);
    }

    public EdizioneDTO selectEdizioneById (int id) {
    	
    	return Converter.convertEdizione(EdizioneDao.selectEdizioneById(id));
    }

    public ArrayList<EdizioneDTO> selectEdizioneByIdEdiz () {
    	
    	return Converter.convertEdizioneList(EdizioneDao.selectAllEdizione());
    }
}
