public class OccuranceOfDigit{
	public static void main(String[] args){
		int input = 65345;
		System.out.println("Input number: "+input);
		int zeros, ones, twos, threes, fours, fives, sixes, sevens, eights, nines, tens;
		zeros = ones = twos = threes = fours = fives = sixes = sevens = eights = nines = tens = 0;

		while(input>0) {
			if(input%10 == 0) {
				zeros++;
			}else if(input%10 == 1) {
				ones++;
			}else if(input%10 == 2) {
				twos++;
			}else if(input%10 == 3) {
				threes++;
			}else if(input%10 == 4) {
				fours++;
			}else if(input%10 == 5) {
				fives++;
			}else if(input%10 == 6) {
				sixes++;
			}else if(input%10 == 7) {
				sevens++;
			}else if(input%10 == 8) {
				eights++;
			}else if(input%10 == 9) {
				nines++;
			}		
			input = input/10;
		}
		System.out.println("Number of zeros: "+zeros);
		System.out.println("Number of ones: "+ones);
		System.out.println("Number of twos: "+twos);
		System.out.println("Number of threes: "+threes);
		System.out.println("Number of fours: "+fours);
		System.out.println("Number of fives: "+fives);
		System.out.println("Number of sixes: "+sixes);
		System.out.println("Number of sevens: "+sevens);
		System.out.println("Number of eights: "+eights);
		System.out.println("Number of nines: "+nines);
	}
}
}