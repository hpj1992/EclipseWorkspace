package com.cmpe283.HW2.ExtraCredit;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.VirtualMachineCapability;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

public class NavigateTree {

	//Extra-Credit
	public static void main(String[] args)
	{
		if( args.length == 4 )
		{
			String ip = args[0];
			String user = args[1];
			String password = args[2];
			String path = args[3];
			try {
				navigateInventoryTree(ip, user, password, path);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void navigateInventoryTree(String ip, String user, String password, String path) throws RemoteException, MalformedURLException
	{
		String url = "https://"+ip+"/sdk";
		ServiceInstance si = new ServiceInstance(new URL(url), user, password, true );
		Folder rootFolder = si.getRootFolder();
		
		enumerateHosts(rootFolder,si);
		enumerateAllVM(rootFolder,si);
		enumerateAllTasks(rootFolder,si);
	}
	
	public static void enumerateHosts(Folder rootFolder,ServiceInstance si)
	{
		try
		{
			ManagedEntity[] hostmanagedEntities = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
			int index = 0;
			for(ManagedEntity mi:hostmanagedEntities)
			{
				
				HostSystem hs=(HostSystem)mi;
				System.out.println("Host["+index+"]");
				System.out.println("Host Name: "+hs.getName());
				System.out.println("Product Full Name: "+si.getAboutInfo().getFullName());
				System.out.println();
				index++;
			}	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void enumerateAllVM(Folder rootFolder, ServiceInstance si)
	{
		try
		{
			String name = rootFolder.getName();
			ManagedEntity[] hostmanagedEntities = new InventoryNavigator(
					si.getRootFolder()).searchManagedEntities("HostSystem");
			ManagedEntity [] mes = new
					InventoryNavigator(si.getRootFolder()). searchManagedEntities("VirtualMachine");
			if (mes == null || mes.length == 0) {
				return;
			}
			int index = 0;
			for (ManagedEntity me: mes) 
			{	
				VirtualMachine vm = (VirtualMachine) me;
					VirtualMachineConfigInfo vminfo = vm.getConfig();
					VirtualMachineCapability vmc = vm.getCapability();	
					System.out.println("VM["+index+"]");
					System.out.println("VM Name " + vm.getName());  
					System.out.println("ESXi Host:"+vm.getSummary().getRuntime().host.get_value());
					System.out.println("Guest OS Full Name:"+vminfo.getGuestFullName());
					System.out.println("Guest State: "+vm.getGuest().guestState);
					System.out.println("Power State: "+vm.getRuntime().powerState);
				
					ManagedEntity m=null;
					index++;
			}	
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	public static void enumerateAllTasks(Folder rootFolder, ServiceInstance si)
	{
		try
		{

			ManagedEntity [] mes = new
					InventoryNavigator(si.getRootFolder()). searchManagedEntities("VirtualMachine");
			if (mes == null || mes.length == 0) {
				return;
			}
			for (ManagedEntity me: mes) 
			{	
				VirtualMachine vm = (VirtualMachine) me;
				
					Task[] tarray=vm.getRecentTasks();
					System.out.println("Tasks for VM: "+vm.getName());
					for(Task temp:tarray)
					{
							
							System.out.println(temp.getTaskInfo().getName());
							System.out.println("Name Of Operation: "+temp.getTaskInfo().getName());
							System.out.println("Task Target:"+temp.getTaskInfo().entityName);
							System.out.println("Task Result: "+temp.getTaskInfo().getState());
							if(temp.getTaskInfo().getState()==TaskInfoState.error)
							{
								System.out.println("Localized Error Message:"+temp.getTaskInfo().getError().getLocalizedMessage());
							}
							System.out.println();		
					}
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
