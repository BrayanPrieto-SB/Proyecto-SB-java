package ProyectoSB.domain;

public class Resumen {
	private String nombre;
	private Long minutos;
	private Long valor;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getMinutos() {
		return minutos;
	}
	public void setMinutos(Long minutos) {
		this.minutos = minutos;
	}
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	public Resumen(String nombre, Long minutos, Long valor) {
		super();
		this.nombre = nombre;
		this.minutos = minutos;
		this.valor = valor;
	}
	public Resumen() {
		super();
	}
	@Override
	public String toString() {
		return "Resumen [nombre=" + nombre + ", minutos=" + minutos + ", valor=" + valor + "]";
	}
}
