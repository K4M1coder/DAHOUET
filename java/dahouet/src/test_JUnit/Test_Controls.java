package test_JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.K4M1coder.dahouet.application.methodes.utils.Controls;

public class Test_Controls {

	@Test
	public void mailAdrFormat() {
		assertEquals(null, Controls.ctlMail("une_adresse.mail-valide@dom.tld"));

		assertEquals(null, Controls.ctlMail("mail@dom.tld"));

		assertEquals("Adresse mail invalide", Controls.ctlMail("maildom.tld"));

		assertEquals("Adresse mail invalide", Controls.ctlMail("m@dom.tld"));

		assertEquals("Adresse mail invalide", Controls.ctlMail("mail@domtld"));

		assertEquals("Adresse mail invalide", Controls.ctlMail("mail@dom.d"));

		assertEquals("Adresse mail invalide", Controls.ctlMail("mail@d.tld"));

	}

}
