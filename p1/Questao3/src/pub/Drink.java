package pub;


public class Drink implements iBeverage{
	
	private IngredientDB ingBD;
	private int price;
	private String name;
	private String[] ingList;

	Drink(String name, String[] ingredientList, IngredientDB ingDB){
		this.name = name;
		this.ingBD = ingDB;
		this.ingList = ingredientList;
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		price = 0;
		
    	for(int i = 0; i < ingList.length; i++)
    	{
    		for(int j = 0; j < this.ingBD.getIngListSize() ; j++)
    		{
        		if(ingList[i] == ingBD.getIngName(j))
        		{
        			price += ingBD.getIngPrice(j);
        		}
    		}

    	}
    	return price;
	}
	
}
