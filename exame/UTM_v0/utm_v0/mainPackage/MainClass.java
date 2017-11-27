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
		
		Cloud cloud = new Cloud(); // Quando da inicialização do presenter Cloud, ela já constroi o UTM_CTR, que é o model.
								   // Podemos ver, pela implementação de UTM_CTR que obedecemos o padrão de projeto Singleton, o que garante
								   // a resolução do problema da questão 3.
		
		cloud.addDrone(drone1); // é responsabilidade do cloud (Presenter) adicionar os Drones e os CGS (Views)
		cloud.addObserver(gcs1);
		
		cloud.addDrone(drone2);
		cloud.addObserver(gcs2);
		
		cloud.addDrone(drone3);
		cloud.addObserver(gcs3);
		
		
		gcs1.setCloud(cloud);
		gcs2.setCloud(cloud);
		gcs3.setCloud(cloud);
		
		cloud.getAllInfo(); // Nessa linha, o cloud (Presenter) pega o Self Status de todos os Drones (elemento de View)
							// Observemos que a isso condiz com o MVP, uma vez que quem comanda a aquisição dos dados é o Presenter.
		
		cloud.refreshSAInfo();// Nessa linha, o cloud(Presenter), atualiza a SAInfo, utilizando para isso o UTM_CTR. Observemos que o
							  // tratamento das informações de All Info é de responsabilidade do UTM_CTR (Model), mas é comandado pelo Cloud (Presenter)
						      // condizendo com o MVP.
		
							 // Após o cálculo da SAInfo, o Presenter, que é um Observable, notifica todos os Observers (GCS) que houve mudança, o que executa o método update() em
							 // todos eles. Cada um deles imprime no terminal o que recebeu como SA Info.
							 // Logo, vemos aplicado o Observer/Observable. 
		
	}

}
