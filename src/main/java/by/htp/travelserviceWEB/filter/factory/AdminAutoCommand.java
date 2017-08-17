package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

import by.htp.travelserviceWEB.util.Commands;

import static by.htp.travelserviceWEB.util.Commands.*;

public class AdminAutoCommand implements SetOfCommands {
	
	private CopyOnWriteArraySet<Commands> set;
	
	public AdminAutoCommand() {
		set = new CopyOnWriteArraySet<>();
		
		set.add(AUTO_CATALOGUE_SORTING_PAGE);
		set.add(AUTO_SORT_SALON_PAGE);
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
