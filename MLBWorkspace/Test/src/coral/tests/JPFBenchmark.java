package coral.tests;

import org.apache.commons.math3.util.FastMath;

public class JPFBenchmark {

  public static String sucess = "sucess";

  // sin(x) + cos(y) > 1.0
  public static void benchmark01(double x, double y) {
    if (Math.sin(x) + Math.cos(y) > 1) {
      System.out.println("sucess");
    }
  }

  // sin(x) - cos(y) < 0.0000000001
  public static void benchmark02(double x, double y) {
    if (Math.sin(x) - Math.cos(y) < 0.0000000001) {
      System.out.println("sucess");
    }
  }

  // sin(x) - cos(y) == 0.0
  public static void benchmark03(double x, double y) {
    if (Math.sin(x) - Math.cos(y) == 0) {
      System.out.println("sucess");
    }
  }

  // exp(x) > 0.0
  public static void benchmark04(double x) {
    if (Math.exp(x) > 0) {
      System.out.println("sucess");
    }
  }

  // sin A + sin B + sin C = 4 * cos A * cos B * cos C
  public static void benchmark05(double x, double y, double z) {
    if (Math.sin(x) + Math.sin(y) + Math.sin(z) == 4 * Math.cos(x)
        * Math.cos(y) * Math.cos(z)) {
      System.out.println("sucess");
    }
  }

  // cos A + cos B + cos C > 4 sin A/2 sin B/2 sin C/2
  public static void benchmark06(double x, double y, double z) {
    if (Math.cos(x) + Math.cos(y) + Math.cos(z) > 4 * Math.sin(x / 2)
        * Math.sin(y / 2) * Math.sin(z / 2)) {
      System.out.println("sucess");
    }
  }

  // (sin(2x - y)/(cos(2y + y) + 1) = cos(2z + x)/(sin(2w + y) - 1)
  public static void benchmark07(double x, double y, double z, double w) {
    if (Math.sin(2 * x - y) / (Math.cos(2 * y + y) + 1) == Math.cos(2 * z + x)
        / (Math.sin(2 * w + y) - 1)) {
      System.out.println("sucess");
    }
  }

  // cos(3x+2y-z) * sin(z+x+y) == cos(z*x*y)
  public static void benchmark08(double x, double y, double z) {
    if (Math.cos(3 * x + 2 * y - z) * Math.sin(z + x + y) == Math
        .cos(z * x * y)) {
      System.out.println("sucess");
    }
  }

  // Math.sin(Math.cos(x*y)) < Math.cos(Math.sin(x*y))
  public static void benchmark09(double x, double y) {
    if (Math.sin(Math.cos(x * y)) < Math.cos(Math.sin(x * y))) {
      System.out.println("sucess");
    }
  }

  // Math.sin(x*Math.cos(y*Math.sin(z))) > Math.cos(x*Math.sin(y*Math.cos(z)))
  public static void benchmark10(double x, double y, double z) {
    if (Math.sin(x * Math.cos(y * Math.sin(z))) > Math.cos(x
        * Math.sin(y * Math.cos(z)))) {
      System.out.println("sucess");
    }
  }





}
