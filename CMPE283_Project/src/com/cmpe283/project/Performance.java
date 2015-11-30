package com.cmpe283.project;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.PerfCounterInfo;
import com.vmware.vim25.PerfEntityMetric;
import com.vmware.vim25.PerfEntityMetricBase;
import com.vmware.vim25.PerfMetricId;
import com.vmware.vim25.PerfMetricIntSeries;
import com.vmware.vim25.PerfMetricSeries;
import com.vmware.vim25.PerfProviderSummary;
import com.vmware.vim25.PerfQuerySpec;
import com.vmware.vim25.PerfSampleInfo;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.PerformanceManager;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;

public class Performance {

	static final String SERVER_NAME = "192.168.190.87";
	static final String USER_NAME = "Administrator";
	static final String PASSWORD = "xxxxxx";
	private static final String HOSTNAME = "192.168.190.34";
	private static final int SELECTED_COUNTER_ID = 2;// Active (mem) in KB (absolute)
	private static ArrayList<Integer> listCounterIds = new ArrayList<Integer>();

	public void getStatistics(ESXI esxi,String hostname)
	{
		String url = "https://" + esxi.getIp() + "/sdk/vimService";
		try {
			ServiceInstance si = new ServiceInstance(new URL(url), esxi.getUser(), esxi.getPassword(), true);
			//HostSystem host = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostname);
			PerformanceManager perfMgr = si.getPerformanceManager();
			System.out.println("Counter ID = " + SELECTED_COUNTER_ID);
			//VirtualMachine vm = (VirtualMachine) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("VirtualMachine", "hadoopmaster");
			VirtualMachine vm =null;
			ManagedEntity[] managedEntitiesVM = new InventoryNavigator(si.getRootFolder()).searchManagedEntities("VirtualMachine");
			for(int i=0;i<managedEntitiesVM.length;i++)
			{
				vm = (VirtualMachine)managedEntitiesVM[i];
				if( vm.getName().equalsIgnoreCase("Hadoop slave 1"))
				{
					break;
				}
				
			}
			PerfProviderSummary summary = perfMgr.queryPerfProviderSummary(vm);
			int perfInterval = summary.getRefreshRate();
			System.out.println("Refresh rate = " + perfInterval);

			PerfMetricId[] queryAvailablePerfMetric = perfMgr.queryAvailablePerfMetric(vm, null, null, perfInterval);
			ArrayList<PerfMetricId> list = new ArrayList<PerfMetricId>();
			for (int i2 = 0; i2 < queryAvailablePerfMetric.length; i2++) {
				PerfMetricId perfMetricId = queryAvailablePerfMetric[i2];
				if (SELECTED_COUNTER_ID == perfMetricId.getCounterId()) {
					//System.out.println("found");
					list.add(perfMetricId);
				
				}
				//System.out.println(perfMetricId.getCounterId());
			}
			if(list.size() == 0)
				{
					System.out.println("No matching metric found.");
					System.exit(0);
				}
			PerfMetricId[] pmis = list.toArray(new PerfMetricId[list.size()]);
			
			PerfQuerySpec qSpec = new PerfQuerySpec();
			qSpec.setEntity(vm.getMOR());	
			qSpec.setMetricId(pmis);
			qSpec.intervalId = perfInterval;

			PerfEntityMetricBase[] pembs = perfMgr.queryPerf(new PerfQuerySpec[] { qSpec });
			for (int i = 0; pembs != null && i < pembs.length; i++) {
				PerfEntityMetricBase val = pembs[i];
				PerfEntityMetric pem = (PerfEntityMetric) val;
				PerfMetricSeries[] vals = pem.getValue();
				PerfSampleInfo[] infos = pem.getSampleInfo();
				System.out.println(vals.length);
				for (int j = 0; vals != null && j < vals.length; ++j) {
					PerfMetricIntSeries val1 = (PerfMetricIntSeries) vals[j];
					long[] longs = val1.getValue();
					System.out.println(longs.length);
					System.out.println(infos[longs.length-1].getTimestamp().getTime() + " : " + longs[longs.length-1]);
					/*for (int k = 0; k < longs.length; k++) {
						System.out.println(infos[k].getTimestamp().getTime() + " : " + longs[k]);
					}*/
					System.out.println();
				}
			}
			si.getServerConnection().logout();
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
		}
	}
	
