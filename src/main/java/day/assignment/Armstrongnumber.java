package day.assignment;

public class Armstrongnumber {
	
	public static void main(String[] args) {
int num = 573, value=0, temp, sum = 0;
num = value;
while(value != 0)
{
	temp = value% 10;
	sum = sum+temp*temp*temp;
	value /= 10;
	
	}
if(sum == num) {
	System.out.println(num + "is Armstrong Number");
}
else
	{
	System.out.println(num + "is not an Armstrong Number");
	}	

	}
}
