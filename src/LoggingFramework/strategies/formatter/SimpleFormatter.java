package LoggingFramework.strategies.formatter;

import LoggingFramework.entities.LogMessage;

public class SimpleFormatter implements LogFormatter{
	public String format(LogMessage message) {
		return String.format("[%s] - [%s] [%s] :[%s]", 
				LogMessage.id, 
				message.getTimestamp(),
				message.getThreadName(),
				message.getMessage());
	}

}
