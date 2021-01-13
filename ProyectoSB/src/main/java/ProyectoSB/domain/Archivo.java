package ProyectoSB.domain;

public class Archivo {
	private String fecha;
	private int duracion;
	private String destino;
	private String num_origen;
	private String num_destino;	
	private int valor_total;
	private int valor_unidad;
	
	
	public Archivo(String fecha,  String destino, String num_origen, String num_destino, int valor_total,
			int valor_unidad,int duracion) {
		super();
		this.fecha = fecha;
		this.num_origen = num_origen;
		this.num_destino = num_destino;
		this.duracion = duracion;
		this.destino = destino;
		this.valor_total = valor_total;
		this.valor_unidad = valor_unidad;
	}
	public String getNum_origen() {
		return num_origen;
	}
	public void setNum_origen(String num_origen) {
		this.num_origen = num_origen;
	}
	public String getNum_destino() {
		return num_destino;
	}
	public void setNum_destino(String num_destino) {
		this.num_destino = num_destino;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getValor_total() {
		return valor_total;
	}
	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}
	public int getValor_unidad() {
		return valor_unidad;
	}
	public void setValor_unidad(int valor_unidad) {
		this.valor_unidad = valor_unidad;
	}
	
	public Archivo() {
		super();
	}
}
