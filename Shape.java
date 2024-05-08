//Class representing the width, radius, and volume of a shape.

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Shape {
	public int i = 0;
	ArrayList<Double> radiuses = new ArrayList<Double>();
	ArrayList<Double> heights = new ArrayList<Double>();
	ArrayList<Double> volumes = new ArrayList<Double>();
	ArrayList<Integer> typeOfShape = new ArrayList<Integer>();
	private double checkDouble;

	//Had to make the same object in both classes, this seems wrong.
	Scanner scan = new Scanner(System.in);
	
	public int getIndex() {
		return i;
		}
	public double getCheckDouble() {
		return checkDouble;
	}

	//Calculates the volume of a shape using the radius and height.
	void calculateConeVolume (ArrayList<Double> parameterRadiuses, ArrayList<Double> parameterHeights) {
		this.radiuses = parameterRadiuses;
		this.heights = parameterHeights;
		volumes.add(i, Math.PI * Math.pow(parameterRadiuses.get(i), 2) * parameterHeights.get(i)/3);
		System.out.printf("%.2f \n", volumes.get(i));
		i++;
		}
	//Calculates the volume of a shape using the radius and height.
	void calculateCylinderVolume (ArrayList<Double> parameterRadiuses, ArrayList<Double> parameterHeights) {
		this.radiuses = parameterRadiuses;
		this.heights = parameterHeights;
		volumes.add(i, Math.PI * Math.pow(parameterRadiuses.get(i), 2) * parameterHeights.get(i));
		System.out.printf("%.2f \n", volumes.get(i));		
		i++;
		}
	//Calculates the volume of a shape using the radius and height.
	void calculateSphereVolume (ArrayList<Double> parameterRadiuses) {
		this.radiuses = parameterRadiuses;
		volumes.add(i, (4.00 / 3.00) * Math.PI * Math.pow(parameterRadiuses.get(i), 3));
		System.out.printf("%.2f \n", volumes.get(i));
		i++;
		}

	//Uses the value of the user input to decide which shape to calculate, then executes the calculate method
	public void shapeChoice(int parameterChoice) {
		if (parameterChoice == 1) {
			calculateConeVolume(radiuses, heights);
		}
		else if (parameterChoice == 2) {
			calculateCylinderVolume(radiuses, heights);
		}	
		else if (parameterChoice == 3) {
			calculateSphereVolume(radiuses);
		}
	}
	public void checkInputDouble (int min, int max) {
		while(true) {
				try {
					checkDouble = scan.nextDouble();
					if (checkDouble <= min || checkDouble > max) {
						System.out.println("Your input must be in between " + min + " and " + max);
					}
					else break;			
				}
				
				catch (InputMismatchException e) {
					System.out.println("That is not a valid input.");
					//scan.next() is used to clear the scanner.
					scan.next();
				}
			}
			
	}
}