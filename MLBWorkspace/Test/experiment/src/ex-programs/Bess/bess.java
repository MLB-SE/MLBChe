//package Bess;

public class bess {
	public static double bessi( int n, double x)
	{
		final double ACC=200.0;
		final int IEXP=Double.MAX_EXPONENT/2;
		int j,k;
		double bi,bim,bip,dum,tox,ans;

		if (n < 2) System.out.println("Index n less than 2 in bessi");
		if (x*x <= 8.0*Double.MIN_VALUE) return 0.0;
		else {
			tox=2.0/Math.abs(x);
			bip=ans=0.0;
			bi=1.0;
			for (j=(int) (2*(n+(int)(Math.sqrt(ACC*n))));j>0;j--) {
				bim=bip+j*tox*bi;
				bip=bi;
				bi=bim;
				k = Math.getExponent(bi);
				dum=bi/Math.pow(2, Math.getExponent(bi));//frexp(bi,&k);
				if (k > IEXP) {
					ans=ans*Math.pow(2, -IEXP);//ldexp(ans,-IEXP);
					bi=bi*Math.pow(2, -IEXP);//ldexp(bi,-IEXP);
					bip=bip*Math.pow(2, -IEXP);//ldexp(bip,-IEXP);
				}
				if (j == n) ans=bip;
			}
			ans *= bessi0(x)/bi;
			
			return x < 0.0 && ((n & 1) == 1) ? -ans : ans;
		}
	}

	private static double bessi0(double x) {
			double ax,ans,y;

			if ((ax=Math.abs(x)) < 3.75) {
				y=x/3.75;
				y*=y;
				ans=1.0+y*(3.5156229+y*(3.0899424+y*(1.2067492
					+y*(0.2659732+y*(0.360768e-1+y*0.45813e-2)))));
			} else {
				y=3.75/ax;
				ans=(Math.exp(ax)/Math.sqrt(ax))*(0.39894228+y*(0.1328592e-1
					+y*(0.225319e-2+y*(-0.157565e-2+y*(0.916281e-2
					+y*(-0.2057706e-1+y*(0.2635537e-1+y*(-0.1647633e-1
					+y*0.392377e-2))))))));
			}
			return ans;
	}	
	
	private static double bessi1(double x){
		double ax,ans,y;

		if ((ax=Math.abs(x)) < 3.75) {
			y=x/3.75;
			y*=y;
			ans=ax*(0.5+y*(0.87890594+y*(0.51498869+y*(0.15084934
				+y*(0.2658733e-1+y*(0.301532e-2+y*0.32411e-3))))));
		} else {
			y=3.75/ax;
			ans=0.2282967e-1+y*(-0.2895312e-1+y*(0.1787654e-1
				-y*0.420059e-2));
			ans=0.39894228+y*(-0.3988024e-1+y*(-0.362018e-2
				+y*(0.163801e-2+y*(-0.1031555e-1+y*ans))));
			ans *= (Math.exp(ax)/Math.sqrt(ax));
		}
		return x < 0.0 ? -ans : ans;
	}
	
	public static double bessk( int n, double x){
		int j;
		double bk,bkm,bkp,tox;

		if (n < 2) System.out.println("Index n less than 2 in bessk");
		tox=2.0/x;
		bkm=bessk0(x);
		bk=bessk1(x);
		for (j=1;j<n;j++) {
			bkp=bkm+j*tox*bk;
			bkm=bk;
			bk=bkp;
		}
		return bk;
	}
	
	private static double bessk0(double x){
		double y,ans;

		if (x <= 2.0) {
			y=x*x/4.0;
			ans=(-Math.log(x/2.0)*bessi0(x))+(-0.57721566+y*(0.42278420
				+y*(0.23069756+y*(0.3488590e-1+y*(0.262698e-2
				+y*(0.10750e-3+y*0.74e-5))))));
		} else {
			y=2.0/x;
			ans=(Math.exp(-x)/Math.sqrt(x))*(1.25331414+y*(-0.7832358e-1
				+y*(0.2189568e-1+y*(-0.1062446e-1+y*(0.587872e-2
				+y*(-0.251540e-2+y*0.53208e-3))))));
		}
		return ans;
	}
	

