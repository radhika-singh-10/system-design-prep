package LoggingFramework.strategies.appender;

import LoggingFramework.entities.LogMessage;
import LoggingFramework.strategies.formatter.LogFormatter;

import java.io.FileWriter;
import java.io.IOException;


public class NetworkAppender implements LogAppender{
	
	
	private FileWriter writer;
	private LogFormatter formatter;
	
	public NetworkAppender( LogFormatter formatter) {
		this.formatter = formatter;
		try {
			//push the network logs in a data structure using elk having {id-> timestamp, threadname, message} - similar to ELK stack
			
		}catch(Exception ex) {
			System.out.println("Failed to create writer for file logs, exception: " + ex.getMessage());
		}
	}

	@Override
	public synchronized void append(LogMessage message) {
		try {
			
		}catch(Exception ex) {
			System.out.println("Failed to write logs to network, exception: " + ex.getMessage());
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