	public void printPerformanceCounters(ESXI esxi) throws RemoteException, MalformedURLException
	{

		String url = "https://" + esxi.getIp() + "/sdk/vimService";
			ServiceInstance si = new ServiceInstance(new URL(url), esxi.getUser(), esxi.getPassword(), true);
			//HostSystem host = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostname);
			PerformanceManager perfMgr = si.getPerformanceManager();
		PerfCounterInfo[] perfCounters = perfMgr.getPerfCounter();
		for (int i = 0; i < perfCounters.length; i++) {
			PerfCounterInfo perfCounterInfo = perfCounters[i];
			String perfCounterString = perfCounterInfo.getNameInfo().getLabel() + " (" + perfCounterInfo.getGroupInfo().getKey() + ") in "
					+ perfCounterInfo.getUnitInfo().getLabel() + " (" + perfCounterInfo.getStatsType().toString() + ")";
				System.out.println(perfCounterInfo.getKey() + " : " + perfCounterString);
		}
	}

	public VM getVMMetrics(ESXI esxi,VM vm)
	{
		String url = "https://" + esxi.getIp() + "/sdk/vimService";
		listCounterIds.add(2);
		listCounterIds.add(24);
		try {
			ServiceInstance si = new ServiceInstance(new URL(url), esxi.getUser(), esxi.getPassword(), true);
			//HostSystem host = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostname);
			PerformanceManager perfMgr = si.getPerformanceManager();
			System.out.println("Counter ID = " + SELECTED_COUNTER_ID);
			//VirtualMachine vm = (VirtualMachine) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("VirtualMachine", "hadoopmaster");
			VirtualMachine virtualMachine =null;
			ManagedEntity[] managedEntitiesVM = new InventoryNavigator(si.getRootFolder()).searchManagedEntities("VirtualMachine");
			for(int i=0;i<managedEntitiesVM.length;i++)
			{
				virtualMachine = (VirtualMachine)managedEntitiesVM[i];
				if( virtualMachine.getName().equalsIgnoreCase(vm.getName()))
				{
					break;
				}
				
			}
			vm.setIp(virtualMachine.getGuest().getIpAddress());
			PerfProviderSummary summary = perfMgr.queryPerfProviderSummary(virtualMachine);
			int perfInterval = summary.getRefreshRate();
			System.out.println("Refresh rate = " + perfInterval);
			
			PerfMetricId[] queryAvailablePerfMetric = perfMgr.queryAvailablePerfMetric(virtualMachine, null, null, perfInterval);
			ArrayList<PerfMetricId> list = new ArrayList<PerfMetricId>();
			for (int i2 = 0; i2 < queryAvailablePerfMetric.length; i2++) {
				PerfMetricId perfMetricId = queryAvailablePerfMetric[i2];
				if (listCounterIds.contains(perfMetricId.getCounterId())) {
					//System.out.println("found");
					list.add(perfMetricId);
				}
				//System.out.println(perfMetricId.getCounterId());
			}
			if(list.size() == 0)
				{
					System.out.println("No matching metric found.");
					System.exit(0);
				}
			PerfMetricId[] pmis = list.toArray(new PerfMetricId[list.size()]);
			
			PerfQuerySpec qSpec = new PerfQuerySpec();
			qSpec.setEntity(virtualMachine.getMOR());	
			qSpec.setMetricId(pmis);
			qSpec.intervalId = perfInterval;

			PerfEntityMetricBase[] pembs = perfMgr.queryPerf(new PerfQuerySpec[] { qSpec });
			for (int i = 0; pembs != null && i < pembs.length; i++) {
				PerfEntityMetricBase val = pembs[i];
				PerfEntityMetric pem = (PerfEntityMetric) val;
				PerfMetricSeries[] vals = pem.getValue();
				PerfSampleInfo[] infos = pem.getSampleInfo();
				System.out.println(vals.length);
				for (int j = 0; vals != null && j < vals.length; ++j) {
					PerfMetricIntSeries val1 = (PerfMetricIntSeries) vals[j];
					long[] longs = val1.getValue();
					System.out.println(longs.length);
					switch(val1.id.counterId)
					{
					case 2:	vm.setCpu(longs[longs.length-1]);break;
					case 24: vm.setMemory(longs[longs.length-1]);break;
					}
					//System.out.println(infos[longs.length-1].getTimestamp().getTime() + " : " + longs[longs.length-1]);
					/*for (int k = 0; k < longs.length; k++) {
						System.out.println(infos[k].getTimestamp().getTime() + " : " + longs[k]);
					}*/
					System.out.println();
				}
			}
			si.getServerConnection().logout();
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
		}
		return vm;
	}
}
