package ProyectoSB.controller;
import java.util.ArrayList;

import java.util.List;
import java.io.*;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;


import ProyectoSB.domain.Archivo;
import ProyectoSB.service.ArchivoService;

@RestController
public class ArchivoController {
	

	@Autowired
	ArchivoService archivoService;

	
	@RequestMapping(method=RequestMethod.GET, value="/archivo/{nit}/{anio}/{mes}/{dur}/{dest}/{val_min}")
	public ResponseEntity<Object> descargarArchivo(@PathVariable int anio,@PathVariable int mes,@PathVariable Long nit, @PathVariable boolean dur, @PathVariable boolean dest, @PathVariable boolean val_min) throws IOException{
		List<Archivo> infoArchivo;
		infoArchivo =  archivoService.infoArchivos(anio,mes, nit);

        File file = new File("Archivos/Archivo_"+ nit +"_"+ anio+"_"+mes);
        if (!file.exists()) {
            file.createNewFile();
        }        
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("---------------------------------------------------------------------------------------------\n");
        bw.write("--------------------------------Informacion de consumos--------------------------------------\n");
        bw.write("---------------------------------------------------------------------------------------------\n");
        bw.write("Nit: "+ nit +"\n");
        bw.write("Ano: "+ anio +"\n");
        bw.write("Mes: "+ mes +"\n");
        bw.write("---------------------------------------------------------------------------------------------\n");
        bw.write("---------------------------------------------------------------------------------------------\n");
        switch(dur +"-"+ dest  +"-"+ val_min) {
        
        case "false-false-false":
        	bw.write(String.format("%-5s %-25s %-25s %-25s %-20s%n", "No.", "Fecha", "Numero de Origen","Numero de destino","Valor llamada ($COP)"));
            for (int i = 0; i < infoArchivo.size(); i++) {
            	String formatStr = "%-5s %-25s %-25s %-25s %-20s%n";
                bw.write(String.format(formatStr,Integer.toString(i+1),infoArchivo.get(i).getFecha(),infoArchivo.get(i).getNum_origen(), infoArchivo.get(i).getNum_destino(),infoArchivo.get(i).getValor_total()));
            }
        	break;
        	
        case "false-false-true":
            bw.write(String.format("%-5s %-25s %-25s %-25s %-20s %-20s%n", "No.", "Fecha", "Numero de Origen","Numero de destino","Valor llamada ($COP)","Valor minuto ($COP)"));        
            for (int i = 0; i < infoArchivo.size(); i++) {
            	String formatStr = "%-5s %-25s %-25s %-25s %-20s %-20s%n";
                bw.write(String.format(formatStr,Integer.toString(i+1),infoArchivo.get(i).getFecha(),infoArchivo.get(i).getNum_origen(), infoArchivo.get(i).getNum_destino(),infoArchivo.get(i).getValor_total(),infoArchivo.get(i).getValor_unidad()));
            }
            break; 
            
        case "false-true-false":
            bw.write(String.format("%-5s %-25s %-25s %-25s %-20s %-20s%n", "No.", "Fecha", "Numero de Origen","Numero de destino","Valor llamada ($COP)", "Destino"));        
            for (int i = 0; i < infoArchivo.size(); i++) {
            	String formatStr = "%-5s %-25s %-25s %-25s %-20s %-20s%n";
                bw.write(String.format(formatStr,Integer.toString(i+1),infoArchivo.get(i).getFecha(),infoArchivo.get(i).getNum_origen(), infoArchivo.get(i).getNum_destino(),infoArchivo.get(i).getValor_total(),infoArchivo.get(i).getDestino()));
            }
            break; 
            
        case "false-true-true":
            bw.write(String.format("%-5s %-25s %-25s %-25s %-20s %-20s %-20s%n", "No.", "Fecha", "Numero de Origen","Numero de destino","Valor llamada ($COP)","Destino","Valor minuto ($COP)"));        
            for (int i = 0; i < infoArchivo.size(); i++) {
            	String formatStr = "%-5s %-25s %-25s %-25s %-20s %-20s %-20s%n";
                bw.write(String.format(formatStr,Integer.toString(i+1),infoArchivo.get(i).getFecha(),infoArchivo.get(i).getNum_origen(), infoArchivo.get(i).getNum_destino(),infoArchivo.get(i).getValor_total(),infoArchivo.get(i).getDestino(),infoArchivo.get(i).getValor_unidad()));
            }
            break; 
            
        case "true-false-false":
            bw.write(String.format("%-5s %-25s %-25s %-25s %-20s %-20s%n", "No.", "Fecha", "Numero de Origen","Numero de destino","Valor llamada ($COP)", "Duracion (Minutos)"));        
            for (int i = 0; i < infoArchivo.size(); i++) {
            	String formatStr = "%-5s %-25s %-25s %-25s %-20s %-20s%n";
                bw.write(String.format(formatStr,Integer.toString(i+1),infoArchivo.get(i).getFecha(),infoArchivo.get(i).getNum_origen(), infoArchivo.get(i).getNum_destino(),infoArchivo.get(i).getValor_total(),infoArchivo.get(i).getDuracion()));
            }
            break;    
            
        case "true-false-true":
            bw.write(String.format("%-5s %-25s %-25s %-25s %-20s %-20s %-20s%n", "No.", "Fecha", "Numero de Origen","Numero de destino","Valor llamada ($COP)", "Duracion (Minutos)","Valor minuto ($COP)"));        
            for (int i = 0; i < infoArchivo.size(); i++) {
            	String formatStr = "%-5s %-25s %-25s %-25s %-20s %-20s %-20s%n";
                bw.write(String.format(formatStr,Integer.toString(i+1),infoArchivo.get(i).getFecha(),infoArchivo.get(i).getNum_origen(), infoArchivo.get(i).getNum_destino(),infoArchivo.get(i).getValor_total(),infoArchivo.get(i).getDuracion(),infoArchivo.get(i).getValor_unidad()));
            }
            break;    
      
        case "true-true-false":
            bw.write(String.format("%-5s %-25s %-25s %-25s %-20s %-20s %-20s%n", "No.", "Fecha", "Numero de Origen","Numero de destino","Valor llamada ($COP)", "Duracion (Minutos)","Destino"));        
            for (int i = 0; i < infoArchivo.size(); i++) {
            	String formatStr = "%-5s %-25s %-25s %-25s %-20s %-20s %-20s%n";
                bw.write(String.format(formatStr,Integer.toString(i+1),infoArchivo.get(i).getFecha(),infoArchivo.get(i).getNum_origen(), infoArchivo.get(i).getNum_destino(),infoArchivo.get(i).getValor_total(),infoArchivo.get(i).getDuracion(),infoArchivo.get(i).getDestino()));
            }
            break;
            
        	
        case "true-true-true":
          bw.write(String.format("%-5s %-25s %-25s %-25s %-20s %-20s %-20s %-20s%n", "No.", "Fecha", "Numero de Origen","Numero de destino","Valor llamada ($COP)", "Duracion (Minutos)","Destino","Valor minuto ($COP)"));        
          for (int i = 0; i < infoArchivo.size(); i++) {
          	String formatStr = "%-5s %-25s %-25s %-25s %-20s %-20s %-20s %-20s%n";
              bw.write(String.format(formatStr,Integer.toString(i+1),infoArchivo.get(i).getFecha(),infoArchivo.get(i).getNum_origen(), infoArchivo.get(i).getNum_destino(),infoArchivo.get(i).getValor_total(),infoArchivo.get(i).getDuracion(),infoArchivo.get(i).getDestino(),infoArchivo.get(i).getValor_unidad()));
          }
          break;
        }           
        bw.flush();
        bw.close();
		System.out.println("Archivo_"+ nit +"_"+ anio+"_"+ mes + " Creado exitosamente" );

		
		String filename = "/Users/fabianprieto/Documents/workspace-spring-tool-suite-4-4.8.1.RELEASE/ProyectoSB/Archivos/"+"/Archivo_"+ nit +"_"+ anio+"_"+mes;
		File file1 = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file1));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",
				String.format("attachment; filename=\"%s\"", file1.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file1.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	
	
		
		
		
	}

}


