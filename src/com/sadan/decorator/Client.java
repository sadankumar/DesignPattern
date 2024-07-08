package com.sadan.decorator;

import com.sadan.decorator.common.Length;
import com.sadan.decorator.common.Size;

public class Client {

	public static void main(String args[]) {
		
		Length mm = Length.MILLIMETER;
		Size dimensions = new Size(mm.scale(188), mm.scale(239), mm.scale(28));
		Book product = new Book("Design Pattern", dimensions);
		new Buyer().handle(product);
	}
}
