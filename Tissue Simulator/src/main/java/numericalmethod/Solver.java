package numericalmethod;
import java.util.Arrays;

public class Solver{
	private double h;
	private Function[] f;
	//private double tolerance = 0.01;

	public Solver(double h, Function[] f){
		this.h = h;
		this.f = f;
	}

	public double[] solve(double xinit, double[] yinit, double xFinal){
		//Muscle, Skin, Fat, Kidney, Liver, Blood
		double x = xinit;
		double[] current = Arrays.copyOf(yinit, yinit.length);
		double[] next = Arrays.copyOf(yinit, yinit.length);
		double[] exit4 = new double[next.length];
		double[] exit5 = new double[next.length];

		do{
			for(int i = 0; i < f.length; i++){
				double add;
				//K1
				double k1 = this.f[i].function(new double[]{0.0});
				//K2
				add = 0.2*k1*this.h;
				next = updateNext(current, add);
				this.f[5].setOpConditions(next);
				double k2 = this.f[i].function(new double[]{0.0});
				//K3
				add = (3./40.)*k1*this.h + (9./40.)*k2*this.h;
				next = updateNext(current, add);
				this.f[5].setOpConditions(next);
				double k3 = this.f[i].function(new double[]{0.0});
				//K4
				add = (3./10.)*k1*this.h - (9./10.)*k2*this.h + (6./5.)*k3*this.h;
				next = updateNext(current, add);
				this.f[5].setOpConditions(next);
				double k4 = this.f[i].function(new double[]{0.0});
				//K5
				add = (-11./54.)*k1*this.h + (5./2.)*k2*this.h - (70./27.)*k3*this.h + (35./27.)*k4*this.h;
				next = updateNext(current, add);
				this.f[5].setOpConditions(next);
				double k5 = this.f[i].function(new double[]{0.0});
				//K6
				add = (1631./55296.)*k1*this.h + (175./512.)*k2*this.h + (575./13824.)*k3*this.h + (44275./110592.)*k4*this.h + (253./4096.)*k5*this.h;
				next = updateNext(current, add);
				this.f[5].setOpConditions(next);
				double k6 = this.f[i].function(new double[]{0.0});
				this.f[5].setOpConditions(current);

				exit4[i] = current[i] + ((37./378.)*k1 + (250./621.)*k3 + (125./594.)*k4 + (512./1771.)*k6) * this.h;
				exit5[i] = current[i] + ((2825./27648.)*k1 + (18575./48384.)*k3 + (13525./55296.)*k4 + (277./14336)*k5 + (1./4.)*k6) * this.h;
				next = Arrays.copyOf(current, current.length);
			}
			
			this.f[5].setOpConditions(next);
			current = Arrays.copyOf(exit5, exit5.length);
			x+=this.h;/**/

			/*if(adaptStepsize(exit4, exit5)){
				this.f[5].setOpConditions(next);
				current = Arrays.copyOf(exit5, exit5.length);
				x+=this.h;
			}/**/

		}while(x < xFinal);

		return exit5;
	}

	private double[] updateNext(double[] current, double add){
		double[] next = new double[current.length];

		for(int i = 0; i < next.length; i++){
			next[i] = current[i] + add;
		}
		return next;
	}

	/*
	private double errorEstimate(double[] a1, double[] a2){
		double maxError = 10e9;
		for(int i = 0; i < a1.length; i++){
			if(Math.abs(a1[i] - a2[i]) < maxError){
				maxError = Math.abs(a1[i] - a2[i]);
			}
		}
		return maxError;
	}

	
	private boolean adaptStepsize(double[] exit4, double[] exit5){
		if(errorEstimate(exit4, exit5) <= tolerance){
			this.h = this.h * Math.pow(Math.abs(tolerance / errorEstimate(exit4, exit5)), 0.2);
			return true;
		}
		else{
			this.h = this.h * Math.pow(Math.abs(tolerance / errorEstimate(exit4, exit5)), 0.25);
			return false;
		}
	}/**/

}