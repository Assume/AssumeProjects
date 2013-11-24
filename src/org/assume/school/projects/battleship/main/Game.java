package org.assume.school.projects.battleship.main;

import java.util.Scanner;

import org.assume.school.projects.battleship.api.types.command.Command;
import org.assume.school.projects.battleship.api.types.command.commands.PrintBoardCommand;
import org.assume.school.projects.battleship.api.types.command.interfaces.Commandable;
import org.assume.school.projects.battleship.api.types.ships.bottom.AircraftCarrier;
import org.assume.school.projects.battleship.api.types.ships.bottom.BattleShip;
import org.assume.school.projects.battleship.api.types.ships.bottom.Cruiser;
import org.assume.school.projects.battleship.api.types.ships.bottom.Destroyer;
import org.assume.school.projects.battleship.api.types.ships.bottom.Submarine;
import org.assume.school.projects.battleship.api.types.users.Player;

public class Game
{

    public static void main(String[] args)
    {
	Game game = Game.getInstance();
	game.setup();
	game.playGame();
    }

    public static Game getInstance()
    {
	Scanner in = new Scanner(System.in);
	System.out.print("Enter Player One name: ");
	String p1 = in.nextLine();
	System.out.print("Enter Player two name: ");
	String p2 = in.nextLine();
	return new Game(new Player(p1), new Player(p2));
    }

    private Player one;
    private Player two;

    private Game(Player one, Player two)
    {
	this.one = one;
	this.two = two;
    }

    public void setup()
    {
	this.setupPlayer(this.getOne());
	this.setupPlayer(this.getTwo());
	this.getOne().setOpponent(this.getTwo());
	this.getTwo().setOpponent(this.getOne());
    }

    public void playGame()
    {
	while (!this.getOne().areAllShipsSunk()
		&& !this.getTwo().areAllShipsSunk())
	{
	    this.executePlayer(this.getOne());
	    this.executePlayer(this.getTwo());
	}
	if (this.getOne().areAllShipsSunk())
	    System.out.println("Congrats " + this.getTwo().getName()
		    + " on winning the game!");
	else
	    System.out.println("Congrats " + this.getOne().getName()
		    + " on winning the game!");
    }

    private void executePlayer(Player player)
    {
	Commandable command = Command.getCommand(player);
	if (command instanceof PrintBoardCommand)
	{
	    player.executeCommand(command);
	    this.executePlayer(player);
	} else
	{
	    player.executeCommand(command);
	}
    }

    public void setupPlayer(Player p)
    {
	AircraftCarrier.createInstance(p);
	BattleShip.createInstance(p);
	Cruiser.createInstance(p);
	Submarine.createInstance(p);
	Destroyer.createInstance(p);
    }

    public Player getOne()
    {
	return one;
    }

    public void setOne(Player one)
    {
	this.one = one;
    }

    public Player getTwo()
    {
	return two;
    }

    public void setTwo(Player two)
    {
	this.two = two;
    }

}
