package org.assume.school.projects.battleship.api.types.command;

public class Command
{

	public static final String ATTACK_STRING = "attack";
	public static final int ATTACK_INT = 1;

	public static final String PROBE_STRING = "probe";
	public static final int PROBE_INT = 2;

	public static final String ORIENTATION_CHANGE_STRING = "orientation";
	public static final int ORIENTATION_CHANGE = 3;

	public static final String MOVE_STRING = "move";
	public static final int MOVE_INT = 4;

	public static boolean isCommandValid(int command)
	{
		return command == Command.ATTACK_INT || command == Command.PROBE_INT
				|| command == Command.ORIENTATION_CHANGE
				|| command == Command.MOVE_INT;
	}
}
