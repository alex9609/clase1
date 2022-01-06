package clase9.oop.intefaces;

public class MainInterfacez {

	public static void main(String[] args) {
		Avion airbus = new Avion();
		Helicoptero blackjack = new Helicoptero();
		Superman man = new Superman();
		
		Volador[] voladores = new Volador[] {airbus,blackjack,man};
		
		for(Volador v: voladores) {
			if(v instanceof Aterrizable) {
				
				
				Aterrizable atr = (Aterrizable)v;
				atr.aterrizar();
			}else {
				System.out.println(v + " No cumple con el contrato");
			}
		}
	}

}
