package org.assume.school.projects.battleship.api.types.users;

import java.util.ArrayList;
import java.util.List;

import org.assume.school.projects.battleship.api.types.board.GameBoard;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;

public class Player
{

	public static int TOTAL_PLAYERS = 0;

	public static Player PLAYER_ONE;
	public static Player PLAYER_TWO;

	private String name;
	private GameBoard board;
	private Player opponent;
	private List<Ship> ships;

	public Player(String name)
	{
		this.name = name;
		this.board = new GameBoard();
		this.ships = new ArrayList<Ship>();
		Player.PLAYER_ONE = Player.PLAYER_ONE == null ? this
				: Player.PLAYER_ONE;
		Player.PLAYER_TWO = Player.PLAYER_ONE == opponent ? this : null;
		this.opponent = Player.PLAYER_ONE == null ? PLAYER_TWO : PLAYER_ONE;

	}

	public void attack(int row, int col)
	{
		if (board.isAttackValid(row, col, this.opponent))
		{
			System.out.println("Direct hit on opponent at: row[" + row
					+ "], col[" + col + "]");
			Ship ship = this.getOpponent().getShipAt(row, col);
			if(ship == null)
				return;
			if(ship.isSunk())
				System.out.println("Congratulations! You sunk"+ship.toString());
		}

	}

	public Ship getShipAt(int row, int col)
	{
		for(Ship s : ships)
		{
			if(s.getRow() == row && s.getCol() == col)
				return s;
		}
		return null;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Player getOpponent()
	{
		return opponent;
	}

	public void setOpponent(Player opponent)
	{
		this.opponent = opponent;
	}

	public List<Ship> getShips()
	{
		return ships;
	}

	public void setShips(List<Ship> list)
	{
		this.ships = list;
	}

	public GameBoard getBoard()
	{
		return board;
	}

}
