package spring006;


public class LifeCycle {
	private String data ;

	public LifeCycle() {
		System.out.println("Constructor ==> " + this.getClass().getName() + "...");
	}
	public void setData(String data) {
		System.out.println("Set...");
		this.data = data;
	}
	public String getData() {
		return data;
	}
	public void init() {
		System.out.println("Init....");
	}
	public void destroy() {
		System.out.println("Destroy...");
	}
}
