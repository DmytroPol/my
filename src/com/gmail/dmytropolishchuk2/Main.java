package com.gmail.dmytropolishchuk2;

public class Main {

	public static void main(String[] args) {
		Cat lion = new Cat("Simbo", 10, 80, 170, true, "antelopes-wildebeest, " + "zebra");
		Cat tiger = new Cat("Margo", 8, 65, 150, false, "boars, " + "reindeer, " + "roe deer, " + "buffaloes");
		Cat puma = new Cat("Oz", 7, 80, 90, true, "guanaco, " + "mountain sheeps, " + "tolkogi");
		Cat jaguar = new Cat("Donna", 12, 90, 70, false,
				"monkeys, " + "foxes, " + "iguanas, " + "opossums, " + "otters");
		Cat cheetah = new Cat("Rocky", 11, 120, 60, true, "gazelles, " + "impala, " + "hares");
		System.out.println(lion.speak("Hello") + lion);
		lion.eat();
		jaguar.sexAnimals();
		System.out.println(puma);
		cheetah.amwAnimals();
		System.out.println(tiger.speak(""));
	}

}
