package by.htp.travelserviceWEB.commander;

import java.util.HashMap;
import java.util.Map;

import static by.htp.travelserviceWEB.commander.EnumCommandAction.*;

public final class CommandManager {	
	
	/*private static final Map<EnumCommandAction, CommandAction> mapCommand = new HashMap<EnumCommandAction, CommandAction>(); 
	
	private CommandManager() {}
	
	static class Singleton {
		private static final CommandManager INSTANCE = new CommandManager();
	}
	
	public static CommandManager getInstance() {
		return Singleton.INSTANCE;
	}
	
	static {
		mapCommand.put(LOG_IN, new LogInAction());
		mapCommand.put(LOG_OUT, new LogOutAction());
		mapCommand.put(LOG_IN_PAGE, new LogInPageAction());
		mapCommand.put(SIGN_UP_PAGE, new SignUpPageAction());
		mapCommand.put(SIGN_UP, new SignUpAction());
	}

	public CommandAction getCommandAction(String command) {
		EnumCommandAction enumCommandAction = initAction(command);
		return mapCommand.get(enumCommandAction);
	}*/
}