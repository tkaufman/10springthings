package org.cinjug.security;

import java.util.List;
import java.util.Random;

public class ListBasedBeerService implements BeerService {

	private List<String> fridge;
	
	public void setFridge(List<String> fridge) {
		this.fridge = fridge;
	}

	private Random generator = new Random();

	public void stockFridge(Beer beer) {
		fridge.add(beer.getName());
	}

    public String suggestBeer() {
		int index = generator.nextInt(fridge.size());
		return fridge.get(index);
	}

}
