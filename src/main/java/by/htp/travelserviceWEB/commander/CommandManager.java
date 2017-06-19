package by.htp.travelserviceWEB.commander;

import java.util.HashMap;
import java.util.Map;

public final class CommandManager {	
	
	private CommandManager() {
		init();
	}
	
	static class Singleton {
		private static final CommandManager INSTANCE = new CommandManager();
	}
	
	public static CommandManager getInstance() {
		return Singleton.INSTANCE;
	}
	
	public Map<String, CommandAction> init() {
		Map<String, CommandAction> mapCommand = new HashMap<String, CommandAction>(); 
		mapCommand.put("log_in", new LogInAction());
		mapCommand.put("log_out", new LogOutAction());
		mapCommand.put("sign_up_page", new SignUpPageAction());
		mapCommand.put("sign_up", new SignUpAction());
		return mapCommand;
	}

}
