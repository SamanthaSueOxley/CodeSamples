import java.util.*;

/* Samantha Oxley
4002-217
*/

public class HowHealthy
{
	private String name, gender;
	private double weight, height;
	private int age, actLv;
	
	private double bmr, bmi, tdee;
	private String bmiResult;
	
	public HowHealthy()
	{
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean setName(String newName)
	{
		if(newName.length() > 0)
		{
			name = newName;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public String getGender()
	{
		return gender;
	}
	
	public boolean setGender(String newGender)
	{
		if((newGender.equals("M")) || (newGender.equals("m")))
		{
			gender = "male";
			return true;
		}
		
		if((newGender.equals("F")) || (newGender.equals("f")))
		{
			gender = "female";
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public boolean setWeight(double newWeight)
	{
		if(newWeight >= 100)
		{
			weight = newWeight;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public double getHeight()
	{
		return height;
	}
	
	public boolean setHeight(double newHeight)
	{
		if((newHeight >= 60)&&(newHeight <= 84))
		{
			height = newHeight;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public int getAge()
	{
		return age;
	}
	
	public boolean setAge(int newAge)
	{
		if(newAge >= 18)
		{
			age = newAge;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public int getActLv()
	{
		return actLv;
	}
	
	public boolean setActLv(int newActLv)
	{
		if((newActLv >= 1) && (newActLv <= 5))
		{
			actLv = newActLv;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public double calcBmr()
	{
		if(getGender().equals("male"))
		{
			bmr = (66 + (13.7 * (getWeight() * 0.45359237)) + (5 * (getHeight()) * 2.54) - (6.8 * getAge()));
		}
		if(getGender().equals("female"))
		{
			bmr = (655 + (9.6 * (getWeight() * 0.45359237)) + (1.8 * (getHeight()) * 2.54) - (4.7 * getAge()));
		}
		return bmr;
	}
	
	public double calcBmi()
	{
		bmi = getWeight()/ (getHeight() * getHeight()) * 703;
		return bmi;
	}
	
	public String getBmiDesc()
	{
		if(calcBmi() < 18.5)
		{
			bmiResult = "underweight";
		}
		if((calcBmi() >= 18.5) && (calcBmi() < 25))
		{
			bmiResult = "normal weight";
		}
		if((calcBmi() >= 25) && (calcBmi() < 30))
		{
			bmiResult = "overweight";
		}
		if(calcBmi() >= 30)
		{
			bmiResult = "obese";
		}

		return bmiResult;
	}
	
	public double tdee(int input)
	{
		if(input == 1)
		{
			tdee = calcBmr() * 1.2;
		}
		if(input == 2)
		{
			tdee = calcBmr() * 1.357;
		}
		if(input == 3)
		{
			tdee = calcBmr() * 1.55;
		}
		if(input == 4)
		{
			tdee = calcBmr() * 1.725;
		}
		if(input == 5)
		{
			tdee = calcBmr() * 1.9;
		}
		
		return tdee;
	}
}
