package tissue;
import numericalmethod.*;

public class Fat extends Tissue implements Function{
	private double Cfat;

	public Fat(double Qfat, double Vfat, double Pfat, double Co){
		super(Qfat,Vfat,Pfat,Co);
		this.Cfat = Co;
	}

	public double getC(){return this.Cfat;}
	public void setC(double C){this.Cfat = C;}

	public void setOpConditions(double[] parameters){return;}

	public double function(double[] parameters){
		return ((Q*(Cb - Cfat/P)/V));
	}
}