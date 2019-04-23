package adapters;

import java.util.logging.Level;

public interface LogAdapter
{
	void info(String message);
	void log(Level level, String message);
}
