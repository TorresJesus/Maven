package prueba;

import beans.InterpreteEspanol;
import beans.Traductor;

public class PruebaInterprete {

	
	public static void main(String[] args) {
		Traductor traductor = new Traductor();
		InterpreteEspanol interprete = new InterpreteEspanol();
		traductor.setInterprete(interprete);
		traductor.setNombre("Carlos Esparza");
		traductor.hablar();
		
	}

}
