package br.com.frtech.bancofr.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.frtech.bancofr.core.Agencia;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private Agencia agencia;
	

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[73px][][]", "[14px][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("BANCO BANCO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel, "cell 0 0,alignx left");
		
		JButton btnTelaDeposito = new JButton("Deposito");
		btnTelaDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeposito td = new TelaDeposito();
				td.setVisible(true);
				td.setAgencia(agencia);
			}
		});
		contentPane.add(btnTelaDeposito, "cell 0 1,growx");
		
		JButton btnTelaSaque = new JButton("Saque");
		btnTelaSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSaque tsa = new TelaSaque();
				tsa.setVisible(true);
				tsa.setAgencia(agencia);
			}
		});
		contentPane.add(btnTelaSaque, "cell 0 2,growx");
		
		JButton btnTelaSaldo = new JButton("Saldo");
		btnTelaSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSaldo tsaldo = new TelaSaldo();
				tsaldo.setVisible(true);
				tsaldo.setAgencia(agencia);
			}
		});
		contentPane.add(btnTelaSaldo, "cell 0 3,growx");
		
		JLabel lblContaPrCadastrada = new JLabel("Contas pré cadastrada para testes");
		contentPane.add(lblContaPrCadastrada, "cell 2 4,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Conta 1: 123");
		contentPane.add(lblNewLabel_1, "cell 2 5");
		
		JLabel lblNewLabel_2 = new JLabel("Conta 2: 321");
		contentPane.add(lblNewLabel_2, "cell 2 6");
	}

}
