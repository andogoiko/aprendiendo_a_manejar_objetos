package relaciones;

public class Personas {

	private String frase, nombre;
	
	/*este método crea una persona*/
	
	public Personas(String Nombre) {
		nombre = this.nombre;
	}
	
	/*este método guarda la frase que le ha dicho una persona a otra*/
	
	public void setFrase(String frase) {
		frase = this.frase;
		System.out.println(frase);
	}
	
	/*este método devuelve la frase que ha dicho una persona*/
	
	public String getFrase() {
		
		return frase;
	}
}
