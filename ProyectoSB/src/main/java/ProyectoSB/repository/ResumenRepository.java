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
    
	 public List<Resumen>getResumenes() {
		 String sql = "select  emp.nombre as Nombre, sum((ceil(llam.duracion * 24 * 60))) as Minutos, sum((ceil(llam.duracion * 24 * 60) * emp.valor_minuto)) as Valor from llamada llam join cliente cli on (cli.cliente_id= llam.cliente_id) join emp_tel_local emp on (cli.emp_tel_local_nit=emp.emp_tel_local_nit) group by emp.nombre";
		 List<Resumen> resumen = jdbcTemplate.query(sql,(rs, rowNum)-> new Resumen (rs.getString("Nombre"), rs.getLong("Minutos"),rs.getLong("Valor")));
		 return resumen;
		 
	 }

}
