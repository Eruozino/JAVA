package tissue;
import numericalmethod.*;

public class Muscle extends Tissue implements Function{
	private double Cmus;

	public Muscle(double Qmus, double Vmus, double Pmus, double Co){
		super(Qmus,Vmus,Pmus,Co);
		this.Cmus = Co;
	}

	public double getC(){return this.Cmus;}
	public void setC(double C){this.Cmus = C;}

	public void setOpConditions(double[] parameters){return;}

	public double function(double[] parameters){
		//System.out.println("\n CMUS: "+Cmus);
		return ((Q*(Cb - Cmus/P)/V));
	}
}