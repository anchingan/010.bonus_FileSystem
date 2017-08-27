
public class FileManagement {
	Directory curDir;
	
	public FileManagement() {
		curDir = new Directory("root");
	}
	
	public Directory getCurrentDir() {
		return this.curDir;
	}
	
	public boolean mkdir(String dirName) {
		if (curDir == null)
			return false;
		//If there is no directory's name is the same of new one, create it.
		if (curDir.findDirectory(dirName) == null) {
			curDir.addItem(new Directory(dirName, this.curDir));
			return true;
		}
		return false;
	}
	
	public boolean touch(String itemName) {
		if (curDir == null)
			return false;
		if (curDir.find(itemName) == -1) {
			curDir.addItem(new File(itemName, this.curDir));
			return true;
		}
		return false;
	}
	
	public boolean cd(String dirName) {
		if (curDir == null) 
			return false;
		//Check if dirName is exist.
		Directory nextDir = curDir.findDirectory(dirName);
		if (nextDir != null) {
			this.curDir = nextDir;
			return true;
		}
		return false;
	}
	
	public boolean back() {
		if (curDir.getParent() == null) {
			return false;
		}
		curDir = curDir.getParent();
		return true;
	}
	
	public String ls() {
		if (curDir == null)
			return "";
		return curDir.ls();
	}
	
	public String[] search(String keyword) {
		if (curDir == null)
			return null;
		return curDir.search(curDir, keyword);
	}
	
	

}
