package hashmapadventure;

import java.util.HashMap;

public class Shovel extends Tool {

	private HashMap<String, Item> gameItems;

	public Shovel(String name, String takeAction, double weight, Location use) {
		super(name, takeAction, weight, use);
	}

	public void use(Player player) {

		if (this.UseItem(player)) {
			System.out.println("You dug hole but you found nothing there..");
			// player.getLocation().getItems().get(0).setVisability(true);
//			System.out.println("You found a note in the ground where you dug!");

			// player.getLocation().getItems().remove(1);
		} else {
			System.out.println("digging here would cause you troble ");
		}
//	}
	}

	public void add(String itemName, Item item) {
		this.gameItems.put(itemName, item);
	}

	@Override
	public boolean doCommand(String cmd, Player player) {

		this.use(player);

		return false;
	}

}
