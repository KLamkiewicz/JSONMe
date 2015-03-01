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
	private static final StringBuilder sb = new StringBuilder();

	private JSONMeObject(){
		
	}
	
	/**
	 * 
	 * @param o Object for conversion
	 * @throws NoDataToConvertException for null passed
	 * @throws UnreasonableJSONException for single values passed
	 * @return String converted from Object
	 */
	public static String getJSON(Object o) throws NoDataToConvertException, UnreasonableJSONException {
		if(o==null)
			throw new NoDataToConvertException("Cannot convert a null object");
		
		for(Types type : Types.values()){
			if(type.toString().equals(o.getClass().getSimpleName()))
				throw new UnreasonableJSONException("Cannot create JSON from just a value");
		}
		sb.delete(0, sb.length());
		return convert(o).toString();
	}
	
	private static Object convert(Object o) {
		List<Field> fieldList = new ArrayList<Field>();
		fieldList.addAll(Arrays.asList(o.getClass().getFields()));
		
		if(o.getClass().isArray()){
			for(int i=0; i<Array.getLength(o); i++){
				//System.out.println(Array.get(o, i));
			}
		}
		
		
		Iterator<Field> it = fieldList.iterator();
		if(!fieldList.isEmpty()){
			sb.append("{\n ");
			while(it.hasNext()){
				Field f = (Field) it.next();
				try {	
					sb.append("\"" + f.getName() + "\": ");
					if(f.get(o).getClass().isArray()){
						sb.append("[");
						if(isUnreasonable(f.get(o).getClass().getComponentType().toString())){
							for(int i=0; i<Array.getLength(f.get(o)); i++){
								sb.append(Array.get(f.get(o), i));
								if(i!=Array.getLength(f.get(o))-1){
									sb.append(",");
								}
							}
						}
						sb.append("]");
					}
					
					else if(!isUnreasonable(f.getType().getSimpleName())){
						convert(f.get(o));
					}else if(f.get(o) == null){
						sb.append("\"null\"");
					}else{
						sb.append("\"" + f.get(o) + "\"");
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
