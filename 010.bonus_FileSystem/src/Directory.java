//Represent all information in a directory.
public class Directory extends FileEntity {
	//Represent for previous directory, set as null if this is root directory.
	private Directory parent;
	//Menu of this directory.
	private FileEntity[] dirList;
	//Number of items in this directory.
	private int itemCount;
	
	//Constructor.
	public Directory(String name) {
		super(name);
		this.parent = null;
		dirList = new FileEntity[5];
		itemCount = 0;
	}
	public Directory(String name, Directory parent) {
		this(name);
		if (parent != null)
			this.parent = parent;
	}
	
	public String getName() {
		String a = super.name();
		a = "[" + a + "]";
		return a;
	}
	
	//Search files by key value.(you can use recursive)
//	public String[] search(String keyword) {
//		String[] a = new String[5];
//		
//		return a;
//	}
	
	public String search(String keyword) {
		String a ; //= new String("")
		if (this.itemCount == 0) {
			if (this.getName().contains(keyword) == true) {
				a = this.name();
				return a;
			}
			else
				return null;
		}
		else {
			for (int i = 0; i < this.itemCount; i++) {
				if (dirList[i].getClass().getName().equals("Directory")) {
					String temp = ((Directory) dirList[i]).search(keyword);
					if (temp != null) {
						a = dirList[i].name() + "\\" + temp;
						return a;
					}
				}
				else {
					if (dirList[i].getName().contains(keyword) == true) {
						a = this.name() + "\\" + dirList[i].name();
						return a;
					}
				}
			}
		}
		return null;
	}
	
	//Get number of item in this directory.
	protected int getItemCount() {
		return this.itemCount;
	}
	//Add new directory under this directory.
	protected void addItem(Directory item) {
		if (this.itemCount >= this.dirList.length) 
			this.resize();
		this.dirList[this.itemCount++] = item;
	}
	//Add new file under this directory.
	protected void addItem(File item) {
		if (this.itemCount >= this.dirList.length) 
			this.resize();
		this.dirList[this.itemCount++] = item;
	}
	
	private void resize() {
		FileEntity[] temp = new FileEntity[this.itemCount * 2];
		System.arraycopy(dirList, 0, temp, 0, this.itemCount);
		this.dirList = null;
		this.dirList = temp;
	}


}
