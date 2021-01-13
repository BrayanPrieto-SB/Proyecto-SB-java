package ProyectoSB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import ProyectoSB.domain.Convenio;
import ProyectoSB.domain.Resumen;

@Repository
public class ResumenRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    
 //Queries pasando la sentencia directamente a la DB
 //retorna la info solicitada usando jdbcTemplate
    
    
	 public List<Resumen>getResumenenTotal() {
		 String sql = "select  emp.nombre as Nombre, sum((ceil(llam.duracion * 24 * 60))) as Minutos, sum((ceil(llam.duracion * 24 * 60) * emp.valor_minuto)) as Valor from llamada llam join cliente cli on (cli.cliente_id= llam.cliente_id) join emp_tel_local emp on (cli.emp_tel_local_nit=emp.emp_tel_local_nit) group by emp.nombre";
		 List<Resumen> resumen = jdbcTemplate.query(sql,(rs, rowNum)-> new Resumen (rs.getString("Nombre"), rs.getLong("Minutos"),rs.getLong("Valor")));
		 return resumen;
		 
	 }
	 
	 
	 public List<Resumen>getResumenes(int anio,int mes) {
		 String sql = 	 "SELECT  EMP.NOMBRE AS NOMBRE, SUM((ceil(LLAM.DURACION * 24 * 60 ))) AS MINUTOS, SUM((CEIL(LLAM.DURACION * 24 * 60) * EMP.VALOR_MINUTO)) AS VALOR FROM LLAMADA LLAM JOIN CLIENTE CLI ON (CLI.CLIENTE_ID = LLAM.CLIENTE_ID) JOIN EMP_TEL_LOCAL EMP ON (CLI.EMP_TEL_LOCAL_NIT=EMP.EMP_TEL_LOCAL_NIT) and extract(year from llam.fecha_inicio) = ? and extract(month from llam.fecha_inicio) = ? GROUP BY EMP.NOMBRE"; 
;
		 List<Resumen> resumen = jdbcTemplate.query(sql,(rs, rowNum)-> new Resumen (rs.getString("Nombre"), rs.getLong("Minutos"),rs.getLong("Valor")),anio,mes);
		 return resumen;
		 
	 }
	 
	 


}



