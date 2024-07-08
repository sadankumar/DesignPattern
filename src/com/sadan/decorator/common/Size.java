package com.sadan.decorator.common;

public class Size {
	private Length width;
	private Length length;
	private Length height;
	
	public Size(Length width, Length length, Length height) {
		this.width = width;
		this.length = length;
		this.height = height;
	}
	
	public static final Size ZERO = new Size(Length.ZERO, Length.ZERO, Length.ZERO);
	
	public Size add(Size other) {
        return new Size(
            this.width.add(other.width),
            this.length.add(other.length),
            this.height.add(other.height));
    }

    public Size addToTop(Size other) {
        return new Size(
            this.width.max(other.width),
            this.length.max(other.length),
            this.height.add(other.height)
        );
    }

    public Size scaleHeight(double factor) {
        return new Size(this.width, this.length, this.height.scale(factor));
    }

    @Override
    public String toString() {
        return Length.toString(" x ", this.width, this.length, this.height);
    }

}
