//Represent for an item in the file system, which can be a file or a directory.
public abstract class FileEntity {
	
	//Name of directory or file.
	private String name; //Private or ??		
	//Get name of item.
	public abstract String getName();	
	
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
	
	protected String name() {
		return this.name;
	}
	
	@Override
	public String toString() {
		String a = this.getName();
		return a;
	}


}
