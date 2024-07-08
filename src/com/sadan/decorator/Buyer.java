package com.sadan.decorator;

public class Buyer {
	
	public void handle(Book product) {
		System.out.println("Buying Book " + product.getTitle() + " of size " + product.getDimension());
	}

}
