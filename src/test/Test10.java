package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparator<Employee>{
	int id;
	String name;
	@Override
	public int compare(Employee o1, Employee o2) {
		int res = o1.name.compareTo(o2.name);
		res = (res==0)?(o1.id-o2.id):res;
		return res;
	}
}
class Singleton{
	
	static Singleton obj = null;
	public static Singleton getInstance() {
		synchronized(obj){
			if(obj==null) {
				System.out.println("null isntance");
				obj = new Singleton();
			}else {
				System.out.println("notnull isntance");
			}
			return obj;
		}
	}
	private Singleton() {}
}
public class Test10 {

	public static void main(String[] args) {
		Singleton.getInstance();
		Singleton.getInstance();
		// TODO Auto-generated method stub
		/*Map<String,String> map= new HashMap<>();
		map.put("A", "D");
		map.put("B", "B");
		map.put("C", "A");
		map.entrySet().stream().filter(m->m.getValue()).sorted(comparator)*/
		
		List<Employee> list = new ArrayList<>();
		
		int x=25;
		int y =29;

		x = (x*y);//29
		y = (y*x)/x;//29
		System.out.println("x: "+x +" y = "+y);
		
	}
	
/**write code to print the accounts having name starts with 'Ab' from accountsList 

account: id, name, balance


List<Accounts> list = list.stream().filter(e->e.getName().startswith("ab")).collect(Collectors.tolist());

(list 
System.out

Optional

Write Rest service / end point to UPDATE account details

Write controller, service and Repo classes

@Repository
class DAO extends JPAREpostory<DAO>{

	public Account update(Account acc){
		return dao.update(acc);
		
	}
}

@Service
class AccountService{
	DAO dao;
	public Account update(Account acc){
		if(acc!=null){
			return	dao.update(acc);
		}
	}
}
@Restcontoller("/update",RequestMethod.PUT)
class AccountContoller{
	@Autowired
	Service service
	public void update(Account acc){
		return service.update();
	}
}

//domain.com/account/update

{
	accountNme: "",
}



**/
}
