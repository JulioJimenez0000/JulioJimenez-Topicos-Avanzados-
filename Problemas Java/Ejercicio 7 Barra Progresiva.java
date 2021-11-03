package Ejercicio3;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JProgessBar extends JFrame 
{
	
	private JProgressBar progressBar;
	private JButton btnIniciar;
	private JButton btnSalir;
	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					JProgessBar frame = new JProgessBar();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public JProgessBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(230, 230, 250));
		progressBar.setFont(new Font("Sitka Small", Font.PLAIN, 17));
		progressBar.setForeground(new Color(0, 0, 205));
		progressBar.setBounds(33, 37, 319, 31);
		contentPane.add(progressBar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		btnSalir.setBackground(new Color(238, 232, 170));
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnSalir.setBounds(392, 53, 126, 29);
		contentPane.add(btnSalir);
		
		btnIniciar = new JButton("INICIAR");
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Hilo objHilo1 = new Hilo("miHilo");
				Thread varHilo1 = new Thread (objHilo1);
				
				ProgesoHilo objHilo2 = new ProgesoHilo (progressBar);
				Thread 		 varHilo2 = new Thread (objHilo2);
				
				varHilo1.start();
				varHilo2.start();
				
				//progressBar.setStringPainted(true);
			}
		});
		btnIniciar.setBackground(new Color(238, 232, 170));
		btnIniciar.setForeground(Color.BLACK);
		btnIniciar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnIniciar.setBounds(392, 11, 126, 31);
		contentPane.add(btnIniciar);
		
		
		setTitle("Barron Jimenez");
	}
	
}
