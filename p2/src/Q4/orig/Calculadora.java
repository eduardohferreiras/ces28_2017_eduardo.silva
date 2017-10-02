package Q4.orig;

import java.util.Iterator;

public class Calculadora {
	
	public float calcularValorTotalDespesas(Iterator<Despesa> iteradorDespesas)
	{
		float valorTotalDespesas = 0.0f;
		while (iteradorDespesas.hasNext()) 
		{
			Despesa desp = iteradorDespesas.next();
			float valorDespesa = desp.getValorDespesa();
			valorTotalDespesas+= valorDespesa;
		}
		return valorTotalDespesas;
	}

}
