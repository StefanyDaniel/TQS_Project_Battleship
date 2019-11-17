import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		char opcion = '\0';
		
		System.out.println("Menu del juego");
		
		Scanner userInput = new Scanner(System.in);
		
		do {
			System.out.println("1. Nueva partida");
			System.out.println("2. Nueva partida con configuracion de barcos aleatoria");//Hacer, si da tiempo
			System.out.println("3. Cargar partida");//Hacer, si da tiempo
			System.out.println("4. Guardar partida");//Hacer, si da tiempo
			System.out.println("5. Salir");
			System.out.print("Introduce una opcion: ");
			
			switch(opcion) {
			case '1':
				Partida p = new Partida(opcion);
				break;
				
			case '2':
				break;
			
			case '3':
				break;
				
			case '4':
				break;
				
				default:
					System.out.println("Introduce una opcion de las que muestra el menu!");
			}
			
			opcion = userInput.next().charAt(0);
		} while(opcion != 5);
		
		userInput.close();
		
		//userInput.close();
	}

}
