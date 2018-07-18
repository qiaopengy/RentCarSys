package com.kgc.Moto;

//汽车类 父类
public abstract class Auto {
	
	private String brand;// 品牌
	private String carId;// 车牌号
	private int perRent;// 日租金

	public String getBrand() {
		return brand;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPerRent() {
		return perRent;
	}

	public void setPerRent(int perRent) {
		this.perRent = perRent;
	}

	public Auto() {
		// TODO Auto-generated constructor stub
	}

	public Auto(String brand, String carId, int perRent) {
		super();
		this.brand = brand;
		this.carId = carId;
		this.perRent = perRent;
	}

	/*
	 * 计算租金抽象方法
	 */
	public abstract double countRent(int days);

}
