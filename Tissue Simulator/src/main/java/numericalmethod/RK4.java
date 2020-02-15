package numericalmethod;
import java.util.Arrays;

public class RK4{
	private double h ;
	private Function[] f;

	public RK4(double h, Function[] f){
		this.h = h;
		this.f = f;
	}

	public double[] solve(double xinit, double[] yinit, double xFinal){
		//Muscle, Skin, Fat, Kidney, Liver, Blood
		double x = xinit;
		double[] current = Arrays.copyOf(yinit, yinit.length);
		double[] next = Arrays.copyOf(yinit, yinit.length);
		double[] exit = new double[next.length];

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

				exit[i] = current[i] + ((37./378.)*k1 + (250./621.)*k3 + (125./594.)*k4 + (512./1771.)*k6) * this.h;
				next = Arrays.copyOf(current, current.length);
			}
			this.f[5].setOpConditions(next);
			current = Arrays.copyOf(exit, exit.length);
			x+=h;
		}while(x < xFinal);

		return exit;
	}

	private double[] updateNext(double[] current, double add){
		double[] next = new double[current.length];

		for(int i = 0; i < next.length; i++){
			next[i] = current[i] + add;
		}

		return next;
	}

}