package LoggingFramework.strategies.appender;
import LoggingFramework.strategies.formatter.LogFormatter;
import LoggingFramework.entities.LogMessage;

public interface LogAppender {
	
	void append(LogMessage message);
	void close();
    LogFormatter getFormatter();
    void setFormatter(LogFormatter formatter);
	
}
