package Q3.TireMonitor;


public class Alarm
{
	
    Sensor sensor = new Sensor();

    private boolean alarmOn = false;
    
    public void turnAlarmOn() {
    	alarmOn = true;
	}

    public void turnAlarmOff() {
    	alarmOn = false;
	}
    
    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}