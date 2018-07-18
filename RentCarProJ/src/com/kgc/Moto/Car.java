package com.kgc.Moto;

public class Car extends Auto {

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
public Car() {
	// TODO Auto-generated constructor stub
}
	public Car(String brand, String carId, int perRent, String type) {
		super(brand, carId, perRent);
		this.type = type;
	}

	@Override
	public double countRent(int days) {
		// TODO Auto-generated method stub
		double money = this.getPerRent() * days;
		if (days > 7 && days < 30) {
			money *= 0.9;
		} else if (days >= 30 && days < 150) {
			money *= 0.8;
		} else if (days >= 150) {
			money *= 0.7;
		}
		return money;
	}

}
