package funciones;

import java.util.ArrayList;

public class Funciones {

	public String ArrayListToString(ArrayList<String> AL) {
		
		String res = "";
		
		for(int i = 0; i < AL.size(); i++) {
			res += i + ".- " + AL.get(i) + "\n";
		}
		
		return res;
	}
	
}
