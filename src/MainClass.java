abstract class Car  
{
    String model;
    String brand;
    public abstract void addFeatures();
    Car()
    {
        this.model = "X5";
        this.brand = "BMW";
    }
}
class SportCar extends Car
{
    boolean nitro;
    @Override
    public void addFeatures() 
    {
        this.nitro = true;
    }
    public void showDetail()
    {
        System.out.println("Model :"+ model);
        System.out.println("Brand :"+ brand);
        System.out.println("Nitro :"+ nitro);
    }
}
public class MainClass
{
    public static void main(String arg[])
    {
        SportCar sportCar = new SportCar();
        sportCar.addFeatures();
        sportCar.showDetail();
        boolean x = sportCar.nitro;
        String xx= sportCar.brand;
    }
}