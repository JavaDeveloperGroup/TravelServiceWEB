package by.htp.travelserviceWEB.service;

public class ColorServiceImpl implements ColorService {

private ColorServiceImpl() {}

private static class Singletone{
private static final ColorServiceImpl INSTANCE = new ColorServiceImpl();
	}

public static ColorServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}