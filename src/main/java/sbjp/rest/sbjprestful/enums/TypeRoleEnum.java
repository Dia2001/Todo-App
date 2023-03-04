package sbjp.rest.sbjprestful.enums;

public enum TypeRoleEnum {
	
	Type_User("user"),  
    Type_Group("group");
	
    private final String roleValue;

    TypeRoleEnum(String roleValue){
    	this.roleValue=roleValue;
    }
    
	public String getRoleValue() {
		return roleValue;
	}
}
