package view;

import controller.BeerController;

import model.Beer;

public class Main {
	
	public static void main(String[] args) {
		
		BeerController beer = new BeerController();
		
		
		try {			
			Beer[] receitas = beer.readFile();
			for (Beer receita : receitas) {
				System.out.println(receita);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
