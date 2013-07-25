package org.assume.api.math;

public class Geometry {
	
	public static double getRectangleArea(double width, double height)
	{
        return width * height;
    }
   
	public static double getCircleCircumfrence(double radius)
    {
        return (radius *2) * Math.PI;
    }
    
    public static double getAreaTrapezoid(double baseOne, double baseTwo , double height)
    {
        return ((baseOne + baseTwo) / 2)*height;
    }
   
    public static double getTriangleArea(double base, double height){
        return (base * height) /2;
    }
    
    public static double getTrianglePerimeter(double sideOne, double sideTwo, double sideThree)
    {
        return sideOne + sideTwo + sideThree;
    }
   
    public static double getTrapezoidPerimeter(double baseOne, double baseTwo, double height)
    {
        return height * (baseOne + baseTwo) / 2;
    }
   
    public static double getCirclePerimeter(double radius)
    {
        return 2 * Math.PI * radius;
    }
    
    public static double getCubeArea(double side)
    {
        return (side*side) * 6;
    }
  
    public static double getSphereArea(double radius)
    {
        return 4 * Math.PI * (radius * radius);
    }
   
    public static double getConeArea(double radius, double side)
    {
        return Math.PI * radius * side;
    }
  
    public static double getCubeVolume(double side) 
    {
    	return Math.pow(side, 3);
    }
   
    public static double getPrismVolume(double sideOne, double sideTwo, double sideThree)
    {
        return sideOne * sideTwo * sideThree;
    }
  
    public static double getSphereVolume(double radius)
    {
        return (4/3)*Math.PI * Math.pow(radius,3);
    }
   
    public static double getCylinderVolume(double radius, double height)
    {
        return Math.PI* Math.pow(radius, 2) * height;
    }
    
    public static double getConeVolume(double radius, double height)
    {
        return (1/3) * Math.PI * Math.pow(radius, 2) * height;
    }
    
    public static double getPyramidVolume(double baseArea, double height)
    {
        return (1/3) *baseArea * height;
    }
   
    public static double[] getMidpoint(double x1, double y1, double x2, double y2){ 
        return new double[] { ((x1 + x2)/2), ((y1+y2)/2) }; 
    }
    
    public static double getDistanceBetweenTwoPoints(double x1, double x2, double y1, double y2){
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
