package Presenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;
import java.util.Vector;

import Model.CubicSpline;
import Model.InterpolationMethod;
import Model.Lagrange;


import View.iView;;

public class Presenter extends Observable{
	
	
	private InterpolationMethod interpolationModel;
    private FileReader input;
    private BufferedReader bufRead;
    private StringTokenizer xy;
    private double _value, result;
    private File _file;
    private Vector<Double> x, y;
    private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private iView _dataSource;
    
    ///
    private HashMap<String,InterpolationMethod> availableMethods;

	
	public Presenter(HashSet<iView> observers) {
		for(iView view: observers)
		{
			addObserver((Observer) view);
		}
		
		//////
		availableMethods = new HashMap<String,InterpolationMethod>();
		availableMethods.put(CS_METHOD, new CubicSpline());
		availableMethods.put(L_METHOD, new Lagrange());
		//Caso queiramos adicionar um novo método, só precisamos implementa-lo em model e dar um adicionar uma instancia dele ao mapa avaliableMethods
		//utilizando como key, o nome que disponibilizaremos para o usuario.
	}
    
    private void buildDataPoints(File file) {
        if(file == null)
           return;
        else _file = file;

        x = new Vector<Double>();
        y = new Vector<Double>();
        try {
            input = new FileReader(_file);
		    /* Filter FileReader through a Buffered read to read a line at a time */
            bufRead = new BufferedReader(input);
            // Read first line
            String line = bufRead.readLine();
            // Read through file one line at time.
            while (line != null){
                xy = new StringTokenizer(line, "\t ");
                while(xy.hasMoreTokens()) {
                    x.addElement(Double.parseDouble(xy.nextToken()));
                    y.addElement(Double.parseDouble(xy.nextToken()));
                }
                line = bufRead.readLine();
            }
            bufRead.close();
        } catch (IOException e) { // If another exception is generated, print a stack trace
            e.printStackTrace();
        }

	}
	
    public boolean calculateResult() { // O método retorna true se ele consegue calcular e notificar todos os observadores.
        buildDataPoints(_file);
        if(getMethod() != null) {
            result = getMethod().calculateResult(_value, x, y);
            setChanged();
            notifyObservers();
            return true;
        } else {
            System.out.println("It is not defined an interpolation method.");
            return false;
        }
    }
    
    public InterpolationMethod getMethod() { return interpolationModel; }
    
    public void getMethodFromSource() {
        
    	String method = _dataSource.getInterpolationMethod();
    	
    	if(availableMethods.containsKey(method))
    	{
    		interpolationModel = availableMethods.get(method);
    	}
    	else
    	{
    		System.out.println("Unknown method " + method);
    	}
    	
    }
    
    public void getPointOfInterpolationFromSource()
    {
    	_value = _dataSource.getPointOfInterpolation();
    }
    
    public void getFileFromSource()
    {
    	_file = _dataSource.getInputFile();
    }
    
    public double getResult()
    {
    	return result;
    }
    
    public double getUsedPointOfInterpolation()
    {
    	return _value;
    }
    
    public File getUsedDataFile()
    {
    	return _file;
    }
    
    public void setDataSource(iView dataSource) //Seleciona de qual das varias views possiveis nos retiraremos os dados (value, file, etc...)
    {
    	_dataSource = dataSource;
    }

}
