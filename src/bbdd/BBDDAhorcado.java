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
	
	
		    
		     public PlayerPojo getPlayer(String nombrePlayer) {
		PlayerPojo player;		
		player=new PlayerPojo();
		 Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rst = null;

        try {
            //1. Conectar a bbdd
        	
        	 con = DriverManager.getConnection( this.servidor + "/" + this.bbdd, this.usuario, this.pass);

            //2. recuperar datos de SELECT filtrando por el nombre
            String sql = "SELECT * FROM players WHERE name = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nombrePlayer);
            rst = pstmt.executeQuery();

            //3. rellenar pojo con los datos. Si no se ha encontrado datos, devolver Pojo con nombre vacio
            if (rst.next()) {
                player.setNombre(rst.getString("nombre"));
                player.setEstado(rst.getInt("estado"));
                player.setIntentos(rst.getInt("intentos"));
		player.setPalabraJuego(rst.getString("palabraJuego"));
                player.setLetrasUtilizadas(rst.getString("letrasUtilizadas"));
                
            } else {
                player.setNombre("");
            }

            //4. Cerrar conexion bbdd
            rst.close();
            pstmt.close();
            con.close();
        }
		//debe existir control de excepciones
        catch (SQLException e) {
        // handle exceptions here
        e.printStackTrace();
        }
		
		return player;		
	}
	    }
	    
		

