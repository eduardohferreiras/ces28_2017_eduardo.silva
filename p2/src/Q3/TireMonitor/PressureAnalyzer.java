package Q3.TireMonitor;

public class PressureAnalyzer {
    
	PressureAnalyzer(Sensor sensor ,Alarm alarm ,double LowPressureThreshold, double HighPressureThreshold)
	{
		_alarm = alarm;
		_LowPressureThreshold = LowPressureThreshold;
	    _HighPressureThreshold = HighPressureThreshold;
	    _sensor = sensor;
	}
	
	Alarm _alarm;
	Sensor _sensor; 
	private double _LowPressureThreshold;
    private double _HighPressureThreshold;
	
    //Foram criados getters e setters para os Thresholds pois � cab�vel que esses valores sejam mudados e consultados durante a execu��o.
    public double getLowPressureThreshold() {
		return _LowPressureThreshold;
	}
	
    public void setLowPressureThreshold(double lowPressureThreshold) {
		_LowPressureThreshold = lowPressureThreshold;
	}
	
    public double getHighPressureThreshold() {
		return _HighPressureThreshold;
	}
	
    public void setHighPressureThreshold(double highPressureThreshold) {
		_HighPressureThreshold = highPressureThreshold;
	}
    
    //Passando a verifica��o para uma classe especialista nisso, podemos isolar no alarme somento os comportamentos esperados de um alarme real.
    //Explicando melhor: n�o se espera que um alarme real fa�a essa verifica��o, somente mantenha informa��o sobre seu estado (ligado, desligado, volume do sinal de alerta, dura��o do sinal de alerta, etc...)
    public void check()
    {
        double psiPressureValue = _sensor.popNextPressurePsiValue();

        if (psiPressureValue < _LowPressureThreshold || _HighPressureThreshold < psiPressureValue)
        {
            _alarm.turnAlarmOn();
        }
    }
}
