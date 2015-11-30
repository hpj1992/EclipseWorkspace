package com.cmpe283.HW2.ExtraCredit;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.RuntimeFault;

public class Main {

	public static void main(String[] args)
	{
		
		if( args.length == 4 )
		{
			String ip = args[0];
			String user = args[1];
			String password = args[2];
			String path = args[3];
			ESXI esxi = new ESXI(ip, user, password);
			OperationsExtraCredit ops = new OperationsExtraCredit();
			try {
				ops.performVMOperations(esxi, path);
			} catch (InvalidProperty e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RuntimeFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*HostOperations hostOperations = new HostOperations();
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
			}*/
			
			
		}
		else
		{
			System.out.println("Please provide required parameters. IP - USER - PASSWORD - Path.");
		}
	}
}
