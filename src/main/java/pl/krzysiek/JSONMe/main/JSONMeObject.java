package pl.krzysiek.JSONMe.main;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import pl.krzysiek.JSONMe.exceptions.*;


/**
 * JSON Converter
 * 
 * 
 * @author krzysiek
 * @version 1.0
 * 
 */
public final class JSONMeObject{

	private JSONMeObject(){

	}
	
	/**
	 * 
	 * @param o Object for conversion
	 * @throws NoDataToConvertException when null is passed
	 * @throws UnreasonableJSONException for single values passed
	 * @return Valid JSON String converted from Object
	 */
	public static String getJSON(Object o) throws NoDataToConvertException, UnreasonableJSONException {
		if(o==null)
			throw new NoDataToConvertException("Cannot convert a null object");
		
		if(isUnreasonable(o.getClass().getSimpleName()))
			throw new UnreasonableJSONException("Cannot create JSON from just a value");

		StringBuilder sb = new StringBuilder();
		return convert(o, sb).toString();
	}
	
	private static void arrayIterate(Object o, StringBuilder sb) throws IllegalArgumentException, IllegalAccessException{
		sb.append("[");

		if(isUnreasonable(o.getClass().getSimpleName().replace("[]", ""))){
			if(o!=null && o.getClass().isArray()){
				for(int i=0; i<Array.getLength(o); i++){
					Object ob = Array.get(o, i);
					if(ob!=null && ob.getClass().isArray()){
						arrayIterate(ob, sb);
					}else{
						if(ob==null){
							sb.append(ob);
						}else if(ob.getClass()==Character.class || ob.getClass()==String.class)
							sb.append("\"" + ob + "\"");
						else{
							sb.append(ob);
						}
					}
					
					if(i!=Array.getLength(o)-1){
						sb.append(",");
					}
				}
			}
		}else{
			if(o!=null && o.getClass().isArray()){
				for(int i=0; i<Array.getLength(o); i++){
					Object ob = Array.get(o, i);
					if(ob!=null && ob.getClass().isArray()){
						arrayIterate(ob, sb);
					}else{
						if(ob!=null)
							convert(ob, sb);
						else{
							sb.append("{}");
						}
					}
					
					if(i!=Array.getLength(o)-1){
						sb.append(",");
					}
				}
			}
		}

		sb.append("]");
	}
	
	private static Object convert(Object o, StringBuilder sb) {

		List<Field> fieldList = new ArrayList<Field>();
		if(o!=null)
			fieldList.addAll(Arrays.asList(o.getClass().getFields()));

		Iterator<Field> it = fieldList.iterator();
		if(!fieldList.isEmpty()){
			sb.append("{\n ");
			while(it.hasNext()){
				Field f = (Field) it.next();
				
				try {	
					sb.append("\"" + f.getName() + "\": ");
					if(f.getType().isEnum()){
						sb.append("\""+ f.get(o) + "\"");
					}
					else if(f.get(o) != null && f.get(o).getClass().isArray()){
						//Array conversion
						arrayIterate(f.get(o), sb);
					}
					//Recursively acquire fields from a class
					else if(!isUnreasonable(f.getType().getSimpleName())){
						convert(f.get(o), sb);
					}else if(f.get(o) == null){
						sb.append("null");
					}else{
						if(f.get(o).getClass()==Character.class || f.get(o).getClass()==String.class)
							sb.append("\"" + f.get(o) + "\"");
						else{
							sb.append(f.get(o));
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
		
				if(!it.hasNext())
					sb.append("\n");
				else
					sb.append(",\n");
				
			};
			
			sb.append("}\n");
		}else{
			sb.append("{}");
		}
		
		return sb;

	}
	
	private static boolean isUnreasonable(Object u){
		for(Types type : Types.values()){
			if(type.toString().equals(u)){
				return true;
			}
		}
		return false;
	}

}
