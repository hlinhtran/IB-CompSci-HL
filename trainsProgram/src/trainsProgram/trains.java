package trainsProgram;
import java.util.Arrays;
import java.util.Scanner;
public class trains {

	public static void main(String[] args)
	{
		int[] journey = {9,11,13,15,10,12,14,16};
		int[] seats = {480, 480, 480, 480,480, 480, 480, 640};
		int cost = 25;
		int[] booked = {0,0,0,0,0,0,0,0};
		double[] trainPrice = {0,0,0,0,0,0,0,0};
		int totalPass = 0;
		int freeTicket = 0;
		int numTicket = 0;
		double price = 0;
		double pricePerTicket = 0;
		double totalPrice = 0;
		int numPass = 0;
		int continueNum = 0;
		boolean buyTicket = true;
		int mostPass = 0;
		int mostTrain = 0;
		
		screenDisplay(journey, seats, booked, trainPrice);
		purchaseTicket(numPass, journey, seats, cost, freeTicket, numTicket, price, booked, trainPrice, pricePerTicket, buyTicket, continueNum);
		endDay(journey, booked, trainPrice, totalPass,totalPrice, mostPass, mostTrain);
		
		
	}
	
	public static void screenDisplay(int[] journey, int[] seats, int[] booked, double[] trainPrice)
	{
		System.out.println("Train journey:");
		System.out.println(Arrays.toString(journey) +"\n");
		
		System.out.println("Seats available:");
		System.out.println(Arrays.toString(seats)+"\n");
		
		System.out.println("Booked seats:");
		System.out.println(Arrays.toString(booked)+"\n");
		
		System.out.println("Total money for each journey:");
		System.out.println(Arrays.toString(trainPrice)+"\n");
	}
	
	public static void purchaseTicket(int numPass, int[]journey, int[]seats, int cost, int freeTicket,int numTicket, 
			double price, int[] booked, double[] trainPrice, double pricePerTicket, boolean buyTicket, int continueNum)
	{
		
		Scanner input = new Scanner(System.in);

		while(buyTicket == true)
		{
			System.out.println("Enter number of passengers:");
			numPass = input.nextInt();
			System.out.println("Choose time for journey up:");
			for (int i = 0; i<=3; i++)
			{
				System.out.println("Enter "+ i + " for train " + journey[i]);
			}
			int up = input.nextInt();
			
			System.out.println("Choose time for journey down:");
			for (int i = 4; i<=7; i++)
			{
				System.out.println("Enter "+ i + " for train "
						+ "" + journey[i]);
			}
			int down = input.nextInt();
				
			//check if there are seats available
			if(seats[up]>= numPass && seats[down] >= numPass)
			{
				//calculate free tickets when number of passengers are from 10-80
				if(numPass >= 10 && numPass <= 80)
				{
					freeTicket = numPass / 10;
					numTicket = (numPass - freeTicket)*2; //num tickets after free tickets
					//number of tickets discount
					System.out.println("Congrats! "+ freeTicket +" tickets of yours are free.");
					System.out.println("Now, you only have to pay for "+numTicket+" tickets for "+numPass+" passengers!");
					
					//price after discount (up+down)
					price = numTicket*cost;
					System.out.println("The price after group discount is $"+price+"\n");
					pricePerTicket = price/2;
				}
				//when no discounts
				else
				{
					numTicket = numPass * 2;
					price = numTicket*cost;
					pricePerTicket = price;
					System.out.println("The price you have to pay for "+numPass+" passsengers is $"+price+"\n");
					
				}
			}
			
			else if(seats[up] == 0 || seats[down] == 0)
			{
				System.out.println("Closed.");
			}
			else //when not enough seats
			{
				System.out.println("Not enough seats.");
			}
			
			//update screen display
			seats[up] = seats[up] - numPass;
			seats[down] = seats[down] - numPass;
			System.out.println("Seats available:");
			System.out.println(Arrays.toString(seats)+"\n");
			
			booked[up] = booked[up] + numPass;
			booked[down] = booked[down] + numPass;
			System.out.println("Booked seats:");
			System.out.println(Arrays.toString(booked)+"\n");
			
			trainPrice[up] = trainPrice[up] + pricePerTicket;
			trainPrice[down] = trainPrice[down] + pricePerTicket;
			System.out.println("Total money for each journey:");
			System.out.println(Arrays.toString(trainPrice)+"\n");
			
			//ask if user wants to re-enter
			System.out.println("Do you want to buy more tickets?");
			System.out.println("Enter 1 for yes.");
			System.out.println("Enter 2 for no.");
			continueNum = input.nextInt();
			if (continueNum == 1)
			{
				buyTicket = true;
			}
			else if (continueNum == 2)
			{
				buyTicket = false;
			}
			
		}
				
	}
	
	public static void endDay(int[] journey, int[] booked, double[] trainPrice, int totalPass,
			double totalPrice, int mostPass, int mostTrain)
	{
		//display no. passengers travelled each train journey + total money taken each train
		System.out.println("Number of passengers travelled on each train journey:");
		for(int i =0; i<=7; i++)
		{
			System.out.println("Train "+ journey[i] + ": "+ booked[i]+ " passengers.");
			System.out.println("Total cost: $"+trainPrice[i]+"\n");
		} 
		
		//calculate & display total number of passengers & total amount money taken of the day
		for(int n = 0; n <= 7; n++)
		{
			totalPass = totalPass + booked[n];
			totalPrice = totalPrice + trainPrice[n];
		}
		
		System.out.println("Total number of passengers: "+totalPass);
		System.out.println("Total money collected today: $"+totalPrice+"\n");
		
		//find train journey with most passengers
		mostPass = booked[0];
		mostTrain = journey[0];
		for(int x = 0; x <= 7; x++)
		{
			if(booked[x] > mostPass)
			{
				mostPass = booked[x];
				mostTrain = journey[x];
			}
		}
		System.out.println("Train journey with most passengers is: Train "+ mostTrain + " with " + mostPass + " passengers.");
	}
}
