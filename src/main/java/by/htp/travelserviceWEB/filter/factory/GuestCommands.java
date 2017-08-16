package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

public class GuestCommands implements UserCommandList {
	
	private CopyOnWriteArraySet<String> set;
	
	public GuestCommands() {
		set = new CopyOnWriteArraySet<>();
		set.add("hotel_catalogue_page");
		set.add("auto_catalogue_sorting_page");
		set.add("auto_sort_salon_page");
		set.add("tour_catalogue_page");
		set.add("log_in_page");
		set.add("sign_up_page");
		set.add("log_in");
		set.add("sign_up");
	}
	
	@Override
	public CopyOnWriteArraySet<String> getSetCommands() {
		return set;
	}
}
