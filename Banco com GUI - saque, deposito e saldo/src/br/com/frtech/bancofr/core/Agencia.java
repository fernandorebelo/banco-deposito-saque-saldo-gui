package br.com.frtech.bancofr.core;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

	private List<Conta> contas;

	public Agencia() {
		this.contas = new ArrayList<Conta>();
	}
	
	public Conta buscarContaPorNumero(String numero) {
		for (Conta conta : contas) {
			if(conta.getNumero().equals(numero)) {
				return conta;
			}
		}
		return null;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
}
