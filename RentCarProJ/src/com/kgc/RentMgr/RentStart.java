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
		carData.initialize();// ִ�г�ʼ������

		String brand = "";// Ʒ��ʵ��
		String type = "";// ��������ʵ��
		int seatNum = 0;// ��λ��ʵ��

		String iscon = "";// �Ƿ�����⳵
		double sum = 0;// �ܼ�

		do { // ѭ����

			// ÿ��ѭ������isHas�������Ϊfalse������ᵼ�¿�ָ���쳣��
			CarData.isHasAuto = false;
			System.out.println("��ӭ�⳵:1.�γ�\t2.�ͳ�");
			int choice = input.nextInt();
			if (choice == 1) {
				System.out.println("1.����\t2.���");
				choice = input.nextInt();
				if (choice == 1) {
					brand = "����";
					System.out.println("1.X6\t2.550i");
					type = (input.nextInt() == 1) ? "X6" : "550i";
				} else if (choice == 2) {
					brand = "���";
					System.out.println("1.������\t2.GL8");
					type = (input.nextInt() == 1) ? "������" : "GL8";
				}
			} else if (choice == 2) {
				System.out.println("1.��\t2.����");
				choice = input.nextInt();
				if (choice == 1) {
					brand = "��";
				} else if (choice == 2) {
					brand = "����";
				}
				System.out.println("1.16��\t2.34��");
				seatNum = (input.nextInt() == 1) ? 16 : 34;
			}

			// ���û�ѡ���brand��type/seatNum��Ϊʵ�δ���rentCar()����,�˷�������ֵ�Ǹ���������ͬ���ø���������
			Auto au = carData.rentCar(brand, type, seatNum);

			// ����isHasAuto��Ǿ����Ƿ������һ��,��Ϊfalse���ʾ��ѡ�����޿�棬������ѡ��
			if (CarData.isHasAuto) {
				System.out.println("���������޵�������");
				double money = au.countRent(input.nextInt());
				sum += money;
				System.out.println("Ԥ���ɹ���������Ϣ����:");
				if (au instanceof Car) {
					Car car = (Car) au;
					System.out.println("Ʒ�ƣ�" + au.getBrand() + "\n�ͺţ�" + car.getType() + "\n���ƺţ�" + au.getCarId());
				} else {
					Bus bus = (Bus) au;
					System.out.println("Ʒ�ƣ�" + au.getBrand() + "\n��λ����" + bus.getSeatNum() + "\n���ƺţ�" + au.getCarId());
				}
				System.out.println("����ܶ�Ϊ��" + sum);

				// ֻ�м���size����0���ܼ����⳵,����ֱ�ӽ���ѭ��
				if (carData.list.size() > 0) {

					// �������size����0��remove��ǰ����
					carData.list.remove(au);
					// �Ƿ����ѯ��
					System.out.println("��Ҫ������y/n");
					iscon = input.next();
					if (!iscon.equalsIgnoreCase("y")) {
						break;
					}
				} else {
					System.out.println("\n���г������������");
					break;
				}
			} else {
				// ��ѡ�����޿�棬��һ��ִ��ѯ��
				System.out.println("��ѡ��ĳ���û�п������y����ѡ����n�˳�");
				iscon = input.next();
				if (!iscon.equalsIgnoreCase("y")) {
					break;
				}
			}
		} while (true);

		System.out.println("\n����ʹ��");

	}

}
