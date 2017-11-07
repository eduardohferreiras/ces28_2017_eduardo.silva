import model.Automat;
import presenter.Presenter;
import view.ConsoleView;

public class mainConsole {
	public static void main(String[] args) {
		
		
		ConsoleView frame = new ConsoleView();
		Automat automat = new Automat(15,15);
		Presenter presenter = new Presenter(frame,automat);
		frame.init();
		frame.bindTo(presenter);
		frame.setUserInput();
		while(!frame.getUserInput().equals("/exit"))
		{
			if(frame.getUserInput().equals("/next"))
				{
					frame.nextText();
				}
			frame.setUserInput();
		}
	}
}
