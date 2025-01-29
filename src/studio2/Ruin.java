package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Your start amount will be:");
		double startAmount = in.nextDouble();
		System.out.println("Your win chance will be:");
		double winChance = in.nextDouble();
		System.out.println("Your win limit is:");
		double winLimit = in.nextDouble();
		System.out.println("Simulations will be:");
		int sim = in.nextInt();
		
		double round = 0; double lose = 0; int realsim = 0;
		
		while (sim > 0) {
			while(startAmount > 0 && startAmount < winLimit) {
				if (Math.random() < winChance) {
					startAmount++;
					round++;
				}else {
					startAmount--;
					round++;
				}
			}
			
			if (startAmount == 0) {
				System.out.println("Simulation "+ round + ": " + startAmount + " LOSE");
				lose++;
			}
			
			if (startAmount == winLimit) {
				System.out.println("Simulation "+ round + ": " + startAmount + " WIN");
				
			}
			
			realsim++;
			sim--;
		}
		
		
		double ruinrate = lose/round;
		double expectrate = 1-winChance;
		
		System.out.println("Losses:" + lose + " Simulations:" + realsim);
		System.out.println("Ruin Rate from Simulation: " + ruinrate + " Expectede Ruin Rate:" + expectrate);

	}

}
