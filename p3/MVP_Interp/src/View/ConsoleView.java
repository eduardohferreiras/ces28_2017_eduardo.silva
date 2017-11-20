package View;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import Presenter.Presenter;

public  class ConsoleView implements Observer,iView{
	
	private String interpolationMethodName;
	private File inputFile;
	private double pointOfInterpolation;
	private Presenter presenter;
	
	public void setInterpolationMethod(String value)
	{
		this.interpolationMethodName = value;
	}

	public void setPointOfInterpolation(double value)
	{
		this.pointOfInterpolation = value;
	}
	
	public void setInputFile(File value)
	{
		this.inputFile = value;
	}
	
	public void setPresenter(Presenter value)
	{
		this.presenter = value;
	}
	
	
	
    private void printResult() {
    	System.out.println("***********************");
    	System.out.println("DataFile: " + presenter.getUsedDataFile());
    	System.out.println("Interp at " + presenter.getUsedPointOfInterpolation() + " ; result = " + presenter.getResult());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.printResult();
	}

	@Override
	public String getInterpolationMethod() {
		return interpolationMethodName;
	}

	@Override
	public double getPointOfInterpolation() {
		return pointOfInterpolation;
	}

	@Override
	public File getInputFile() {
		return inputFile;
	}

	
	
}
