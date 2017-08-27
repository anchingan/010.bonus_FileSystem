/*
 * Practice 010.bonus_File system
 * 				Build an easy simulated file system.
 * Date 20170819
 */

import java.util.Scanner;

public class TestFileSystem {

	public static FileManagement fm = new FileManagement();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Directory root = new Directory("root");
		String commandLine, itemName;
		CommandParser parser = new CommandParser("");
		boolean result;
		do {
			System.out.print(fm.curDir.getPath() + ">");
			commandLine = scanner.nextLine();
			parser.setCommand(commandLine);
			if (commandLine.equals("quit"))
				break;
			else if (parser.isValid() == false)
				System.out.println("Input error!");
			else if (parser.getCommand() == Command.LS)
				System.out.print(fm.ls());
			else if (parser.getCommand() == Command.CD) {
				itemName = parser.getArgs()[0];
				result = fm.cd(itemName);
				if (result == false)
					System.out.println("Input error!");
			}
			else if (parser.getCommand() == Command.BACK) {
				result = fm.back();
				if (result == false)
					System.out.println("Input error!");
			}
			else if (parser.getCommand() == Command.TOUCH) {
				itemName = parser.getArgs()[0];
				result = fm.touch(itemName);
				if (result == false)
					System.out.println("Input error!");
			}
			else if (parser.getCommand() == Command.MKDIR) {
				itemName = parser.getArgs()[0];
				fm.mkdir(itemName);
			}
			else if (parser.getCommand() == Command.SEARCH) {
				itemName = parser.getArgs()[0];
				String[] s = fm.search(itemName);
				if (s != null) {
					for (int i = 0; i < s.length; i++)
						System.out.println(s[i]);
				}
			}

		} while (true);
		
		System.out.println("Program terminate.");

	}
	

}
