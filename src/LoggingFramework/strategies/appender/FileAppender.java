package LoggingFramework.strategies.appender;

import LoggingFramework.entities.LogMessage;
import LoggingFramework.strategies.formatter.LogFormatter;
import java.io.FileWriter;
import java.io.IOException;


public class FileAppender implements LogAppender{
	

	private FileWriter writer;
	private LogFormatter formatter;
	
	public FileAppender(String filePath, LogFormatter formatter) {
		this.formatter = formatter;
		try {
			writer = new FileWriter(filePath,true);	
		}catch(Exception ex) {
			System.out.println("Failed to create writer for file logs, exception: " + ex.getMessage());
		}
	}
	
	
	@Override
	public synchronized void append(LogMessage message){
		try {
			writer.write(formatter.format(message));
			writer.flush();
			
		}catch(Exception ex) {
			System.out.println("Failed to write logs to file, exception: " + ex.getMessage());
		}
	}	
	
	@Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to close logs file, exception: " + e.getMessage());
        }
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public LogFormatter getFormatter() {
        return formatter;
    }
	
	
}
