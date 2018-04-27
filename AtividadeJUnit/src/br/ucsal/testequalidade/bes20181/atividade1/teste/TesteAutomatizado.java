package br.ucsal.testequalidade.bes20181.atividade1.teste;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.ucsal.testequalidade.bes20181.atividade1.business.RegistroNotaBC;
import br.ucsal.testequalidade.bes20181.atividade1.exceptions.NotaInvalidaException;
import br.ucsal.testequalidade.bes20181.atividade1.exceptions.PesoInvalidoException;

class TesteAutomatizado {

	RegistroNotaBC rg = new RegistroNotaBC();

	@Test
	void testeValidarPesoFalseMaiorQue10() {

		try {
			rg.validarPeso(11);
		} catch (PesoInvalidoException e) {
			e.printStackTrace();
		}

		Assert.assertEquals((Object) 1, (Object) rg.auxValidarPeso);
	}

	@Test
	void testeValidarPesoFalseMenorQue1() {

		RegistroNotaBC rg = new RegistroNotaBC();

		try {
			rg.validarPeso(0);
		} catch (PesoInvalidoException e) {
			e.printStackTrace();
		}

		Assert.assertEquals((Object) 1, (Object) rg.auxValidarPeso);
	}

	@Test
	void testeValidarPesoTrue() {
		RegistroNotaBC rg = new RegistroNotaBC();

		try {
			rg.validarPeso(5);
		} catch (PesoInvalidoException e) {
			e.printStackTrace();
		}

		Assert.assertEquals((Object) 0, (Object) rg.auxValidarPeso);
	}

	@Test
	void testeValidarNotaFalseNegativa() {
		try {
			rg.validarNota(-1);
		} catch (NotaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals((Object) 1, (Object) rg.auxValidarNota);
	}

	@Test
	void testeValidarNotaFalseMaiorQue100() {
		try {
			rg.validarNota(101);
		} catch (NotaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals((Object) 1, (Object) rg.auxValidarNota);
	}

	@Test
	void testeValidarNotaTrue() {
		try {
			rg.validarNota(55);
		} catch (NotaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals((Object) 0, (Object) rg.auxValidarNota);
	}

	@Test
	void testeCalcularMedia() {
		Integer atual = rg.calcularMedia(90, 80, 10, 5);
		Integer esperado = 86;
		Assert.assertEquals(esperado, atual);
	}

	@Test
	void testeCalcularConceitoOtimo() {
		String atual = rg.calcularConceito(76);
		String esperado = "Ótimo";
		Assert.assertEquals(esperado, atual);

	}

	@Test
	void testeCalcularConceitoBom() {
		String atual = rg.calcularConceito(55);
		String esperado = "Bom";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	void testeCalcularConceitoRegular() {
		String atual = rg.calcularConceito(48);
		String esperado = "Regular";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	void testeCalcularConceitoInsuficiente() {
		String atual = rg.calcularConceito(20);
		String esperado = "Insuficiente";
		Assert.assertEquals(esperado, atual);
	}

}
