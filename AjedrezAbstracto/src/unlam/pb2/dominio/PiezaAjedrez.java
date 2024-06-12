package unlam.pb2.dominio;

public abstract class PiezaAjedrez {

	private Boolean estaViva;
	private Integer contadorPiezaComida;
	protected Character columna = 64;
	protected Integer fila=1;

	public PiezaAjedrez() {
		super();
		this.contadorPiezaComida = 0;
		this.estaViva = true;
		columna++;
		fila++;
	}

	public abstract String mover();

	public abstract String comer();

	//podria no ser abstracto y manejar que se creen en una ubicacion especifica
	public abstract String ubicacion();

	public void sumarPiezaComida() {
		contadorPiezaComida++;
	}

	public Boolean getEstaViva() {
		return this.estaViva;
	}

}
