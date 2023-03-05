package sbjp.rest.sbjprestful.enums;

public enum TypeGroupEnum {

	Type_Owner("owner"),  
    Type_Member("member");
	
    private final String typeGroupValue;

    private TypeGroupEnum(String roleValue) {
    	this.typeGroupValue=roleValue;
	} 
    
	public String getTypeGrpupValue() {
		return typeGroupValue;
	}
}
