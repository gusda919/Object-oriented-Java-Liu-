package hashmapadventure;

public class Weapon extends Item {

	public Weapon(String name, String takeAction, double weight) {
		super(name, takeAction, weight);

	}

	public boolean doCommand(String cmd, Player player) {

		System.out.println("You swing you sword through the air");

		return true;

	}

}
