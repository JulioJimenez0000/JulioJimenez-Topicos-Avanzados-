package BarraProgresiva;

import javax.swing.JProgressBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EjercicioHiloProgreso implements Runnable
{
	private JProgressBar barra;
	private JPanel contentPane;
	
	
	public EjercicioHiloProgreso (JProgressBar BarraVentana)
	{
		this.barra = BarraVentana;
	}
	
	@Override
	public void run()
	{
		while (!Hilo.terminado)
		{
			//System.out.println("ProgresoHilo.Java PROGRESO");
			
			barra.setValue(Hilo.progreso);
			barra.repaint();
			
			if (Hilo.terminado)
			{
				barra.setValue(100);
				JOptionPane.showMessageDialog(contentPane, "La carga termino");;
				//System.out.println("ProgesoHilo.Java TERMINADO");
				
				break;
			}
		}
	}
		
	
}
