abstract class AbClass{
    int x = 10;
    AbClass(){
	
    }
}
class AbClassImp extends AbClass{
    AbClassImp(){
	
    }
    String m1(String s) {
	return s+"11";
    }
    int m1(String s,  int x) {
  	return x+1;
      }
    void m2(short x){
   	System.out.println("short m2");
       }
    void m2(int x){
	System.out.println("int m2");
    }
    void m2(long x){
	System.out.println("long m2");
    }
    void m4(Long x){
	System.out.println("int m4");
    }
    void m4(Integer x){
	System.out.println("Integer m4");
    }
    void m3(double x){
   	System.out.println("double m2");
       }
       void m3(float x){
   	System.out.println("float m2");
   }
       public void test(Integer i) {
	        System.out.println("Integer");
	    } 
	    public void test(Object o) {
	        System.out.println("Object");
	    }    
}

public class TestOops {

static void continueCheck() {
    for(int i = 0; i<3; i++) {
	if(i==1) {
	    continue;
	}
	System.out.println("i : "+i);
    }

}
    public static void main(String[] args) {
	continueCheck();
	/*AbClassImp pb= new AbClassImp();
	short x =10;
	Object ref=new int[]{1,2,3};
	//int y = x;
	pb.m2(10);
	pb.m3(2.3d);
	pb.m4(10);
	int i  = 10;
	pb.test(i);*/
	//System.out.println(pb.m2(10));
	String ss = "harish";
	String s2 = new String("harish");
	System.out.println(ss==s2);
	s2 = s2.intern();
	System.out.println(ss.hashCode()+"="+s2.intern().hashCode());
    }
}