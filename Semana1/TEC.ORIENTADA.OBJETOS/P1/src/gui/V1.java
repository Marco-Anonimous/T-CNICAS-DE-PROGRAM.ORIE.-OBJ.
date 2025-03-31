package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Empleado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblSueldo;
	private JLabel lblHoras;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtSue;
	private JTextField txtHE;
	private JLabel lblAfiliacin;
	private JLabel lblNewLabel_3;
	private JComboBox cboAreala;
	private JComboBox cboAfilia;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
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
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Área laboral :");
			lblNewLabel.setBounds(25, 109, 76, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Código :");
			lblNewLabel_1.setBounds(25, 61, 76, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Nombre :");
			lblNewLabel_2.setBounds(25, 84, 76, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblSueldo = new JLabel("Sueldo :");
			lblSueldo.setBounds(25, 135, 76, 14);
			contentPane.add(lblSueldo);
		}
		{
			lblHoras = new JLabel("Horas extras :");
			lblHoras.setBounds(25, 160, 86, 14);
			contentPane.add(lblHoras);
		}
		{
			txtCod = new JTextField();
			txtCod.setBounds(111, 58, 103, 20);
			contentPane.add(txtCod);
			txtCod.setColumns(10);
		}
		{
			txtNom = new JTextField();
			txtNom.setColumns(10);
			txtNom.setBounds(111, 81, 103, 20);
			contentPane.add(txtNom);
		}
		{
			txtSue = new JTextField();
			txtSue.setColumns(10);
			txtSue.setBounds(111, 132, 103, 20);
			contentPane.add(txtSue);
		}
		{
			txtHE = new JTextField();
			txtHE.setColumns(10);
			txtHE.setBounds(111, 157, 103, 20);
			contentPane.add(txtHE);
		}
		{
			lblAfiliacin = new JLabel("Afiliación :");
			lblAfiliacin.setBounds(25, 192, 76, 14);
			contentPane.add(lblAfiliacin);
		}
		{
			lblNewLabel_3 = new JLabel("PRÁCTICA I");
			lblNewLabel_3.setBackground(Color.CYAN);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_3.setBounds(225, 11, 76, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			cboAreala = new JComboBox();
			cboAreala.setModel(new DefaultComboBoxModel(new String[] {"Administración", "Sistemas", "Marketing"}));
			cboAreala.setBounds(111, 105, 103, 22);
			contentPane.add(cboAreala);
		}
		{
			cboAfilia = new JComboBox();
			cboAfilia.setModel(new DefaultComboBoxModel(new String[] {"AFP", "SNP"}));
			cboAfilia.setBounds(111, 188, 103, 22);
			contentPane.add(cboAfilia);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 235, 468, 195);
			contentPane.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			btnNewButton_1 = new JButton("Procesar");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(300, 80, 89, 23);
			contentPane.add(btnNewButton_1);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		
		String cod = txtCod.getText();
		String nom = txtNom.getText();
		String arealaboral = cboAreala.getSelectedItem().toString(); //para trabajar con texto
		Double sue = Double.parseDouble(txtSue.getText());
		int he = Integer.parseInt(txtHE.getText());
		int afilia = cboAfilia.getSelectedIndex();
		Empleado e1 = new Empleado(cod, nom, arealaboral, sue, he, afilia);
		Listado(e1);
		
	}
	void Imprimir(String s) {
		txtS.append(s + "\n");
	}
	
	void Listado(Empleado e) {
		Imprimir("\nDATOS DEL USUARIO: \n");
	
		Imprimir("El código es: " + e.getCod());
		Imprimir("El nombre es: " + e.getNom());
		Imprimir("Área laboral: " + e.getArealaboral());
		Imprimir("Sueldo: " + e.getSue());
		
		if (e.getAfilia() == 0) {
			Imprimir("Descuento por AFP: " + e.DsctoAFP());
		}
		else 
		{
			Imprimir("Descuento por SNP: " + e.DsctoSNP());
		}
		Imprimir("Sueldo bruto: " + e.SueldoBruto());
		Imprimir("Suelndo Neto: " + e.SN());
		
		 //AGREGAR EL RESTO COMO MENSAJE
		
	}
	
}










