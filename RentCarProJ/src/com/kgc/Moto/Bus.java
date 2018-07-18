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
			money *= 0.9;// ����7����9��
		} else if (days >= 30 && days < 150) {
			money *= 0.8;// ����30����8��
		} else if (days >= 150) {
			money *= 0.7;// ����30��7��
		}
		return money;
	}

}
