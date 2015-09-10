package DefaultNamespace;

import java.rmi.RemoteException;

public class TestClient {
	
	public static void main(String[] a)
	{
		
	TestClient t=new TestClient();
	t.exe();
	}

	public void exe()
	{
		HelloWorldProxy p=new HelloWorldProxy();
		String res="";
		try {
			res = p.getGreetings("harshit");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res);
		
	}
}
