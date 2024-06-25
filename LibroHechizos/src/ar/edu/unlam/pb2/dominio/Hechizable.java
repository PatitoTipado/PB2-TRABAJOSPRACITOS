package ar.edu.unlam.pb2.dominio;

public class Hechizable {

	protected String hechizoAplicado;
	
	public String getEstado() {
		if(hechizoAplicado.equals("enormuvus")) {
			return "Ahora soy más grande";
		}else if(hechizoAplicado.equals("expelliarmus")){
			return "Me desarmaron";
		}else {
			//==null
			//lanza una excepcion de tipo no se aplico hechizo
		}
		return null;
	}

	public void setHechizo(String string) {
		this.hechizoAplicado=string;
	}

}
