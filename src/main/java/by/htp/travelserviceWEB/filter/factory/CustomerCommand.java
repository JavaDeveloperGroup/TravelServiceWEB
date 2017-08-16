package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

import by.htp.travelserviceWEB.util.Commands;

import static by.htp.travelserviceWEB.util.Commands.*;

public class CustomerCommand implements SetOfCommands {
	
	private CopyOnWriteArraySet<Commands> set;
	
	public CustomerCommand() {
		set = new CopyOnWriteArraySet<>();
		
		set.add(HOTEL_CATALOGUE_PAGE);
		set.add(AUTO_CATALOGUE_SORTING_PAGE);
		set.add(AUTO_SORT_SALON_PAGE);
		set.add(TOUR_CATALOGUE_PAGE);
		set.add(LOG_OUT);
		set.add(UPDATE_ACCOUNT);
		set.add(UPDATE_ACCOUNT_PAGE);
	}
	
	@Override
	public CopyOnWriteArraySet<Commands> getCommands() {
		return set;
	}

}
