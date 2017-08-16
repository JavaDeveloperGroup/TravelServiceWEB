package by.htp.travelserviceWEB.filter.factory;

import by.htp.travelserviceWEB.entity.User;

interface UserCommandListCreator {

	boolean isUserCommand(User user, String command);

}
