package com.cmpe283.ExtraCredit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Date;

import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;

public class NoServiceDisruption {

	public static void main(String[] args)
	{
		try
		{
			while(true)
			{
			logTimeAndHostIP();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void logTimeAndHostIP() throws InvalidProperty, RuntimeFault, RemoteException, MalformedURLException
	{
		String url = "https://130.65.159.14/sdk";
		ServiceInstance si = new ServiceInstance(new URL(url), "cmpe283_sec5_student@vsphere.local", "cmpe283-agc3", true );
		String vmName = "Testing VM";
		Folder rootFolder = si.getRootFolder();
		ManagedEntity[] managedEntitiesHosts = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
			for(int i =0; i<managedEntitiesHosts.length;i++)
			{
				HostSystem ds = (HostSystem)managedEntitiesHosts[i];
				VirtualMachine[] vms = ds.getVms();
				for(VirtualMachine tempVm: vms)
				{
					if(tempVm.getName().equalsIgnoreCase(vmName))
					{
						String toLog = new Date() + " Host IP: "+ ds.getName();
						System.out.println(toLog);
						try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Migration.txt", true)))) {
						    out.println(toLog);
						}catch (IOException e) {
						    //exception handling left as an exercise for the reader
						}
					
					}
				}
			
			}
		
		
	}
}
