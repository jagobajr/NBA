package JugadoresEquipos;

public class DBException extends Exception{
	
	
	private static final long SerialVersionUID=1L;
	
	public DBException(String message) {
		super(message);
	}
	
	public DBException(String message, Throwable e) {
		super (message, e);
		
	}

}
