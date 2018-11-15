package ejbInterfaces;


import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;

import dto.EdizioneDTO;

@Local
public interface EdizioneejbLocal {

	public boolean insertEdizione(EdizioneDTO ed);
	
	public boolean deleteEdizioneById(int id);
	
	public boolean deleteEdizioneByIdSede (int idSede);
	
	public boolean deleteEdizioneByIdDocente (int idDocente);
	
	public boolean deleteEdizioneByIdCorso (int idCorso);
	
	public boolean updateEdizione(int id, int idSede, int idDocente, Date dataIn, Date dataFin);
	 
	 public EdizioneDTO selectEdizioneById (int id);
	 
	 public ArrayList<EdizioneDTO> selectAllEdizione ();
}
