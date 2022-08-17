package earnings;

public class Main {

	public static void main(String[] args) {
		double version = 1.0;
		boolean programLoop = true;
		boolean menuLoop = true;
		boolean shiftLoop = false;
		boolean inputLoop = false;
		int option = 0;
		
		Shift shift = new Shift();
		
		while(programLoop) {
			while(menuLoop){
				shift.printTitle(version);
				
				inputLoop = true;
				while(inputLoop) {
					option = shift.inputInt("[Enter: 1 to Start | 2 to Exit]: ");
					switch(option) {
						case 1:
							shift.startShift();
							inputLoop = false;
							menuLoop = false;
							shiftLoop = true;
							shift.cls();
							break;
						case 2:
							inputLoop = false;
							menuLoop = false;
							programLoop = false;
							break;
						default:
							System.out.println("Error");
							break;
					}
				}// Input Loop
			}// Menu Loop
			
			while(shiftLoop) {			
				shift.printTitle(version);
				option = shift.inputInt("Enter:%n| 1 to Reset Shift %n| 2 to Complete Job %n| 3 to Tank Up %n| 4 for a Pit Stop %n| 5 to End Shift %n| 6 to Exit%n[Option]: ");
				switch(option) {
					case 1:
						shift.startShift();
						shift.cls();
						inputLoop = false;
						break;
					case 2:
						double rate = shift.inputDouble("How much was the fair: ");
						double tip = shift.inputDouble("How much was the tip: ");
						shift.completeJob(rate,tip);
						shift.cls();
						break;
					case 3:
						double gasPrice = shift.inputDouble("How much per leter: ");
						double leters = shift.inputDouble("How many leters: ");
						shift.tankUp(gasPrice, leters);
						shift.cls();
						break;
					case 4:
						double spent = shift.inputDouble("How much did you spend: ");
						shift.pitStop(spent);
						shift.cls();
						break;
					case 5:
						shift.endShift();
						//shift.pause();
						shift.cls();
						break;
					case 6:
						shiftLoop = false;
						programLoop = false;
						break;
					default:
						System.out.println("Error");
						break;
				}				
			}// Shift Loop
		} // Program Loop
	}
}
