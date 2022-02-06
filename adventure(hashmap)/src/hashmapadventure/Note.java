package hashmapadventure;

public class Note extends Tool {

	public Note(String name, String takeAction, double weight, boolean revealed, Location loot) {
		super(name, takeAction, weight, revealed, loot);
	}

	@Override
	public boolean doCommand(String command, Player player) {
		return false;

	}

}