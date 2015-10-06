package com.cmpe283.HW1;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.rmi.RemoteException;

import com.vmware.vim25.GuestInfo;
import com.vmware.vim25.TaskInfo;
import com.vmware.vim25.VirtualMachineCapability;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.VirtualMachinePowerState;
import com.vmware.vim25.VirtualMachineRuntimeInfo;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

public class VMOperations {

	public void enumerateVMs(ESXI esxi) throws RemoteException, MalformedURLException, InterruptedException
	{
		String url = "https://"+esxi.getIp()+"/sdk";
		ServiceInstance si = new ServiceInstance(new URL(url), esxi.getUser(), esxi.getPassword(), true );
		Folder rootFolder = si.getRootFolder();
		
		
		ManagedEntity[] mes = new InventoryNavigator(rootFolder)
				.searchManagedEntities("VirtualMachine");
		if (mes == null || mes.length == 0) {
			return;
		}
		for (ManagedEntity me : mes) {
			VirtualMachine vm = (VirtualMachine) me;
			VirtualMachineConfigInfo vminfo = vm.getConfig();
			VirtualMachineCapability vmc = vm.getCapability();
			VirtualMachineRuntimeInfo runtimeInfo = vm.getRuntime();
			
			System.out.println("Multiple snapshot supported: " + vmc.isMultipleSnapshotsSupported());
			String name = vminfo.getName();
			String guestOs = vminfo.getGuestFullName();
			GuestInfo guest = vm.getGuest();
			String state = guest.getGuestState();
			VirtualMachinePowerState powerState = runtimeInfo.getPowerState();
			System.out.println("Name: " + name);
			System.out.println("Guest OS: " + guestOs);
			System.out.println("Guest State :" + state);
			System.out.println("Power State :" + powerState.toString());
			
			/*TaskInfo info = null;
			if( powerState.equals(VirtualMachinePowerState.poweredOn))
			{
				Task powerOfTask = vm.powerOffVM_Task();
				if(powerOfTask.waitForTask() == Task.SUCCESS)
				{
					info = powerOfTask.getTaskInfo();
					System.out.println("Power OFF VM. Status = success. " + vm.getName() + " is now OFF.");
				}
			}
			else if( powerState.equals(VirtualMachinePowerState.poweredOff))
			{
				Task powerOnTask = vm.powerOnVM_Task(null);
				if(powerOnTask.waitForTask() == Task.SUCCESS)
				{
					info = powerOnTask.getTaskInfo();
					System.out.println("Power ON VM. Status = success. " + vm.getName() + " is now ON.");
				}
			}
			System.out.println("Name: "+ info.getName());
			System.out.println("Start Time: "+ info.getStartTime().getTime());
			System.out.println("End Time: "+ info.getCompleteTime().getTime());*/
		}
		si.getServerConnection().logout();
	}
}
