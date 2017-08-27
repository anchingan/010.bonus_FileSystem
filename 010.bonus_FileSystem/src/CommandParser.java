
public class CommandParser {
	
	private int command = Command.NONE;
	//Parameter.
	private String[] args = null;
	//ErrorCode: 0:correct, -1:command error, -2:parameter error.
	private int errorCode = 0;
	
	public CommandParser(String commandLine) {
		this.setCommand(commandLine);
	}
	
	public void setCommand(String commandLine) {
		if (commandLine == null)
			return;
		String[] tokens = commandLine.split("\\s+");
		errorCode = 0;
		if (tokens.length > 0) {
			if (tokens[0].equals("cd") == true) {
				this.command = Command.CD;
				if (tokens.length != 2)
					this.errorCode = -2; //Parameter error.
			}
			else if (tokens[0].equals("touch") == true) {
				this.command = Command.TOUCH;
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			else if (tokens[0].equals("mkdir") == true) {
				this.command = Command.MKDIR;
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			else if (tokens[0].equals("search") == true) {
				this.command = Command.SEARCH;
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			else if (tokens[0].equals("ls") == true) {
				this.command = Command.LS;
				if (tokens.length > 1)
					this.errorCode = -2;
			}
			else if (tokens[0].equals("cd..") == true) {
				this.command = Command.BACK;
				if (tokens.length > 1)
					this.errorCode = -2;
			}
			else {
				this.errorCode = -1;
				return;
			}
			//If there are parameter in command then add into args.
			if (tokens.length > 1) {
				this.args = new String[tokens.length - 1];
				for (int i = 1; i < tokens.length; i++) {
					this.args[i - 1] = tokens[i];
				}
			}
		}
	}
	
	public int getCommand() {
		return command;
	}
	
	public boolean isValid() {
		if (this.errorCode == 0)
			return true;
		return false;
	}
	
	public String commandString() {
		String[] commandString = {"none", "cd", "back", "touch", "mkdir", "ls", "search"};
		return commandString[this.command];
	}
	
	public String[] getArgs() {
		return this.args;
	}
	
	

}
