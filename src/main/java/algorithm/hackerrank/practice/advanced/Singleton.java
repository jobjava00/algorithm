package algorithm.hackerrank.practice.advanced;

public class Singleton {
	private Singleton() {}
	public String str;

	public static Singleton getSingleInstance() { return LazyHolder.INSTANCE; }

	private static class LazyHolder {
		private static final Singleton INSTANCE = new Singleton();
	}
}
