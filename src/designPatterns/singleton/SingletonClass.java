package designPatterns.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonClass implements Cloneable, Serializable {

	private static SingletonClass instance = null;

	protected Object clone() throws CloneNotSupportedException {
		if (instance != null) {
			throw new CloneNotSupportedException("Can't create instance. Please use getInsance() to create it.");
		}
		return super.clone();
	}

	private SingletonClass() {
		if (instance != null) {
			throw new RuntimeException("Can't create instance. Please use getInsance() to create it.");
		}
	}

	public static synchronized SingletonClass getInstance() {
		if (instance == null) {
			synchronized (SingletonClass.class) {
				if (instance == null) {
					instance = new SingletonClass();
				}
			}
		}
		return instance;
	}

	private Object readResolve() {
		System.out.println("Applying readResolve()......");
		return SingletonClass.getInstance();
	}

	public static void main(String[] args) throws Exception {
		serializationTest();
		cloneTest();
		multiThreadTest();
		reflectionTest();
	}

	public static void serializationTest() throws FileNotFoundException, IOException, ClassNotFoundException {
		SingletonClass s1 = SingletonClass.getInstance();
		SingletonClass s2 = SingletonClass.getInstance();
		System.out.println("serializationTest-Hashcode of Object s1: " + s1.hashCode());
		System.out.println("serializationTest-Hashcode of Object s2: " + s2.hashCode());

		File file = new File("E:/tmp/s2.ser");
		file.createNewFile();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/tmp/s2.ser"));
		oos.writeObject(s2);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/tmp/s2.ser"));
		SingletonClass s3 = (SingletonClass) ois.readObject();

		System.out.println("serializationTest-Hashcode of Object s3: " + s3.hashCode());
	}

	public static void cloneTest() throws Exception {
		System.out.println("\ncloneTest beings.....");
		try {
			SingletonClass s1 = SingletonClass.getInstance();
			SingletonClass s2 = SingletonClass.getInstance();
			System.out.println("Hashcode of Object s1: " + s1.hashCode());
			System.out.println("Hashcode of Object s2: " + s2.hashCode());

			SingletonClass s3 = (SingletonClass) s2.clone();
			System.out.println("Hashcode of Object s3: " + s3.hashCode());
		} catch (Exception e) {

		}
		System.out.println("cloneTest ends.....");
	}

	public static void reflectionTest() throws Exception {
		System.out.println("\nreflectionTest beings.....");
		try {
		SingletonClass s1 = SingletonClass.getInstance();
		SingletonClass s2 = SingletonClass.getInstance();
		System.out.println("Hashcode of Object s1: " + s1.hashCode());
		System.out.println("Hashcode of Object s2: " + s2.hashCode());

		Class clazz = Class.forName("designPatterns.singleton.SingletonClass");
		Constructor<SingletonClass> ctr = clazz.getDeclaredConstructor();
		ctr.setAccessible(true);
		SingletonClass s3 = ctr.newInstance();
		System.out.println("Hashcode of Object s3: " + s3.hashCode());
		}catch(Exception e) {
			
		}
		System.out.println("reflectionTest ends.....");
	}

	static void useSingleton() {
		SingletonClass singleton = SingletonClass.getInstance();
		System.out.println("multiThreadTest Hashcode of Singleton Object: " + singleton.hashCode());
	}

	public static void multiThreadTest() throws Exception {
		System.out.println("\nmultiThreadTest beings.....");
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(SingletonClass::useSingleton);
		service.submit(SingletonClass::useSingleton);
		service.shutdown();
		System.out.println("multiThreadTest ends.....");
	}

}
