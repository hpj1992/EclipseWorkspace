import java.net.URL;
import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;

public class HelloVM {
	public static void main(String[] args) throws Exception {
		ServiceInstance si = new ServiceInstance(new URL(
				"https://192.168.163.128/sdk"), "root", "harshitroot", true);
		Folder rootFolder = si.getRootFolder();
		String name = rootFolder.getName();
		System.out.println("root:" + name);
		ManagedEntity[] mes = new InventoryNavigator(rootFolder)
				.searchManagedEntities("VirtualMachine");
		if (mes == null || mes.length == 0) {
			return;
		}
		for (ManagedEntity me : mes) {
			VirtualMachine vm = (VirtualMachine) me;
			VirtualMachineConfigInfo vminfo = vm.getConfig();
			VirtualMachineCapability vmc = vm.getCapability();
			System.out.println("Hello " + vm.getName());
			System.out.println("GuestOS: " + vminfo.getGuestFullName());
			System.out.println("Multiple snapshot supported: "
					+ vmc.isMultipleSnapshotsSupported());
		}
		si.getServerConnection().logout();
	}
}