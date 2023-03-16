package sbjp.rest.sbjprestful.exception;

public class UserNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(int id){
        super("User " + id + " Not found!");
    }
}
