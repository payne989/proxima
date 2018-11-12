package test;

import java.rmi.RemoteException;

import webservices.ContoWSProxy;
import webservices.MovimentoWSProxy;

public class Test {

	public static void main(String[] args) {
		
		
		MovimentoWSProxy pro = new MovimentoWSProxy();
		ContoWSProxy prox = new ContoWSProxy();
		
		try {
			pro.createMovimento(1, 1, 100, "2018-10-22");
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		try {
//			prox.insertConto(1000, "2018-10-30", 19);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
