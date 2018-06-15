public class BonusCalculator{ 
	public static void main(String args[]){ 
			double salary=20000.0, yearsOfExp=3.5;
			double bonussal=0;
			char desig='A';
			if(yearsOfExp>0 && yearsOfExp<2 && desig=='A') 
				bonussal=(salary*50)/100; 
			else if(yearsOfExp>2 && yearsOfExp<3 && desig=='A')
				bonussal=(salary*40)/100; 
			else if(yearsOfExp>3 && yearsOfExp<4 && desig=='A') 
				bonussal=(salary*30)/100; 
			else if(yearsOfExp>4)
				bonussal=(salary*20)/100; 
			System.out.println("Bonus is: "+bonussal);
	}
} 