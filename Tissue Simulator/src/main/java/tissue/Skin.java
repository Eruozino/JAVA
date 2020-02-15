package tissue;
import numericalmethod.*;

public class Skin extends Tissue implements Function{
	private double Cskin;

	public Skin(double Qskin, double Vskin, double Pskin, double Co){
		super(Qskin,Vskin,Pskin,Co);
		this.Cskin = Co;
	}

	public double getC(){return this.Cskin;}
	public void setC(double C){this.Cskin = C;}

	public void setOpConditions(double[] parameters){return;}

	public double function(double[] parameters){
		return ((Q*(Cb - Cskin/P)/V));
	}
}