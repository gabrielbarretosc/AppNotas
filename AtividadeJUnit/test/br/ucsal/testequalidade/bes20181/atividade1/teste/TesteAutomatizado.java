package br.ucsal.testequalidade.bes20181.atividade1.teste;

import org.junit.Assert;
import org.junit.Test;

import br.ucsal.testequalidade.bes20181.atividade1.business.RegistroNotaBC;
import br.ucsal.testequalidade.bes20181.atividade1.exceptions.NotaInvalidaException;
import br.ucsal.testequalidade.bes20181.atividade1.exceptions.PesoInvalidoException;

public class TesteAutomatizado {

	RegistroNotaBC rg = new RegistroNotaBC();

	@Test(expected = PesoInvalidoException.class)
	public void testeValidarPesoFalseMaiorQue10() throws PesoInvalidoException {

		rg.validarPeso(11);
	}

	@Test(expected = PesoInvalidoException.class)
	public void testeValidarPesoFalseMenorQue1() throws PesoInvalidoException {

		RegistroNotaBC rg = new RegistroNotaBC();

		rg.validarPeso(0);

	}

	@Test
	public void testeValidarPesoTrue() throws PesoInvalidoException {
		RegistroNotaBC rg = new RegistroNotaBC();

		rg.validarPeso(5);
		

	}

	@Test(expected = NotaInvalidaException.class)
	public void testeValidarNotaFalseNegativa() throws NotaInvalidaException {

		rg.validarNota(-1);

	}

	@Test(expected = NotaInvalidaException.class)
	public void testeValidarNotaFalseMaiorQue100() throws NotaInvalidaException {

		rg.validarNota(101);

	}

	@Test
	public void testeValidarNotaTrue() throws NotaInvalidaException {

		rg.validarNota(55);

	}

	@Test
	public void testeCalcularMedia() {
		Integer atual = rg.calcularMedia(90, 80, 10, 5);
		Integer esperado = 86;
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void testeCalcularConceitoOtimo() {
		String atual = rg.calcularConceito(76);
		String esperado = "Ótimo";
		Assert.assertEquals(esperado, atual);

	}

	@Test
	public void testeCalcularConceitoBom() {
		String atual = rg.calcularConceito(55);
		String esperado = "Bom";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void testeCalcularConceitoRegular() {
		String atual = rg.calcularConceito(48);
		String esperado = "Regular";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void testeCalcularConceitoInsuficiente() {
		String atual = rg.calcularConceito(20);
		String esperado = "Insuficiente";
		Assert.assertEquals(esperado, atual);
	}

}
