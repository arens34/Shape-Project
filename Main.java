import java.util.InputMismatchException;
import java.util.Scanner;

//This class is used to run the main method.
public class Main {
	//Method used to execute the program.
	public static void main(String[] args) {
		//Index variable for each shape.
		Scanner scan = new Scanner(System.in);
		Shape shape0 = new Shape();
	
		System.out.println("This program allows you to make new shapes and access old ones.");
		//while loop for creating a shape
		while(true) {
			System.out.println("\nWhat shape would you like to make?");
			System.out.printf("Cone: 1 \t Cylinder: 2 \t Sphere: 3 \n");

			//While loop for catching invalid inputs, repeats only if exception is caught.
			int checkInt = 0;
			//double checkDouble = 0.0;
			while(true) {
				try {
					checkInt = scan.nextInt();
					if (checkInt < 1 || checkInt > 3) {
						System.out.println("The only valid inputs are 1, 2 and 3.");
					}
					else break;			
				}
				
				catch (InputMismatchException e) {
					System.out.println("That is not a valid input.");
					//scan.next() is used to clear the scanner. My try catch blocks were not working without using scan.next().
					scan.next();
				}
			}
			shape0.typeOfShape.add(checkInt);


			System.out.printf("\nPlease enter the height of your shape (Between 0 and 100).");
			shape0.checkInputDouble(0, 100);
			shape0.heights.add(shape0.getCheckDouble());

			System.out.printf("\nPlease enter the radius of your shape (Between 0 and 100).");
			shape0.checkInputDouble(0, 100);
			shape0.radiuses.add(shape0.getCheckDouble());

			System.out.printf("\nThe volume of your shape is: ");
			shape0.shapeChoice(shape0.typeOfShape.get(shape0.getIndex()));
			
			//While loop that prompts the user to choose between making/viewing a shape, and the code for viewing the shape
			while(true) {
			System.out.printf("\nWould you like to make another shape or view a previous shape?\n");
			System.out.printf("1: Make a new shape \t 2: View an old one\n");

			int viewOrMake;
	
				while(true) {
					try {
					viewOrMake = scan.nextInt();
					break;
					}
					catch (InputMismatchException e) {
					System.out.println("That is not a valid input.");
					scan.next();
					}
				}
				
				//If-else statement that allows the user to decide to make a new shape (return to previous loop) or view and old one.
				if (viewOrMake == 1) {
				break;
				}
	
				else if (viewOrMake == 2) {
				//For loop to display all shapes that have been created by the user so far (type of shape + number)
				for (int i = 0; i < shape0.getIndex(); i++) {
					String shapeType = "";
					if (shape0.typeOfShape.get(i) == 1) {
						shapeType = "Cone ";
					}
					else if (shape0.typeOfShape.get(i) == 2) {
						shapeType = "Cylinder ";
					}
					else if (shape0.typeOfShape.get(i) == 3) {
						shapeType = "Sphere ";
					}
					System.out.printf("\n" + shapeType + (i + 1));
				}

				//Prompts the user to choose the shape they want to view
				System.out.println("\n\nWhich shape would you like to view?");
				int viewChoice = scan.nextInt();
				if (shape0.getIndex() < viewChoice) {
					System.out.println("Sorry, that shape does not exist yet.");
				}
				else {
					System.out.println("Radius: " + shape0.radiuses.get(viewChoice - 1));
					System.out.println("Height: " + shape0.heights.get(viewChoice - 1));
					System.out.printf("Volume: %.2f \n", shape0.volumes.get(viewChoice - 1));
				}
				}
			}
		}
	}

		
}