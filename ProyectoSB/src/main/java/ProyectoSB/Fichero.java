package ProyectoSB;

import java.io.*;

import java.util.*;

import ProyectoSB.domain.Archivo;;

public class Fichero  {
	
	public void crearFichero(String nombre, List<Archivo> texto) throws IOException {
	Archivo entrada;	
	File f;
	FileWriter w;
	BufferedWriter bw;
	PrintWriter wr;
	
	f=new File (nombre+".txt");
	w=new FileWriter(f);
	bw=new BufferedWriter(w);
	wr=new PrintWriter(bw);
	
	wr.write("*-----------------------------------*");
	wr.append("FFDS");
	
	wr.close();
	bw.close();
	
}
}