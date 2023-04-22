package bbdd;
import arquetipoAhorcadoBD.*;


	    

	    public BBDDAhorcado(){
	        
	        this.servidor = "jdbc:mysql://localhost:3306/ahorcadobd"; //modificar
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
