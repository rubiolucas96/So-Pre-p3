package controller;

import java.io.*;

import model.Beer;

public class BeerController {
	
	public String osPath () {
		String os = System.getProperty("os.name").split(" ")[0];
		if(os.contains("Win")) os = "C:\\Windows\\Temp";
		if(os.contains("Linux")) os = "/tmp";
		return os;
	}
	
	public Beer[] readFile () throws IOException {
		String path = osPath();
		File arquivo = new File(path, "beers.json");
		FileInputStream fis = new FileInputStream(arquivo);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader buffer = new BufferedReader(isr);
		
		String file = buffer.readLine();
		
		Beer[] receitas = formatFile(file);
		
		buffer.close();
		
		return receitas;
	}
	
	private Beer[] formatFile (String file) {
		String[] byId = file.split("\"id\":");
		
		Beer[] receitas = new Beer[byId.length - 1];
		
		String[] aux = new String[4];
		
		int objIndex = 0;
		
		for(String obj : byId) {
			if (!obj.contains("name")) continue;
			String[] line = obj.split("\",");
			
			int index = 0;
			
			for (String key : line) {
				aux[index] = key.split(":\"")[1];
				
				index++;
				
				if (key.contains("description")) break;
			}
			
			receitas[objIndex] = new Beer(aux[0], aux[1], aux[2], aux[3]);
			
			objIndex++;
		}
		
		return receitas;
	}
	

}
