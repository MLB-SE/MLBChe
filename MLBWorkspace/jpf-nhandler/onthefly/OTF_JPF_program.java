import gov.nasa.jpf.vm.NativePeer;
import gov.nasa.jpf.vm.MJIEnv;
import nhandler.conversion.ConversionException;
import nhandler.conversion.ConverterBase;
import nhandler.conversion.jvm2jpf.JVM2JPFConverter;
import nhandler.conversion.jpf2jvm.JPF2JVMConverter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class OTF_JPF_program extends NativePeer {

  public OTF_JPF_program() {
  }

  public static double newsqrt__D__D (MJIEnv env, int robj, double arg0) {
    return 0.0;
  }
}
