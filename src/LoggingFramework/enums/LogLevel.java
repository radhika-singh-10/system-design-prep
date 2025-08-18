package LoggingFramework.enums;

public enum LogLevel {
	INFO, DEBUG, WARNING, ERROR;
	
	public boolean isAsSevereAs(LogLevel level) {
		return this.ordinal()>=level.ordinal();
	}

}
