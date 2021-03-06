package admin.demo.exception;

public class UserCollectionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public UserCollectionException(String message){
		super(message);
	}

	public static String NotFoundExeption() {
		return "User not found";
	}

	public static String UserAlreadyExist() {
		return "email is already existing";
	}

	public static String CannotDeleteUser(){
		return "User cannot be deleted";
	}
	public static String UserPasswordWrong(String password) {
		return "Password entered is wrong "+password;
	}
}
