package day1.classroom;

public class Mobile {
	
	public boolean MakeCall(int number)
	{
		System.out.println("call connected  " + number);
		
		return true;

	}
	public String SendSMS(String message)
	{
		System.out.println("Your Message is: " + message);
		return message;
	}
	public boolean ShutDown()
	{
		System.out.println("Mobile is shutting Down");
		return true;
	}
	public static void main(String[] args) {
		Mobile phone = new Mobile();
		boolean MakeCall = phone.MakeCall(999410939);
		String SendSMS = phone.SendSMS("Congrats");
		boolean ShutDown = phone.ShutDown();
		
		
	}
}
