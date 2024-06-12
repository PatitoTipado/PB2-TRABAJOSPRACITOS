package unlam.pb2.dominio;

public class Rey extends PiezaAjedrez{
	
	public Rey() {
		super();
	}

	@Override
	public String mover() {
		return "puedo moverme a cualquier direccion soy el rey";
	}

	@Override
	public String comer() {
		return "comere la ficha que esta parada";
	}

	@Override
	public String ubicacion() {
		return "" + super.columna + super.fila;
	}
	
	

}
