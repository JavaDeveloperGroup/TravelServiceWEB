package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

import by.htp.travelserviceWEB.util.Commands;

import static by.htp.travelserviceWEB.util.Commands.*;

public class AdminHotelCommand implements SetOfCommands {
	
	private CopyOnWriteArraySet<Commands> set;
	
	public AdminHotelCommand() {
		set = new CopyOnWriteArraySet<>();
		
		set.add(HOTEL_CATALOGUE_PAGE);
		set.add(ADMIN_PAGE);
		set.add(LOG_OUT);
		set.add(LOG_IN);
		set.add(LOG_IN_PAGE);

	}
	
	@Override
	public CopyOnWriteArraySet<Commands> getCommands() {
		return set;
	}
	
	

}
