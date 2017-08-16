package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

public class AdminHotelCommands implements UserCommandList {
	
	private CopyOnWriteArraySet<String> set;
	
	public AdminHotelCommands() {
		set = new CopyOnWriteArraySet<>();
		set.add("admin_page");
		set.add("log_out");
		set.add("hotel_catalogue_page");
	}
	
	@Override
	public CopyOnWriteArraySet<String> getSetCommands() {
		return set;
	}

}
