package app;

import java.util.Scanner;

import relaciones.*;
import funciones.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		boolean seguir = true, bFallo = false;
		Scanner tec = new Scanner(System.in);
		int opcion = 0, perPos = 0;
		String persona, frase;
		ArrayList<Personas> ALPersonas = new ArrayList<Personas>(); 
		ArrayList<String> ALPerPos = new ArrayList<String>(); 
		Personas UnaPersona;
		Personas Oyente;
		
		Funciones fun = new Funciones();
		
		/*loop del programa*/
		
		do {
			
			/*escogiendo la opción*/
			
			do {
				
				/*aquí se encuentra el menú de opciones*/
				
				System.out.println("Opciones: " +
									"\n1.- Añadir persona" +
									"\n2.- Decir algo a otra persona" +
									"\n3.- Decir lo que se ha escuchado" +
									"\n4.- Apagar el programa");
				
				
				try {
					
					opcion = tec.nextInt();
					bFallo = false;
					
				}catch(Exception e) {
					
					System.out.println("¡No se ha introducido un número! Por favor introduzca de nuevo\n");
					bFallo = true; 
					opcion = 0;
					
				}finally {
			        tec.nextLine();
			    }
				
				if((opcion < 1 || opcion > 4) && !bFallo) {
					System.out.println("¡No se ha elegido una opción! Por favor introduzca de nuevo\n");
				}
				
			}while((opcion < 1 || opcion > 4) && bFallo);
			
			switch(opcion) {
			
			case 1:
				
				System.out.println("Introduce el nombre de la persona: ");
				persona = tec.next();
				
				
				//llamando al método para crear un objeto persona
				UnaPersona = new Personas(persona);
				
				// añadiendo a un arraylist de objetos a la persona
				ALPersonas.add(UnaPersona);
				
				// añadiendo el nombre a una lista para luego poder interactuar
				ALPerPos.add(persona);
				
				break;
				
			case 2:
				
				do {
					
					// eligiendo a la persona que ha hablado
					System.out.println("¿Qué persona ha dicho algo? ");
					System.out.println(fun.ArrayListToString(ALPerPos));
					
					try {
						
						perPos = tec.nextInt();
						bFallo = false;
						
					}catch(Exception e) {
						
						System.out.println("¡No se ha introducido un número! Por favor introduzca de nuevo\n");
						bFallo = true; 
						perPos = -1;
						
					}finally {
				        tec.nextLine();
				    }
					
					if((perPos < 0 || perPos > ALPerPos.size() - 1) && !bFallo) {
						System.out.println("¡No se ha elegido una persona! Por favor introduzca de nuevo\n");
						bFallo = true; 
					}
					
				}while((perPos < 0 || perPos > ALPerPos.size() - 1) && bFallo);
				
				// que ha dicho?
				
				System.out.println("¿Qué ha dicho? ");
				frase = tec.next();
				
				UnaPersona = ALPersonas.get(perPos);
				UnaPersona.setFrase(frase);
				
				ALPersonas.set(perPos, UnaPersona);
				
				break;
				
			case 3:
				
				int PosOyente = 0;
				
				do {
					
					// eligiendo a la persona que ha escuchado
					System.out.println("¿Qué persona ha escuchado algo? ");
					System.out.println(fun.ArrayListToString(ALPerPos));
					
					try {
						
						PosOyente = tec.nextInt();
						bFallo = false;
						
					}catch(Exception e) {
						
						System.out.println("¡No se ha introducido un número! Por favor introduzca de nuevo\n");
						bFallo = true; 
						PosOyente = -1;
						
					}finally {
				        tec.nextLine();
				    }
					
					if((PosOyente < 0 || PosOyente > ALPerPos.size() - 1) && !bFallo) {
						System.out.println("¡No se ha elegido una persona! Por favor introduzca de nuevo\n");
					}
					
				}while((PosOyente < 0 || PosOyente > ALPerPos.size() - 1) && bFallo);
				
				do {
					
					// eligiendo a la persona que le ha dicho algo
					System.out.println("¿Qué persona se lo ha dicho? ");
					System.out.println(fun.ArrayListToString(ALPerPos));
					
					try {
						
						perPos = tec.nextInt();
						bFallo = false;
						
					}catch(Exception e) {
						
						System.out.println("¡No se ha introducido un número! Por favor introduzca de nuevo\n");
						bFallo = true; 
						perPos = -1;
						
					}finally {
				        tec.nextLine();
				    }
					
					if((perPos < 0 || perPos > ALPerPos.size() - 1) && !bFallo) {
						System.out.println("¡No se ha elegido una persona! Por favor introduzca de nuevo\n");
					}
					
				}while((perPos < 0 || perPos > ALPerPos.size() - 1) && bFallo);
				
				// ¿Qué le ha dicho?
				
				Oyente = ALPersonas.get(PosOyente);
				UnaPersona = ALPersonas.get(perPos);
				Oyente.setFrase(UnaPersona.getFrase());
				
				ALPersonas.set(PosOyente, Oyente);
				
				System.out.println(ALPerPos.get(perPos) + " le ha dicho a " + ALPerPos.get(PosOyente) + ": " + Oyente.getFrase());
				
				break;
				
			case 4:
				
				//cerrando el programa
				/*aquí se encuentra el menú de opciones*/
				
				System.out.println("Apagando el programa");
				
				seguir = false;
				
				break;
			}
			
		}while(seguir);
		
	}
	
}
