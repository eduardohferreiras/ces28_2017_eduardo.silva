package pub;


public class Pub {
	
	Pub()
	{
		pubMenu = new Menu();
	}
	
	private Menu pubMenu;

    private void populateMenu()
    {
    	pubMenu.addBeverage("hansa", 74);
    	pubMenu.addBeverage("grans", 103);
    	pubMenu.addBeverage("strongbow", 110);
    	
    	String[] gtIngredientList = {"ginUnit","tonicWaterUnit","greenStuffUnit"};
    	pubMenu.addBeverage("gt",gtIngredientList);
    	
    	String[] bacardiIngredientList = {"ginUnit","rumUnit","grenadineUnit","limeJuiceUnit"};
    	pubMenu.addBeverage("bacardi_special",bacardiIngredientList);
    }
    
    public int computeCost(String drink, boolean student, int amount) {

    	populateMenu();
    
    	
        int price=0;
        boolean find = false;
        
    	if (amount > 2 && (drink == "gt" || drink == "bacardi_special")) 
            throw new RuntimeException("Too many drinks, max 2.");
    	
    	for(int i = 0; i < pubMenu.getBeverageListSize(); i++)
    	{
    		if(drink == pubMenu.getBeverageName(i)) {
    			price = pubMenu.getBeveragePrice(i);
    			find = true;
    		}
    	}
        
    	if(!find)
    		throw new RuntimeException("No such drink exists");
        
    	if (student && (drink == "grans" || drink == "hansa" || drink == "strongbow")) {
            price = (int) (price - Math.ceil(price/10));
        }
        return price*amount;
    		
    }
}
