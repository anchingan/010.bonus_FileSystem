//Represent all information in a directory.

import java.util.Arrays;

public class Directory extends FileEntity {
	//Menu of this directory.
	private FileEntity[] dirList;
	//Number of items in this directory.
	private int itemCount;
	
	//Constructor.
	public Directory(String name) {
		super(name);
		dirList = new FileEntity[10];
		itemCount = 0;
	}
	public Directory(String name, Directory parent) {
		this(name);
		if (parent != null) 
			this.setParent(parent);
	}
	
	@Override
	public String getName() {
		String a = this.name;
		return a;
	}
	
	public String getDirName() {
		String a = this.name;
		a = "[" + a + "]";
		return a;
	}
	
	
	//Search files by key value.(you can use recursive)
	//Return path of qualified item and separate by \n.
	public String[] search(Directory temp, String keyword) {
		String[] str = new String[10];
		int count = 0;
		//Use contains to find if name of items under this directory contains keyword.
		for (int i = 0; i < temp.itemCount; i++) {
			if (temp.dirList[i].getName().contains(keyword)) {
				if (count >= str.length)
					str = Arrays.copyOf(str, count * 2);
				str[count++] = temp.dirList[i].getPath();
			}
			String[] others = {};
			//If temp.dirList[i] is a directory, search inside.
			if (temp.dirList[i] instanceof Directory) {
				//If there are items in this directory.
				if (((Directory)temp.dirList[i]).getItemCount() > 0)
					others = search((Directory)temp.dirList[i], keyword);
			}
			//Add others into str.
			//If return items is more than str's length.
			if ((others.length + count) >= str.length)
				str = Arrays.copyOf(str, others.length + count);
			for (int j = 0; j < others.length; j++) 
				str[count++] = others[j];
		}
		//Delete excess array space.
		str = Arrays.copyOf(str, count);
		return str;
	}
	
/*	public String[] search(String keyword) {
		String[] a = new String[5];
		
		return a;
	}
*/	
/*	public String[] search(String keyword) {
		String[] a = new String[itemCount] ; //= new String("")
		if (this.itemCount == 0) {
			if (this.getName().contains(keyword) == true) {
				for (int i = 0; i < itemCount; i++) {
					if (a[i] == null) {
						a[i] = this.name();
						break;
					}
				}
			}
			return a;
		}
		else {
			for (int i = 0; i < this.itemCount; i++) {
				if (dirList[i].getClass().getName().equals("Directory")) {
					String[] temp = ((Directory) dirList[i]).search(keyword);
					for (int j = 0; j < this.itemCount; j++) {
						if (temp[j] != null) {
							a[i] = dirList[i].name() + "\\" + temp[j];
							return a;
						}
					}

				}
				else {
					if (dirList[i].getName().contains(keyword) == true) {
						for (int j = 0; j < this.itemCount; j++) {
							if (a[j] != null) {
								a[j] = dirList[i].name() + "\\" + a[j];
								return a;
							}
						}
						a = this.name() + "\\" + dirList[i].name();
						if (this.parent.name().equals("root") == true)
							a = "root\\" + a;
						return a;
					}
				}
			}
		}
		return null;
	}
*/	

	//Get number of item in this directory.
	protected int getItemCount() {
		return this.itemCount;
	}
	//Add new directory or file under this directory (use parent class"FileEntity").
	protected void addItem(FileEntity item) {
		if (this.itemCount >= this.dirList.length) 
			dirList = Arrays.copyOf(dirList, itemCount * 2);
		this.dirList[this.itemCount++] = item;
	}
/*	//Add new file under this directory.
	protected void addItem(File item) {
		if (this.itemCount >= this.dirList.length) 
			this.resize();
		this.dirList[this.itemCount++] = item;
		fileCount++;
	}
*/

	//Search if certain name of item(file or directory) is under this directory.
	public int find(String key) {
		for (int i = 0; i < itemCount; i++) {
			if (dirList[i].getName().equals(key))
				return i;
		}
		return -1;
	}
	
	//Search if certain name of directory is under this directory.
	public Directory findDirectory(String key) {
		//Find if this name of item is under this directory.
		int index = this.find(key);
		if (index == -1)
			return null;
		//Decide if find index of dirList belongs to Directory class and return.
		if (dirList[index] instanceof Directory)
			return (Directory)dirList[index];
		else
			return null;
	}
	
	//Show info of this directory.
	public String ls() {
		String str = "";
		int dirCount = 0, fileCount = 0;
		for (int i = 0; i < itemCount; i++) {
			//Directory item
			if (dirList[i] instanceof Directory) {
				dirCount++;
				str += ((Directory)dirList[i]).getDirName() + "\n";
			}
			else if (dirList[i] instanceof File) {
				fileCount++;
				str += dirList[i].getName() + "\n";
			}
		}
		if (str.equals(""))
			return "file/directory not found\n";
		str += "\n" + dirCount + " directories, " + fileCount + " files\n";
		return str;
	}

}
