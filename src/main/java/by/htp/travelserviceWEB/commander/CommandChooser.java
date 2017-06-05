package by.htp.travelserviceWEB.commander;

public class CommandChooser {

	public static CommandAction chooserAction(String command) {
		return (CommandAction) CommandMap.map().get(command);
	}
}
