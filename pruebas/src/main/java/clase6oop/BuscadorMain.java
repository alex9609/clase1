package clase6oop;

public class BuscadorMain {

	public static void main(String[] args) {
		
		Buscador buscador = new Buscador();

		
		String claveDeBusqueda = "iron man";
		buscador.definirClaveBusqueda(claveDeBusqueda);

		buscador.buscar();

		buscador.mostrarResultados();
	}

}
