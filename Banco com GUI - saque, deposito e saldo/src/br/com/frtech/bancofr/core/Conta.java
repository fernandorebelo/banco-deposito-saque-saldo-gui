package br.com.frtech.bancofr.core;

import java.util.Objects;

import javax.swing.JOptionPane;

public class Conta {

	private String numero;
	private double saldo;
	
	public Conta() {
		this.saldo = 0;
	}
	
	public String depositar(double deposito) {
		if(deposito > 0) {
			int confirma = JOptionPane.showConfirmDialog(null, "Confirmar operação?");
			if(confirma == 0) {
				this.saldo += deposito;
				return "Depósito realizado";
			}else {
				return "Operação cancelada.";
			}
		}else {
			return "Valor inválido. Tem que ser maior que zero.";
		}
	}
	
	public String sacar(double saque) {
		if(saque >= this.saldo) {
			int confirma = JOptionPane.showConfirmDialog(null, "Confirmar operação?");
			if(confirma == 0) {
				this.saldo -= saque;
				return "Saque realizado.";
			}else {
				return "Operação cancelada.";
			}
		}else {
			return "Saldo inválido.";
		}
		
	}
	
	//Encapsulamento dos atributos
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(numero, other.numero);
	}
	
}
