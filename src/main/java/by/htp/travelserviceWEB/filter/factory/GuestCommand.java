package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

import by.htp.travelserviceWEB.util.Commands;

import static by.htp.travelserviceWEB.util.Commands.*;

public class GuestCommand implements SetOfCommands {
	
	private CopyOnWriteArraySet<Commands> set;
	
	public GuestCommand() {
		set = new CopyOnWriteArraySet<>();
		
		set.add(HOTEL_CATALOGUE_PAGE);
		set.add(AUTO_CATALOGUE_SORTING_PAGE);
		set.add(AUTO_SORT_SALON_PAGE);
		set.add(TOUR_CATALOGUE_PAGE);
		set.add(LOG_IN);
		set.add(SIGN_UP);
		set.add(LOG_IN_PAGE);
		set.add(SIGN_UP_PAGE);
	}
	
	@Override
	public CopyOnWriteArraySet<Commands> getCommands() {
		return set;
	}
}
