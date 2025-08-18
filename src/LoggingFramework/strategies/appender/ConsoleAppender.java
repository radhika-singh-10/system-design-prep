package LoggingFramework.strategies.appender;

import LoggingFramework.entities.LogMessage;
import LoggingFramework.strategies.formatter.LogFormatter;

public class ConsoleAppender implements LogAppender{
	
	private LogFormatter formatter;
	
	public ConsoleAppender(LogFormatter formatter) {
		this.formatter = formatter;
	}
	
	@Override
	public synchronized void append(LogMessage logMessage) {
		System.out.println(formatter.format(logMessage));
	}

	
	@Override
    public void close() {}

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public LogFormatter getFormatter() {
        return formatter;
    }
}
