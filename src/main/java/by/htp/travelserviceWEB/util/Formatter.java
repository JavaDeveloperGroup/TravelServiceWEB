package by.htp.travelserviceWEB.util;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.User;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;
import by.htp.travelserviceWEB.sqlbuilder.select.Select;

import static by.htp.travelserviceWEB.util.ConstantValue.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class Formatter {
	
	private Formatter() {}

	public static Map<String, Object> listOfEntityFieldsAndValues(Entity entity, Map<String, Object> columnsAndValues)
			throws SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {

		int i = 0;
		for (Field field : Class.forName(entity.getClass().getName()).getDeclaredFields()) {
			field.setAccessible(true);
			if (i > 0) {
				columnsAndValues.put(remodel(field.getName()), field.get(entity));
			}
			i++;
		}
		return columnsAndValues;
	}

    private static String remodel(String string) {
        boolean isId = string.matches(".*Id");
        boolean isTO = string.matches(".*TO.*");

        if (isId) {
            String[] id_string = string.split("Id");
            string = "id_" + formatting(id_string[0]);
        } else if (isTO) {
            String[] to_string = string.split("TO");
            string = formatting(to_string[0]);
        } else {
            string = formatting(string);
        }
        return string;
    }

    private static String formatting(String string) {
        char[] array = string.toCharArray();
        string = "";
        for(int i = 0; i < array.length; i++) {
            if (Character.isUpperCase(array[i])) {
                if (i == 0 && Character.isUpperCase(array[i])) {
                    string += String.valueOf(Character.toLowerCase(array[i]));
                } else {
                    string += "_" + String.valueOf(Character.toLowerCase(array[i]));
                }
            } else {
                string += String.valueOf(array[i]);
            }
        }
        return string;
    }

    public static String framing(Object obj) {
        return "'" + obj + "'";
    }

    public static String stringWhereForUpdateAndDelete(Entity entity, Map<String, Object> columnsAndValues)
            throws SecurityException, ClassNotFoundException {

        StringBuilder builder = new StringBuilder();
        String id_columnsForConditionWhere = "";
        String valueForConditionWhere = "";
        String nameOfCallingClass = Thread.currentThread().getStackTrace()[2].getClassName();
        
        int i = 0;
        for (Map.Entry<String, Object> value : columnsAndValues.entrySet()) {
            i++;
            if (i == 1) {
                id_columnsForConditionWhere = value.getKey();
                valueForConditionWhere = framing(value.getValue());
            }
            if ("Update".equals(nameOfCallingClass.substring(nameOfCallingClass.lastIndexOf(".") + 1))) {
                if (i > startIndex(entity) && i < columnsAndValues.size()) {
                    builder.append(value.getKey()).append(" = ").append(framing(value.getValue())).append(", ");
                } else if (i == columnsAndValues.size()) {
                    builder.append(value.getKey()).append(" = ").append(framing(value.getValue()));
                }
            }
        }
        builder.append(" WHERE " + id_columnsForConditionWhere + " = " + valueForConditionWhere).append(";");
        
        return builder.toString();
    }
    
	public static String stringInsert(Entity entity, Map<String, Object> columnsAndValues) 
			throws SecurityException, ClassNotFoundException {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(" (" + stringOfColumns(entity, columnsAndValues) + ") ")
			 .append("VALUES ")
			 .append("(" + stringOfValues(entity, columnsAndValues) + ");");
		
		return builder.toString();
	}

    public static String stringOfColumns(Entity entity, Map<String, Object> columnsAndValues)
            throws SecurityException, ClassNotFoundException {
    	
        StringBuilder builder = new StringBuilder();
        
        int i = 0;
        for (Map.Entry<String, Object> column : columnsAndValues.entrySet()) {
            i++;
            //String nameOfCallingClass = Thread.currentThread().getContextClassLoader();
            if (i > startIndex(entity) && i < columnsAndValues.size()) {
                builder.append(column.getKey()).append(", ");
            } else if (i == columnsAndValues.size()) {
                builder.append(column.getKey());
            }
        }
        return builder.toString();
    }
    
    private static int startIndex(Entity entity) {
    	String className = entity.getClass().getSimpleName();
		boolean isTO = className.matches(".*TO.*");
		
		int index = 0;
		if (isTO) {
			index = 0;  
		}
		return index;
    }

    public static String stringOfValues(Entity entity, Map<String, Object> columnsAndValues)
            throws SecurityException, ClassNotFoundException {

        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, Object> value : columnsAndValues.entrySet()) {
            i++;
            if (i > startIndex(entity) && i < columnsAndValues.size()) {
                builder.append(framing(value.getValue())).append(", ");
            } else if (i == columnsAndValues.size()) {
                builder.append(framing(value.getValue()));
            }
        }
        return builder.toString();
    }
    
	public static Class<?>[] getParameterTypes(Entity entity) 
			throws SecurityException, ClassNotFoundException {
		
		return getConstructor(entity)[1].getParameterTypes();
	}
	
	public static Constructor<?>[] getConstructor(Entity entity) 
			throws SecurityException, ClassNotFoundException {
	
		return Class.forName(entity.getClass().getName()).getConstructors();
	}
	
	public static String getClassName(Entity entity) {
		String className = entity.getClass().getSimpleName();

		String[] serviceArray = className.split("TO");
		className = remodel(serviceArray[0]);

		return className;
	}
	
	public static String getRoleName(User user) {
		if (user == null) {
			return "Guest";
		}
		Integer roleId = user.getRoleId();
		switch (roleId) {
		case 1:
			return "Customer";
		case 2:
			return "Admin_Tour";
		case 3:
			return "Admin_Hotel";
		case 4:
			return "Admin_Auto";
		default:
			return "User";	
		}
	}
	
	public static void fieldsAndValuesListFormation(Entity entity, CustomerTOLP customerTOLP,
																	Map<String, Object> entityMap, 
																	Map<String, Object> conditionsMap)
			throws SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {

		listOfEntityFieldsAndValues(entity, entityMap);
		listOfEntityFieldsAndValues(customerTOLP, conditionsMap);
	}

	public static void fromWhere(Query query, Entity entity, Map<String, Object> entityMap)
			throws SecurityException, ClassNotFoundException {
		
		query.append(stringOfColumns(entity, entityMap)).append(" FROM ").append(getClassName(entity)).append(" WHERE");
	}

	public static void fromWhereForChecking(Query query, Entity entity, Map<String, Object> conditionsMap) {
		query.append(conditions(entity, conditionsMap));
	}

	private static String conditions(Entity entity, Map<String, Object> conditionsMap) {
		StringBuilder condition = new StringBuilder();
		int i = 0;
		for (Map.Entry<String, Object> map : conditionsMap.entrySet()) {
			if (i >= 0 && i < conditionsMap.size() - 1) {
				condition.append(" ").append(getClassName(entity)).append(".").append(map.getKey()).append(" = ")
						.append(framing(map.getValue())).append(" AND ");
			}
			if (i == conditionsMap.size() - 1) {
				condition.append(" ").append(getClassName(entity)).append(".").append(map.getKey()).append(" = ")
						.append(framing(map.getValue())).append(";");
			}
			i++;
		}

		return condition.toString();
	}
	
	public static Object newInstance(HttpServletRequest request, Entity entity) {
		Object obj = null;
		try {
			obj =  getConstructor(entity)[1].newInstance(parameters(request, entity));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
				| InvocationTargetException	| SecurityException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return obj;
	}
	
	public static Object newInstance(Entity entity, Object[] object) {
		
		Object obj = null;
		try {
			obj =  getConstructor(entity)[1].newInstance(getValuesForEntity(entity, object));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
				| InvocationTargetException	| SecurityException | ClassNotFoundException e) {	
			e.printStackTrace();
		}
		return obj;
	}
	
	private static Object[] getValuesForEntity(Entity entity, Object[] object) throws SecurityException, ClassNotFoundException {
		Class<?>[] types = getConstructor(entity)[1].getParameterTypes();
	
		return castValueFromDatabase(types, object);
	}
	
	private static Object[] castValueFromDatabase(Class<?>[] types, Object[] object) {
		for (int i = 0; i < object.length; i++) {
			if ("java.lang.Integer".equals(types[i].getName())) {
				object[i] = (Integer) object[i];
			} else if ("java.lang.Double".equals(types[i].getName())) {
				object[i] = (Double) object[i];
			} else {
				object[i] = object[i].toString();
			}
		}
		return object;
	}
	
	private static Object[] parameters(HttpServletRequest request, Entity entity) 
			throws SecurityException, ClassNotFoundException {
		
		Object[] obj = new Object[getParameterTypes(entity).length];
		
		int i = 0;
		for (Object value : allListsParameters.get(entity.getClass().getSimpleName().toLowerCase())) {
			obj[i] = castValueFromRequest(request, value);
			i++;
		}

		return obj;
	}
	
	private static Object castValueFromRequest(HttpServletRequest request, Object value) {
		Object obj = null;
		if ((value.toString()).matches("id_.*")) {
			obj = Integer.parseInt(request.getParameter(value.toString()));
		} else {
			obj = request.getParameter(value.toString());
		}
		return obj;
	}
	
	public static List<Entity> extractionEntities(Entity entity) {
		Select select = new QueryBuilder().select(entity).all();
		//System.out.println(entity.getClass().getSimpleName() + " : " + select.toString());
		ResultSet rs = null;
		List<Entity> list = null;

		try {
			rs = select.resultSet(select.toString());
			list = select.getListOfInstanceWithDataFromSQL(rs, entity);
		} catch (SecurityException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static Map<Integer, Entity> extractionEntitiesInMap(Entity entity) {
		Select select = new QueryBuilder().select(entity).all();
		//System.out.println(entity.getClass().getSimpleName() + " : " + select.toString());
		ResultSet rs = null;
		Map<Integer, Entity> map = null;

		try {
			rs = select.resultSet(select.toString());
			map = select.getMapOfInstanceWithDataFromSQL(rs, entity);
		} catch (SecurityException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return map;
	}
}
