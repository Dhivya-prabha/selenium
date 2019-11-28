package week1.assignments;

public class FindIntersection {

	public static void main(String[] args) {
		// Here is the input 
				int[] arr1 = {3,2,11,4,6,7};
				int len1 = arr1.length;				
				int[] arr2 = {1,2,8,4,9,7};
				int len2 = arr2.length;
				for(int i = 0; i<len1; i++ )
				{
					for(int j = 0; j<len2; j++) 
					{
						if(arr1[i] == arr2[i])
						{
							System.out.println(arr1[i]);
							break;
						}
					}
				}
				//Build a logic to identify the intersection between given arrays
				
				/* Pseudo Code: 
				 * 1)Traverse through each array item for each given array (use nested for loop)
				 * 2)Compare both the arrays 
				 * 3) Print the matching item
				 */

	}

}
