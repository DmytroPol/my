package com.gmail.dmytropolishchuk2;

public class Cat {
	private String name;
	private int age;
	private int maxSpeed;
	private double weight;
	private boolean sex;
	private String ration;

	public Cat(String name, int age, int maxSpeed, double weight, boolean sex, String ration) {
		super();
		this.name = name;
		this.age = age;
		this.maxSpeed = maxSpeed;
		this.weight = weight;
		this.sex = sex;
		this.ration = ration;

	}

	public Cat() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getRation() {
		return ration;
	}

	public void setRation(String ration) {
		this.ration = ration;

	}

	Cat newCat(Cat a, boolean newsex) {
		a.sex = newsex;
		return a;
	}

	public void eat() {
		System.out.print("Eating...\n");
	}

	public void sleep() {
		System.out.print("Sleeping zz-z-z-z...\n");
	}

	public void amwAnimals() {
		if (age <= 0 || maxSpeed <= 0 || weight <= 0) {
			System.out.println("Invalid input: age or maxSpeed or weight");
		}
	}

	public String speak(String words) {
		String phrase = words + "...mauu...\n";
		return phrase;
	}

	public void sexAnimals() {
		if (sex == true) {
			System.out.println("male");
		} else
			System.out.println("female");
	}

	@Override
	public String toString() {
		return "[" + "name: " + name + ", age: " + age + ", maxSpeed: " + maxSpeed + ", weight: " + weight + ", sex: "
				+ sex + ", ration: " + ration + "]";
	}
}