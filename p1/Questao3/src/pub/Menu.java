package pub;

import java.util.ArrayList;


public class Menu {
	
	Menu()
	{
		ingDB = new IngredientDB();
		populateIngredientList();
	}
	
	
	public void addBeverage(String name, int price)
	{
		beverageList.add(new ReadyBeverage(name,price));
	}
	
	public void removeBeverage(int i)
	{
		beverageList.remove(i);
	}
	
	public void addBeverage(String name, String[] ingredientList)
	{
		beverageList.add(new Drink(name, ingredientList,ingDB));
	}
	
	public int getBeverageListSize()
	{
		return beverageList.size();
	}
	
	public String getBeverageName(int i)
	{
		return beverageList.get(i).getName();
	}
	
	public int getBeveragePrice(int i)
	{
		return beverageList.get(i).getPrice();
	}

	private IngredientDB ingDB;
	
	private ArrayList<iBeverage> beverageList = new ArrayList<iBeverage>();
	
    private void populateIngredientList()
    {
    	ingDB.addIngredient("rumUnit", 65);
    	ingDB.addIngredient("grenadineUnit", 10);
    	ingDB.addIngredient("limeJuiceUnit", 10);
    	ingDB.addIngredient("greenStuffUnit", 10);
    	ingDB.addIngredient("tonicWaterUnit", 20);
    	ingDB.addIngredient("ginUnit", 85);
    	
    }



}


