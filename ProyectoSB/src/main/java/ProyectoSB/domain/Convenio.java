package ProyectoSB.domain;

public class Convenio {
	private Long empTelLocal_nit;
	private String nombre;
	
	
	public Convenio(Long empTelLocal_nit, String nombre) {
		super();
		this.empTelLocal_nit = empTelLocal_nit;
		this.nombre = nombre;
	}
	
	public Convenio () {
		super();
	}
	@Override
	public String toString() {
		return "Convenio [empTelLocal_nit=" + empTelLocal_nit + ", nombre=" + nombre + "]";
	}
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

}
