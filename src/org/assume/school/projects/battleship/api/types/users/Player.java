package org.assume.school.projects.battleship.api.types.users;

import java.util.ArrayList;
import java.util.List;

import org.assume.school.projects.battleship.api.types.board.GameBoard;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;

public class Player
{

	private String name;
	private GameBoard board;
	private Player opponent;
	private List<Ship> ships;

	public Player(String name)
	{
		this.name = name;
		this.board = new GameBoard();
		this.ships = new ArrayList<Ship>();
	}

	public void attack(int row, int col)
	{
		if (board.isAttackValid(row, col, this.opponent))
		{
			System.out.println("Direct hit on " + this.opponent.getName()
					+ " at: row[" + row + "], col[" + col + "]");
			Ship ship = this.getOpponent().getShipAt(row, col);
			if (ship == null) return;
			ship.onHit(row, col);
			this.board.onHit(row, col);
			if (ship.isSunk())
				System.out.println("Congratulations! You sunk "
						+ this.opponent.getName() + "'s " + ship.toString());
		}
		else
		{
			System.out.println("Missed " + this.opponent.getName()
					+ " at: row[" + row + "], col[" + col + "]");
			this.board.onMiss(row, col);
		}

	}

	public boolean addShip(Ship s)
	{
		if (!ships.contains(s)
				&& this.board.isShipPlacementValid(s.getRow(), s.getCol(),
						s.getOrientation(), s.getSize()))
		{
			this.board.addShip(s);
			this.ships.add(s);
			return true;
		}
		else
		{
			System.out.println("Ship already added here[r" + s.getRow() + ",c"
					+ s.getCol()
					+ "] or you have already added a ship of this type["
					+ s.getClass().getSimpleName() + "]");
			return false;
		}

	}

	public Ship getShipAt(int row, int col)
	{
		for (Ship s : ships)
		{
			if (s.isOnShip(row, col)) return s;
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

	@Override
	public String toString()
	{
		return this.name + "\n" + this.board.toString();
	}

}
