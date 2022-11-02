package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class UYmain {
	
	
			
	private static final Logger logger = LogManager.getLogger(UYmain.class);
	
	public static void main(String[] args) {
		String stored_procedure=""
				+ "use monitordb\r\n" + 
				"go\r\n" + 
				"create procedure actualizarSeccionalesPoliciales @site_no integer, @jurisdiction_id  integer\r\n" + 
				"as\r\n" + 
				"\r\n" + 
				"update site set change_date=getdate(),change_user=1,change_type='C',jurisdiction_id=@jurisdiction_id where site_no=@site_no\r\n" + 
				"\r\n" + 
				"go";
		logger.info("Iniciando versi�n 1.0");
	
		logger.info("El contenido del stored procedure a ejecutar es el siguiente\n"+stored_procedure);
	    Utilidades.leerArchivoDeConfiguraciones();
		Utilidades.cargarSeccionales();
		Utilidades.cargarClientesDeMasterMind();
		Utilidades.imprimirUpdatesArealizar();	
		Utilidades.actualizarDatosEnBBDD();
		
	
}







}