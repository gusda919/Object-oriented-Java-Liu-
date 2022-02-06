package hashmapadventure;

import java.util.HashMap;

public class Room extends Location {

	private int size;
	private final HashMap<String, Location> paths;
	private HashMap<String, Item> locationItems;

	public Room(String name, String longDescription, String shortDescription) {
		super(name, longDescription, shortDescription);
		this.paths = new HashMap<String, Location>();
		this.locationItems = new HashMap<String, Item>();

	}

	@Override
	public void describeYourself() {

		if (beenThere) {
			System.out.println("You are at " + super.getName() + getShortDescription());
			for (String mapKey : paths.keySet()) {
				System.out.println("There is a door " + mapKey + " leading to " + paths.get(mapKey).getName());

			}
			for (String items : locationItems.keySet()) {
				System.out.println("There is a item " + items);

			}

		} else {
			System.out.println("You are at " + super.getName() + getLongDescription());
			for (String mapKey : paths.keySet()) {
				System.out.println("There is a door " + mapKey + " leading to " + paths.get(mapKey).getName());

			}

			for (String items : locationItems.keySet()) {
				System.out.println("There is a item " + items);

			}

			beenThere = true;
		}

	}

	public void locationItem(String Key, Item item) {

		this.locationItems.put(Key, item);

	}

	public boolean AvalibleItems(String Key) {
		return this.locationItems.containsKey(Key);
	}

	public void addtoPlayer(String cmd, Player player) {

		for (String key : locationItems.keySet())

			if (cmd.contains(key)) {

				cmd = key;

				for (Item items : locationItems.values()) {

					player.addtoPlayer(items);
					locationItems.remove(cmd);
				}
			}
	}

	public void nearbyLocations(String key, Location position) {
		this.paths.put(key, position);
	}

	public Location getNextPath(String key) {
		return this.paths.get(key);
	}

	public boolean AvaliblePaths(String key) {
		return this.paths.containsKey(key);
	}

}
