package providedCode;

public class Command {
	private String _commandWord;
	private String _secondWord;
	
	public Command(String firstWord, String secondWord) {
		_commandWord = firstWord;
		_secondWord = secondWord;
	}
	
	public String getCommandWord() { return _commandWord; }
	public String getSecondWord() { return _secondWord; }
	public boolean isUnknown() { return (_commandWord == null); }
	public boolean hasSecondWord() { return (_secondWord != null); }
}
