
public abstract class TemplateHouse {
	public final void buildHouse(){
		buildFoundation();
	    buildPillars();
	    buildWalls();
	    buildWindows();
		    System.out.println("House is built.");
		}
	
	  private void buildFoundation() {
		    System.out.println("Building foundation with cement,iron rods and sand");
		  }
		  protected abstract void buildPillars();
		  
		  protected abstract void buildWalls();
		  
		  private void buildWindows() {
		    System.out.println("Building Glass Windows");
		  }

}
