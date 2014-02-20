package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;
import com.zork.api.types.toplevel.items.Weapon;

public class EquipCommand extends Command
{

    public static Command createInstance(String name)
    {
	return new EquipCommand(name);
    }

    private String name;

    private EquipCommand(String name)
    {
	this.name = name;
    }

    @Override
    public boolean canRun()
    {
	return Game.getGame().getBag().hasItem(name)
		&& Game.getGame().getBag().getItemForName(name) instanceof Weapon;
    }

    @Override
    public void execute()
    {
	Weapon wep = Game.getGame().getPlayer().getWeapon();
	Game.getGame()
		.getPlayer()
		.setWeapon(
			(Weapon) Game.getGame().getBag()
				.getItemForName(this.name));
	System.out.println("You are now wearing a "+this.name);
	if (wep == null)
	    return;
	Game.getGame().getBag().add(wep);
    }

}
