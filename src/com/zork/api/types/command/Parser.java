package com.zork.api.types.command;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.zork.api.types.bottomlevel.game.Game;

public class Parser {

	public static final List<String> ALLOWED_COMMANDS = Arrays
			.asList(new String[] { "go", "eat", "open", "use", "quit", "fight",
					"take", "help", "climb", "remove", "read", "equip",
					"items", "stats", "activate", "trade", "assume" });

	private static Parser parser = null;

	public static Parser getParser() {
		return parser == null ? new Parser() : parser;
	}

	public Command getCommand() {
		if (Game.getGame().isOver())
			return null;
		Scanner in = new Scanner(System.in);
		System.out.print("\n> ");
		String command = in.nextLine();
		command = command.replaceAll("the", "").trim();
		String[] splits = command.split(" ");
		if (splits.length == 0) {
			System.out
					.println("No command entered. Please try again. Type help for help");
			return getCommand();
		}
		if (splits[0].equalsIgnoreCase("help")) {
			System.out
					.println("The goal of this game is to find the boss monster and defeat him. All you have to do in the meantime is stay alive...");
			System.out.print(Game.getGame().getPlayer().getLocation()
					.showExits());
			System.out.println();
			System.out.println();
			System.out.print("Available commands: ");
			for (String x : ALLOWED_COMMANDS)
				System.out.print("\n " + x);
			System.out.println();
			return getCommand();
		}
		if (splits[0].equalsIgnoreCase("commands")) {
			System.out.print("Available commands: ");
			for (String x : ALLOWED_COMMANDS)
				System.out.print("\n " + x);
			System.out.println();
			return getCommand();
		}
		if (splits[0].equalsIgnoreCase("use") && splits.length != 4) {
			System.out
					.println("Incorrect usage of use command \nProper usage of use command is \"use TOOL on ITEM\"");
			return getCommand();

		}
		if (!ALLOWED_COMMANDS.contains(splits[0].toLowerCase())) {
			System.out
					.println("Invalid command entered. Please try again. Type  commands for commands");
			return getCommand();
		}
		return Command.getCommandForName(splits[0], splits);

	}

}
