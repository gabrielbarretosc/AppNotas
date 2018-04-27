package br.ucsal.testequalidade.bes20181.atividade1.teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.ucsal.testequalidade.bes20181.atividade1.business.RegistroNotaBC;
import br.ucsal.testequalidade.bes20181.atividade1.exceptions.NotaInvalidaException;
import br.ucsal.testequalidade.bes20181.atividade1.exceptions.PesoInvalidoException;

class TesteAutomatizado {

	RegistroNotaBC rg = new RegistroNotaBC();

	@Test
	void testeValidarPesoFalse() {

		RegistroNotaBC rg = new RegistroNotaBC();

		try {
			rg.validarPeso(11);
		} catch (PesoInvalidoException e) {
			e.printStackTrace();
		}
			
		Assert.assertEquals((Object)1,(Object)rg.auxValidarPeso);
	}

	@Test
	void testeValidarPesoTrue() {
		RegistroNotaBC rg = new RegistroNotaBC();

		try {
			rg.validarPeso(5);
		} catch (PesoInvalidoException e) {
			e.printStackTrace();
		}
			
		Assert.assertEquals((Object)0,(Object)rg.auxValidarPeso);
	}
		
		@Test
		void testeValidarNotaFalseNegativo() {
			try {
				rg.validarNota(-1);
			} catch (NotaInvalidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Assert.assertEquals((Object)1,(Object)rg.auxValidarNota);
		}

		@Test
		void testeValidarNotaMaiorQue100() {
		try {
			rg.validarNota(101);
		} catch (NotaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals((Object)1,(Object)rg.auxValidarNota);
	}
		
		@Test
		void testeValidarNotaTrue() {
			try {
				rg.validarNota(55);
			} catch (NotaInvalidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertEquals((Object)0,(Object)rg.auxValidarNota);
		}
		
		
	@Test
	void testeCalcularMedia() {
		Integer atual = rg.calcularMedia(90, 80, 10, 5);
		Integer esperado = 86;
		Assert.assertEquals(atual, esperado);
	}

	@Test
	void testeCalcularConceitoOtimo() {
		String atual = rg.calcularConceito(76);
		String esperado = "Ótimo";

		Assert.assertEquals(atual, esperado);

	}

	@Test
	void testeCalcularConceitoBom() {
		String atual = rg.calcularConceito(55);
		String esperado = "Bom";
		Assert.assertEquals(atual, esperado);
	}

	@Test
	void testeCalcularConceitoRegular() {
		String atual = rg.calcularConceito(48);
		String esperado = "Regular";
		Assert.assertEquals(atual, esperado);
	}

	@Test
	void testeCalcularConceitoInsuficiente() {
		String atual = rg.calcularConceito(20);
		String esperado = "Insuficiente";
		Assert.assertEquals(atual, esperado);
	}

}
