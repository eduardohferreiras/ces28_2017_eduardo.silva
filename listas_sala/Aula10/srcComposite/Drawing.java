import java.util.ArrayList;

public class Drawing implements Shape {

	@Override
	public void draw(String fillColor) {
		for(Shape shape : list) {
			shape.draw(fillColor);
		}
		
	}
	
	private ArrayList<Shape> list = new ArrayList<Shape>();
	
	public void add(Shape listElement)
	{
		list.add(listElement);
	}
	
	public void clear()
	{
		list.clear();
		System.out.println("Clearing all the shapes from drawing");
	}

}
