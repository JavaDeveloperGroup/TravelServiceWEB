package by.htp.travelserviceWEB.filter.factory;

import by.htp.travelserviceWEB.entity.User;

public class CheckCommandList implements UserCommandsCreator{
	
	private CheckCommandList() {}
	
	private static class Singleton {
		private static final CheckCommandList INSTANCE = new CheckCommandList();
	}
	
	public static CheckCommandList getInstance() {
		return Singleton.INSTANCE;
	}

	@Override
	public SetOfCommands fetchUserCommands(User user) {
		if (user == null) {
			return new GuestCommand();
		} else {
			switch (user.getRoleId()) {
			case 1:
				return new CustomerCommand();
			case 2:
				return new AdminTourCommand();
			case 3:
				return new AdminHotelCommand();
			case 4:
				return new AdminAutoCommand();
			default:
				return new GuestCommand();
			}
		}
	}
}
