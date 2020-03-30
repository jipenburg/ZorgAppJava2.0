package adsd.app.zorgapp;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class AlarmClock 
{
 
	
	public void checkAlarm(final int a, final int b) 
	{
		Thread t = new Thread() 
		
		{
			public void run() 
			{
				int wl = 0;
				
				while (wl == 0) 
				{
					Calendar c = new GregorianCalendar();
					int hours = c.get(Calendar.HOUR_OF_DAY);
					int mins = c.get(Calendar.MINUTE);
					if (a == hours && b == mins) 
					{
						JOptionPane.showMessageDialog(null, "Time to take your medicine");
						break;
					}
					
					
				}
			}
			
		};
		
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
		
	}
	
}