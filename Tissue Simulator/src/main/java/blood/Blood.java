package blood;
import tissue.*;
import numericalmethod.*;

public class Blood implements Function {
	private double Qb, Vb, Cb;
	private Tissue[] tissues;

	public Blood(double Qb, double Vb, double Cbo, Tissue[] tissues){
		this.Qb = Qb;
		this.Vb = Vb;
		this.Cb = Cbo;
		this.tissues = tissues;
		this.setTissueCb(Cbo);
	}

	public void setTissueCb(double Cb){
		for(Tissue t : this.tissues){
			t.setCb(this.Cb);
		}
	}

	public void setOpConditions(double[] update){
		//Update C in individual tissues
		for(int i = 0; i < 5; i++){
			tissues[i].setC(update[i]);
		}

		//Update Blood C
		this.Cb = update[5];
		
		//Update Cb in tissues
		setTissueCb(update[5]);
	}

	public double function(double[] parameters){
		double delCb = 0;
		for(Tissue t : this.tissues){
			delCb += (t.getQ()*t.getC())/t.getP();
		}
		delCb = delCb - (this.Qb*this.Cb);
		delCb = delCb / this.Vb;
		return delCb;
	}
}