package NBA;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_Jugador {

	@Test
	public void test() {
		Jugador j= new Jugador("Lebron","LAL",0,"Alero");
		assertEquals("Alero", j.getPosicion());
		
		
	}

}
