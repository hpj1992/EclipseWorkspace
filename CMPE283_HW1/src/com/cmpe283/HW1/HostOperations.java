package com.cmpe283.HW1;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import com.vmware.vim25.mo.Datastore;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.Network;
import com.vmware.vim25.mo.ServiceInstance;

public class HostOperations {
	public void enumerateHosts(ESXI esxi) throws RemoteException, MalformedURLException
	{
		String url = "https://"+esxi.getIp()+"/sdk";
		
		ServiceInstance si = new ServiceInstance(new URL(url), esxi.getUser(), esxi.getPassword(), true );
		Folder rootFolder = si.getRootFolder();
		System.out.println("Host Name:"+rootFolder.getName());
		System.out.println("Product Full Name: " + si.getAboutInfo().getFullName());
		
		ManagedEntity[] hosts = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
		if( hosts == null || hosts.length == 0)
			return;
		
		for(ManagedEntity host : hosts)
		{
			HostSystem hostSystem = (HostSystem)host;
			System.out.println("Host Name: "+ hostSystem.getName());
			Datastore[] dataStores = hostSystem.getDatastores();
			int index = 0;
			for(Datastore dataStore : dataStores)
			{
				String datastoreName = dataStore.getName();
				Long capacity = dataStore.getInfo().maxVirtualDiskCapacity;
				Long freeSpace = dataStore.getSummary().getFreeSpace();
				System.out.println("Datastore["+ index++ + "]: Name = " + datastoreName + ", Capacity = "+ capacity + " , Free Space = " + freeSpace);
			}
			Network[] networks = hostSystem.getNetworks();
			index = 0;
			for(Network network : networks)
			{
				System.out.println("Network["+ index++ +"]: Name = "+network.getName());
			}
		}
	
		si.getServerConnection().logout();
	}
}
