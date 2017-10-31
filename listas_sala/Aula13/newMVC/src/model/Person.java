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
		_name = name;
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
	
	private String _name;
	private List<PersonListener> listeners = new ArrayList<PersonListener>();
}
