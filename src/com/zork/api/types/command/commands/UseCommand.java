package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;
import com.zork.api.types.toplevel.items.Item;
import com.zork.api.types.toplevel.items.Tool;
import com.zork.api.types.toplevel.items.UsedOnItem;

public class UseCommand extends Command {

	public static Command createInstance(String tool, String item) {
		return new UseCommand(tool, item);
	}

	private String tool;
	private String item;

	private UseCommand(String tool, String item) {
		this.tool = tool;
		this.item = item;
	}

	@Override
	public boolean canRun() {
		Item tool = Game.getGame().getBag().getItemForName(this.tool);
		Item use = Game.getGame().getBag().getItemForName(this.item);
		return tool != null && use != null && tool instanceof Tool
				&& use instanceof UsedOnItem
				&& ((UsedOnItem) use).isUsable((Tool) tool);
	}

	@Override
	public void execute() {
		Item tool = Game.getGame().getBag().getItemForName(this.tool);
		Item use = Game.getGame().getBag().getItemForName(this.item);
		((UsedOnItem) use).use((Tool) tool);
		System.out.println("You used " + tool.description() + " on " + item
				+ ", to yield "
				+ ((UsedOnItem) use).makes.description());

	}

}
