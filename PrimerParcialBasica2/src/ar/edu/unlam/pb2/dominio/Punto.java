package ar.edu.unlam.pb2.dominio;

public class Punto {
	
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	private Double x;
	private Double y;
	
	public Double getX() {
		return x;
	}
	public void moverEnX(Double double1) {
		this.x += double1;
	}
	public Double getY() {
		return y;
	}
	public void moverEnY(Double y) {
		this.y += y;
	}
	
	public Punto(Double x, Double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	

}
