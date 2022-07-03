package br.com.frtech.bancofr.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.frtech.bancofr.core.Agencia;
import br.com.frtech.bancofr.core.Conta;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSaque extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNumeroConta;
	private JTextField textFieldValorSaque;
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
					TelaSaque frame = new TelaSaque();
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
	public TelaSaque() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("SAQUE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Número da Conta");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx left");
		
		textFieldNumeroConta = new JTextField();
		contentPane.add(textFieldNumeroConta, "cell 1 1,growx");
		textFieldNumeroConta.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor do Saque");
		contentPane.add(lblNewLabel_2, "cell 0 2,alignx left");
		
		textFieldValorSaque = new JTextField();
		contentPane.add(textFieldValorSaque, "cell 1 2,growx");
		textFieldValorSaque.setColumns(10);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double saque = Double.parseDouble(textFieldValorSaque.getText());
					String numero = textFieldNumeroConta.getText();
					Conta conta = agencia.buscarContaPorNumero(numero);
					if(textFieldNumeroConta.getText().isBlank() || textFieldValorSaque.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Insira um valor nos espaços em branco.");
					}else {
						if(conta != null) {
							JOptionPane.showMessageDialog(null, agencia.buscarContaPorNumero(numero).sacar(saque));
						}else {
							JOptionPane.showMessageDialog(null, "Conta inexistente.");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Insira um valor válido nos espaços em branco.");
				}
			}
		});
		contentPane.add(btnSacar, "cell 1 3,alignx left");
	}

}
