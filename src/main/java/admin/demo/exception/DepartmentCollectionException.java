package admin.demo.exception;

public class DepartmentCollectionException extends Exception {
    private static final long serialVersionUID = 1L;

    public DepartmentCollectionException(String messeage) {
        super(messeage);
    }

    public static String DepartmentAlreadyExist() {
        return "Department Already Existing";
    }
}