	private static double bessk1(double x){
		double y,ans;

		if (x <= 2.0) {
			y=x*x/4.0;
			ans=(Math.log(x/2.0)*bessi1(x))+(1.0/x)*(1.0+y*(0.15443144
					+y*(-0.67278579+y*(-0.18156897+y*(-0.1919402e-1
							+y*(-0.110404e-2+y*(-0.4686e-4)))))));
		} else {
			y=2.0/x;
			ans=(Math.exp(-x)/Math.sqrt(x))*(1.25331414+y*(0.23498619
					+y*(-0.3655620e-1+y*(0.1504268e-1+y*(-0.780353e-2
							+y*(0.325614e-2+y*(-0.68245e-3)))))));
		}
		return ans;
	}
	
	public static double bessj( int n, double x){
		final double ACC=160.0;
		final int IEXP=Double.MAX_EXPONENT/2;
		boolean jsum;
		int j,k,m;
		double ax,bj,bjm,bjp,dum,sum,tox,ans;

		if (n < 2) System.out.println("Index n less than 2 in bessj");
		ax=Math.abs(x);
		if (ax*ax <= 8.0*Double.MIN_VALUE) return 0.0;
		else if (ax > (n)) {
			tox=2.0/ax;
			bjm=bessj0(ax);
			bj=bessj1(ax);
			for (j=1;j<n;j++) {
				bjp=j*tox*bj-bjm;
				bjm=bj;
				bj=bjp;
			}
			ans=bj;
		} else {
			tox=2.0/ax;
			m=(int) (2*((n+(Math.sqrt(ACC*n)))/2));
			jsum=false;
			bjp=ans=sum=0.0;
			bj=1.0;
			for (j=m;j>0;j--) {
				bjm=j*tox*bj-bjp;
				bjp=bj;
				bj=bjm;
				
				k = Math.getExponent(bj);
				dum=bj/Math.pow(2, Math.getExponent(bj));//frexp(bj,&k);
				if (k > IEXP) {
					bj*=Math.pow(2, -IEXP);//ldexp(bj,-IEXP);
					bjp*=Math.pow(2, -IEXP);//ldexp(bjp,-IEXP);
					ans*=Math.pow(2, -IEXP);//=ldexp(ans,-IEXP);
					sum*=Math.pow(2, -IEXP);//ldexp(sum,-IEXP);
				}
				if (jsum) sum += bj;
				jsum=!jsum;
				if (j == n) ans=bjp;
			}
			sum=2.0*sum-bj;
			ans /= sum;
		}
		return x < 0.0 && (n & 1) == 1 ? -ans : ans;
	}
	
	private static double bessj0(double x){
		double ax,z,xx,y,ans,ans1,ans2;

		if ((ax=Math.abs(x)) < 8.0) {
			y=x*x;
			ans1=57568490574.0+y*(-13362590354.0+y*(651619640.7
				+y*(-11214424.18+y*(77392.33017+y*(-184.9052456)))));
			ans2=57568490411.0+y*(1029532985.0+y*(9494680.718
				+y*(59272.64853+y*(267.8532712+y*1.0))));
			ans=ans1/ans2;
		} else {
			z=8.0/ax;
			y=z*z;
			xx=ax-0.785398164;
			ans1=1.0+y*(-0.1098628627e-2+y*(0.2734510407e-4
				+y*(-0.2073370639e-5+y*0.2093887211e-6)));
			ans2 = -0.1562499995e-1+y*(0.1430488765e-3
				+y*(-0.6911147651e-5+y*(0.7621095161e-6
				-y*0.934945152e-7)));
			ans=Math.sqrt(0.636619772/ax)*(Math.cos(xx)*ans1-z*Math.sin(xx)*ans2);
		}
		return ans;
	}
	
