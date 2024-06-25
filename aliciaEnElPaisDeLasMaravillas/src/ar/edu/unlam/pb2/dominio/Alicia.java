package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class Alicia {

	private static final double ALTURA_MAXIMA = 280;
	private static final double ALTURA_MINIMA = 50;
	private Double altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double saldo;
	private ArrayList<Alimento> alimentos = new ArrayList<>();

	public Alicia(Double saldoInicial) {
		// ya que peso no lo usaremos lo hardcodeare
		this.altura = 180.0;
		this.peso = 40.0;
		this.nombre = "alicia";
		this.edad = 32;
		this.saldo = saldoInicial;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void pagarAlimento(Double valor) {
		this.saldo -= valor;
	}

	public Boolean adquirirAlimento(Alimento alimento) {
		return alimentos.add(alimento);
	}

	public Double getAltura() {
		return this.altura;
	}

	public Boolean consumirAlimentoAgrandador(Alimento alimento) throws NoPuedeAgrandarseMasExeptions {
		if (alimentos.contains(alimento)) {
			if (puedeConsumirloAgrandador(alimento)) {
				agrandar(alimento.habilidad());
				return alimentos.remove(alimento);
			}
		}
		throw new NoPuedeAgrandarseMasExeptions();
	}

	private boolean puedeConsumirloAgrandador(Alimento alimento) {
		return "agrandador".equals(alimento.tipoDeAlimento()) && this.puedeAgrandarse(alimento.habilidad());
	}

	private void agrandar(Double cantidadCentimetros) {
		this.altura += cantidadCentimetros;
	}

	private boolean puedeAgrandarse(Double cantidadCentimetros) {
		Boolean puede = false;
		if (cantidadCentimetros + this.altura < ALTURA_MAXIMA) {
			puede = true;
		}
		return puede;
	}

	public Boolean consumirAlimentoAchicador(Achicador alimento) throws NoPuedeAchicarseMasExeptions {
		if (alimentos.contains(alimento)) {
			if (puedeConsumirloAchicador(alimento)) {
				achicar(alimento.habilidad());
				return alimentos.remove(alimento);
			}
		}
		throw new NoPuedeAchicarseMasExeptions();
	}

	private void achicar(Double cantidadCentimetros) {
		this.altura -= cantidadCentimetros;
	}

	private boolean puedeConsumirloAchicador(Alimento alimento) {
		return "achicador".equals(alimento.tipoDeAlimento()) && this.puedeAchicarse(alimento.habilidad());
	}

	private boolean puedeAchicarse(Double cantidadCentimetros) {
		Boolean puede = false;
		if (ALTURA_MINIMA < this.altura - cantidadCentimetros) {
			puede = true;
		}
		return puede;
	}

	public static double getAlturaMaxima() {
		return ALTURA_MAXIMA;
	}

	public static double getAlturaMinima() {
		return ALTURA_MINIMA;
	}

	public Double getPeso() {
		return peso;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public ArrayList<Alimento> getAlimentos() {

		Collections.sort(alimentos);

		return alimentos;
	}

}
