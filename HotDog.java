public class HotDog {
	// returns the number of combinations
	public long printMenu(){
		for(long count = 0; count <= 127; count++){
			String output = "Dog in Bun with";
			double cost = 99;
			if((count % 2) != 0) { //ketchup
				output = output + " Ketchup,";
				cost += 15;
			}
			if(((int)(count/2) % 2) != 0) { //mustard
				output = output + " Mustard,";
				cost += 17;
			}
			if(((int)(count/4) % 2) != 0) { //chopped onions
				output = output + " Chopped Onions,";
		
				cost += 20;
			}
			if(((int)(count/8) % 2) != 0) { //tomato wedge		
				output = output + " Tomato Wedge,";
				cost += 25;
			}
			if(((int)(count/16) % 2) != 0) { // sweet relish	
				output = output + " Sweet Relish,";
				cost += 30;
			}
			if(((int)(count/32) % 2) != 0) { // sport peppers
				output = output + " Sport Peppers,";
				cost += 35;
			}
			if(((int)(count/64) % 2) != 0) { // sauerkraut	
				output = output + " Sauerkraut";
				cost += 45;
			}

			//swap output if no toppings
			if (cost == 99) {
				output = "Dog in Bun";
			}
			//Cost rounding calculation
			cost = cost / 100;

			System.out.printf("%3d %-111s %s%.2f%n", count, output, "$", cost);
		}
		return 69;
	}
	
	public static void main(String [] args){
		HotDog obj =  new HotDog();
		long count = obj.printMenu();
		assert count == 24;
		
	}
}
