package mainPackage;
import Presenter.Cloud;
import View.Drone;
import View.GCS;
public class MainClass {

	public static void main(String[] args) {
		
		
		Drone drone1 = new Drone ("4H_d1",1.0,1.0,1.0);
		Drone drone2 = new Drone ("8H_d2",80.5, 35.7, 6.8);
		Drone drone3 = new Drone ("8H_d3",100.0,87.6,0.0);
		
		GCS gcs1 = new GCS(drone1.getDroneID());
		GCS gcs2 = new GCS(drone2.getDroneID());
		GCS gcs3 = new GCS(drone3.getDroneID());
		
		Cloud cloud = new Cloud(); // Quando da inicializa��o do presenter Cloud, ela j� constroi o UTM_CTR, que � o model.
								   // Podemos ver, pela implementa��o de UTM_CTR que obedecemos o padr�o de projeto Singleton, o que garante
								   // a resolu��o do problema da quest�o 3.
		
		cloud.addDrone(drone1); // � responsabilidade do cloud (Presenter) adicionar os Drones e os CGS (Views)
		cloud.addObserver(gcs1);
		
		cloud.addDrone(drone2);
		cloud.addObserver(gcs2);
		
		cloud.addDrone(drone3);
		cloud.addObserver(gcs3);
		
		
		gcs1.setCloud(cloud);
		gcs2.setCloud(cloud);
		gcs3.setCloud(cloud);
		
		cloud.getAllInfo(); // Nessa linha, o cloud (Presenter) pega o Self Status de todos os Drones (elemento de View)
							// Observemos que a isso condiz com o MVP, uma vez que quem comanda a aquisi��o dos dados � o Presenter.
		
		cloud.refreshSAInfo();// Nessa linha, o cloud(Presenter), atualiza a SAInfo, utilizando para isso o UTM_CTR. Observemos que o
							  // tratamento das informa��es de All Info � de responsabilidade do UTM_CTR (Model), mas � comandado pelo Cloud (Presenter)
						      // condizendo com o MVP.
		
							 // Ap�s o c�lculo da SAInfo, o Presenter, que � um Observable, notifica todos os Observers (GCS) que houve mudan�a, o que executa o m�todo update() em
							 // todos eles. Cada um deles imprime no terminal o que recebeu como SA Info.
							 // Logo, vemos aplicado o Observer/Observable. 
		
	}

}
