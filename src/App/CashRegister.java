package App;

import java.util.Scanner;

public class CashRegister {
	public static void main(String[] args) {
		// Initialize the loop variable
		boolean goAgain = true;

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to the Cash Register Change Calculator!");

		// Loop around while we still want to use the program
		while (goAgain) {
			System.out.println("Please enter the price of the item bought: ");
			double itemPriceTemp = sc.nextDouble();
			System.out.println("Please enter the amount paid for the item: ");
			double amountPaidTemp = sc.nextDouble();
			sc.nextLine();

			if (amountPaidTemp < itemPriceTemp) {
				System.out.println("You didn't pay enough for the item!\n");
			} else if (amountPaidTemp == itemPriceTemp) {
				System.out.println("You paid the exact amount!\n");
			} else {
				printChange(itemPriceTemp, amountPaidTemp);
			}
			// Does the user want to use the program again?
			System.out.println();
			System.out.println("Do you want to go again? [y/n]");
			String answer = sc.nextLine();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("Thanks for using the Cash Register Change Calculator!");
				goAgain = false;
			}
		}
		sc.close();
	}

	public static void printChange(double itemPriceTemp, double amountPaidTemp) {
		// Initialize all of the variables. Change is done by cents instead of dollars
		// so that we can avoid errors from doubles
		// Initialization of variables used locally, this resets the variables every
		// loop
		String change = "";
		boolean multiple = false;
		int _20D = 2000;
		int _10D = 1000;
		int _5D = 500;
		int _1D = 100;
		int _25c = 25;
		int _10c = 10;
		int _5c = 5;
		int _1c = 1;
		int twenties = 0;
		int tens = 0;
		int fives = 0;
		int ones = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		
		int itemPrice = (int) (itemPriceTemp * 100);
		if ((double) itemPrice / 100 < itemPriceTemp) {
			itemPrice++;
		}
		
		int amountPaid = (int) (amountPaidTemp * 100);
		if ((double) amountPaid / 100 < amountPaidTemp) {
			amountPaid++;
		}

		// Find out how much change there is
		amountPaid -= itemPrice;

		// Sort the change into piles going from largest to smallest unit of currency
		while (amountPaid > 0) {
			if (amountPaid >= _20D) {
				twenties++;
				amountPaid -= _20D;
				continue;
			} else if (amountPaid >= _10D) {
				tens++;
				amountPaid -= _10D;
				continue;
			} else if (amountPaid >= _5D) {
				fives++;
				amountPaid -= _5D;
				continue;
			} else if (amountPaid >= _1D) {
				ones++;
				amountPaid -= _1D;
				continue;
			} else if (amountPaid >= _25c) {
				quarters++;
				amountPaid -= _25c;
				continue;
			} else if (amountPaid >= _10c) {
				dimes++;
				amountPaid -= _10c;
				continue;
			} else if (amountPaid >= _5c) {
				nickels++;
				amountPaid -= _5c;
				continue;
			} else if (amountPaid >= _1c) {
				pennies++;
				amountPaid -= _1c;
				continue;
			}
		}

		// Debug string
		// System.out.printf("%4d %4d %4d %4d %4d %4d %4d %4d", twenties, tens, fives,
		// ones, quarters, dimes, nickels, pennies);

		String starter = "Your change is: ";

		// Add twenties to change
		if (twenties == 1) {
			change += twenties + " twenty dollar bill";
			multiple = true;
		} else if (twenties > 1) {
			change += twenties + " twenty dollar bills";
			multiple = true;
		}

		// Add tens to change, concat if multiple = true
		if (tens == 1 && multiple == true) {
			change += ", " + tens + " ten dollar bill";
		} else if (tens > 1 && multiple == true) {
			change += ", " + tens + " ten dollar bills";
		} else if (tens == 1) {
			change += tens + " ten dollar bill";
			multiple = true;
		} else if (tens > 1) {
			change += tens + " ten dollar bills";
			multiple = true;
		}

		// Add fives to change, concat if multiple = true
		if (fives == 1 && multiple == true) {
			change += ", " + fives + " five dollar bill";
		} else if (fives > 1 && multiple == true) {
			change += ", " + fives + " five dollar bills";
		} else if (fives == 1) {
			change += fives + " five dollar bill";
			multiple = true;
		} else if (fives > 1) {
			change += fives + " five dollar bills";
			multiple = true;
		}

		// Add ones to change, concat if multiple = true
		if (ones == 1 && multiple == true) {
			change += ", " + ones + " one dollar bill";
		} else if (ones > 1 && multiple == true) {
			change += ", " + ones + " one dollar bills";
		} else if (ones == 1) {
			change += ones + " one dollar bill";
			multiple = true;
		} else if (ones > 1) {
			change += ones + " one dollar bills";
			multiple = true;
		}

		// Add quarters to change, concat if multiple = true
		if (quarters == 1 && multiple == true) {
			change += ", " + quarters + " quarter";
		} else if (quarters > 1 && multiple == true) {
			change += ", " + quarters + " quarters";
		} else if (quarters == 1) {
			change += quarters + " quarter";
			multiple = true;
		} else if (quarters > 1) {
			change += quarters + " quarters";
			multiple = true;
		}

		// Add dimes to change, concat if multiple = true
		if (dimes == 1 && multiple == true) {
			change += ", " + dimes + " dime";
		} else if (dimes > 1 && multiple == true) {
			change += ", " + dimes + " dimes";
		} else if (dimes == 1) {
			change += dimes + " dime";
			multiple = true;
		} else if (dimes > 1) {
			change += dimes + " dimes";
			multiple = true;
		}

		// Add nickels to change, concat if multiple = true
		if (nickels == 1 && multiple == true) {
			change += ", " + nickels + " nickel";
		} else if (nickels > 1 && multiple == true) {
			change += ", " + nickels + " nickels";
		} else if (nickels == 1) {
			change += nickels + " nickel";
			multiple = true;
		} else if (nickels > 1) {
			change += nickels + " nickels";
			multiple = true;
		}

		// Add pennies to change, concat if multiple = true
		if (pennies == 1 && multiple == true) {
			change += ", " + pennies + " penny";
		} else if (pennies > 1 && multiple == true) {
			change += ", " + pennies + " pennies";
		} else if (pennies == 1) {
			change += pennies + " penny";
			multiple = true;
		} else if (pennies > 1) {
			change += pennies + " pennies";
			multiple = true;
		}

		System.out.println(starter + change + ".");
	}
}