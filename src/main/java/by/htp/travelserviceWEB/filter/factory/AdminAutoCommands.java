package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

public class AdminAutoCommands implements UserCommandList {
	
	private CopyOnWriteArraySet<String> set;
	
	public AdminAutoCommands() {
		set = new CopyOnWriteArraySet<>();
		set.add("admin_page");
		set.add("log_out");
		set.add("auto_catalogue_sorting_page");
		set.add("auto_sort_salon_page");
	}

	@Override
	public CopyOnWriteArraySet<String> getSetCommands() {
		return set;
	}

}
