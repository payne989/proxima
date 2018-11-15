package ejbInterfaces;

import java.util.ArrayList;

import javax.ejb.Local;

import dto.FrequenzeDTO;

@Local
public interface FrequenzeejbLocal {

	public boolean insertFrequenze (FrequenzeDTO freq);
	
	public boolean deleteFrequenzeById (int id);
	
	public boolean deleteFrequenzeByIdSede (int idSede);
	
	public boolean deleteFrequenzeByIdCorso (int idCorso);
	
	public boolean deleteFrequenzeByIdDocente (int idDocente);
	
	public FrequenzeDTO selectFrequenzeById (int id);
	
	public ArrayList<FrequenzeDTO> selectAllFrequenze();
}
