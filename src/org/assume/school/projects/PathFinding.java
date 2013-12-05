package org.assume.school.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class PathFinding
{

    public static void main(String[] args)
    {

	new PathFinding();
    }

    private int[][] map;
    private Stack<Cell> stack = new Stack<Cell>();
    private int totalCells = 192;
    private Cell currentCell;
    private int cellsVisited = 1;

    private void print()
    {
	for (int i = 0; i < this.map.length; i++)
	{
	    System.out.print("|");
	    for (int j = 0; j < this.map[i].length; j++)
	    {
		if (this.map[i][j] == 1)
		    System.out.print(" ");
		else
		    System.out.print("-");
	    }
	    System.out.print("|");
	    System.out.println();
	}
    }

    public PathFinding()
    {
	this.map = new int[16][12];
	this.currentCell = new Cell(new Random().nextInt(16), 0);
	while (cellsVisited < totalCells)
	{
	    Cell[] walledNeighbors = getNeighborsWalled();
	    if (walledNeighbors.length > 1)
	    {
		int ran = new Random().nextInt(walledNeighbors.length);
		Cell x = walledNeighbors[ran];
		System.out.println(x.getRow() + " " + x.getCol());
		this.map[x.getRow()][x.getCol()] = 1;
		this.stack.push(this.currentCell);
		this.currentCell = x;
		this.cellsVisited++;
	    } else
	    {
		try
		{
		    this.currentCell = this.stack.pop();
		} catch (Exception e)
		{
		    break;
		}
	    }
	}
	this.print();
    }

    private Cell[] getNeighborsWalled()
    {
	List<Cell> list = new ArrayList<Cell>();

	if (this.currentCell.getRow() + 1 < 15)
	{
	    if (this.map[this.currentCell.getRow() + 1][this.currentCell
		    .getCol()] == 0)
	    {
		list.add(new Cell(this.currentCell.getRow() + 1,
			this.currentCell.getCol()));
	    }
	}
	if (this.currentCell.getRow() - 1 > 0)
	{
	    if (this.map[this.currentCell.getRow() - 1][this.currentCell
		    .getCol()] == 0)
	    {
		list.add(new Cell(this.currentCell.getRow() - 1,
			this.currentCell.getCol()));
	    }
	}

	if ((this.currentCell.getCol() + 1) < 11)
	{
	    if (this.map[this.currentCell.getRow()][this.currentCell.getCol() + 1] == 0)
	    {
		list.add(new Cell(this.currentCell.getRow(), this.currentCell
			.getCol() + 1));
	    }
	}

	if (this.currentCell.getCol() - 1 > 0)
	{
	    if (this.map[this.currentCell.getRow()][this.currentCell.getCol() - 1] == 0)
	    {
		list.add(new Cell(this.currentCell.getRow(), this.currentCell
			.getCol() - 1));
	    }

	}
	return list.toArray(new Cell[list.size()]);

    }
}

class Cell
{

    private int row;
    private int col;

    public Cell(int row, int col)
    {
	this.row = row;
	this.col = col;
    }

    public int getRow()
    {
	return row;
    }

    public void setRow(int row)
    {
	this.row = row;
    }

    public int getCol()
    {
	return col;
    }

    public void setCol(int col)
    {
	this.col = col;
    }

    @Override
    public String toString()
    {
	return "Cell [row=" + row + ", col=" + col + "]";
    }

}
