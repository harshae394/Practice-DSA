package javapractice;

import java.util.HashSet;

class Country {
    String name;
    long population;
    
    public Country(String name, long population) {
	super();
	this.name = name;
	this.population = population;
    }
    /*
     * @Override public String toString() { return "Country [name=" + name +
     * ", population=" + population + "]"; }
     */

}

public class HashMapTest {

    public static void main(String[] args) {
	 HashSet countrySet=new HashSet();
	  Country india=new Country("India",1100l);
	  Country india2=new Country("India",1100l);
	  Country US=new Country("US",100l);
	 System.out.println("india : "+india+" : "+ india.hashCode());
	 System.out.println("india2 : "+india2+" : " +india2.hashCode());
	 System.out.println(US.hashCode());
	  System.out.println(countrySet);

    }

}
