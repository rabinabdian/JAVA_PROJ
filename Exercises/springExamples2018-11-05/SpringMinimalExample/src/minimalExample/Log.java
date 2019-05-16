package minimalExample;

public class Log {
	private Log () {}
	static Log log = new Log();
	public static Log getInstance()
	{
		System.out.println("Inside Log.getInstance");
		return log;
	}
}