	private static double bessj1(double x){
		double  ax,z,xx,y,ans,ans1,ans2;

		if ((ax=Math.abs(x)) < 8.0) {
			y=x*x;
			ans1=x*(72362614232.0+y*(-7895059235.0+y*(242396853.1
				+y*(-2972611.439+y*(15704.48260+y*(-30.16036606))))));
			ans2=144725228442.0+y*(2300535178.0+y*(18583304.74
				+y*(99447.43394+y*(376.9991397+y*1.0))));
			ans=ans1/ans2;
		} else {
			z=8.0/ax;
			y=z*z;
			xx=ax-2.356194491;
			ans1=1.0+y*(0.183105e-2+y*(-0.3516396496e-4
				+y*(0.2457520174e-5+y*(-0.240337019e-6))));
			ans2=0.04687499995+y*(-0.2002690873e-3
				+y*(0.8449199096e-5+y*(-0.88228987e-6
				+y*0.105787412e-6)));
			ans=Math.sqrt(0.636619772/ax)*(Math.cos(xx)*ans1-z*Math.sin(xx)*ans2);
			if (x < 0.0) ans = -ans;
		}
		return ans;
	}
	
	public static double bessy(int n, double x){
		int j;
		double by,bym,byp,tox;

		if (n < 2) System.out.println("Index n less than 2 in bessy");
		tox=2.0/x;
		by=bessy1(x);
		bym=bessy0(x);
		for (j=1;j<n;j++) {
			byp=j*tox*by-bym;
			bym=by;
			by=byp;
		}
		return by;
	}
	
	private static double bessy0(double x){
		double z,xx,y,ans,ans1,ans2;

		if (x < 8.0) {
			y=x*x;
			ans1 = -2957821389.0+y*(7062834065.0+y*(-512359803.6
				+y*(10879881.29+y*(-86327.92757+y*228.4622733))));
			ans2=40076544269.0+y*(745249964.8+y*(7189466.438
				+y*(47447.26470+y*(226.1030244+y*1.0))));
			ans=(ans1/ans2)+0.636619772*bessj0(x)*Math.log(x);
		} else {
			z=8.0/x;
			y=z*z;
			xx=x-0.785398164;
			ans1=1.0+y*(-0.1098628627e-2+y*(0.2734510407e-4
				+y*(-0.2073370639e-5+y*0.2093887211e-6)));
			ans2 = -0.1562499995e-1+y*(0.1430488765e-3
				+y*(-0.6911147651e-5+y*(0.7621095161e-6
				+y*(-0.934945152e-7))));
			ans=Math.sqrt(0.636619772/x)*(Math.sin(xx)*ans1+z*Math.cos(xx)*ans2);
		}
		return ans;
	}
	
	private static double bessy1(double x){
		double z,xx,y,ans,ans1,ans2;

		if (x < 8.0) {
			y=x*x;
			ans1=x*(-0.4900604943e13+y*(0.1275274390e13
				+y*(-0.5153438139e11+y*(0.7349264551e9
				+y*(-0.4237922726e7+y*0.8511937935e4)))));
			ans2=0.2499580570e14+y*(0.4244419664e12
				+y*(0.3733650367e10+y*(0.2245904002e8
				+y*(0.1020426050e6+y*(0.3549632885e3+y)))));
			ans=(ans1/ans2)+0.636619772*(bessj1(x)*Math.log(x)-1.0/x);
		} else {
			z=8.0/x;
			y=z*z;
			xx=x-2.356194491;
			ans1=1.0+y*(0.183105e-2+y*(-0.3516396496e-4
				+y*(0.2457520174e-5+y*(-0.240337019e-6))));
			ans2=0.04687499995+y*(-0.2002690873e-3
				+y*(0.8449199096e-5+y*(-0.88228987e-6
				+y*0.105787412e-6)));
			ans=Math.sqrt(0.636619772/x)*(Math.sin(xx)*ans1+z*Math.cos(xx)*ans2);
		}
		return ans;
	}
}
