package Ejercicio3;

public class Hilo implements Runnable
{
	public static boolean terminado = false;
	public static int	  progreso  = 0;
	public 		  String  nombreHilo;
	
	public Hilo (String nombre)
	{
		this.nombreHilo = nombre;
	}
	
	@Override
	public void run()
	{
		terminado = false;
		
		for (int i=1; i<100; i++)
		{
			//System.out.println("Hilo.Java PROCESANDO");
			progreso = i;
			
			try
			{
				Thread.sleep(100);
			}catch (InterruptedException e)
			{
				System.out.println("Hilo.Java INTERRUPCION");
			}
		}
		
		terminado = true;
	}
	
}
