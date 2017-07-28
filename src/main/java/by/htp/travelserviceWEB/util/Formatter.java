package by.htp.travelserviceWEB.util;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.EntityAll;
import by.htp.travelserviceWEB.entity.dto.EntityTO;
import by.htp.travelserviceWEB.entity.tour.Bus;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Formatter {

    public static Map<String, Object> listOfEntityFieldsAndValues(EntityAll entityAll, EntityAll entityAllCompare, Map<String, Object> columnsAndValues)
            throws SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
    	if (entityAll instanceof EntityTO) {    		
    		recursion(entityAll, entityAll.getClass().getName(), columnsAndValues);
    	} else {   		
        	int i = 0;           
        	for (Field field : Class.forName(entityAll.getClass().getName()).getDeclaredFields()) {
                field.setAccessible(true);
                if (i > 0) {
                	columnsAndValues.put(remodel(field.getName()), field.get(entityAll));
                }
                i++;
            }
    	}
        return compare(entityAllCompare, columnsAndValues);
    }
       
	private static void recursion(EntityAll entityAll, String className, Map<String, Object> columnsAndValues) 
			throws ClassNotFoundException, IllegalAccessException {

	    getFields(entityAll, className, columnsAndValues);

    	Class obj = Class.forName(className).getSuperclass();

		if (obj != null && Class.forName(className).getClass() != obj) {
			recursion(entityAll, obj.getName(), columnsAndValues);
		}
	}

	private static void getFields(EntityAll entityAll, String className, Map<String, Object> columnsAndValues)
            throws ClassNotFoundException, IllegalAccessException {

	    int i = 0;

        for (Field field : Class.forName(className).getDeclaredFields()) {

            field.setAccessible(true);

            if (i >= 0) {
                columnsAndValues.put(field.getName(), field.get(entityAll));
            }

            field.setAccessible(false);

            i++;
        }
    }

    private static String remodel(String string) {
        String name = string.substring(0, string.length() - 2);
        String strId = string.substring(string.length() - 2, string.length());
        
        if ("Id".equals(strId)) {
            string = strId.toLowerCase() + "_" + name;
        }

        char[] array = string.toCharArray();
        string = "";
        for(int i = 0; i < array.length; i++) {
            if (Character.isUpperCase(array[i])) {
            	if (Character.isUpperCase(array[0])) {
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

    public static String stringWhere(Map<String, Object> columnsAndValues)
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
                if (i > 1 && i < columnsAndValues.size()) {
                    builder.append(value.getKey()).append(" = ").append(framing(value.getValue())).append(", ");
                } else if (i == columnsAndValues.size()) {
                    builder.append(value.getKey()).append(" = ").append(framing(value.getValue()));
                }
            }
        }
        builder.append(" WHERE " + id_columnsForConditionWhere + " = " + valueForConditionWhere);
        return builder.toString();
    }

    public static String stringOfColumns(Map<String, Object> columnsAndValues)
            throws SecurityException, ClassNotFoundException {

        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, Object> column : columnsAndValues.entrySet()) {
            i++;
            if (i > 1 && i < columnsAndValues.size()) {
                builder.append(column.getKey()).append(", ");
            } else if (i == columnsAndValues.size()) {
                builder.append(column.getKey());
            }
        }
        return builder.toString();
    }

    public static String stringOfValues(Map<String, Object> columnsAndValues)
            throws SecurityException, ClassNotFoundException {

        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, Object> value : columnsAndValues.entrySet()) {
            i++;
            if (i > 1 && i < columnsAndValues.size()) {
                builder.append(framing(value.getValue())).append(", ");
            } else if (i == columnsAndValues.size()) {
                builder.append(framing(value.getValue()));
            }
        }
        return builder.toString();
    }
    
	public static Class<?>[] getParameterTypes(EntityAll entityAll) {
		return getConstructor(entityAll)[1].getParameterTypes();
	}
	
	public static Constructor<?>[] getConstructor(EntityAll entityAll) {
		try {
			return Class.forName(entityAll.getClass().getName()).getConstructors();
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getClassName(EntityAll entityAll) {
    	String className = entityAll.getClass().getSimpleName();
    	
		if (entityAll instanceof EntityTO) {
    		String[] serviceArray = className.split("TO");
    		className = remodel(serviceArray[0]);
    	} else {
    		className = remodel(className);
    	}
		return className;
	}
	
    private static Map<String, Object> compare(EntityAll entityAll, Map<String, Object> columnsAndValues) 
    		throws ClassNotFoundException {
    	Map<String, Object> columnsAndValuesConmpare = new LinkedHashMap<>();
    	
        Field[] fields = Class.forName(entityAll.getClass().getName()).getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            String s1 = fields[i].getName();
            for ( String s2 : columnsAndValues.keySet() ) {
                if (s1 == s2) {
                    columnsAndValuesConmpare.put(s1, columnsAndValues.get(s2));
                }
            }
        }
        for (Map.Entry<String, Object> value : columnsAndValues.entrySet()) {
			System.out.println(value.getKey() + " : " + value.getValue());
		}
        System.out.println("==========================================================================");
        for (Map.Entry<String, Object> value : columnsAndValuesConmpare.entrySet()) {
            System.out.println(value.getKey() + " : " + value.getValue());
        }
        columnsAndValues = columnsAndValuesConmpare;
        return columnsAndValues;
    }
}
