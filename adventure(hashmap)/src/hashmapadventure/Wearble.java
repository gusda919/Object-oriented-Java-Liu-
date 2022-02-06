package hashmapadventure;

public class Wearble extends Item {
	private int itemHP;

	public Wearble(String name, String takeAction, double weight, int itemHP) {
		super(name, takeAction, weight, itemHP);
		this.itemHP = itemHP;
	}

	public boolean doCommand(String cmd, Player player) {

		System.out.println("You are now weairng " + getName());
		player.getMoreHealth(itemHP);
		player.addtoEquipment(this);
		player.removefromPlayer(this);

		System.out.println("Current Health: " + player.getHealth());

		return true;
	}

}