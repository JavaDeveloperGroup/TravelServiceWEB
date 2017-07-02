package by.htp.travelserviceWEB.service.auto.impl;

import by.htp.travelserviceWEB.service.auto.BodyTypeService;

public class BodyTypeServiceImpl implements BodyTypeService {

private BodyTypeServiceImpl() {}

private static class Singletone{
private static final BodyTypeServiceImpl INSTANCE = new BodyTypeServiceImpl();
	}

public static BodyTypeServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}