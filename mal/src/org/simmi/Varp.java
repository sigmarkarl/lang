package org.simmi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Varp {
	static Map<String,String> charmap = new HashMap<String,String>();
	static Map<String,String> lastmap = new HashMap<String,String>();
	
	static {		
		charmap.put("hv", "q");
		charmap.put("kv", "q");
		charmap.put("Hv", "Q");
		charmap.put("Kv", "Q");
		
		charmap.put("é", "je");
		charmap.put("É", "Je");
		
		charmap.put("æ", "aj");
		charmap.put("Æ", "Aj");
		charmap.put("au", "öj");
		charmap.put("Au", "Öj");
		
		charmap.put("u", "y");
		charmap.put("U", "Y");
		
		charmap.put("ð", "þ");
		charmap.put("Ð", "Þ");
		
		lastmap.put("í", "j");
		lastmap.put("Í", "J");
		lastmap.put("ú", "u");
		lastmap.put("Ú", "U");
		lastmap.put("ó", "ou");
		lastmap.put("Ó", "Ou");
		lastmap.put("á", "au");
		lastmap.put("Á", "Au");
	}
	
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/Users/sigmar.MATIS/Documents/texti.txt");
			BufferedReader br = new BufferedReader( new InputStreamReader( fis, "ISO-8859-15") );
			String line = br.readLine();
			//List<String> lines = Files.readAllLines( p );
			while( line != null ) {
				for( String rep : charmap.keySet() ) {
					line = line.replace(rep, charmap.get(rep) );
				}
				for( String rep : lastmap.keySet() ) {
					line = line.replace(rep, lastmap.get(rep) );
				}
				System.out.println( line );
				
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
