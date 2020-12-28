package ProyectoSB.domain;

public class EmpTelLocal {

	private Long empTelLocal_nit;
	private String nombre;
	private String correo;
	private int valor_minuto;
	
	public Long getEmpTelLocal_nit() {
		return empTelLocal_nit;
	}
	public void setEmpTelLocal_nit(Long empTelLocal_nit) {
		this.empTelLocal_nit = empTelLocal_nit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getValor_minuto() {
		return valor_minuto;
	}
	public void setValor_minuto(int valor_minuto) {
		this.valor_minuto = valor_minuto;
	}
	public EmpTelLocal(Long empTelLocal_nit, String nombre, String correo, int valor_minuto) {
		super();
		this.empTelLocal_nit = empTelLocal_nit;
		this.nombre = nombre;
		this.correo = correo;
		this.valor_minuto = valor_minuto;
	}
	public EmpTelLocal() {
		super();
	}
	@Override
	public String toString() {
		return "EmpTelLocal [empTelLocal_nit=" + empTelLocal_nit + ", nombre=" + nombre + ", correo=" + correo
				+ ", valor_minuto=" + valor_minuto + "]";
	}
	


	
}
