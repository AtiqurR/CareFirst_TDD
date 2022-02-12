package careFirst.qa.reporting;

public class Logger {
	
	public static void log(String msg) {
		JavaLogger.getLog(msg);
		TestNGLogger.getLog(msg);
	}

}
