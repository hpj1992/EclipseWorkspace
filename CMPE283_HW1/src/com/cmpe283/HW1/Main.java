package com.cmpe283.HW1;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args)
	{
		
		if( args.length ==3 )
		{
			String ip = args[0];
			String user = args[1];
			String password = args[2];
			ESXI esxi = new ESXI(ip, user, password);
			
			HostOperations hostOperations = new HostOperations();
			VMOperations vmOperations = new VMOperations();
			
			try {
				hostOperations.enumerateHosts(esxi);
				try {
					vmOperations.enumerateVMs(esxi);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else
		{
			System.out.println("Please provide required parameters. IP - USER - PASSWORD.");
		}
	}
}
