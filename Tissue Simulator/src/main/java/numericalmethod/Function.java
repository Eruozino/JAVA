package numericalmethod;

public interface Function{
	double function(double[] parameters);
	void setOpConditions(double[] update);
}