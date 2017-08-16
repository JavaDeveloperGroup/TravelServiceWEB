package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

public class AdminTourCommands implements UserCommandList {
	
	private CopyOnWriteArraySet<String> set;
	
	public AdminTourCommands() {
		set = new CopyOnWriteArraySet<>();
		set.add("admin_page");
		set.add("log_out");
		set.add("tour_catalogue_page");
	}
	
	@Override
	public CopyOnWriteArraySet<String> getSetCommands() {
		return set;
	}

}
