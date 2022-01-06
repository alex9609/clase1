package clase6oop;

public class Buscador {

	private String claveBusqueda;
	private Articulo[] resultados;
	public Integer unAtributo; //NO SE DEFINEN ATRIBUTOS PUBLICOS SALVO AL DEFINIR UNA CONSTANTE
	
	private Integer cantidadResultados;
	//CONSTRUCTOR 
	public Buscador(){
		System.out.println("Creando el buscador ");
	}

	//Publico permite que un metodo pueda funcionar fuera del paquete

	public void buscar() {
		System.out.println("buscando..." + this.claveBusqueda);

		// como mi buscador necesita usar un objeto de la clase DB
		// debe instanciar un objeto de dicha clase
		DB db = new DB();

		this.resultados = db.consultar(claveBusqueda);
		this.setCantidadResultado(this.resultados.length);
	}
	
	private void setCantidadResultado(int cantidad) {
		if(cantidad < 0){
			this.cantidadResultados = 0;
		}else {
			this.cantidadResultados = cantidad;
		}
		
	}
	
	public Integer getCantidadResultados() {
		if(this.cantidadResultados == null) {
			this.setCantidadResultado(0);
		}
		return this.cantidadResultados;
	}

	void definirClaveBusqueda(String clave) {
		claveBusqueda = clave;
	}
	
	//Combinacion de teclas alt+shift+s

	public void mostrarResultados() {
		if(this.resultados.length > 0) {
			for(Articulo aux : this.resultados ) {
				aux.detalleArticulo();
			}
		}else {
			System.out.println("No hay resultados para " + this.claveBusqueda);
		}
	}

	public String getClaveBusqueda() {
		return claveBusqueda;
	}

	public void setClaveBusqueda(String claveBusqueda) {
		this.claveBusqueda = claveBusqueda;
	}

	public Articulo[] getResultados() {
		return resultados;
	}
}