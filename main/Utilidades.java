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
public static ArrayList<Cliente>clientes=new ArrayList<Cliente>();
private static String _ipsDeBases;
private static String []ipsDebases;
private static String seguirServidorActivo;
private static String usuarioBase;
private static String passwordBase;
private static String queryExtractora;
private static String queryActualizadora;
	

public static double obtenerLatitud(String linea) {
	return Double.parseDouble(linea.substring(1, linea.indexOf(',')).trim());	
}
public static double obtenerLongitud(String linea) {
	return Double.parseDouble(linea.substring(linea.indexOf(',')+1, linea.indexOf(']')).trim());	
}
	
public static ArrayList<Coordenada> LeerCoordenadas(String ruta_archivo) {
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



public static boolean coordenadasEstanDentroDelPoligono(Cliente cliente, Seccional seccional) {
boolean inside = false;
boolean intersect;
double x = cliente.getCoordenada().getLatitud();
double y = cliente.getCoordenada().getLongitud();
double xi;
double yi;
double yj;
double xj;



//for (int ii=0;ii<seccional.getCoordenadas().size();ii++){
	
//	coordenadas = seccional.getCoordenadas();
    
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
 * Metodo que se encarga de leer las seccionales dadas como coordenadas, (poligonos) y guardarlos en el array estático
 * "seccionales"
 */
public static void cargarSeccionales() {
	logger.info("Leyendo seccionales descriptas en src/seccionalesUruguayInfo");
	Seccional primera=new Seccional(1, "Primera", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/1.txt"));	
	Seccional segunda=new Seccional(2, "Segunda", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/2.txt"));	
	Seccional tercera=new Seccional(3, "Tercera", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/3.txt"));	
	Seccional cuarta=new Seccional(4, "Cuarta", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/4.txt"));	
	Seccional quinta=new Seccional(5, "Quinta", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/5.txt"));	
	Seccional sexta=new Seccional(6, "Sexta", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/6.txt"));	
	Seccional septima=new Seccional(7, "Septima", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/7.txt"));	
	Seccional octava=new Seccional(8, "Octava", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/8.txt"));	
	Seccional novena=new Seccional(9, "Novena", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/9.txt"));	
	Seccional decima=new Seccional(10, "Decima", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/10.txt"));	
	Seccional decimoprimera=new Seccional(11, "Decimoprimera", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/11.txt"));	
	Seccional decimosegunda=new Seccional(12, "Decimosegunda", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/12.txt"));	
	Seccional decimotercera=new Seccional(13, "Sexta", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/13.txt"));	
	Seccional decimocuarta=new Seccional(14, "Decimocuarta", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/14.txt"));	
	Seccional decimoquinta=new Seccional(15, "Decimoquinta", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/15.txt"));	
	Seccional decimosexta=new Seccional(16, "Decimosexta", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/16.txt"));	
	Seccional decimoseptima=new Seccional(17, "Decimoseptima", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/17.txt"));	
	Seccional decimooctava=new Seccional(18, "Decimooctava", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/18.txt"));	
	Seccional decimonovena=new Seccional(19, "Decimonovena", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/19.txt"));	
	Seccional vigesima=new Seccional(20, "Vigesima", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/20.txt"));	
	Seccional vigesimoprimera=new Seccional(21, "Vigesimoprimera", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/21.txt"));	
	Seccional vigesimosegunda=new Seccional(22, "Vigesimosegunda", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/22.txt"));	
	Seccional vigesimotercera=new Seccional(23, "Vigesimotercera", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/23.txt"));	
	Seccional vigesimocuarta=new Seccional(24, "Vigesimocuarta", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/24.txt"));	
	Seccional vigesimoquinta=new Seccional(25, "Vigesimoquinta", Utilidades.LeerCoordenadas("src/seccionalesUruguayInfo/25.txt"));	
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
	logger.info(seccionales.size()+" seccionales cargadas listas para consultar");
}
/**
 * 
 * @param cliente
 * @return Busca y asigna al cliente la seccional que le corresponde, en caso de no haber coincidencia, la seccional es cero 0
 */
public static int obtenerSeccional(Cliente cliente) {
	logger.info("Obteniendo seccional correspondiente a site_no: "+cliente.getSite_no()+" Coordenadas: "+cliente.getCoordenada().getLatitud()+","+cliente.getCoordenada().getLongitud());
	boolean estaba=false;
	int seccionalNro=0;
	for (int i=0;i<seccionales.size();i++) {
		if(Utilidades.coordenadasEstanDentroDelPoligono(cliente,seccionales.get(i))) {
			seccionalNro=seccionales.get(i).getId();
			cliente.setSeccional_id(seccionalNro);
			
			estaba=true;
		}
		
		
	}
	if(estaba) {
		logger.info("Seccional numero :"+seccionalNro+" encontrada para site_no: "+cliente.getSite_no());			
	}else {
		logger.warn("Atención!!!, el site_no "+cliente.getSite_no()+" no pertenece a ninguna de las seccionales policiales descriptas\n"
				+ "puedes verificarlo aquí en la página oficial del Ministerio del Interior https://www.google.com/maps/d/embed?mid=1-MjOJFdUGEdLJRdccCuXwkbVhOM&ehbc=2E312F");
		
		logger.warn("El punto de este cliente corresponde a ésta ubicación en maps \n"
				+ "https://www.google.com.ar/maps/place/"+cliente.getCoordenada().getLatitud()+","+cliente.getCoordenada().getLongitud());
	}
	return seccionalNro;
}

public static void cargarClientesDeMasterMind() {
	leerArchivoDeConfiguraciones();
	Coordenada coordenada=new Coordenada();
	Cliente cliente;
	MetodosSql metodos=new MetodosSql(ipsDebases[1],usuarioBase,passwordBase);
	metodos.setDatabase("monitordb");
	ArrayList<ArrayList<String>> _clientes=metodos.consultar(queryExtractora);
	
	for(int i=0;i<_clientes.size();i++) {
		coordenada.setLatitud(Double.parseDouble(_clientes.get(i).get(1)));
		coordenada.setLongitud(Double.parseDouble(_clientes.get(i).get(2)));
		cliente=new Cliente(_clientes.get(i).get(0),coordenada);
		obtenerSeccional(cliente);
		clientes.add(cliente);
	}
	
	System.out.println("Hola");
	
	
	
	
	
}
/**
 * Lee las configuraciones de conectividad de ip, base de datos, usuario, password, etc.. del archivo configs/Configs.properties
 */
public static void leerArchivoDeConfiguraciones() {
	Properties props = ReadPropertyFile.getInstance().obtenerPropiedades();
	_ipsDeBases=props.getProperty("ipsDebases");
	ipsDebases=_ipsDeBases.split(",");
	seguirServidorActivo=props.getProperty("seguirServidorActivo");
	usuarioBase=props.getProperty("usuarioBase");
	passwordBase=props.getProperty("passwordBase");
	queryExtractora=props.getProperty("queryExtractora");
	queryActualizadora=props.getProperty("queryActualizadora");
	
	logger.info("Hosts de Mastermind a usar : "+_ipsDeBases);
	logger.info("seguirServidorActivo : "+seguirServidorActivo);
	logger.info("usuarioBase : "+usuarioBase);
	logger.info("passwordBase : "+passwordBase);
	logger.info("queryExtractora : "+queryExtractora);
	logger.info("queryActualizadora : "+queryActualizadora);
}
public static String getQueryActualizadora() {
	return queryActualizadora;
}
}
