package ejbInterfaces;

import java.util.ArrayList;

import javax.ejb.Local;

import dto.DocenteDTO;

@Local
public interface DocenteejbLocal {

	public boolean insertDocente (String nome, String cognome, String cf);
	
	public boolean deleteDocente (int id);
	
	public boolean updateDocente (String nome, String cognome, String cf, int id);
	
	public DocenteDTO selectDocenteById(int id);
	
	public DocenteDTO selectDocenteByCf(String cf);
	
	public ArrayList<DocenteDTO> selectAllDocente();
}
