package br.com.frtech.bancofr.view;

import br.com.frtech.bancofr.core.Agencia;
import br.com.frtech.bancofr.core.Conta;

public class Principal {

	public static void main(String[] args) {

		//Pequeno banco de dados
		Agencia agencia = new Agencia();
		Conta c1 = new Conta();
		c1.setNumero("123");
		
		Conta c2 = new Conta();
		c2.setNumero("321");
		
		agencia.getContas().add(c1);
		agencia.getContas().add(c2);
		
		//Fim do banco de dados
		
		TelaPrincipal tp = new TelaPrincipal();
		tp.setVisible(true);
		tp.setAgencia(agencia);
	}

}
