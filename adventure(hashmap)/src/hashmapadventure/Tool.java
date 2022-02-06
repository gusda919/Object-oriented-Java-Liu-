package hashmapadventure;

public abstract class Tool extends Item {

	private Location loot;

	public Tool(String name, String takeAction, double weight, boolean found, Location loot) {
		super(name, takeAction, weight, found);
		this.loot = loot;

	}

	public Tool(String name, String takeAction, double weight, Location loot) {
		super(name, takeAction, weight);
		this.loot = loot;
	}

	public boolean UseItem(Player player) {

		return this.loot.equals(player.getLocation());
	}

	public abstract boolean doCommand(String cmd, Player player);

}
