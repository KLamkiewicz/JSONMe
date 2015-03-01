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
	
	private static StringBuilder arrayIterate(Field f, StringBuilder sb, Object o) throws IllegalArgumentException, IllegalAccessException{
		for(int i=0; i<Array.getLength(f.get(o)); i++){
			Object obj = Array.get(f.get(o), i);
			if(obj!=null && obj.getClass().isArray()){
				arrayIterate(f, sb, obj);
			}else{
				sb.append("\""+Array.get(f.get(o), i)+"\"");
			}
			if(i!=Array.getLength(f.get(o))-1){
				sb.append(",");
			}
		}
		return sb;
	}
	
	private static Object convert(Object o) {
		List<Field> fieldList = new ArrayList<Field>();
		fieldList.addAll(Arrays.asList(o.getClass().getFields()));

		Iterator<Field> it = fieldList.iterator();
		if(!fieldList.isEmpty()){
			sb.append("{\n ");
			while(it.hasNext()){
				Field f = (Field) it.next();
				try {	
					sb.append("\"" + f.getName() + "\": ");
					if(f.get(o)!=null && f.get(o).getClass().isArray()){
						sb.append("[");
						String cleanArray = f.get(o).getClass().getComponentType().getSimpleName().toString().replace("[]", "");
						if(isUnreasonable(cleanArray)){
							for(int i=0; i<Array.getLength(f.get(o)); i++){
								Object obj = Array.get(f.get(o), i);
//								if(obj!=null && obj.getClass().isArray()){
//									arrayIterate(f, sb, obj);
//								}else{
									sb.append("\""+Array.get(f.get(o), i)+"\"");
								//}
								if(i!=Array.getLength(f.get(o))-1){
									sb.append(",");
								}
							}
						}else{
							for(int i=0; i<Array.getLength(f.get(o)); i++){
								if(Array.get(f.get(o), i) == null){
									sb.append("{}");
								}else{
									convert(Array.get(f.get(o), i));
								}
								
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
		//System.out.println(u);
		for(Types type : Types.values()){
			if(type.toString().equals(u)){
				return true;
			}
		}
		return false;
	}

}
