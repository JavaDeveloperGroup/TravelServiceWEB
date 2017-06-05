package by.htp.travelserviceWEB.service;

public class AdminServiceImpl implements AdminService {

private AdminServiceImpl() {}

private static class Singletone{
private static final AdminServiceImpl INSTANCE = new AdminServiceImpl();
	}

public static AdminServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}