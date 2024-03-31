package dominio;

public class LLamada {

	private static final int NO_QUIERO_SER_CLIENTE = 0;
	private static final int QUIERO_SER_CLIENTE = 1;
	private Double duracion;
	private Contacto contactoALlamar;

	public LLamada(Contacto contactoALlamar) {
		this.duracion = aniadirDuracionRamdon();
		this.contactoALlamar = contactoALlamar;
		quisoSerCliente();
	}

	public Boolean quisoSerCliente() {
		Integer quisoSerCliente = (int) (Math.random() * 2);

		if (quisoSerCliente.equals(NO_QUIERO_SER_CLIENTE)) {

			this.contactoALlamar.quieroSerCliente();
			this.contactoALlamar.quieroSerLlamado();

		} else if (quisoSerCliente.equals(QUIERO_SER_CLIENTE)) {

			this.contactoALlamar.quieroDejarDeSerLlamado();

		}

		return quisoSerCliente.equals(quisoSerCliente);
	}

	private Double aniadirDuracionRamdon() {

		return Math.random() * 1000;
	}

	public Double getDuracion() {
		return duracion;
	}

	public Contacto getContactoALlamar() {
		return contactoALlamar;
	}

}
