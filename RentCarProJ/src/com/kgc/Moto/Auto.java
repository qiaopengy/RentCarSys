package com.kgc.Moto;

//������ ����
public abstract class Auto {
	
	private String brand;// Ʒ��
	private String carId;// ���ƺ�
	private int perRent;// �����

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
	 * ���������󷽷�
	 */
	public abstract double countRent(int days);

}
