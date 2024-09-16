
/**
 * Write a description of class LogoRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class LogoRunner
{
    // add methods to organize your code ;)
// circle(double x, double y, double radius)}
// ellipse(double x, double y, double semiMajorAxis, double semiMinorAxis)}
// square(double x, double y, double halfLength)}
// rectangle(double x, double y, double halfWidth, double halfHeight)}
// arc(double x, double y, double radius, double angle1, double angle2)}
// polygon(double[] x, double[] y)}
 //filledPolygon(double[] x, double[] y)}
 // with vertices (0.1, 0.2), (0.2, 0.3), (0.3, 0.2), and (0.2, 0.1):
//double[] x = { 0.1, 0.2, 0.3, 0.2 };
 //double[] y = { 0.2, 0.3, 0.2, 0.1 };
 // StdDraw.filledPolygon(x, y);
   
    public static void main (String []args) {
        //star1
        double[] x = { -50, -45, -40, -43,-42,-50,-58,-57, -60, -55 };
        double[] y = { 50, 45, 45, 40, 35, 38, 35, 40, 45, 45 };
        //yellow triagle
        double[] x1 = {110,-110,0};
        double[] y1 = {-95,-95,-150};
        //big blue triangle
        double[] x2 = {-115,115,-115};
        double[] y2 = {155,155,-102};
        
        // write your staring code here
        StdDraw.setCanvasSize();
        StdDraw.setXscale(-200,200);
        StdDraw.setYscale(-200,200);
        
        //yellow corner arcs
        StdDraw.setPenRadius(0.040);
        StdDraw.setPenColor(247, 209, 23);
        StdDraw.arc(-105, -80, 15, 90,-45 );
        StdDraw.arc(105, -80, 15, 235, 90);
        
        
        // Yellow rect
        StdDraw.setPenRadius(0.040);
        StdDraw.setPenColor(247, 209, 23);
        StdDraw.rectangle(0, 40, 120,120);
        
        
        //Blue triangle
        StdDraw.setPenRadius(0.010);
        StdDraw.setPenColor(23, 23, 150);
        StdDraw.filledPolygon(x2, y2);
        
        
        //triangle
        StdDraw.setPenRadius(0.040);
        StdDraw.setPenColor(247, 209, 23);
        StdDraw.polygon(x1,y1);
        
        StdDraw.setPenRadius(0.020);
        StdDraw.setPenColor(StdDraw.WHITE);
        
        
        //white triangle
        StdDraw.setPenRadius(0.020);
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] x4 = {-90,60,-90};
        double[] y4 = {130,130,-25};
        StdDraw.filledPolygon(x4, y4);
        
        
        //color arc
        StdDraw.setPenRadius(0.023);
        StdDraw.setPenColor(23, 23, 150);
        StdDraw.arc(-103, -83.5, 8, 90,-120 );
        StdDraw.setPenColor(212, 46, 18);
        //212, 46, 18 StdDraw.MAGENT
        StdDraw.arc(103, -79, 8, 235, 90);
        
        
        
        //red white stripes
        StdDraw.setPenRadius(0.020);
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] x3 = {-80,-110,-80};
        double[] y3 = {-110,-94,-62};
        StdDraw.filledPolygon(x3, y3);
        StdDraw.setPenRadius(0.020);
        StdDraw.setPenColor(212, 46, 18);
        double[] x5 = {-80,-80,-52.5,-52.5};
        double[] y5 = {-110,-62,-31,-123};
        StdDraw.filledPolygon(x5,y5);
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] x6 = {-52.5, -52.5, -22.5, -22.5};
        double[] y6 = {-31,-123, -138, 3};
        StdDraw.filledPolygon(x6, y6);
        StdDraw.setPenColor(212, 46, 18);
        double[] x7 = {-22.5 , -22.5, 0, 5, 5};
        double[] y7 = {3, -138, -150, -148,34};
        StdDraw.filledPolygon(x7,y7);
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] x8 = {5, 5, 35, 35};
        double[] y8 = {-148,34, 67, -130 };
        StdDraw.filledPolygon(x8, y8);
        StdDraw.setPenColor(212, 46, 18);
        double[] x9 = {35, 35, 62.5, 62.5};
        double[] y9 = {67, -130, -115, 98};
        StdDraw.filledPolygon(x9,y9);
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] x10 = {62.5, 62.5,92.5,92.5};
        double[] y10 = {-115, 98, 130, -100};
        StdDraw.filledPolygon(x10, y10);
        StdDraw.setPenColor(212, 46, 18);
        double[] x11 = {92.5, 92.5, 115, 115};
        double[] y11 = {130, -100, -85, 155};
        //88
        StdDraw.filledPolygon(x11,y11);
        
        //stars
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledPolygon(x,y);
        double[] xs = new double[10];
        double[] ys = new double[10];        
        for (int i = 0; i < 10; i++) {
            double angle = 2 * Math.PI / 10 * i + Math.PI / 2;
            double radius;
            if (i % 2 == 0) {
                radius = 12;
            } else {
                radius = 6;
            }
            xs[i] = radius * Math.cos(angle)-30;
            ys[i] = radius * Math.sin(angle)+20;
        }
        StdDraw.filledPolygon(xs, ys);
        double[] xs1 = new double[10];
        double[] ys1 = new double[10];        
        for (int i = 0; i < 10; i++) {
            double angle = 2 * Math.PI / 10 * i + Math.PI / 2;
            double radius;
            if (i % 2 == 0) {
                radius = 12;
            } else {
                radius = 6;
            }
            xs1[i] = radius * Math.cos(angle)-97;
            ys1[i] = radius * Math.sin(angle)-50;
        }
        StdDraw.filledPolygon(xs1, ys1);
        double[] xs2 = new double[10];
        double[] ys2 = new double[10];        
        for (int i = 0; i < 10; i++) {
            double angle = 2 * Math.PI / 10 * i + Math.PI / 2;
            double radius;
            if (i % 2 == 0) {
                radius = 12;
            } else {
                radius = 6;
            }
            xs2[i] = radius * Math.cos(angle)+29;
            ys2[i] = radius * Math.sin(angle)+80;
        }
        StdDraw.filledPolygon(xs2, ys2);
        double[] xs3 = new double[10];
        double[] ys3 = new double[10];        
        for (int i = 0; i < 10; i++) {
            double angle = 2 * Math.PI / 10 * i + Math.PI / 2;
            double radius;
            if (i % 2 == 0) {
                radius = 12;
            } else {
                radius = 6;
            }
            xs3[i] = radius * Math.cos(angle)+80;
            ys3[i] = radius * Math.sin(angle)+140;
        }
        StdDraw.filledPolygon(xs3, ys3);
        double[] xs4 = new double[10];
        double[] ys4 = new double[10];        
        for (int i = 0; i < 10; i++) {
            double angle = 2 * Math.PI / 10 * i + Math.PI / 2;
            double radius;
            if (i % 2 == 0) {
                radius = 12;
            } else {
                radius = 6;
            }
            xs4[i] = radius * Math.cos(angle)-7;
            ys4[i] = radius * Math.sin(angle)+141;
        }
        StdDraw.filledPolygon(xs4, ys4);
        double[] xs5 = new double[10];
        double[] ys5 = new double[10];        
        for (int i = 0; i < 10; i++) {
            double angle = 2 * Math.PI / 10 * i + Math.PI / 2;
            double radius;
            if (i % 2 == 0) {
                radius = 12;
            } else {
                radius = 6;
            }
            xs5[i] = radius * Math.cos(angle)-97;
            ys5[i] = radius * Math.sin(angle)+141;
        }
        StdDraw.filledPolygon(xs5, ys5);
        double[] xs6 = new double[10];
        double[] ys6 = new double[10];        
        for (int i = 0; i < 10; i++) {
            double angle = 2 * Math.PI / 10 * i + Math.PI / 2;
            double radius;
            if (i % 2 == 0) {
                radius = 12;
            } else {
                radius = 6;
            }
            xs6[i] = radius * Math.cos(angle)-102;
            ys6[i] = radius * Math.sin(angle)+47;
        }
        StdDraw.filledPolygon(xs6, ys6);
        
        //tree and apple
        StdDraw.setPenColor(112, 56, 36);
        StdDraw.setPenRadius(0.020);
        StdDraw.filledRectangle(-59, 80, 5, 40);
        StdDraw.setPenColor(0, 153, 89);
        StdDraw.setPenRadius(0.020);
        StdDraw.filledEllipse(-59, 110, 30, 20);
        StdDraw.setPenRadius(0.020);
        StdDraw.setPenColor(112, 56, 36);
        StdDraw.line(-79,38,-36,38);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(-58, 36, 26, 2);
        StdDraw.setPenColor(212, 46, 18);
        StdDraw.point(-80,107);
        StdDraw.point(-65,102);
        StdDraw.point(-65,117);
        StdDraw.point(-50,122);
        StdDraw.point(-45,102);
        StdDraw.point(-40,111);
        StdDraw.setPenRadius(0.010);
        StdDraw.setPenColor(112, 56, 36);
        //112, 56, 36
        StdDraw.arc(-51, 45, 5, 175,-95 );
        StdDraw.setPenColor(112, 56, 36);
        StdDraw.arc(-67, 46, 5, -100, 20);
        
        //bear
        StdDraw.setPenColor(StdDraw.BLACK);
        double[] bearX = {22  , 23.7, 24.1  , 23.5, 24,  25.1, 26.2, 27.1, 28.2, 30, 28.5, 28.1, 28.5, 25.9, 24.8, 25, 23.1, 22};
        double[] bearY = {13.5, 11.3, 13.7, 15,   15.5,14.9, 15.2, 14.4, 14.4, 4.5, 3.6, 2.5, 0.5, 0.5, 3.3, 4.3,  7.5, 7.9};
        int A = 39;
        int B = 120;
        for (int i = 0; i < bearX.length; i++){
            bearX[i] *= 3;
            bearY[i] *= 3;
        }
        for (int i = 0; i < bearX.length; i++){
            bearX[i] -= 120;
            bearY[i] +=A;
        }
        StdDraw.filledPolygon(bearX, bearY);
        
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.arc( 37.5*3-120, 12.5*3+38 , 9*3, 172, 211);
       
        StdDraw.setPenRadius(0.007);
        StdDraw.point(23.5*3-B,12*3+A);
        StdDraw.point(23.4*3-B,12.4*3+A);
        StdDraw.point(25.8*3-B,1.1*3+A);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.arc(27.5*3-B, 3.8*3+A, 3*3,160, 235);
        StdDraw.point(25.9*3-B,1.1*3+A);
        StdDraw.setPenRadius(0.005);
        StdDraw.point(23.2*3-B, 9.6*3+A);
        StdDraw.setPenRadius(0.003);
        StdDraw.point(27.3*3-B, 0.7*3+A);
       
        StdDraw.setPenRadius(0.015);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.point(29.5*3-B, 4.5*3+A);
        StdDraw.setPenRadius(0.01);
        StdDraw.point(27.5*3-B, 14*3+A);
        StdDraw.arc(28.8*3-B,9*3+A, 5.5*3, 196, 228);
    
        
        //while(true) {
          //  if(StdDraw.isMousePressed()){
            //    System.out.println("Mouse pos: " + StdDraw.mouseX() + ", "+ StdDraw.mouseY());
            //}
        //}
       
        
    }
    
}
