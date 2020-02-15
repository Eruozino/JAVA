package numericalmethod;
import java.util.Arrays;

public class Euler{
	private double h ;
	private Function[] f;

	public Euler(double h, Function[] f){
		this.h = h;
		this.f = f;
	}

	public double[] solve(double xinit, double[] yinit, double xFinal){
		//Muscle, Skin, Fat, Kidney, Liver, Blood
		double x = xinit;
		double[] current = Arrays.copyOf(yinit, yinit.length);
		double[] next = new double[f.length];

		do{
			//System.out.println("Current: "+Arrays.toString(current));
			for(int i = 0; i < f.length; i++){
				//System.out.printf("%f + %f * 0.05\n", current[i], this.f[i].function(new double[]{0.0}));
				next[i] = current[i] + this.f[i].function(new double[]{0.0}) * h;
			}
			this.f[5].setOpConditions(next);
			current = Arrays.copyOf(next, next.length);
			x+=h;
		}while(x < xFinal);

		return next;
	}
}