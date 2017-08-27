//Represent for an item in the file system, which can be a file or a directory.
public abstract class FileEntity {
	//Parent directory of this directory or file.
	protected Directory parent;
	//Name of directory or file.
	protected String name;	
	//Get name of item.
	
	abstract public String getName();	
	
	//Constructor.
	public FileEntity(String name) {
		this.setName(name);
	}
	protected void setName(String name) {
		if (name != null)
			this.name = name;
		else
			this.name = "name undefined";
	}
	
	public void setParent(Directory parent) {
		this.parent = parent;
	}
	
	
	public Directory getParent() {
		return this.parent;
	}
	
	public String getPath() {
		return recurGetPath(parent) + "\\" + getName();
	}
	
	private String recurGetPath(Directory parent) {
		if (parent == null)
			return "";
		return recurGetPath(parent.getParent()) + "\\" + parent.getName();
	}
	

}
