package model;

public class Beer {
	private String name;
	private String tagline;
	private String first_brewed;
	private String description;
	
	
	public Beer () {
		super();
	}
	
	public Beer (String name, String tagline, String first_brewed, String description) {
		this.name = name;
		this.tagline = tagline;
		this.first_brewed = first_brewed;
		this.description = description;
	}

	@Override
	public String toString() {
		return "name: " + name + "\ntagline: " + tagline + "\nfirst_brewed: " + first_brewed + "\ndescription: "
				+ description + "\n\n";
	}
	
		

}
