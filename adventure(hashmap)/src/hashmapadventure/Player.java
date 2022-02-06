package hashmapadventure;

import java.util.ArrayList;

import java.util.HashMap;

public class Player {

	private String name;
	private Location position;
	private int health = 100;
	private HashMap<String, Item> playerItems;
	ArrayList<Item> Equipment = new ArrayList<Item>();

	public Player(String name, Location position) {
		this.name = name;
		this.position = position;
		playerItems = new HashMap<String, Item>();

	}

	public void addtoEquipment(Item item) {
		this.Equipment.add(item);
	}

	public void addtoPlayer(Item item) {
		playerItems.put(item.getName(), item);
	}

	public void removefromPlayer(Item item) {
		playerItems.remove(item.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return this.position;
	}

	public void setLocation(Location position) {
		this.position = position;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;

	}

	public void movePlayer(String command) {
		if (getLocation().AvaliblePaths(command)) {
			setLocation(getLocation().getNextPath(command));

		}
	}

	public void getMoreHealth(int health) {

		for (Item item : this.playerItems.values())

			this.health = this.health + item.getHealth();

	}

	public boolean doCommand(String cmd, Player player) {



		if (cmd.equals("help")) {
			System.out.println(
					"You move around by typing 'north', 'east', ´south' or 'west'. Check your 'staus' . reveal your 'inventory'. pickup items by typing take, and the item name. Every item has a listed command.");
		}

		if (cmd.equals("look")) {
			this.position.look();
		}

		if (cmd.equals("inventory")) {
			System.out.println("Items in inventory:");

			for (Item items : playerItems.values()) {

				System.out.println(
						items.getName() + "  " + items.getWeight() + "kg " + "'" + items.getTakeAction() + "'");

			}

		}

		if (cmd.contains("take")) {

			this.position.addtoPlayer(cmd, player);

		}

		if (cmd.contains("status")) {

			System.out.println("Current Health: " + health);
			System.out.println("Currently Equiped");
			for (Item item : Equipment) {

				System.out.println(item.getName());

			}

		}

		for (Item item : playerItems.values())

			if (cmd.contains(item.getTakeAction())) {

				item.doCommand(cmd, player);
				break;
			}
		
			

		return false;

	}

}