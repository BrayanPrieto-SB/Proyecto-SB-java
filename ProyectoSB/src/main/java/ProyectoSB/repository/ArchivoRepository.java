package ProyectoSB.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import  org.springframework.jdbc.core.simple.AbstractJdbcCall;
import java.sql.ResultSet;
import java.sql.Types;

import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;

import ProyectoSB.domain.Archivo;
import oracle.jdbc.OracleTypes;


@Repository
public class ArchivoRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    
    @SuppressWarnings("unchecked")
	
    public List<Archivo> infoArchivos(int anio, int mes, long nit){
    	
//Query a un procedimiendo almacenado en un paquete 
//que retorna un cursor referenciadocon var OUT usando SimpleJdbcCall	
   
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
    		.withCatalogName("PK_EMPRESAS")
            .withFunctionName("FILTRO_MES")
            .returningResultSet("L_CURSOR", new RowMapper<Archivo>()
            {
            
                public Archivo mapRow(ResultSet rs, int rowNum)
                		throws SQLException
                {
            		Archivo archivo = new Archivo();
                	archivo.setFecha(rs.getString("FECHA"));
                	archivo.setNum_origen(rs.getString("NUM_ORIGEN"));
                	archivo.setNum_destino(rs.getString("NUM_DESTINO"));
                	archivo.setDuracion(rs.getInt("DURACION"));
                	archivo.setDestino(rs.getString("DESTINO"));
                	archivo.setValor_total(rs.getInt("VALOR_TOTAL"));
                	archivo.setValor_unidad(rs.getInt("VALOR_UNIDAD"));
                	return archivo;
                }
            });

    SqlParameterSource in = new MapSqlParameterSource()
    		.addValue("ANIO", anio)
    		.addValue("MES", mes)
    		.addValue("NIT", nit);   
    Map<String, Object> out = call.execute(in);
    return (List<Archivo>) out.get("L_CURSOR");
           
 };
   
            
}       
      
		    

