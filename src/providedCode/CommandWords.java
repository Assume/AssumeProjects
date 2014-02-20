package providedCode;

public class CommandWords {
	private static final String _validCommands[] = {"go", "quit", "help" };
	
	public CommandWords() { }
	
	public boolean isCommand(String aString) {
		for (int i = 0; i < _validCommands.length; i++) {
			if (_validCommands[i].equals(aString)) { return true; }
		}
		return false;
	}
	
	public void showAll() {
		for (int i = 0; i < _validCommands.length; i++) {
			System.out.println(_validCommands[i] + "   ");
		}
		System.out.println();
	}
}
