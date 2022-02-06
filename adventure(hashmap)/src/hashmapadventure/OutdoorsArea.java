package hashmapadventure;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class OutdoorsArea extends Location {

	private final HashMap<String, Location> paths;

	private HashMap<String, Item> locationItems;
	private String loot;
	private String weather;

	public OutdoorsArea(String name, String longDescription, String shortDescription) {
		super(name, longDescription, shortDescription);
		this.paths = new HashMap<String, Location>();
		this.locationItems = new HashMap<String, Item>();

	}

	private static int weatherGenerator() {
		Random generator = new Random();
		return generator.nextInt(2);

	}

	private static String randomWeather() {
		final String Pissregn = " Rainy";
		final String Fansolasså = " Sun rises";
		final String molnigt = " Cloudy";

		String[] weatherArray = new String[3];
		weatherArray[0] = Pissregn;
		weatherArray[1] = Fansolasså;
		weatherArray[2] = molnigt;

		return weatherArray[weatherGenerator()];

	}

	public void doCommand(String cmd) {

	}

	@Override
	public void describeYourself() {

		this.weather = randomWeather();

		if (beenThere) {
			System.out.println("You are at " + super.getName() + getShortDescription() + this.weather);

			for (String mapKey : paths.keySet()) {
				System.out.println("There is a path " + mapKey + " leading to " + paths.get(mapKey).getName());

			}

			for (String items : locationItems.keySet()) {
				System.out.println("There is a item " + items);

			}

		} else {
			System.out.println("You are at " + super.getName() + getLongDescription() + this.weather);

			for (String mapKey : paths.keySet()) {
				System.out.println("There is a path " + mapKey + " leading to " + paths.get(mapKey).getName());

			}

			for (String items : locationItems.keySet()) {
				System.out.println("There is a item " + items);

			}
			beenThere = true;
		}
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

	public void locationItem(String Key, Item item) {

		this.locationItems.put(Key, item);

	}

	public boolean AvalibleItems(String Key) {
		return this.locationItems.containsKey(Key);
	}

	public void nearbyLocations(String roads, Location position) {
		this.paths.put(roads, position);
	}

	public Location getNextPath(String roads) {
		return this.paths.get(roads);
	}

	public boolean AvaliblePaths(String roads) {
		return this.paths.containsKey(roads);
	}

}
