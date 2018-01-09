package com.demo.service.impl;

public enum TriangleType {
	ERROR("Not-A-Valid-Triangle"),EQUILATERAL("Equilateral"),SCALENE("Scalene"),ISOSCELES("Isosceles");
	
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
