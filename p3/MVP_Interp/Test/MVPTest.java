import static org.junit.Assert.*;

import java.io.File;
import java.util.HashSet;

import org.junit.Test;

import Presenter.Presenter;
import View.ConsoleView;
import View.iView;

public class MVPTest {

	@Test
	public void test() {
		ConsoleView myConsole = new ConsoleView();
		HashSet<iView> views = new HashSet<iView>();
		views.add(myConsole);
		Presenter myPresenter = new Presenter(views);
		myConsole.setPresenter(myPresenter);
	
		//PRIMEIRAMENTE ESCOLHEMOS DE QUAL DOS VARIOS VIEWS POSSIVEIS TIRAREMOS NOSSAS INFORMAÇÕES. NO CASO, A FONTE SERA O CONSOLE.
		myPresenter.setDataSource(myConsole);
		
		// ENTRADA DE USUARIO HUMANO: ESCOLHA DO METODO DE INTERPOLACAO	   
		myConsole.setInterpolationMethod("Cubic Spline");
     
		   
		// RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO		   
		myPresenter.getMethodFromSource();
		   
		   
		// ENTRADA DE USUARIO HUMANO: PONTO DE INTERPOLACAO E NOME DO ARQUIVO DE DADOS.		   
		myConsole.setPointOfInterpolation(10.3);
		   
		   
		// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO)		  
		myPresenter.getPointOfInterpolationFromSource();
		   
		   
		// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)		   
		myConsole.setInputFile(new File("dados\\data.dat"));		   
		myPresenter.getFileFromSource();
		   
		   
		assertTrue(myPresenter.calculateResult());
		
		//O teste mostra como cada uma das responsabilidades foi alocada.
		//Ademais, a função calculateResult() retorna true quando é executada com sucesso.Logo, o calculo ocorre corretamente.
	}

}
