package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

public class CustomerCommands implements UserCommandList {
	
	private CopyOnWriteArraySet<String> set;
	
	public CustomerCommands() {
		set = new CopyOnWriteArraySet<>();
		set.add("hotel_catalogue_page");
		set.add("auto_catalogue_sorting_page");
		set.add("auto_sort_salon_page");
		set.add("tour_catalogue_page");
		set.add("hotel_make_order");
		set.add("auto_make_order");
		set.add("tour_make_order");
		set.add("log_out");
		set.add("update_account_page");
		set.add("update_account");
	}
	
	@Override
	public CopyOnWriteArraySet<String> getSetCommands() {
		return set;
	}

}
