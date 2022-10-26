import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Cliente;
import main.Coordenada;
import main.Seccional;
import main.Utilidades;

class Tests {

	
	Cliente cliente=new Cliente();	
	
	
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
	
	
	@Test
	void enPrimeraSeccionalTrue() {
		
		cliente.setCoordenada(new Coordenada(-34.90497, -56.20668));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, primera));
		cliente.setCoordenada(new Coordenada(-34.9027, -56.19853));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, primera));
		cliente.setCoordenada(new Coordenada(-34.9029, -56.19895));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, primera));
		cliente.setCoordenada(new Coordenada(-34.90404, -56.2005));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, primera));
		cliente.setCoordenada(new Coordenada(-34.90569, -56.20318));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, primera));
		cliente.setCoordenada(new Coordenada(-34.90344, -56.19632));// corresponde a la segunda
		assertFalse(Utilidades.coordenadasEstanDentroDelPoligono(cliente, primera));
	}
	
	@Test
	void enSegundaSeccionalTrue() {
			
	//	cliente.setCoordenada(new Coordenada(-34.91270133745454, -56.18749542675934));
	//	assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, segunda));
		cliente.setCoordenada(new Coordenada(-34.90891132627787, -56.19332418405753));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, segunda));
	}
	
	@Test
	void enTerceraSeccionalFalse() {
		cliente.setCoordenada(new Coordenada(-34.9027, -56.19853));
		assertFalse(Utilidades.coordenadasEstanDentroDelPoligono(cliente, tercera));
		cliente.setCoordenada(new Coordenada(-34.886162478244735, -56.16966488074699));
		assertFalse(Utilidades.coordenadasEstanDentroDelPoligono(cliente, tercera));
		cliente.setCoordenada(new Coordenada(-34.8884670130076, -56.1791625124878));
		assertFalse(Utilidades.coordenadasEstanDentroDelPoligono(cliente, tercera));
		cliente.setCoordenada(new Coordenada(-34.883858126785775, -56.170058932336566));
		assertFalse(Utilidades.coordenadasEstanDentroDelPoligono(cliente, tercera));
		cliente.setCoordenada(new Coordenada(-34.88634714003238, -56.172138117884984));
		assertFalse(Utilidades.coordenadasEstanDentroDelPoligono(cliente, tercera));
		cliente.setCoordenada(new Coordenada(-34.8886057449727, -56.17202585118208));
		
	}

	
	@Test
	void enCuartaSeccionalTrue() {
		cliente.setCoordenada(new Coordenada(-34.895522, -56.176358));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, cuarta));
		cliente.setCoordenada(new Coordenada(-34.886162478244735, -56.16966488074699));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, cuarta));
		cliente.setCoordenada(new Coordenada(-34.8884670130076, -56.1791625124878));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, cuarta));
		cliente.setCoordenada(new Coordenada(-34.883858126785775, -56.170058932336566));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, cuarta));
		cliente.setCoordenada(new Coordenada(-34.88634714003238, -56.172138117884984));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, cuarta));
		cliente.setCoordenada(new Coordenada(-34.8886057449727, -56.17202585118208));
		
	}



	@Test
	void enQuintaSeccionalTrue() {
		//-34.9288003285806, -56.1613496356442
		
		cliente.setCoordenada(new Coordenada(-34.9288003285806, -56.1613496356442));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, quinta));
		cliente.setCoordenada(new Coordenada(-34.916085015420926, -56.1678168070446));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, quinta));
		
	}
	@Test
	void enDecimoterceraTrue() {
		//-34.87963549845439, -56.158609081077934
		cliente.setCoordenada(new Coordenada(-34.87963549845439, -56.158609081077934));
		assertTrue(Utilidades.coordenadasEstanDentroDelPoligono(cliente, decimotercera));
	}
	@Test
	/**
	 * Le pongo coordenadas de cuarta, se espera que sea falso
	 */
	void enQuintaSeccional_1_false() {
		
		cliente.setCoordenada(new Coordenada(-34.9288003285806, -56.1613496356442));
		assertFalse(Utilidades.coordenadasEstanDentroDelPoligono(cliente, cuarta));
	}
	


}
