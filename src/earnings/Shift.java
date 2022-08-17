package earnings;

import java.util.*;

public class Shift {
//Attributes
	private double shiftStart;
	private double totalEarnings;
	private double earnings;
	private double expenses;
	private double shiftLength;
	private double earningsPerHour;
	
	Scanner keyboard = new Scanner(System.in);
	
// Getters & Setters
	public double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public double getEarnings() {
		return earnings;
	}

	public void setEarnings(double earnings) {
		this.earnings += earnings;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses += expenses;
	}

	public double getShiftLength() {
		return shiftLength;
	}

	public void setShiftLength(double shiftLength) {
		this.shiftLength = shiftLength;
	}

	public double getEarningsPerHour() {
		return earningsPerHour;
	}

	public void setEarningsPerHour(double earningsPerHour) {
		this.earningsPerHour = earningsPerHour;
	}
	
	
//Worker Methods
	public void printTitle(double version) {
		System.out.println("Welcome to Uber Earnings Companion | Version: " + version + " | By Aubrey Cumbo-Steinmetz" );
	}
	
	public void pause() { // Does not prompt user for input. Use printf.
		String keypress = "";
		while (keypress.length() < 1) {
			keypress = keyboard.nextLine();
		} 
	}
	
	public void cls() {
		try {	
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception E) {
				System.out.println(E);
			}
	}
	
	public void clearScreen() { // Bash Only
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public String inputString(String message) {
		System.out.print(message);
		String result = keyboard.nextLine().toLowerCase();
		return result;
	}
	
	public double inputDouble(String message) {
		System.out.print(message);
		double result = keyboard.nextDouble();
		keyboard.nextLine();
		return result;
	}

	public int inputInt(String message) {
		System.out.printf(message);
		return inputInt();
	}
	
	public int inputInt() {
		int result = keyboard.nextInt();
		keyboard.nextLine();
		return result;
	}
	
	public void startShift() {
		this.shiftStart = System.currentTimeMillis();
		this.totalEarnings = 0;
		this.earnings = 0;
		this.expenses = 0;
		this.shiftLength = 0;
		this.earningsPerHour = 0;
	}
	
	public void endShift() {
		setShiftLength(System.currentTimeMillis() - shiftStart);
		System.out.print("Hours Worked: " + String.format("%.2f", (getShiftLength() / 3600000)));
		setTotalEarnings(getEarnings() - getExpenses());
		setEarningsPerHour(getTotalEarnings() / (getShiftLength() / 3600000)); // Not working
		System.out.printf("%nEarnings: " + String.format("%.2f", getEarnings()) + "%nExpensis: " + String.format("%.2f", getExpenses()) + "%nHourly Rate: " + String.format("%.2f", getEarningsPerHour())+ "%nTotal Earnings: " + String.format("%.2f", getTotalEarnings()) + "%n[Type done to contune]%n");
		startShift();
		pause();
	}
	
	public void tankUp(double gasPrice, double leters) {
		double result = gasPrice * leters;
		setExpenses(result);
	}
	
	public void completeJob(double rate, double tip) {
		double result = rate + tip;
		setEarnings(result);
	}
	
	public void pitStop(double spent) {
		setExpenses(spent);
	}
	
	
}
