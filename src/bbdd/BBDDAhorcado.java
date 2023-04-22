package bbdd;
import arquetipoAhorcadoBD.*;

public class BBDDAhorcado {
	
	 
	    private String servidor;
	    private String usuario;
	    private String pass; 
	    private String bbdd;
	    
	    

	    public BBDDAhorcado(){
	        
	        this.servidor = "jdbc:mysql://localhost:3306"; 
	        this.bbdd = "ahorcadobd"; 
	        this.usuario = "root";
	        this.pass = ""; 
		    

	        try {
	            Class.forName("com.mysql.jdbc.Driver"); 
	        } catch (Exception e) {
	            throw new AhorcadoException("Driver de BD no localizado"+e);
	        }
	    }
	    
		
}
