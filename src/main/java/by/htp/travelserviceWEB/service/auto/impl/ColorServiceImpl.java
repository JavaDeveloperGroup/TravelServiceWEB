package by.htp.travelserviceWEB.service.auto.impl;

import by.htp.travelserviceWEB.service.auto.ColorService;

public class ColorServiceImpl implements ColorService {

private ColorServiceImpl() {}

private static class Singletone{
private static final ColorServiceImpl INSTANCE = new ColorServiceImpl();
	}

public static ColorServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}