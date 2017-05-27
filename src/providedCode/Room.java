package providedCode;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Room {
	private String _description;
	private HashMap<String, Room> _exits;

	public Room(String description) {
		this._description = description;
		_exits = new HashMap<String, Room>();
	}

	public void setExits(Room north, Room east, Room south, Room west) {
		if (north != null) {
			_exits.put("north", north);
		}
		if (east != null) {
			_exits.put("east", east);
		}
		if (south != null) {
			_exits.put("south", south);
		}
		if (west != null) {
			_exits.put("west", west);
		}
	}

	public String shortDescription() {
		return _description;
	}

	public String longDescription() {
		return "you are in " + _description + ".\n" + exitString();
	}

	private String exitString() {
		String returnString = "Exits:";
		Set<String> keys = _exits.keySet();
		for (Iterator<String> iter = keys.iterator(); iter.hasNext();) {
			returnString += " " + iter.next();
		}
		return returnString;
	}

	public Room nextRoom(String direction) {
		return (Room) _exits.get(direction);
	}
}
