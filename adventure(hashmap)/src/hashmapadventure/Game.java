
package hashmapadventure;

import java.util.*;

public class Game {
	private Scanner keyboard;
	private ArrayList<Location> locations;
	private Player player;
	private ArrayList<Item> Items;
	private ArrayList<Location> world;

	public Game() {
		keyboard = new Scanner(System.in);
		locations = new ArrayList<>();
		Items = new ArrayList<>();
		world = new ArrayList<>();

		OutdoorsArea startingLocation = new OutdoorsArea("Marketplace ",
				"The town is at your feet, as the night is young and full of wonders",
				" the rats fester on the dropped goods ");
		Room Castle = new Room(" The Local Tavern ",
				"You're met with cheerful singing rose-red cheeks, and a bountiful of liquid courage ",
				"someone pissing on the floor ");
		Room Prison = new Room(" The Church ", "The Priest is performing sunday mass ", "Crowd harmonizes in hymns");
		OutdoorsArea Park = new OutdoorsArea("The Royal Garden ",
				" The Royal Garden surely has seen better days, yet some of its former glory remains. The vastness of the Cherry Blossom orchids truly is remarkble despite their current state ",
				"The local nudist poses for an empty crowd ");
		OutdoorsArea Market = new OutdoorsArea("The Square ",
				"A mob gathers around the local drunk professing his despice towards the new Mayor ",
				" The drunk sleeps deeply upon a bench ");

		locations.add(startingLocation);
		locations.add(Castle);
		locations.add(Prison);
		locations.add(Park);
		locations.add(Market);

		Shovel Shovel = new Shovel("Spade", "dig", 5.2, Prison);
		Weapon sword = new Weapon("Sword", "strike", 3.5);
		Wearble Kilt = new Wearble("Kilt", "wear", 4.5, 10);
		Wearble Hat = new Wearble("Hat", "wear", 4.5, 15);
		Torch Torch = new Torch("Torch", "light", 3.5, Park);
		Note note = new Note("Note", " It reads: .....  ", 0.23, false, Prison);

		Items.add(Torch);
		Items.add(Shovel);
		Items.add(sword);
		Items.add(Kilt);
		Items.add(Hat);
		Items.add(note);

		locations.get(1).locationItem("Spade", Items.get(1));
		locations.get(2).locationItem("Sword", Items.get(2));
		locations.get(3).locationItem("Kilt", Items.get(3));
		locations.get(4).locationItem("Hat", Items.get(4));
		// locations.get(2).locationItem("note" ,Items.get(5));

		world.add(startingLocation);
		world.add(Castle);
		world.add(Prison);
		world.add(Park);
		world.add(Market);

		Castle.nearbyLocations("North", startingLocation);

		Market.nearbyLocations("West", startingLocation);

		Park.nearbyLocations("East", startingLocation);

		Prison.nearbyLocations("South", startingLocation);

		startingLocation.nearbyLocations("South", Castle);
		startingLocation.nearbyLocations("East", Market);
		startingLocation.nearbyLocations("West", Park);
		startingLocation.nearbyLocations("North", Prison);
	}

	public void run() {

		String name;

		System.out.println("Welcome to the adventure game! What is your name?");
		name = keyboard.nextLine();
		player = new Player(name, world.get(0));
		player.addtoPlayer(Items.get(0));

		System.out.println("Hello " + name
				+ ", welcome to this magical world of wonder! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");

		while (true) {
			String command;
			player.getLocation().describeYourself();
	

			System.out.println("What do you want to do?");
			command = keyboard.nextLine();
            player.movePlayer(command);
			player.doCommand(command, player);

		}
	}
}
