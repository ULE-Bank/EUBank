package es.unileon.ulebankoffice.domain;
import java.util.ArrayList;
import java.util.List;

public class TAE extends Operation {
	
	private double tipoInteres;
	private int tipoPeriodo;
	
	public TAE(double i, int p) {
		this.tipoInteres = i / 100.0;
		this.tipoPeriodo = p;
	}

	public List<List<String>> calcularTabla() {
		double ip = tipoInteres / tipoPeriodo;
        
        double resultado = Math.pow(1+ip, tipoPeriodo) - 1;
        resultado = resultado * 100;
        
        List<List<String>> tabla = new ArrayList<>();
		List<String> itemTabla = new ArrayList<>();
		
		itemTabla.add(Double.toString(tipoInteres*100.0) + " %");
		itemTabla.add(Integer.toString(tipoPeriodo));
		itemTabla.add(Double.toString(round(resultado)) + " %");
		
		tabla.add(itemTabla);
		
		return tabla;
	}

	public double getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres / 100.0;
	}

	public int getTipoPeriodo() {
		return tipoPeriodo;
	}

	public void setTipoPeriodo(int tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}
}
