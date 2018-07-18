package com.kgc.RentMgr;

import java.util.Scanner;

import com.kgc.Moto.Bus;
import com.kgc.Moto.Car;
import com.kgc.Moto.Auto;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class RentStart {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		CarData carData = new CarData();
		carData.initialize();// 执行初始化方法

		String brand = "";// 品牌实参
		String type = "";// 车辆类型实参
		int seatNum = 0;// 座位数实参

		String iscon = "";// 是否继续租车
		double sum = 0;// 总价

		do { // 循环体

			// 每次循环都将isHas标记重置为false，否则会导致空指针异常。
			CarData.isHasAuto = false;
			System.out.println("欢迎租车:1.轿车\t2.客车");
			int choice = input.nextInt();
			if (choice == 1) {
				System.out.println("1.宝马\t2.别克");
				choice = input.nextInt();
				if (choice == 1) {
					brand = "宝马";
					System.out.println("1.X6\t2.550i");
					type = (input.nextInt() == 1) ? "X6" : "550i";
				} else if (choice == 2) {
					brand = "别克";
					System.out.println("1.林荫大道\t2.GL8");
					type = (input.nextInt() == 1) ? "林荫大道" : "GL8";
				}
			} else if (choice == 2) {
				System.out.println("1.金杯\t2.金龙");
				choice = input.nextInt();
				if (choice == 1) {
					brand = "金杯";
				} else if (choice == 2) {
					brand = "金龙";
				}
				System.out.println("1.16座\t2.34座");
				seatNum = (input.nextInt() == 1) ? 16 : 34;
			}

			// 将用户选择的brand、type/seatNum作为实参传入rentCar()方法,此方法返回值是父类对象，因此同样用父类对象接收
			Auto au = carData.rentCar(brand, type, seatNum);

			// 根据isHasAuto标记决定是否继续下一步,若为false则表示所选车辆无库存，需重新选择
			if (CarData.isHasAuto) {
				System.out.println("请输入租赁的天数：");
				double money = au.countRent(input.nextInt());
				sum += money;
				System.out.println("预定成功，车辆信息如下:");
				if (au instanceof Car) {
					Car car = (Car) au;
					System.out.println("品牌：" + au.getBrand() + "\n型号：" + car.getType() + "\n车牌号：" + au.getCarId());
				} else {
					Bus bus = (Bus) au;
					System.out.println("品牌：" + au.getBrand() + "\n座位数：" + bus.getSeatNum() + "\n车牌号：" + au.getCarId());
				}
				System.out.println("租金总额为：" + sum);

				// 只有集合size大于0才能继续租车,否则直接结束循环
				if (carData.list.size() > 0) {

					// 如果集合size大于0就remove当前对象
					carData.list.remove(au);
					// 是否继续询问
					System.out.println("还要继续吗？y/n");
					iscon = input.next();
					if (!iscon.equalsIgnoreCase("y")) {
						break;
					}
				} else {
					System.out.println("\n所有车辆都已租出！");
					break;
				}
			} else {
				// 所选车辆无库存，再一次执行询问
				System.out.println("您选择的车型没有库存啦！y重新选车，n退出");
				iscon = input.next();
				if (!iscon.equalsIgnoreCase("y")) {
					break;
				}
			}
		} while (true);

		System.out.println("\n结束使用");

	}

}
