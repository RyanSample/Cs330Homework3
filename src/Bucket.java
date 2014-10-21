/*Written by Ryan Sample
 * Bucket class is written to take and hold an int key in Hashlab's table. 
 * I mainly wrote this to properly hold on to the neverused value as specified in HW3*/
public class Bucket {
	private int object;
	private boolean neverused/*,empty*/;
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bucket bucket = new Bucket();
		if(bucket.getused()==true)
			System.out.println("neverused");
		bucket.addvalue(2);
		System.out.println(bucket.getvalue());//should be 2
		bucket.deletevalue();
		if(bucket.getvalue()=='\0')
			System.out.println("empty");
		if(!bucket.getused())
			System.out.println("Used!");
		
		
	}*/
	//constructor, initializes everything to empty
	Bucket(){
		object= '\0';
		neverused=true;
		//empty= true;		//might not need this since you can set int to \0
	}
	//addvalue, used to add value to bucket
	/**Adds int value to bucket
	 * @param value
	 * @return int equal to value of input
	 */
	public int addvalue(int value){
		if(neverused)
			neverused=false;
		
		object = value;
		return value;
	}
	/**
	 * 
	 * @return
	 */
	public boolean deletevalue(){
		if(object=='\0')
			return false;
		else
			object = '\0';
		return true;
	}
	
	public int getvalue(){
		return object;
	}
	public boolean getused(){
		return neverused;
	}

}
