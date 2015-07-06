package test_JUnit;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

import com.K4M1coder.dahouet.application.methodes.model.Licencie;
import com.K4M1coder.dahouet.application.methodes.utils.Calcul;

public class Test_Calculs {

	@Test
	public void age() {
		DateTime dt = new DateTime(1973, 12, 11, 12, 12);
		assertEquals(41, Calcul.calculAge(dt.toDate()));

	}

	@Test
	public void calculPoints() {
		
		Licencie calcul = new Licencie(1, null, null, null, 0L, null, null,
				0,0, 0L, 2015, 50);
		


		assertEquals("200.0", Calcul.calculPoints(150, 2015, calcul));


		Licencie calcul2 = new Licencie(1, null, null, null, 0L, null, null,
				0,0, 0L, 2015, 200);
		


		assertEquals("Problème Licence, MAJ impossible",
				Calcul.calculPoints(380.5, 2014, calcul2));

	}
}
