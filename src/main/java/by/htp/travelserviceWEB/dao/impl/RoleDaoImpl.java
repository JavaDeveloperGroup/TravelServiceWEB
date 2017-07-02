package by.htp.travelserviceWEB.dao.impl;

import by.htp.travelserviceWEB.dao.RoleDao;

public class RoleDaoImpl implements RoleDao {

	private RoleDaoImpl() {
	}

	private static class Singletone {
		private static final RoleDaoImpl INSTANCE = new RoleDaoImpl();
	}

	public static RoleDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
}