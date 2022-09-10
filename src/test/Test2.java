package test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import test.h.N;

interface h{
	h obj = new N();;
	public void wor();
	class N implements h{

		@Override
		public void wor() {
			// TODO Auto-generated method stub
			System.out.println("wrknn");
		}
		private N() {
			
			System.out.println("nn");
		}
		//h obj= new N();
	}
}
public class Test2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		exec(h.obj);
		
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("harish");
		bw.flush();
	}
	static void exec(h obj) {
		obj.wor();
	}

}
