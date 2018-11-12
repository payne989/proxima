package ejbInterfaces;

import java.sql.Date;
import java.util.ArrayList;

import javax.ejb.Remote;

import dto.EdizioneDTO;

@Remote
public interface EdizioneejbRemote {

	
public boolean insertEdizione(int idCorso,int idSede, int idDocente, Date dataIn, Date dataFin);
	
	public boolean deleteEdizioneById(int id);
	
	public boolean deleteEdizioneByIdSede (int idSede);
	
	public boolean deleteEdizioneByIdDocente (int idDocente);
	
	public boolean deleteEdizioneByIdCorso (int idCorso);
	
	 public boolean updateEdizione(int id, int idCorso,int idSede, int idDocente, Date dataIn, Date dataFin);
	 
	 public EdizioneDTO selectEdizioneById (int id);
	 
	 public ArrayList<EdizioneDTO> selectAllEdizione ();
}
