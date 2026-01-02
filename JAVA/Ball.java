class Ball {
	//Data Members
	private static int quantity = 0; // class attribute
	private String color; //instance attribute
	private double radius; //instance attribute

	//Constructors
	public Ball() {
		setColor("yellow");
		setRadius(10.0);
		quantity++;
	}
	public Ball(String newColor, double newRadius) {
		setColor(newColor);
		setRadius(newRadius);
		quantity++;
	}

	//Accessors
	public static int getQuantity() {
		return quantity;
	}
	public String getColor() {
		return color;
	}
	public double getRadius() {
		return radius;
	}

	//Mutators
	public void setColor(String newColor) {
		color = newColor;
	}
	public void setRadius(double newRadius) {
		radius = newRadius;
	}
}