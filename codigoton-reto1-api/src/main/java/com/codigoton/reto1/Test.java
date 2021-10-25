package com.codigoton.reto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.codigoton.reto1.dto.FiltroSolicitudReserva;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		Path input = Paths.get("/Users/Documents/CURSOS/CODIGOTON/BANCOLOMBIA/RETO 1/FUENTES/reto1-code/codigoton-reto1-api/static/upload/entrada copy.txt");
		HashMapFromTextFile(input);

	}
	
	public static void HashMapFromTextFile(Path path)
    {
		List<FiltroSolicitudReserva> listFiltros = new ArrayList<>();
		FiltroSolicitudReserva temp = null;
        Map<String, Object> map
            = new HashMap<String, Object>();
        BufferedReader br = null;
  
        try {
  
            // create file object
            File file = new File(path.toUri());
  
            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));
  
            String line = null;
  
            // read file line by line
            while ((line = br.readLine()) != null) {
            	
                // split the line by :
                String[] parts = line.split(":");
                System.out.println(parts[0]);
                if(parts[0].charAt(0) == '<') {
                    temp = new FiltroSolicitudReserva(parts[0]);
                	listFiltros.add(temp);
                }
                if(parts.length > 0 && parts[0].charAt(0) != '<') {
	                // first part is name, second is number
	                String key = parts[0].trim();
	                Object value = parts[1].trim();
	  
	                // put name, number in HashMap if they are
	                // not empty
	                if (!key.equals("") && !value.equals(""))
	                	if(key.equals("TC"))
	                		temp.setType(Integer.parseInt((String) value));
		                if(key.equals("UG"))
	                		temp.setLocation((String) value);
		                if(key.equals("RI"))
	                		temp.setRi(new BigDecimal((String) value));
		                if(key.equals("RF"))
		                	temp.setRf(new BigDecimal((String) value));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
  
            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        System.out.println(listFiltros.size());
    }

}
