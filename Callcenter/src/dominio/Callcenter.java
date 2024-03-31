package dominio;

public class Callcenter {

	private String nombre;
	private Contacto[] agendaContactos;
	private LLamada[] llamadas;

	public Callcenter(Integer cantidadDeContactos, Integer cantidadDeLLamadasMaximas) {

		this.nombre = "Oeste Cable color";
		this.agendaContactos = new Contacto[cantidadDeContactos];
		this.llamadas = new LLamada[cantidadDeLLamadasMaximas];

	}

	public String getNombre() {

		return nombre;
	}

	public boolean ingresarContactos(Contacto contactoNuevo) {

		Boolean sePudo = false;
		Integer indice = 0;

		if (sePuedeIngresarContacto(contactoNuevo)) {

			while (!sePudo && indice < agendaContactos.length) {

				if (agendaContactos[indice] == null) {
					agendaContactos[indice] = contactoNuevo;
					sePudo = true;
				}

				indice++;

			}

		}

		return sePudo;
	}

	public Integer getCantidadDeContactosTotales() {

		Integer contador = 0;
		for (int i = 0; i < agendaContactos.length; i++) {
			if (agendaContactos[i] != null) {
				contador++;
			}
		}

		return contador;
	}

	public Integer getCantidadDeLlamadas() {

		Integer contador = 0;

		for (int i = 0; i < llamadas.length; i++) {
			if (llamadas[i] != null) {
				contador++;
			}
		}

		return contador;
	}

	public boolean realizarUnaLLamada() {

		Boolean sePudo = false;

		Contacto contactoAContactar = buscarContactoAContactar();

		if (siSePuedeRealizarLaLlamada(contactoAContactar)) {

			sePudo = agregarNuevaLLamada(contactoAContactar);

		}

		return sePudo;

	}

	private boolean siSePuedeRealizarLaLlamada(Contacto contactoAContactar) {
		return contactoAContactar != null && existe(contactoAContactar.getCelular()) && siSePuedeAgendarLLamadas();
	}

	private boolean siSePuedeAgendarLLamadas() {
		Boolean sePuede = false;
		Integer indice = 0;

		while (!sePuede && indice < llamadas.length) {

			if (llamadas[indice] == null) {
				sePuede = true;
			}

			indice++;

		}

		return sePuede;

	}

	private Contacto buscarContactoAContactar() {

		Contacto buscarContactoQueNoSeaCliente = null;
		Integer indice = 0;

		while (buscarContactoQueNoSeaCliente == null && indice < agendaContactos.length) {

			if (siSePuedeContactar(indice)) {
				buscarContactoQueNoSeaCliente = agendaContactos[indice];
			}

			indice++;

		}

		return buscarContactoQueNoSeaCliente;
	}

	private boolean siSePuedeContactar(Integer indice) {
		return agendaContactos[indice] != null && !agendaContactos[indice].isCliente()
				&& agendaContactos[indice].isDeseaSerLlamadoNuevamente();
	}

	private boolean agregarNuevaLLamada(Contacto contactoALlamar) {
		Boolean sePudo = false;
		Integer indice = 0;

		if (contactoALlamar != null && contactoALlamar.isDeseaSerLlamadoNuevamente()) {

			while (!sePudo && indice < llamadas.length) {

				if (llamadas[indice] == null) {
					llamadas[indice] = new LLamada(contactoALlamar);
					sePudo = true;
				}

				indice++;

			}

		}

		return sePudo;
	}

	private boolean sePuedeIngresarContacto(Contacto contactoNuevo) {
		return contactoNuevo != null && !existe(contactoNuevo.getCelular())
				&& contieneDatosValidos(contactoNuevo.getCelular(), contactoNuevo.getEmail());
	}

	private boolean existe(Integer numeroCelular) {
		Boolean existe = false;
		Integer indice = 0;
		while (!existe && indice < agendaContactos.length) {

			if (agendaContactos[indice] != null && agendaContactos[indice].getCelular().equals(numeroCelular)) {
				existe = true;
			}

			indice++;

		}

		return existe;
	}

	private boolean contieneDatosValidos(Integer telefono, String email) {
		return contieneLonguitudApropiada(telefono) && isEmailValido(email);
	}

	private boolean contieneLonguitudApropiada(Integer telefono) {

		Integer longituApropiada = 10000000;

		return telefono > longituApropiada;
	}

	private boolean isEmailValido(String email) {
		return email.contains("@") && email.endsWith(".com");
	}

}
