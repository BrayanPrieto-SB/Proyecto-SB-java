package ProyectoSB.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import ProyectoSB.domain.Convenio;
import ProyectoSB.domain.EmpTelLocal;

@Repository
public class EmpTelLocalRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    
	/* 
	public EmpTelLocal getEmp(Long nit){
	        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
	        		.withCatalogName("PK_EMPRESAS")
	        		.withProcedureName("MOSTRAR_EMPRESAS");
	        SqlParameterSource in = new MapSqlParameterSource().addValue("NIT", nit);
	        Map<String, Object> out = simpleJdbcCall.execute(in);
	   /*     EmpTelLocal emp = new EmpTelLocal();
	        emp.setEmpTelLocal_NIT((Long) out.get("emp_tel_local_nit"));
	        emp.setNombre((String) out.get("nombre"));
	        emp.setCorreo("CORREO");
	        emp.setValor_minuto(0);
	        
	        return emp;
	   
	        EmpTelLocal emp = new EmpTelLocal((Long) out.get("NIT"),  (String) out.get("NOM"), "correo", 1);
	        return emp;
	    }
   */
    
	 public List <EmpTelLocal> getEmps(long nit) {
		  String sql = "select * from emp_tel_local where emp_tel_local_nit=?";
		  List<EmpTelLocal> empresas =jdbcTemplate.query(sql,(rs, rowNum)-> new EmpTelLocal(rs.getLong("emp_tel_local_nit"),
				  rs.getString("nombre"),
				  rs.getString("correo"),
				  rs.getInt("valor_minuto")),nit);
		  return empresas;
				  
	 }
		  
	 
	 

	
		  
		  
	 public void crearConvenio(EmpTelLocal emp ) {
		 	EmpTelLocal empresa = emp;
	        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
	        		.withCatalogName("PK_EMPRESAS")
	        		.withProcedureName("CREAR_CONVENIO");
	        SqlParameterSource in = new MapSqlParameterSource()
	        		.addValue("EMP_TEL_LOCAL_NIT", empresa.getEmpTelLocal_nit() )
	        		.addValue("NOMBRE", empresa.getNombre())
	        		.addValue("CORREO", empresa.getCorreo())
	        		.addValue("VALOR_MINUTO",empresa.getValor_minuto());
	        simpleJdbcCall.execute(in);

	 }

}