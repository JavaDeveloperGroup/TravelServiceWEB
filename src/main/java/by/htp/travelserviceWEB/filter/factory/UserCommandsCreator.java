package by.htp.travelserviceWEB.filter.factory;

import by.htp.travelserviceWEB.entity.User;

interface UserCommandsCreator {

	SetOfCommands fetchUserCommands(User user);

}
