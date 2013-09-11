import java.util.*;

/* Samantha Oxley
4002-217
*/

public class HowHealthyTester
{
	public static void main(String [] args)
	{
		HowHealthy person = new HowHealthy();
		
		Scanner contCheck = new Scanner(System.in);
		
		String name;
		String gender;
		double weight;
		double height;
		int age;
		int actLv;
		
		double bmr;
		double bmi;
		double tdee;
		
		String bmiResult;
		boolean cont = true;
		
		
		while(cont = true)
		{
		Scanner scan = new Scanner(System.in);
		System.out.print("Your name: ");
		name = scan.nextLine();
		while(person.setName(name) == false)
		{
			System.out.println("Invalid information - Must be at least one character");
			System.out.print("Your name: ");
			name = scan.nextLine();
		}
		
		System.out.print(name + ", are you male or female? (M or F): ");
		gender = scan.nextLine();
		while(person.setGender(gender) == false)
		{
			System.out.println("Invalid information - Must be M or F (upper or lower case)");
			System.out.print(name + ", are you male or female? (M or F): ");
			gender = scan.nextLine();
		}
		
		System.out.print(name + "'s weight (pounds): ");
		weight = scan.nextDouble();
		while(person.setWeight(weight) == false)
		{
			System.out.println("Invalid information - Must be at least 100 pounds");
			System.out.print(name + "'s weight (pounds): ");
			weight = scan.nextDouble();
		}
		
		System.out.print(name + "'s height (inches): ");
		height = scan.nextDouble();
		while(person.setHeight(height) == false)
		{
			System.out.println("Invalid information - Must be between 60 to 84 inches, inclusively");
			System.out.print(name + "'s height (inches): ");
			height = scan.nextDouble();
		}
		
		System.out.print(name + "'s age (years): ");
		age = scan.nextInt();
		while(person.setAge(age) == false)
		{
			System.out.println("Invalid information - Must be at least 18 years old");
			System.out.print(name + "'s age (years): ");
			age = scan.nextInt();
		}
		

		System.out.println("\n Activity Level: Use these categories:");
		System.out.println("\t 1 - Sedentary (little or no exercise, desk job)");
		System.out.println("\t 2 - Lightly active (light exercise/sports 1-3 days/ wk");
		System.out.println("\t 3 - Moderately active (moderate exercise/sports 3-5 days/wk");
		System.out.println("\t 4 - Very active (hard exercise/sports 6-7 days/wk");
		System.out.println("\t 5 - Extra active (hard daily exercise/sports & physical job or 2X day training, i.e. marathon, contest, etc.");
		
		System.out.println("How active are you? ");
		actLv = scan.nextInt();
		while(person.setActLv(actLv) == false)
		{
			System.out.println("Invalid information - Must be between 1 and 5, inclusively");
			System.out.print("How active are you? ");
			actLv = scan.nextInt();
		}
		

		
		
		System.out.println(person.getName() + "'s information");
		System.out.println("Weight: " + person.getWeight());
		System.out.println("Height: " + person.getHeight());
		System.out.println("Age:    " + person.getAge());
		System.out.println("These are for a " + person.getGender());
		
		System.out.printf("\n BMR is %.2f", person.calcBmr());
		System.out.printf("\n BMI is %.2f", person.calcBmi());
		System.out.printf("\n TDEE is %.2f", person.tdee(actLv));
		System.out.println("\n Your BMI classifies you as " + person.getBmiDesc());
		
		
		
		System.out.println("\nDo you wish to do another calculation (Yes/No): ");
		String contIn = contCheck.nextLine();
		
		if((contIn.equals("yes"))||(contIn.equals("Yes")))
		{
			cont = true;
		}
		
		else
		{
			cont = false;
			System.out.print("Have a good day!");
			System.exit(0);
		}
		
		}
	}
}