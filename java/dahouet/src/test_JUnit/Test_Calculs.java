package test_JUnit;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import com.K4M1coder.dahouet.application.methodes.Calcul;
import com.K4M1coder.dahouet.application.models.Licencie;

public class Test_Calculs {

	@Test
	public void age() {
		DateTime dt = new DateTime(1973, 12, 11, 12, 12);
		assertEquals(41, Calcul.calculAge(dt.toDate()));

	}

	@Test
	public void calculPoints() {

		Licencie calcul = new Licencie(null, null, null, 0, 50, null, 2015);

		assertEquals("200.0", Calcul.calculPoints(150, 2015, calcul));

		Licencie calcul2 = new Licencie(null, null, null, 0, 200, null, 2015);

		assertEquals("Problème Licence, MAJ impossible",
				Calcul.calculPoints(380.5, 2014, calcul2));

	}
}
