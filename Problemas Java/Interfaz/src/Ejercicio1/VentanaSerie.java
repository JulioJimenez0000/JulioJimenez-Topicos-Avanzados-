package Ejercicio1;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaSerie extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JTextField txtIteraciones;
	private JTextArea txtaSerie;

	
	public static void main(String[] args)
	{
		
		VentanaSerie frame = new VentanaSerie();
		frame.setVisible(true);
				
		
	}

	
	public VentanaSerie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		btnSalir.setBounds(318, 212, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnGenerar = new JButton("GENERAR SERIE");
		btnGenerar.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String varNumero1S = txtNum1.getText();
				String varNumero2S = txtNum2.getText();
				String varIteraS   = txtIteraciones.getText();
				String CadenaSerie = " ";
				
				
				int varNumero1I = Integer.parseInt(varNumero1S);
				int varNumero2I = Integer.parseInt(varNumero2S);
				int varIteraI   = Integer.parseInt(varIteraS);
				int Suma        = 0;
				int Recorrido   = 0;
				
				CadenaSerie = CadenaSerie + " " + varNumero1S + "," + varNumero2S;
				
				do
				{
					Suma = varNumero1I + varNumero2I;
					
					CadenaSerie = CadenaSerie + "," + Suma;
					
					varNumero1I = varNumero2I;
					varNumero2I = Suma;
					
					Recorrido++;
				}while(Recorrido<varIteraI);
				
				txtaSerie.setText(CadenaSerie);
				
			}
		});
		btnGenerar.setBounds(252, 164, 155, 23);
		contentPane.add(btnGenerar);
		
		JLabel lblNum1 = new JLabel("PRIMER NUMERO:");
		lblNum1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNum1.setBounds(10, 21, 161, 14);
		contentPane.add(lblNum1);
		
		JLabel lblNum2 = new JLabel("SEGUNDO NUMERO:");
		lblNum2.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNum2.setBounds(10, 73, 161, 14);
		contentPane.add(lblNum2);
		
		JLabel lblIteraciones = new JLabel("NUMERO DE ITERACIONES: ");
		lblIteraciones.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblIteraciones.setBounds(10, 115, 202, 14);
		contentPane.add(lblIteraciones);
		
		txtNum1 = new JTextField();
		txtNum1.setBounds(158, 16, 136, 20);
		contentPane.add(txtNum1);
		txtNum1.setColumns(10);
		
		txtNum2 = new JTextField();
		txtNum2.setBounds(158, 68, 136, 20);
		contentPane.add(txtNum2);
		txtNum2.setColumns(10);
		
		txtIteraciones = new JTextField();
		txtIteraciones.setBounds(208, 110, 86, 20);
		contentPane.add(txtIteraciones);
		txtIteraciones.setColumns(10);
		
		txtaSerie = new JTextArea();
		txtaSerie.setBounds(10, 163, 208, 76);
		contentPane.add(txtaSerie);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				txtNum1.setText("");
				txtNum2.setText("");
				txtIteraciones.setText("");
				txtaSerie.setText(null);
				
			}
		});
		btnLimpiar.setBounds(318, 115, 89, 23);
		contentPane.add(btnLimpiar);
	}
}
