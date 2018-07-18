package com.kgc.Moto;

public class Bus extends Auto {
	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public Bus(String brand, String carId, int perRent, int seatNum) {
		super(brand, carId, perRent);
		this.seatNum = seatNum;
	}

	private int seatNum;

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	@Override
	public double countRent(int days) {
		double money = this.getPerRent() * days;
		if (days > 7 && days < 30) {
			money *= 0.9;// 大于7天享9折
		} else if (days >= 30 && days < 150) {
			money *= 0.8;// 大于30天享8折
		} else if (days >= 150) {
			money *= 0.7;// 大于30天7折
		}
		return money;
	}

}
