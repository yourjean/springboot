package javaExam;

public class DriverExample {

	public static void main(String[] args) {
		Driver dv=new Driver();
		
		Bbb bus = new Bbb();
		Ccc taxi = new Ccc();
		
		dv.drive(bus);
		dv.drive(taxi);

	}

}
