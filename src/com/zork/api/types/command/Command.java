package com.zork.api.types.command;

import com.zork.api.types.command.commands.ActivateCommand;
import com.zork.api.types.command.commands.AssumeCommand;
import com.zork.api.types.command.commands.ClimbCommand;
import com.zork.api.types.command.commands.EatCommand;
import com.zork.api.types.command.commands.EquipCommand;
import com.zork.api.types.command.commands.FightCommand;
import com.zork.api.types.command.commands.GoCommand;
import com.zork.api.types.command.commands.InvalidCommand;
import com.zork.api.types.command.commands.ListItemsCommand;
import com.zork.api.types.command.commands.OpenCommand;
import com.zork.api.types.command.commands.QuitCommand;
import com.zork.api.types.command.commands.ReadCommand;
import com.zork.api.types.command.commands.RemoveCommand;
import com.zork.api.types.command.commands.StatsCommand;
import com.zork.api.types.command.commands.TakeCommand;
import com.zork.api.types.command.commands.TradeCommand;
import com.zork.api.types.command.commands.UseCommand;
import com.zork.api.types.interfaces.Executable;

public abstract class Command implements Executable {

	public static Command getCommandForName(String key, String[] array) {

		switch (key.toLowerCase()) {
		case "fight":
			if (array.length < 2) {
				System.out.println("You can't just fight nothing...");
				return InvalidCommand.createInstance();
			}
			else {
				return FightCommand.createInstance(array[1]);
			}
		case "items": {
			return ListItemsCommand.createInstance();
		}
		case "eat":
			if (array.length < 2) {
				System.out.println("Gluttony is unhealthy. Try to pick at least one thing to eat.");
				return InvalidCommand.createInstance();
			}
			else {
				return EatCommand.createInstance(array[1]);
			}
		case "take":
			if (array.length < 2) {
				System.out.println("What do you want to take...?");
				return InvalidCommand.createInstance();
			}
			else {
				return TakeCommand.createInstance(array[1]);
			}
		case "use":
			if (array.length < 2) {
				System.out.println("Use what...");
				return InvalidCommand.createInstance();
			}
			else if (array.length < 4) {
				System.out.println("With what?");
				return InvalidCommand.createInstance();
			}
			else {
				return UseCommand.createInstance(array[1], array[3]);
			}
		case "go":
			if (array.length < 2) {
				System.out.println("Go where?");
				return InvalidCommand.createInstance();
			}
			else {
				return GoCommand.createInstance(array[1]);
			}
		case "quit":
			return QuitCommand.createInstance();
		case "climb":
			if (array.length < 2) {
				System.out.println("Climb what?");
				return InvalidCommand.createInstance();
			}
			else
				return ClimbCommand.createInstance(array[1]);
		case "remove":
			if (array.length < 2) {
				System.out.println("Remove what?");
				return InvalidCommand.createInstance();
			}
			else
				return RemoveCommand.createInstance(array[1]);
		case "trade":
			if (array.length < 2) {
				System.out.println("Trade what?");
				return InvalidCommand.createInstance();
			}
			else
				return TradeCommand.createInstance(array[1]);

		case "open":
			if (array.length < 2) {
				System.out.println("Open what...");
				return InvalidCommand.createInstance();
			}
			if (array[1] == "door") {
				System.out.println("Open which door?");
				return InvalidCommand.createInstance();
			}
			else
				return OpenCommand.createInstance(array[1]);
		case "assume":
			if (array.length < 2) {
				System.out.println("Let's not jump to conclusions. Assume what?");
				return InvalidCommand.createInstance();
			}
			else
				return AssumeCommand.createInstance(array[1]);
		case "activate":
			if (array.length<2) {
				System.out.println("Activate what?");
				return InvalidCommand.createInstance();
			}
			else
				return ActivateCommand.createInstance(array[1]);
		case "read":
			if (array.length < 2) {
				System.out.println("Read what...");
				return InvalidCommand.createInstance();
			}
			else
				return ReadCommand.createInstance(array[1]);
		case "equip":
			if (array.length < 2) {
				System.out.println("Equip what...");
				return InvalidCommand.createInstance();
			}
			else
				return EquipCommand.createInstance(array[1]);
		case "stats":
			return StatsCommand.createInstance();
		default:
			System.out.println("Sorry, that's not valid.");
			return InvalidCommand.createInstance();
		}
	}

}
