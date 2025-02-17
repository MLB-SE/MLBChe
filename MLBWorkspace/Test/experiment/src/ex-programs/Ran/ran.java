//package Ran;

public class ran {
	
	public static double ran0(int idum){//&idum
		final int IA=16807,IM=2147483647,IQ=127773;
		final int IR=2836,MASK=123459876;
		final double AM=1.0/(double)IM;
		int k;
		double ans;

		idum ^= MASK;
		k=idum/IQ;
		idum=IA*(idum-k*IQ)-IR*k;
		if (idum < 0) idum += IM;
		ans=AM*idum;
		idum ^= MASK;
		return ans;
	}
	
	public static double ran1(int idum){//&idum
		final int IA=16807,IM=2147483647,IQ=127773,IR=2836,NTAB=32;
		final int NDIV=(1+(IM-1)/NTAB);
		final double EPS=3.0e-16,AM=1.0/IM,RNMX=(1.0-EPS);
		int iy=0;
		int[] iv = new int[NTAB];
		int j,k;
		double temp;

		if (idum <= 0 || iy==0) {
			if (-idum < 1) idum=1;
			else idum = -idum;
			for (j=NTAB+7;j>=0;j--) {
				k=idum/IQ;
				idum=IA*(idum-k*IQ)-IR*k;
				if (idum < 0) idum += IM;
				if (j < NTAB) iv[j] = idum;
			}
			iy=iv[0];
		}
		k=idum/IQ;
		idum=IA*(idum-k*IQ)-IR*k;
		if (idum < 0) idum += IM;
		j=iy/NDIV;
		iy=iv[j];
		iv[j] = idum;
		if ((temp=AM*iy) > RNMX) return RNMX;
		else return temp;
	}
	
	public static double ran2(int idum){//&idum
		final int IM1=2147483563,IM2=2147483399;
		final int IA1=40014,IA2=40692,IQ1=53668,IQ2=52774;
		final int IR1=12211,IR2=3791,NTAB=32,IMM1=IM1-1;
		final int NDIV=1+IMM1/NTAB;
		final double EPS=3.0e-16,RNMX=1.0-EPS,AM=1.0/(double)(IM1);
		int idum2=123456789,iy=0;
		int[] iv = new int[NTAB];
		int j,k;
		double temp;

		if (idum <= 0) {
			idum=(idum==0 ? 1 : -idum);
			idum2=idum;
			for (j=NTAB+7;j>=0;j--) {
				k=idum/IQ1;
				idum=IA1*(idum-k*IQ1)-k*IR1;
				if (idum < 0) idum += IM1;
				if (j < NTAB) iv[j] = idum;
			}
			iy=iv[0];
		}
		k=idum/IQ1;
		idum=IA1*(idum-k*IQ1)-k*IR1;
		if (idum < 0) idum += IM1;
		k=idum2/IQ2;
		idum2=IA2*(idum2-k*IQ2)-k*IR2;
		if (idum2 < 0) idum2 += IM2;
		j=iy/NDIV;
		iy=iv[j]-idum2;
		iv[j] = idum;
		if (iy < 1) iy += IMM1;
		if ((temp=AM*iy) > RNMX) return RNMX;
		else return temp;
	}
	public static double ran3(int idum)	{//&idum
		int inext = 0,inextp = 0;
		int iff=0;
		final int MBIG=1000000000,MSEED=161803398,MZ=0;
		final double FAC=(1.0/MBIG);
		int[] ma = new int[56];
		int i,ii,k,mj,mk;

		if (idum < 0 || iff == 0) {
			iff=1;
			mj=Math.abs(MSEED-Math.abs(idum));
			mj %= MBIG;
			ma[55]=mj;
			mk=1;
			for (i=1;i<=54;i++) {
				ii=(21*i) % 55;
				ma[ii]=mk;
				mk=mj-mk;
				if (mk < (int)(MZ)) mk += MBIG;
				mj=ma[ii];
			}
			for (k=0;k<4;k++)
				for (i=1;i<=55;i++) {
					ma[i] -= ma[1+(i+30) % 55];
					if (ma[i] < (int)(MZ)) ma[i] += MBIG;
				}
			inext=0;
			inextp=31;
			idum=1;
		}
		if (++inext == 56) inext=1;
		if (++inextp == 56) inextp=1;
		mj=ma[inext]-ma[inextp];
		if (mj < (int)(MZ)) mj += MBIG;
		ma[inext]=mj;
		return mj*FAC;
	}
	
	
}
