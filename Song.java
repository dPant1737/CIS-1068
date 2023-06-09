//Dhruv Pant
//01/19/22
//
//This program eliminates redundancy from an American folk song using static methods 
//

public class Song {

	public static void main(String[] args) {
		verseOne(); 
		verseTwo();
		verseThree();
		verseFour();
		verseFive();
		verseSix(); 
			
	}

	//Verses
	public static void verseOne()
	{
		System.out.println("Bought me a cat and the cat pleased me,\n"
				+ "I fed my cat under yonder tree.");
		Cat();
	}
	
	public static void verseTwo()
	{
		System.out.println("Bought me a hen and the hen pleased me,\n"
				+ "I fed my hen under yonder tree.");
		CatAndHen();
	}
	
	public static void verseThree()
	{
		System.out.println("Bought me a duck and the duck pleased me,\n"
				+ "I fed my duck under yonder tree.");
		CatAndHenAndDuck();
	}
	
	public static void verseFour()
	{
		System.out.println("Bought me a goose and the goose pleased me,\n"
				+ "I fed my goose under yonder tree.");
		CatAndHenAndDuckAndGoose();
	}
	
	public static void verseFive()
	{
		System.out.println("Bought me a sheep and the sheep pleased me,\n"
				+ "I fed my sheep under yonder tree.");
		CatAndHenAndDuckAndGooseAndSheep();
	}
	
	public static void verseSix()
	{
		System.out.println("Bought me a pig and the pig pleased me,\n"
				+ "I fed my pig under yonder tree.");
		AllAnimals();
	}
	
	
	
	//Repeated Lines
	
	public static void Cat()
	{
		System.out.println("Cat goes fiddle-i-fee.\n");
	}
	
	public static void CatAndHen()
	{
		System.out.println("Hen goes chimmy-chuck, chimmy-chuck,");
		Cat();
	}
	public static void CatAndHenAndDuck()
	{
		System.out.println("Duck goes quack, quack,");
		CatAndHen();
	}
	
	public static void CatAndHenAndDuckAndGoose()
	{
		System.out.println("Goose goes hissy, hissy,");
		CatAndHenAndDuck();
	}
	public static void CatAndHenAndDuckAndGooseAndSheep()
	{
		System.out.println("Sheep goes baa, baa,");
		CatAndHenAndDuckAndGoose();
	}
	
	public static void AllAnimals()
	{
		System.out.println("Pig goes oink, oink,");
		CatAndHenAndDuckAndGooseAndSheep();
	}
	
	
	
	
	
}
