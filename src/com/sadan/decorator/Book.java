package com.sadan.decorator;

import com.sadan.decorator.common.Size;

public class Book {
	private String title;
	private Size dimension;

	public Book(String title, Size dimension) {
		this.title = title;
		this.dimension = dimension;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Size getDimension() {
		return this.dimension;
	}
	
	@Override
	public String toString() {
		
		return this.title + " - " + this.dimension;
	}
}
