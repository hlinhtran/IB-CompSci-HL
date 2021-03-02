package binarySearch;
import java.util.Arrays;
import java.util.Scanner;

public class bSearch 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//user inputs search number
		System.out.println("What numbers are you looking for?");
		int search = input.nextInt(); 
		//create new instance of bSearch
		bSearch b1 = new bSearch(search);
		
		
	}
	public bSearch (int search)
	{
		
		int[] numbers = {1, 212, 16, 67, 42, 53, 23, 14, 93, 537};
		int lowerLimit = 0; //limit the array we're looking at
		int higherLimit = numbers.length-1;
		int foundAt = -1;
		
		//main loop to find the number
		while (lowerLimit <= higherLimit && foundAt == -1)
		{
			int midpoint = (higherLimit + lowerLimit) / 2; //midpoint is calculated
			
			if(numbers[midpoint] == search) //number found
			{
				foundAt = midpoint;
			}
			
			else
			{
				//if search item < midpoint
				if(numbers[midpoint] > search) //check if 
				{
					//update higher limit
					higherLimit = midpoint - 1;
					
				}
				//if search item > midpoint
				else if(numbers[midpoint] < search)
				{
					//update lower limit
					lowerLimit = midpoint + 1;
				}
//				System.out.println("This number " + numbers[midpoint] + " isn't your search number.");
			}
		}
		//when number has been found
		if(foundAt >= 0)
		{
			System.out.println("Number has been found at position "+foundAt);
			
		}
		//when the number isn't found, the lower limit > higher limit --> number not found
		else
		{
			System.out.println("Number has not been found.");
		}
	}
}
