package sbjp.rest.sbjprestful.enums;

public enum RoleEnum {
	
	ROLE_USER("ROLE_USER"),  
    ROLE_GROUP("ROLE_GROUP");
	
    private final String roleValue;

    RoleEnum(String roleValue){
    	this.roleValue=roleValue;
    }
	public String getRoleValue() {
		return roleValue;
	}
    
}
