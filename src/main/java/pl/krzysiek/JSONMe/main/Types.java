package pl.krzysiek.JSONMe.main;

public enum Types {
	primitiveInt("int"),
	Integer("Integer"), 
	String("String"),
	primitiveDouble("double"),
	Double("Double"),
	primitiveFloat("float"),
	Float("Float"),
	primitiveByte("byte"),
	Byte("Byte"),
	primitiveBoolean("boolean"),
	Boolean("Boolean"),
	primitiveChar("char"),
	Character("Character"),
	primitiveLong("long"),
	Long("Long"),
	primitiveShort("short"),
	Short("Short");
	
	private final String type;

	private Types(String type){
		this.type = type;
	}
	
	@Override
	public String toString(){
		return type;
	}

}
