package ar.edu.unlam.videoClub;
import ar.edu.unlam.videoClub.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVendedor {

	@Test
	public void queSePuedaCrearUnVendedor() {
		Vendedor vendedor = new Vendedor ("Gabriel", 1125);
		
		assertNotNull(vendedor);
	}

}
