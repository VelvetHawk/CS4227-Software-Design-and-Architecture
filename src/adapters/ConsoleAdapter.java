package adapters;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleAdapter implements LogAdapter
{
	private Logger log;
	
	public ConsoleAdapter()
	{
		System.setProperty(
				"java.util.logging.config.file",
				new File("consoleLog.properties").getAbsolutePath()
		);
		log = Logger.getLogger("Graylog Adapter");
	}
	
	
	@Override
	public void info(String message)
	{
		log.info(message);
	}
	
	@Override
	public void log(Level level, String message)
	{
		log.log(level, message);
	}
}
