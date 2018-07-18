package com.kgc.RentMgr;

import java.util.LinkedList;

import com.kgc.Moto.Bus;
import com.kgc.Moto.Car;
import com.kgc.Moto.Auto;

public class CarData {

	public LinkedList<Auto> list = new LinkedList<Auto>();// 库存车辆集合
	
	static boolean isHasAuto = false;// 库存标记

	/*
	 * 初始化车辆信息方法。
	 */
	public void initialize() {

		list.add(new Car("宝马", "京Q89Z68", 800, "X6"));
		list.add(new Car("宝马", "京S88967", 800, "X6"));
		list.add(new Car("宝马", "京A9A991", 600, "550i"));
		list.add(new Car("别克", "津C97831", 600, "GL8"));
		list.add(new Car("别克", "津Y89434", 300, "林荫大道"));
		list.add(new Bus("金杯", "津89425Q", 800, 16));
		list.add(new Bus("金杯", "津C54893", 1600, 34));
		list.add(new Bus("金龙", "津Q58883", 800, 16));
		list.add(new Bus("金龙", "京C54F89", 1600, 34));

	}

	/*
	 * 租车方法，需要的参数是品牌、型号/座位数
	 */
	public Auto rentCar(String brand, String type, int seatNum) {
		// 返回值类型是父类，所以实例化一个父类对象作为返回值
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
