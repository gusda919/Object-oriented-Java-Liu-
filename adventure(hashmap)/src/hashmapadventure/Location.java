package hashmapadventure;

public abstract class Location {

	private String name, shortDescription, longDescription;
	public boolean beenThere;

	public Location(String name, String longDescription, String shortDescription) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;

	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getName() {

		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void describeYourself() {

		System.out.println("You are at " + getName() + "and " + getLongDescription());

	}

	public void look() {

		System.out.println(this.getLongDescription());

	}

	public abstract void locationItem(String Key, Item item);

	public abstract boolean AvalibleItems(String Key);

	public abstract void nearbyLocations(String Key, Location position);

	public abstract Location getNextPath(String Key);

	public abstract boolean AvaliblePaths(String Key);

	protected abstract void addtoPlayer(String cmd, Player player);

}
