package ProyectoSB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import ProyectoSB.domain.Convenio;
@Repository
public class ConvenioRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
	
	
	 public List<Convenio>getConvenios() {
		 String sql = "select * from table (pk_empresas.listar_emps)";
		 List<Convenio> convenio = jdbcTemplate.query(sql,(rs, rowNum)-> new Convenio (rs.getLong("emp_nit"), rs.getString("emp_nombre")));
		 return convenio;
		 
	 }
}
