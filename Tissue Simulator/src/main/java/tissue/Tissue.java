package tissue;

public abstract class Tissue{
	protected double Q, V, P, Co, Cb;

	public Tissue(double Q, double V, double P, double Co){
		this.Q = Q;
		this.V = V;
		this.P = P;
		this.Co = Co;
	}

	public double getQ(){return this.Q;}
	public double getP(){return this.P;}

	public void setCb(double Cb){this.Cb = Cb;}

	public void setOpConditions(double[] parameters){return;}

	public abstract double getC();
	public abstract void setC(double C);
	public abstract double function(double[] parameters);

	public void display(){
		System.out.printf("\nQ: %f\nV: %f\nP: %f\nCo: %f\n", Q, V, P, Co);
	}

}