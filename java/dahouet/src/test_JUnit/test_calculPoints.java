package test_JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dahouet.application.models.Licencie;
import com.dahouet.application.models.Calculs;

public class test_calculPoints {

	@Test
	public void test() {

		Licencie calcul = new Licencie(null, null, null, 0, 50, null, 2015);

		assertEquals("200.0", Calculs.calculPoints(150, 2015, calcul));

		Licencie calcul2 = new Licencie(null, null, null, 0, 200, null, 2015);

		assertEquals("Problème Licence, MAJ impossible",
				Calculs.calculPoints(380.5, 2014, calcul2));
	}

}
