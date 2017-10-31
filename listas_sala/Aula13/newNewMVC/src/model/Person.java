package model;


import java.util.ArrayList;
import java.util.List;

public class Person {
	public interface PersonListener{
		void onPersonNameChanged();
	}
	
	public Person()
	{
	
	}
	
	public Person(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		System.out.println("Ação5: getName");
		return _name;
	}
	
	public void setName(String name)
	{
		
		System.out.println("Ação3: setName");

		boolean hasNonAlpha = name.matches("^.*[^a-zA-z0-9].*$");
		if(!hasNonAlpha && Character.isUpperCase(name.charAt(0)))
				{
					_name = name;
					setNameColor();
					_name = _nameColor + " " + name;
				}
		
		
		fireOnNameChanged();
	}

	public void addListener(PersonListener l)
	{
		this.listeners.add(l);
	}
	
	public void removeListener(PersonListener l)
	{
		this.listeners.remove(l);
	}
	
	private void fireOnNameChanged() {
		for(PersonListener l:this.listeners)
		{
			l.onPersonNameChanged();
		}
	}
	
	private void setNameColor()
	{
		if (_name.length() < 5)
		{
			_nameColor = "VERMELHO";
		}
		else if(_name.length() > 4 && _name.length() < 15)
		{
			_nameColor = "VERDE";
		}
		else
		{
			_nameColor = "AMARELO";
		}
	}
	
	private String _name;
	private String _nameColor;
	private List<PersonListener> listeners = new ArrayList<PersonListener>();
}
