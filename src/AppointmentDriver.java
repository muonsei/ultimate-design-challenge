import javax.swing.*;

public class AppointmentDriver
{
	public static void main(String[] args)
	{
		Runnable application = new Runnable()
		{
			public void run()
			{
				AppointmentProgram ap = new AppointmentProgram();
			}
		};
		
		SwingUtilities.invokeLater(application);
	}
}