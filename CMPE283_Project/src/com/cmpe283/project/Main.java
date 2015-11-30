package com.cmpe283.project;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.VirtualMachinePowerState;
import com.vmware.vim25.mo.Datacenter;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;


public class Main {

	public static void main(String[] args)
	{
		if( args.length == 3 )
		{
			String ip = args[0];
			String user = args[1];
			String password = args[2];
			String vmName = "Testing VM";
			ESXI esxi = new ESXI(ip, user, password);
			Operations ops = new Operations();
			Performance performance = new Performance();
			try {
				ops.createVMForHadoop(esxi, 1,"Classroom","New Virtual Machine","Slave 2");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//performance.printPerformanceCounters(esxi);
			//2 - CPU Percentage
			//24 - Memory Percentage
			// 143 - Network Percentage
			// 125 Usage Disk
			//performance.getStatistics(esxi, "130.65.159.10");
			/*VM vm = new VM();
			vm.setName("Hadoop Master Node");
			//vm = performance.getVMMetrics(esxi, vm);
			System.out.println(vm.getCpu()[0]);
			System.out.println(vm.getMemory()[0]);
			printPOJO(vm);*/
			try {
				new Main().getTeam3VM(esxi);
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
			};
		}
		else
		{
			System.out.println("Please provide required parameters. IP - USER - PASSWORD - Path.");
		}
	}
	public static void printPOJO(VM vm)
	{
		ObjectMapper mapper = new ObjectMapper();


		try {
			// Convert object to JSON string and save into a file directly
		//	mapper.writeValue(new File("D:\\staff.json"), vm);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(vm);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vm);
			System.out.println(jsonInString);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getTeam3VM(ESXI esxi) throws InvalidProperty, RuntimeFault, RemoteException, MalformedURLException
	{
		String url = "https://"+esxi.getIp()+"/sdk";
		ServiceInstance si = new ServiceInstance(new URL(url), esxi.getUser(), esxi.getPassword(), true );
		Folder rootFolder = si.getRootFolder();
		String path = "CMPE LABS/CMPE283 SEC5/workspace/Team 3/";
		System.out.println("args[3]: "+path);
		ManagedEntity[] managedEntitiesDataCenters = new InventoryNavigator(rootFolder).searchManagedEntities("Datacenter");
		String[] paths = path.split("/");
		int pathLength = paths.length;
		int counter =0;
		
			for(int i =0;i<managedEntitiesDataCenters.length;i++)
			{
				Datacenter dataCenter = (Datacenter) managedEntitiesDataCenters[i];
				System.out.println("DataCenter Folder Name: "+ dataCenter.getName());
				Folder vmFolder = dataCenter.getVmFolder();
				if(pathLength>0)
				{
					pathLength--;
					counter++;
					while(pathLength>0) 
					{
						ManagedEntity[] allVms = vmFolder.getChildEntity();
						for(ManagedEntity entity: allVms)
						{
							Folder folder = (Folder)entity;
							if(folder.getName().equals(paths[counter]))
							{
								vmFolder = folder;
								counter++;
								pathLength--;
								
								break;
							}
						}
					}
	
					System.out.println("VM Folder: "+ vmFolder.getName());
					for(ManagedEntity entity: vmFolder.getChildEntity())
					{
						VirtualMachine vm = (VirtualMachine)entity;
						System.out.println(vm.getName());
						if(vm.getRuntime().powerState.equals(VirtualMachinePowerState.poweredOn))
						{
							VM vmm = new VM();
							vmm.setName(vm.getName());
							vmm.setIp(vm.getGuest().getIpAddress());
							vmm = new Performance().getVMMetrics(esxi, vmm);
							vmm = new Operations().getHostDetails(rootFolder, vmm);
							printPOJO(vmm);
						}
					}
					
				}
	}

}
}
