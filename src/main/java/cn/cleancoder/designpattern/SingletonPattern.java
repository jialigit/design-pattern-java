package cn.cleancoder.designpattern;

/**
 * Singleton Pattern Definition: A Class only has one instance and has a global
 * access point to get it
 * 
 * One of a kind of Objects for which there is only one instance
 * 
 * 
 * How to ensure the thread safe:
 * 	1. eagerly mode depend on the JVM to create the instance before a thread to access it
 *  2. use locking with volative keyword
 *  
 *  **about the volatile keyword***
 *  Short of reading the memory model specification,
 *  I recommend you read 
 *  http://jeremymanson.blogspot.com/2008/11/what-volatile-means-in-java.html. 
 * 
 * **happen before model specification***
 * @author ice
 *
 */
public class SingletonPattern {

	public static void main(String[] args) {
		LazilySingleton inst = LazilySingleton.getInstance();
		LazilySingleton inst2 = LazilySingleton.getInstance();
		
		System.out.println(inst == inst2);
		
		
		
	}
}

/**
 * lazily created
 * 
 * @author ice
 *
 */
class LazilySingleton {

	private static LazilySingleton inst;

	private LazilySingleton() {
	}

	/**
	 * synchronized for multi-thread cases
	 * 
	 * @return
	 */
	public static synchronized LazilySingleton getInstance() {
		if (null == inst) {
			inst = new LazilySingleton();
		}

		return inst;
	}
}

/**
 * Eagerly created
 * 
 * @author ice
 *
 */
class EagerlySingleton {
	private static EagerlySingleton inst = new EagerlySingleton();

	private EagerlySingleton() {
	}

	public static EagerlySingleton getInstance() {
		return inst;
	}

}

/**
 * Performance considered
 * 
 * key word volatile is used to ensure that 
 * in multi-thread environment
 * @author ice
 *
 */
class WithDoubleCheckSingleton {

	private volatile static WithDoubleCheckSingleton inst;

	private WithDoubleCheckSingleton() {
	}

	public static WithDoubleCheckSingleton getInstance() {
		if (inst == null) {
			synchronized (WithDoubleCheckSingleton.class) {
				if (inst == null) {
					inst = new WithDoubleCheckSingleton();
				}
			}
		}
		return inst;
	}
}
