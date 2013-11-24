package org.assume.school.projects.battleship.api.types.command.commands;

import java.util.Scanner;

import org.assume.school.projects.battleship.api.types.command.interfaces.Commandable;
import org.assume.school.projects.battleship.api.types.users.Player;

public class AttackCommand implements Commandable
{

    public static AttackCommand createInstance(Player player)
    {
	Scanner in = new Scanner(System.in);
	System.out.print("Enter row: ");
	int row = in.nextInt();
	System.out.print("Enter column");
	int col = in.nextInt();
	return new AttackCommand(row, col, player);

    }

    private int row;
    private int col;
    private Player player;

    private AttackCommand(int row, int col, Player player)
    {
	this.row = row;
	this.col = col;
	this.player = player;
    }

    @Override
    public boolean canExecute()
    {
	return true;
    }

    @Override
    public void execute()
    {
	player.attack(row, col);
    }

}
