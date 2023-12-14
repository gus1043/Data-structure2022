package test;

import beans.Computer;
import factory.ComputerFactory;
import factory.ComputerType;

public class ComputerClient {

	public static void main(String[] args) {

		Computer pc = ComputerFactory.createComputer(ComputerType.PC, "1GB", "256GB", "Intel Core 2 Duo");
		System.out.println("PC Details:");
		System.out.println("RAM: " + pc.getRAM());
		System.out.println("HDD: " + pc.getHDD());
		System.out.println("CPU: " + pc.getCPU());
		
		Computer server = ComputerFactory.createComputer(ComputerType.SERVER, "32GB", "1TB", "AMD Ryzen 7 2700X");
		System.out.println("\nServer Details:");
		System.out.println("RAM: " + server.getRAM());
		System.out.println("HDD: " + server.getHDD());
		System.out.println("CPU: " + server.getCPU());
	}

}
