package hashmapadventure;

public class Torch extends Tool {

	public Torch(String name, String takeAction, double weight, Location use) {
		super(name, takeAction, weight, use);

	}

	public void use(Player player) {

		if (this.UseItem(player)) {
			player.getLocation().setShortDescription(
					"The light from your torch draws attention to you, as you start hearing whipser from the distance");

		}
	}

	public boolean doCommand(String cmd, Player player) {

		this.use(player);
		return true;

	}

}
