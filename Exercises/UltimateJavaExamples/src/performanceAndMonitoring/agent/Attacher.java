package performanceAndMonitoring.agent;

import java.util.List;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

public class Attacher {
	   public final static String PROCESS_NAME = 
		"performanceAndMonitoring.agent.TestClass";
	   public static void main(String[] args) throws Exception {
	      List<VirtualMachineDescriptor> vms = VirtualMachine.list();
	      String pid = null; // need the process id
	      for (VirtualMachineDescriptor desc : vms) {
	    	  System.out.println("VM: " + desc.displayName());
		// Find the relevant JVM Process
		if (desc.displayName().equals(PROCESS_NAME)) {
		   pid = desc.id();
		   break;
		}
	      }
	      if (pid != null) {
	    System.out.println("Found process. Loading agent");
		VirtualMachine vm = VirtualMachine.attach(pid);
		vm.loadAgent("agent.jar");
	      }
	      else
	      {
	    	  System.out.println("Could not find process");
	      }
	   }
	}
