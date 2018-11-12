package ejbInterfaces;

import java.util.ArrayList;
import javax.ejb.Local;
import dto.SedeDTO;


@Local
public interface SedeejbLocal {

	public boolean insertSede (String nome, String indirizzo,String citta);
	
	public boolean deleteSede (int id);
	
	public boolean updateSede (String nome, String indirizzo,String citta, int id);
	
	public ArrayList<SedeDTO> selectAllSede ();
	
    public ArrayList<SedeDTO> selectSedeByNome (String nomeSede);
	
	public SedeDTO selectSedeById (int id);
    

}
