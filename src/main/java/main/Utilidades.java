package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import MetodosSql.MetodosSql;
import configs.ReadPropertyFile;

public class Utilidades {
	
	private static final Logger logger = LogManager.getLogger(Utilidades.class);

public static ArrayList<Seccional>seccionales=new ArrayList<Seccional>();
public static ArrayList<Comisaria> comisarias = new ArrayList<Comisaria>();
public static ArrayList<Cliente>clientes=new ArrayList<Cliente>();
private static String _ipsDeBases;
private static String []ipsDebases;
//private static String seguirServidorActivo;
private static String usuarioBase;
private static String passwordBase;
private static String queryExtractora;
private static String queryActualizadora;
private static String baseDefault;
	

public static double obtenerLatitud(String linea) {
	return Double.parseDouble(linea.substring(1, linea.indexOf(',')).trim());	
}
public static double obtenerLongitud(String linea) {
	return Double.parseDouble(linea.substring(linea.indexOf(',')+1, linea.indexOf(']')).trim());	
}
	
public static ArrayList<Coordenada> LeerCoordenada(String ruta_archivo) {
	ArrayList<Coordenada> coordenada=new ArrayList<Coordenada>();
	Coordenada tempCoordenada;
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

    try {
       // Apertura del fichero y creacion de BufferedReader para poder
       // hacer una lectura comoda (disponer del metodo readLine()).
       archivo = new File (ruta_archivo);
       fr = new FileReader (archivo);
       br = new BufferedReader(fr);

       // Lectura del fichero
       String linea;
       while((linea=br.readLine())!=null) {
         // System.out.println(linea);
       	  tempCoordenada=new Coordenada(obtenerLatitud(linea), obtenerLongitud(linea));
          coordenada.add(tempCoordenada);
       }
    }
    catch(Exception e){
       e.printStackTrace();
    }finally{
       // En el finally cerramos el fichero, para asegurarnos
       // que se cierra tanto si todo va bien como si salta 
       // una excepcion.
       try{                    
          if( null != fr ){   
             fr.close();     
          }                  
       }catch (Exception e2){ 
          e2.printStackTrace();
       }
    }
    return coordenada;
}



public static boolean CoordenadaEstanDentroDelPoligono(Cliente cliente, Seccional seccional) {
boolean inside = false;
boolean intersect;
double x = cliente.getCoordenada().getLatitud();
double y = cliente.getCoordenada().getLongitud();
double xi;
double yi;
double yj;
double xj;



//for (int ii=0;ii<seccional.getCoordenada().size();ii++){
	
//	Coordenada = seccional.getCoordenada();
    
    for (int i = 0, j = seccional.getCoordenadas().size() - 1; i < seccional.getCoordenadas().size() ; j = i++) {
         xi = seccional.getCoordenadas().get(i).getLatitud(); yi = seccional.getCoordenadas().get(i).getLongitud();
         xj = seccional.getCoordenadas().get(j).getLatitud(); yj = seccional.getCoordenadas().get(j).getLongitud();

         //intersect = ((((yi > y) != (yj > y))) && ((x < (xj - xi) * (y - yi) / (yj - yi) + xi)));
         intersect = ((yi > y) != (yj > y)) && (x < (xj - xi) * (y - yi) / (yj - yi) + xi);
        
      
         
        if (intersect) {
        	inside = !inside;// true;
       
        }
    }
//}
	
	return inside; 
};

/**
 * Metodo que se encarga de leer las seccionales dadas como Coordenada, (poligonos) y guardarlos en el array estático
 * "seccionales"
 */
public static void cargarSeccionales() {
	logger.info("Leyendo seccionales descriptas en src/seccionalesUruguayInfo");
	Seccional primera=new Seccional(1, "Primera", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/1.txt"));	
	Seccional segunda=new Seccional(2, "Segunda", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/2.txt"));	
	Seccional tercera=new Seccional(3, "Tercera", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/3.txt"));	
	Seccional cuarta=new Seccional(4, "Cuarta", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/4.txt"));	
	Seccional quinta=new Seccional(5, "Quinta", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/5.txt"));	
	Seccional sexta=new Seccional(6, "Sexta", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/6.txt"));	
	Seccional septima=new Seccional(7, "Septima", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/7.txt"));	
	Seccional octava=new Seccional(8, "Octava", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/8.txt"));	
	Seccional novena=new Seccional(9, "Novena", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/9.txt"));	
	Seccional decima=new Seccional(10, "Decima", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/10.txt"));	
	Seccional decimoprimera=new Seccional(11, "Decimoprimera", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/11.txt"));	
	Seccional decimosegunda=new Seccional(12, "Decimosegunda", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/12.txt"));	
	Seccional decimotercera=new Seccional(13, "Sexta", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/13.txt"));	
	Seccional decimocuarta=new Seccional(14, "Decimocuarta", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/14.txt"));	
	Seccional decimoquinta=new Seccional(15, "Decimoquinta", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/15.txt"));	
	Seccional decimosexta=new Seccional(16, "Decimosexta", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/16.txt"));	
	Seccional decimoseptima=new Seccional(17, "Decimoseptima", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/17.txt"));	
	Seccional decimooctava=new Seccional(18, "Decimooctava", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/18.txt"));	
	Seccional decimonovena=new Seccional(19, "Decimonovena", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/19.txt"));	
	Seccional vigesima=new Seccional(20, "Vigesima", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/20.txt"));	
	Seccional vigesimoprimera=new Seccional(21, "Vigesimoprimera", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/21.txt"));	
	Seccional vigesimosegunda=new Seccional(22, "Vigesimosegunda", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/22.txt"));	
	Seccional vigesimotercera=new Seccional(23, "Vigesimotercera", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/23.txt"));	
	Seccional vigesimocuarta=new Seccional(24, "Vigesimocuarta", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/24.txt"));	
	Seccional vigesimoquinta=new Seccional(25, "Vigesimoquinta", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/25.txt"));	
	Seccional montevideo=new Seccional(1000, "montevideo", Utilidades.LeerCoordenada("src/seccionalesUruguayInfo/Montevideo.txt"));	
	logger.info("Fin de lectura en src/seccionalesUruguayInfo");
	logger.info("Cargando arreglo estático seccionales");
	seccionales.add(primera);
	seccionales.add(segunda);
	seccionales.add(tercera);
	seccionales.add(cuarta);
	seccionales.add(quinta);
	seccionales.add(sexta);
	seccionales.add(septima);
	seccionales.add(octava);
	seccionales.add(novena);
	seccionales.add(decima);
	seccionales.add(decimoprimera);
	seccionales.add(decimosegunda);
	seccionales.add(decimotercera);
	seccionales.add(decimocuarta);
	seccionales.add(decimoquinta);
	seccionales.add(decimosexta);
	seccionales.add(decimoseptima);
	seccionales.add(decimooctava);
	seccionales.add(decimonovena);
	seccionales.add(vigesima);
	seccionales.add(vigesimoprimera);
	seccionales.add(vigesimosegunda);
	seccionales.add(vigesimotercera);
	seccionales.add(vigesimocuarta);
	seccionales.add(vigesimoquinta);
	seccionales.add(montevideo);
	logger.info(seccionales.size()+" seccionales cargadas listas para consultar");
	cargarComisarias();
}
/**
 * 
 * @param cliente
 * @return Busca y asigna al cliente la seccional que le corresponde, en caso de no haber coincidencia, la seccional es cero 0
 */
public static int obtenerSeccional(Cliente cliente) {
	logger.info("Obteniendo seccional correspondiente a site_no: "+cliente.getSite_no()+" Coordenada: "+cliente.getCoordenada().getLatitud()+","+cliente.getCoordenada().getLongitud());
	boolean estaba=false;
	int seccionalNro=0;
	int indexMontevideo=0;
	
	for (int i=0;i<seccionales.size();i++) {
		// solo buscamos seccionales sin mirar si pertenecen a montevideo, esa función se usará para los puntos que están afuara en los 
		//puntos ciegos
		if(Utilidades.CoordenadaEstanDentroDelPoligono(cliente,seccionales.get(i))&&!seccionales.get(i).getNombre().equals("montevideo")) {
			seccionalNro=seccionales.get(i).getId();
			cliente.setSeccional_id(seccionalNro);
			
			estaba=true;
		}
		//Seteando indice montevideo para posterior uso
		if(seccionales.get(i).getNombre().equals("montevideo")) {
			indexMontevideo=i;
			}	
		
		
	}
	if(estaba) {
		logger.info("Seccional numero :"+seccionalNro+" encontrada para site_no: "+cliente.getSite_no());			
	}else {
		
		
		//ver si por lo menos está en Montevideo
		
		logger.warn("Atención!!!, el site_no "+cliente.getSite_no()+" no pertenece a ninguna de las seccionales policiales descriptas"
				+ "puedes verificarlo aquí en la página oficial del Ministerio del Interior https://www.google.com/maps/d/embed?mid=1-MjOJFdUGEdLJRdccCuXwkbVhOM&ehbc=2E312F");
		logger.info("El site_no "+cliente.getSite_no()+" no esta en las seccionales provistas, revisando si está en Montevideo");
		
		if(Utilidades.CoordenadaEstanDentroDelPoligono(cliente,seccionales.get(indexMontevideo))) {
			
			// Asignar la comisaria mas cercana;
			cliente.setSeccional_id(buscarComisariaMasCercana(cliente));
			
		}else{

			logger.warn("Atención!!!, el site_no "+cliente.getSite_no()+" no pertenece a Montevideo");
			cliente.setSeccional_id(0);
		
			logger.warn("El punto de este cliente corresponde a ésta ubicación en maps "
					+ "https://www.google.com.ar/maps/place/"+cliente.getCoordenada().getLatitud()+","+cliente.getCoordenada().getLongitud());
			logger.warn("Resumen|"+cliente.getSite_no()+"|"+cliente.getCoordenada().getLatitud()+"|"+cliente.getCoordenada().getLongitud());
		};
		
		
		
		
		/*
		
		*/
		
	}
	return seccionalNro;
}

private static int buscarComisariaMasCercana(Cliente cliente) {
	logger.info("Asignando comisaria mas cercana al cliente "+cliente.getSite_no());
	int nroComisaria=0;
	double distanciaMenor=0;
	double distanciaActual=0;
	distanciaActual=distanciaDosPuntos(
			cliente.getCoordenada().getLatitud(), cliente.getCoordenada().getLongitud(),
			comisarias.get(0).getCoordenada().getLatitud(), comisarias.get(0).getCoordenada().getLongitud());
	nroComisaria=comisarias.get(0).getId();
	distanciaMenor=distanciaActual;
	
	for(int i=1;i<comisarias.size();i++) {
		
				distanciaActual=distanciaDosPuntos(
				cliente.getCoordenada().getLatitud(), cliente.getCoordenada().getLongitud(),
				comisarias.get(i).getCoordenada().getLatitud(), comisarias.get(i).getCoordenada().getLongitud());
	if(	
			distanciaActual<distanciaMenor)
		{
		distanciaMenor=distanciaActual;
		nroComisaria=comisarias.get(i).getId();
		}
	
	
	}
	logger.info("Asignando comisaria nro "+nroComisaria+" por cercanía y porque está en Montevideo al site_no "+cliente.getSite_no());
	return nroComisaria;
}




/**
 * Se conecta a MasterMind obtiene los datos especificados en la query extractora, crea los objetos clientes en un array de objetos clientes
 * para que luego corra el proceso de iteración de objetos actualizando la base de datos.
 * Estos clientes creados ya cuentan en este proceso con la seccional que le corresponde.
 */
public static void cargarClientesDeMasterMind() {
	leerArchivoDeConfiguraciones();
	logger.info("Iniciando creación de clientes virtuales");
	Coordenada coordenada=new Coordenada();
	Cliente cliente;
	MetodosSql metodos=new MetodosSql(ipsDebases[0],usuarioBase,passwordBase);
	metodos.setDatabase(baseDefault);
	ArrayList<ArrayList<String>> _clientes=metodos.consultar(queryExtractora);
	
	for(int i=0;i<_clientes.size();i++) {
		coordenada.setLatitud(Double.parseDouble(_clientes.get(i).get(1)));
		coordenada.setLongitud(Double.parseDouble(_clientes.get(i).get(2)));
		cliente=new Cliente(_clientes.get(i).get(0),coordenada);
		obtenerSeccional(cliente);
		clientes.add(cliente);
	}
	logger.info("Fin de creación de clientes virtuales en el array Utilidades.clientes");
	imprimirResultadosPreviosAlaActualizacion();
	
		
}
/**
 * Lee las configuraciones de conectividad de ip, base de datos, usuario, password, etc.. del archivo configs/Configs.properties
 */
public static void leerArchivoDeConfiguraciones() {
	Properties props = ReadPropertyFile.getInstance().obtenerPropiedades();
	_ipsDeBases=props.getProperty("ipsDebases");
	ipsDebases=_ipsDeBases.split(",");
//	seguirServidorActivo=props.getProperty("seguirServidorActivo");
	usuarioBase=props.getProperty("usuarioBase");
	passwordBase=props.getProperty("passwordBase");
	queryExtractora=props.getProperty("queryExtractora");
	queryActualizadora=props.getProperty("queryActualizadora");
	baseDefault=props.getProperty("baseDefault");
	
	logger.info("Hosts de Mastermind a usar : "+_ipsDeBases);
	logger.info("Base de datos : "+baseDefault);
//	logger.info("seguirServidorActivo : "+seguirServidorActivo);
	logger.info("usuarioBase : "+usuarioBase);
	//logger.info("passwordBase : "+passwordBase);
	logger.info("queryExtractora : "+queryExtractora);
	logger.info("queryActualizadora : "+queryActualizadora);
	
}
public static String getQueryActualizadora() {
	return queryActualizadora;
}

private static void imprimirResultadosPreviosAlaActualizacion() {
	int clientes0=0;
	int clientesconSeccional=0;
	for(int i=0;i<clientes.size();i++) {
		if(clientes.get(i).getSeccional_id()==0) {
			clientes0++;
		}else {
			clientesconSeccional++;
		}
	}
	logger.info("Clientes que no se pueden geolocalizar "+ clientes0);
	logger.info("Clientes geolocalizables "+ clientesconSeccional);

}
public static void imprimirUpdatesArealizar() {
	logger.info("Imprimiendo query a ejecutar");
	for(int i=0;i<clientes.size();i++) {
		logger.info(clientes.get(i).getQueryUpdate());
	}
	logger.info("Fin de impresión de query a ejecutar");
	
}

public static double distanciaDosPuntos(double lat1, double lng1, double lat2, double lng2) {  
    //double radioTierra = 3958.75;//en millas  
    double radioTierra = 6371;//en kilómetros  
    double dLat = Math.toRadians(lat2 - lat1);  
    double dLng = Math.toRadians(lng2 - lng1);  
    double sindLat = Math.sin(dLat / 2);  
    double sindLng = Math.sin(dLng / 2);  
    double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
    double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
    double distancia = radioTierra * va2;  

    return distancia;  
}  

//https://donnierock.com/2015/03/16/calculando-la-distancia-entre-doos-Coordenada-en-java/

private static void cargarComisarias() {
	logger.info("Cargando comisarias");
	Comisaria primera=new Comisaria(1, "Primera", new Coordenada(-34.90762, -56.21089));
	Comisaria segunda=new Comisaria(2, "Segunda", new Coordenada(-34.90911, -56.18985));
	Comisaria tercera=new Comisaria(3, "Tercera", new Coordenada(-34.90207, -56.19001));
	Comisaria cuarta=new Comisaria(4, "Cuarta", new Coordenada(-34.89334, -56.17706));
	Comisaria quinta=new Comisaria(5, "Quinta", new Coordenada(-34.9067, -56.16981));
	Comisaria sexta=new Comisaria(6, "Sexta", new Coordenada(-34.88646, -56.19162));
	Comisaria septima=new Comisaria(7, "Septima", new Coordenada(-34.86424, -56.20864));
	Comisaria octava=new Comisaria(8, "Octava", new Coordenada(-34.84238, -56.20852));
	Comisaria novena=new Comisaria(9, "Novena", new Coordenada(-34.89069, -56.15803));
	Comisaria decima=new Comisaria(10, "Decima", new Coordenada(-34.90706, -56.1502));
	Comisaria decimoprimera=new Comisaria(11, "Decimoprimera", new Coordenada(-34.89341, -56.11089));
	Comisaria decimosegunda=new Comisaria(12, "Decimosegunda", new Coordenada(-34.85461, -56.19687));
	Comisaria decimotercera=new Comisaria(13, "Sexta", new Coordenada(-34.8698, -56.17166));
	Comisaria decimocuarta=new Comisaria(14, "Decimocuarta", new Coordenada(-34.8833, -56.09052));
	Comisaria decimoquinta=new Comisaria(15, "Decimoquinta", new Coordenada(-34.87558, -56.14127));
	Comisaria decimosexta=new Comisaria(16, "Decimosexta", new Coordenada(-34.85077, -56.14372));
	Comisaria decimoseptima=new Comisaria(17, "Decimoseptima", new Coordenada(-34.8362, -56.17281));
	Comisaria decimooctava=new Comisaria(18, "Decimooctava", new Coordenada(-34.8007, -56.08702));
	Comisaria decimonovena=new Comisaria(19, "Decimonovena", new Coordenada(-34.85696, -56.22464));
	Comisaria vigesima=new Comisaria(20, "Vigesima", new Coordenada(-34.78889, -56.35348));
	Comisaria vigesimoprimera=new Comisaria(21, "Vigesimoprimera", new Coordenada(-34.80466, -56.22125));
	Comisaria vigesimosegunda=new Comisaria(22, "Vigesimosegunda", new Coordenada(-34.79896, -56.25665));
	Comisaria vigesimotercera=new Comisaria(23, "Vigesimotercera", new Coordenada(-34.83743, -56.26982));
	Comisaria vigesimocuarta=new Comisaria(24, "Vigesimocuarta", new Coordenada(-34.88722, -56.25288));
	Comisaria vigesimoquinta=new Comisaria(25, "Vigesimoquinta", new Coordenada(-34.83723, -56.11601));
	
	
	comisarias.add(primera);
	comisarias.add(segunda);
	comisarias.add(tercera);
	comisarias.add(cuarta);
	comisarias.add(quinta);
	comisarias.add(sexta);
	comisarias.add(septima);
	comisarias.add(octava);
	comisarias.add(novena);
	comisarias.add(decima);
	comisarias.add(decimoprimera);
	comisarias.add(decimosegunda);
	comisarias.add(decimotercera);
	comisarias.add(decimocuarta);
	comisarias.add(decimoquinta);
	comisarias.add(decimosexta);
	comisarias.add(decimoseptima);
	comisarias.add(decimooctava);
	comisarias.add(decimonovena);
	comisarias.add(vigesima);
	comisarias.add(vigesimoprimera);
	comisarias.add(vigesimosegunda);
	comisarias.add(vigesimotercera);
	comisarias.add(vigesimocuarta);
	comisarias.add(vigesimoquinta);
	logger.info("Fin de carga de comisarias");

}
public static void actualizarDatosEnBBDD() {
	MetodosSql metodos=new MetodosSql(ipsDebases[0],usuarioBase,passwordBase);
	metodos.setDatabase(baseDefault);
	
		metodos.insertarOmodifClientes(clientes);
	
	
}

}
