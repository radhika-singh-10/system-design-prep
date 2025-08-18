package LoggingFramework.strategies.appender;


import LoggingFramework.entities.LogMessage;
import LoggingFramework.strategies.formatter.LogFormatter;

public class DatabaseAppender implements LogAppender{
	
	private LogFormatter formatter;
	
	public DatabaseAppender(LogFormatter formatter) {
		try {
			
		}catch(Exception ex) {
			
		}
	}
	
	@Override 
	public synchronized void append(LogMessage message) {
		try {
			
		}catch(Exception ex) {
			System.out.println("Failed to write logs to database, exception: " + ex.getMessage());
		}
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
