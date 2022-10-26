package main;


import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import configs.ReadPropertyFile;

/*	logger.info("We've just greeted the user!");
logger.warn("We've just greeted the user!");
logger.error("We've just greeted the user!");
*/



class UYmain {
	private static final Logger logger = LogManager.getLogger(UYmain.class);
	
	public static void main(String[] args) {
		Utilidades.leerArchivoDeConfiguraciones();
		Utilidades.cargarSeccionales();
		Utilidades.cargarClientesDeMasterMind();
		
		int clientes0=0;
		int clientesconSeccional=0;
		for(int i=0;i<Utilidades.clientes.size();i++) {
			if(Utilidades.clientes.get(i).getSeccional_id()==0) {
				clientes0++;
			}else {
				clientesconSeccional++;
			}
		}
		
		System.out.println(clientes0);
		System.out.println(clientesconSeccional);
		
		
		
		
	

}







}