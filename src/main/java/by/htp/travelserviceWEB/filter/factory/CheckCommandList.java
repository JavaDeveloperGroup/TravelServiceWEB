package by.htp.travelserviceWEB.filter.factory;

import by.htp.travelserviceWEB.entity.User;

public class CheckCommandList implements UserCommandListCreator{
	
	private CheckCommandList() {}
	
	private static class Singleton {
		private static final CheckCommandList INSTANCE = new CheckCommandList();
	}
	
	public static CheckCommandList getInstance() {
		return Singleton.INSTANCE;
	}

	@Override
	public boolean isUserCommand(User user, String command) {
		if (user == null)
			return new GuestCommands().getSetCommands().contains(command);
		switch (user.getRoleId()) {
		case 1:
			return new CustomerCommands().getSetCommands().contains(command);
		case 2:
			return new AdminTourCommands().getSetCommands().contains(command);
		case 3:
			return new AdminHotelCommands().getSetCommands().contains(command);
		case 4:
			return new AdminAutoCommands().getSetCommands().contains(command);
		default:
			return new GuestCommands().getSetCommands().contains(command);
		}	
	}
}
