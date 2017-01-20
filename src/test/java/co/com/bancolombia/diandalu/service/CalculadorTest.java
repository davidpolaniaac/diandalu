package co.com.bancolombia.diandalu.service;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import co.com.bancolombia.diandalu.service.Calculador;

public class CalculadorTest {
	@Test
	public void CuandoLeEnvie4y2MeDebeDevolver6(){
		//arrange
		Calculador calculador=new Calculador();
		//act
		int resultado=Integer.parseInt(calculador.sumarValores(2,4));
		//assert
		Assert.assertEquals(6, resultado);
	}

	@Test
	public void CuandoLeEnvieUnNumeroAyElNumeroBMeDebeDevolverLaSuma(){
		//arrange
		Random ran=new Random();
		int aleatorio1= ran.nextInt();
		int aleatorio2= ran.nextInt();
		Calculador calculador=new Calculador();
		//act
		int resultado=Integer.parseInt(calculador.sumarValores(aleatorio1,aleatorio2));
		//assert
		Assert.assertEquals(aleatorio1+aleatorio2, resultado);
	}
}
