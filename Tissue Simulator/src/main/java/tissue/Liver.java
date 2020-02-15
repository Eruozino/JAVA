package tissue;
import numericalmethod.*;

public class Liver extends Tissue implements Function{
	private double km, Cliver;

	public Liver(double Qliver, double Vliver, double Pliver, double km, double Co){
		super(Qliver,Vliver,Pliver,Co);
		this.km = km;
		this.Cliver = Co;
	}

	public double getC(){return this.Cliver;}
	public void setC(double C){this.Cliver = C;}

	public void setOpConditions(double[] parameters){return;}

	public double function(double[] parameters){
		return (((Q*(Cb - Cliver/P) - (km*Cliver*V))/V));
	}
}