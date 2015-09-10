package SourceCodes;

import java.rmi.RemoteException;

import DefaultNamespace.CalculatorServiceProxy;





public class CalculatorServerClient {
	
	public static void main(String[] a)
	{
		
		CalculatorServiceProxy proxy=new CalculatorServiceProxy();
		try {
			float ans=proxy.getResult(5, 6, "Add");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
