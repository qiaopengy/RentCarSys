package com.kgc.RentMgr;

import java.util.LinkedList;

import com.kgc.Moto.Bus;
import com.kgc.Moto.Car;
import com.kgc.Moto.Auto;

public class CarData {

	public LinkedList<Auto> list = new LinkedList<Auto>();// ��泵������
	
	static boolean isHasAuto = false;// �����

	/*
	 * ��ʼ��������Ϣ������
	 */
	public void initialize() {

		list.add(new Car("����", "��Q89Z68", 800, "X6"));
		list.add(new Car("����", "��S88967", 800, "X6"));
		list.add(new Car("����", "��A9A991", 600, "550i"));
		list.add(new Car("���", "��C97831", 600, "GL8"));
		list.add(new Car("���", "��Y89434", 300, "������"));
		list.add(new Bus("��", "��89425Q", 800, 16));
		list.add(new Bus("��", "��C54893", 1600, 34));
		list.add(new Bus("����", "��Q58883", 800, 16));
		list.add(new Bus("����", "��C54F89", 1600, 34));

	}

	/*
	 * �⳵��������Ҫ�Ĳ�����Ʒ�ơ��ͺ�/��λ��
	 */
	public Auto rentCar(String brand, String type, int seatNum) {
		// ����ֵ�����Ǹ��࣬����ʵ����һ�����������Ϊ����ֵ
		Auto au = null;
		for (Auto auto : list) {
			if (auto instanceof Car) {
				Car car = (Car) auto;
				if (car.getBrand().equals(brand) && car.getType().equals(type)) {
					isHasAuto = true;
					au = car;
					break;
				}
			} else if (auto instanceof Bus) {
				Bus bus = (Bus) auto;
				if (bus.getBrand().equals(brand) && bus.getSeatNum() == seatNum) {
					isHasAuto = true;
					au = bus;
					break;
				}
			} else {
				isHasAuto = false;
				break;
			}
		}
		return au;
	}
}
