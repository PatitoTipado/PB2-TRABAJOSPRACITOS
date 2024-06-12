package unlam.pb2.dominio;

public class Peon extends PiezaAjedrez {

	public Peon() {
		super();
	}

	@Override
	public String mover() {
		return "me muevo en diagonal";
	}

	@Override
	public String comer() {
		return "comere la ficha que esta parada";
	}

	@Override
	public String ubicacion() {
		return "" + super.columna + super.fila ;
	}

}
