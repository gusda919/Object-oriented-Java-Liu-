package hashmapadventure;

public abstract class Item {
	private double weight;
	private String name;
	private String takeAction;
	private boolean pickedUp = false;
	private boolean revealed = true;
	private int health;
	private Location position;

	public Item(String name, String takeAction, double weight, boolean revealed, Location position) {
		this.weight = weight;
		this.name = name;
		this.takeAction = takeAction;
		this.revealed = revealed;
		this.position = position;

	}

	public Item(String name, String takeAction, double weight, int health) {
		this.weight = weight;
		this.name = name;
		this.takeAction = takeAction;
		this.health = health;

	}

	public Item(String name, String takeAction, double weight, boolean revealed) {
		this.weight = weight;
		this.name = name;
		this.takeAction = takeAction;
		this.revealed = revealed;

	}

	public Item(String name, String takeAction, double weight) {

		this.weight = weight;
		this.name = name;
		this.takeAction = takeAction;

	}

	public boolean getVisability() {
		return this.revealed;
	}

	public void setVisability(boolean status) {
		this.revealed = status;
	}

	public String getTakeAction() {
		return this.takeAction;
	}

	public void setTakeAction(String takeAction) {
		this.takeAction = takeAction;
	}

	public String getName() {
		return name;
	}

	public Location getPosition() {
		return position;
	}

	public void setPosition(Location position) {
		this.position = position;
	}

	public double getWeight() {
		return this.weight;
	}

	public abstract boolean doCommand(String cmd, Player player);

	public void useTool(Location position) {

	}

	public void setPickedUp(boolean status) {
		this.pickedUp = status;
	}

	public boolean getPickedUp() {
		return this.pickedUp;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Item values() {

		return this;

	}

}
