package com.demo.service.impl;

public enum TriangleType {
	ERROR("Undefine-Shape"),EQUILATERAL("Equilateral"),SCALENE("Scalene"),ISOSCELES("Isosceles");
	
	private final String text;

    /**
     * @param text
     */
    private TriangleType(final String text) {
        this.text = text;
    }

    public String getShape() {
        return text;
    }
}
