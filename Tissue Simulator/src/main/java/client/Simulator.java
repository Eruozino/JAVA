package client;
import tissue.*;
import java.util.Arrays;
import blood.*;
import numericalmethod.*;
import java.util.Scanner;

public class Simulator{
	public static void main(String[] args) {
		userInterface();
	}

	public static void userInterface(){
		System.out.println("WELCOME TO YOUR BLOOD-FLOW-LIMITED PHYSIOLOGIC MODEL");
		System.out.print("In this simulator, the concentration of drug in tissues (muscle, skin, fat, kidney and Liver) and blood is plotted as a function of time.");
		System.out.print(" To best describe your individual body, modify the default parameters to an estimate of your body, ");
		System.out.print("adjust these parameters by modifying the input text located in the * folder or manually key in parameter values the when prompted.\n");
		System.out.println("\nWould you like to stick to the default parameters (20 year Old Male) or would you like to modify these parameter?");
		Scanner input = new Scanner(System.in);
		boolean stickToDefault = true;
		boolean repeat = false;
		String decision = input.nextLine().toLowerCase();

		do{
			switch(decision){
			case "yes":
				stickToDefault = true;
				repeat = false;
				break;
			case "y":
				stickToDefault = true;
				repeat = false;
				break;
			case "no":
				stickToDefault = false;
				repeat = false;
				break;
			case "n":
				stickToDefault = false;
				repeat = false;
				break;
			default:
				System.out.println("Please enter yes or no");
				decision = input.nextLine().toLowerCase();
				repeat = true;
			}
		}while(repeat);

		if(stickToDefault){
			System.out.println("How long would you like the plot to extend to (in mins)?");
			double t = input.nextDouble();
			runDefault(t);
		}
		input.close();
	}

	public static void runDefault(double time){
		//Initialise Tissue
		Muscle muscle = new Muscle(2.0, 10.0, 1.2, 0.0);
		Skin skin = new Skin(2.0, 5.0, 1.1, 0.0);
		Fat fat = new Fat(3.0, 2.0, 2.0, 0.0);
		Kidney kidney = new Kidney(1.0, 5.0, 1.05, 0.10, 0.0);
		Liver liver = new Liver(1.0, 3.0, 1.05, 0.05, 0.0);

		System.out.println("\nDefault parameters are: ");
		Tissue[] tissues =  new Tissue[]{muscle, skin, fat, kidney, liver};
		for(Tissue t : tissues){t.display();}

		Blood blood = new Blood(9.0, 5.0, 20.0, tissues);

		System.out.println("Tissue Test");
		for(Tissue t : tissues){
			System.out.println(t.function(new double[]{0.0}));
		}

		System.out.println("\nBlood Test");
		System.out.println(blood.function(new double[]{0.0}));

		//Solve Differential Equations
		System.out.println("\nDifferential Solver Test");
		Function[] functions =  new Function[]{muscle, skin, fat, kidney, liver, blood};
		double[] inital = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 20.0};

		System.out.println("EULER:");
		Euler euler = new Euler(0.01, functions);
		System.out.println(Arrays.toString(euler.solve(0.0, inital, 60.0)));

		System.out.println("RK4:");
		RK4 rk4 = new RK4(0.05, functions);
		System.out.println(Arrays.toString(rk4.solve(0.0, inital, 60.0)));

		System.out.println("CASH-KARP:");
		Solver solver = new Solver(0.01, functions);
		System.out.println(Arrays.toString(solver.solve(0.0, inital, time)));

		System.out.println("ESTIMATED ANSWER:");
		System.out.println("[1.6, 1.4, 2.4, 0.87, 1.13, 1.2]");/**/
	}
}