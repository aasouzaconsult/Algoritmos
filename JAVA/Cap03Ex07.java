//ARRAY

public class Cap03Ex07 {
	public static void main (String args[])
	{
		int media;
		int idade[]=new int[5];
		idade[0] = 12;
		idade[1] = 14;
		idade[2] = 13;
		idade[3] = 16;
		idade[4] = 15;
		
		media = (idade[0] + idade[1] + idade[2] + idade[3] + idade[4])/5; 
		
		System.out.println(media);
	}
}
