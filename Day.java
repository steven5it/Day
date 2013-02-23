/*
  File: Day.java

  Description: Prompts for day (date, month, year) and returns the Day of week

  Student Name: Steven Lee

  Date Created: 2/14/12

  Date Last Modified: 2/16/12

*/

import java.util.Scanner;
public class Day
{
    public static void main (String [] args)
    {
        //create Scanner object and declare variables
        Scanner sc = new Scanner (System.in);
        int b = 0;
        int a = 0;
        int month = 0;
        int year = 0;
        String day = "";

        //prompt user for inputs, prompt again if not within range

        do
        {
        	System.out.print ("Enter day: ");
            b = sc.nextInt();
            System.out.print ("Enter month: ");
            month = sc.nextInt();
            System.out.print ("Enter year: ");
            year = sc.nextInt();
        }
        while (b < 1 || b > 31 || month < 1 || month > 12 || year < 1900 || year > 2100);

        //prompt again if day is not within range for specific months
        if (month == 4 || month == 6 || month == 9 || month == 11)
        {
        	while (b > 30 || b < 1)
            {
                System.out.print ("Invalid date, re-enter day: ");
                b = sc.nextInt();
            }
        }
        // february special case
        if (month == 2)
        {
        	//leap year
        	if ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0))
        	{
        		while (b > 29 || b < 1)
        		{
        			System.out.print ("Invalid date, re-enter day: ");
                    b = sc.nextInt();
        		}
        	}
        	else
        	{
        		while (b > 28 || b < 1)
        		{
        			System.out.print ("Invalid date, re-enter day: ");
        			b = sc.nextInt();
        		}
        	}

        }

        //change month to Gregorian month, change year for Jan/Feb
        switch (month)
        {
        case 1:
        	{
        		a = 11;
        		year -= 1; break;
        	}
        case 2:
        	{
        		a = 12;
        		year -= 1; break;
        	}
        case 3: a = 1; break;
        case 4: a = 2; break;
        case 5: a = 3; break;
        case 6: a = 4; break;
        case 7: a = 5; break;
        case 8: a = 6; break;
        case 9: a = 7; break;
        case 10: a = 8; break;
        case 11: a = 9; break;
        case 12: a = 10; break;

        }

        //change year to correct format
        int c = year % 100;
        int d = year / 100;

        //computations to find day
        int w = (13 * a - 1)/5;
        int x = c / 4;
        int y = d / 4;
        int z = w + x + y + b + c - 2 * d;
        int r = z % 7;
        if (r < 0)
        {
        	r = (r+7) % y;
        }

        //change r number to corresponding day
        switch (r)
        {
        case 0: day = "Sunday"; break;
        case 1: day = "Monday"; break;
        case 2: day = "Tuesday"; break;
        case 3: day = "Wednesday"; break;
        case 4: day = "Thursday"; break;
        case 5: day = "Friday"; break;
        case 6: day = "Saturday"; break;
        }

        //make year the correct year again for Jan/Feb
        if (month == 1 || month == 2)
        {
        	year += 1;
        }

        System.out.println ("");
        if (year > 2013 || (year == 2012 && month > 2) || (year == 2012 && month == 2 && b > 17))
        {
        	System.out.println ("That day will be a " + day + ".");
        }
        else if (year == 2012 && month == 2 && b ==17)
        {
        	System.out.println ("That day is today, which is a " + day + ".");
        }
        else
        {
        	System.out.println ("That day was a " + day + ".");
        }

    }
}
