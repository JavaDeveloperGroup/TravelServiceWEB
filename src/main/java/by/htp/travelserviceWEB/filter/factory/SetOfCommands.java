package by.htp.travelserviceWEB.filter.factory;

import java.util.concurrent.CopyOnWriteArraySet;

import by.htp.travelserviceWEB.util.Commands;

public interface SetOfCommands {
	
	CopyOnWriteArraySet<Commands> getCommands();

}
