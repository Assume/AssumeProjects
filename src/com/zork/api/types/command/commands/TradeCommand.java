package com.zork.api.types.command.commands;

import java.util.Random;
import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.bottomlevel.items.ValidItems;
import com.zork.api.types.bottomlevel.rooms.TradingRoom;
import com.zork.api.types.command.Command;
import com.zork.api.types.toplevel.items.Item;

public class TradeCommand extends Command {
	String tradeItem;

	public static Command createInstance(String item) {
		return new TradeCommand(item);
	}

	private TradeCommand(String item) {
		this.tradeItem = item;
	}

	@Override
	public boolean canRun() {
		return Game.getGame().getBag().hasItem(tradeItem)
				&& Game.getGame().getPlayer().getLocation() instanceof TradingRoom;
	}

	@Override
	public void execute() {
		System.out.println("You give up your " + tradeItem
				+ " and receive....");
		int currentSpace = Game.getGame().getBag()
				.getItemForName(tradeItem).getBagSpace();
		for (int x = 0; x < ValidItems.VALID_ITEMS.length; x++) {
			Random r = new Random();
			int i = r.nextInt(ValidItems.VALID_ITEMS.length);
			Item item = ValidItems.VALID_ITEMS[i];
			if (Game.getGame().getBag().getSize() - currentSpace
					+ item.getBagSpace() <= Game.getGame().getBag()
					.getSize()) {
				System.out.println("\t" + item.description());
				Game.getGame()
						.getPlayer()
						.getBag()
						.remove(Game.getGame().getBag()
								.getItemForName(tradeItem))
						.add(item);
				break;
			}

		}

	}

}
