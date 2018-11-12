package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ProvaEJB
 */
@Stateless
@LocalBean
public class ProvaEJB implements ProvaEJBRemote, ProvaEJBLocal {

   public ProvaEJB() {
        
    }

   public void prova () {
	   
	   System.out.println("ciao");
   }
}
