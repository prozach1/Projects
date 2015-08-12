package com.Converter;

import java.util.Scanner;

/*
 * Converts currency between USD, EUR, GBP, and AUD
 */
public class Currency {

	public Currency() {
	}
	
	public static void main(String[] args) {
		String again="y";
		Scanner sc= new Scanner(System.in);
		
		while(again.equalsIgnoreCase("y")){
			System.out.println("Please enter the currency to be converted: ");
			String firstCur = sc.next().toUpperCase();
			double amount = sc.nextDouble();
			String secondCur = sc.next().toUpperCase();
			
			String response = getConversion(firstCur, amount, secondCur);
			System.out.println(response);
			
			System.out.println("Continue? (y/n)");
			again=sc.next();
		}

	}

	private static String getConversion(String firstCur, double amount,
			String secondCur) {
		double firstNum = getVal(firstCur);
		double secondNum = getVal(secondCur);
		
		String rsp = amount + " " + firstCur + " is equal to " 
				+ ((amount/firstNum)*secondNum) + " "+ secondCur;
		return rsp;
	}

	private static double getVal(String cur) {
		double val=0.0;
		switch (cur) {
		case "USD":
			val=1.0;
			break;
		case "EUR":
			val=.91;
			break;
		case "GBP":
			val=.64;
			break;
		case "AUD":
			val=1.37;
			break;
		default:
			break;
		}
		
		return val;
	}

}
