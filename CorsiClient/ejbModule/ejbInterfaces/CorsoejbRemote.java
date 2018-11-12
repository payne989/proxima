package ejbInterfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import dto.CorsoDTO;

@Remote
public interface CorsoejbRemote {

public boolean insertCorso (String nome);
	
	public boolean deleteCorso(int id);
	
	public boolean updateCorso(String nome);
	 
	public ArrayList<CorsoDTO> selectCorsoByNome (String nome);
	 
	public CorsoDTO selectCorsoById (int id);
	 
	public ArrayList<CorsoDTO> selectAllCorso ();
	
	
}
