
public class File extends FileEntity {
	//Constructor
	public File(String name, Directory parent) {
		super(name);
		this.parent = parent;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	

}
