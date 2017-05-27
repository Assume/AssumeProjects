package providedCode;

public class Game {
	private Parser _parser;
	private Room _currentRoom;

	public Game() {
		createRooms();
		_parser = new Parser();
	}

	private void createRooms() {
		Room outside, lab, tavern, gblock, office;

		outside = new Room(" Max Pham's locker area");
		lab = new Room("the chemistry lab w/dr varnold :(");
		tavern = new Room("Dr. Varnold's room and super confused");
		gblock = new Room("the cooliest  building");
		office = new Room("the computing admin office");

		outside.setExits(null, lab, gblock, tavern);
		lab.setExits(null, null, null, outside);
		tavern.setExits(null, outside, null, null);
		gblock.setExits(outside, office, null, null);
		office.setExits(null, null, null, gblock);

		_currentRoom = outside;
	}

	public void play() {
		printWelcome();

		boolean finished = false;
		while (!finished) {
			Command command = _parser.getCommand();
			finished = processCommand(command);
		}
		System.out.println("Thank you for playing, good bye.");
	}

	public void printWelcome() {
		System.out.println();
		System.out.println("Welcome to Zork");
		System.out.println("Zork is a new, incredibly boring adventure game");
		System.out.println("Type help if you need help");
		System.out.println();
		System.out.println(_currentRoom.longDescription());
	}

	private boolean processCommand(Command command) {
		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");
			return false;
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("quit")) {
			if (command.hasSecondWord()) {
				System.out.println("Quit what?");
			} else {
				return true;
			}
		}
		return false;
	}

	private void printHelp() {
		System.out.println("You are lost. You are alone. You wander");
		System.out.println("around at Monash Uni, Peninsula Campus.");
		System.out.println();
		System.out.println("Your command words are:");
		_parser.showCommands();
	}

	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			System.out.println("Go where?");
			return;
		}
		String direction = command.getSecondWord();

		Room nextRoom = _currentRoom.nextRoom(direction);

		if (nextRoom == null) {
			System.out.println("There is no door!");
		} else {
			_currentRoom = nextRoom;
			System.out.println(_currentRoom.longDescription());
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}
}
