package tissue;
import numericalmethod.*;

public class Kidney extends Tissue implements Function{
	private double ke, Ckidney;

	public Kidney(double Qkidney, double Vkidney, double Pkidney, double ke, double Co){
		super(Qkidney,Vkidney,Pkidney,Co);
		this.ke = ke;
		this.Ckidney = Co;
	}

	public double getC(){return this.Ckidney;}
	public void setC(double C){this.Ckidney = C;}

	public void setOpConditions(double[] parameters){return;}

	public double function(double[] parameters){
		return (((Q*(Cb - Ckidney/P) - (ke*Ckidney*V))/V));
	}
}