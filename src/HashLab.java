/*Code by Ryan Sample
 * Hashlab is a class that defines a hash function to store elements in a table
 * using linear probing.
 * Designed for CS330 Homework 3*/
public class HashLab {
	private Bucket hasharray[];
	private int size;

	/**test method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int addkeys[]={9,10,22,35,11,23,2,4,15,16,48,28};//array of keys to add to hash table.
		int deletekeys[]={22,2,11,35,28};//array of keys to delete from hash table.
		HashLab table = new HashLab();//create new hash table
		for(int i=0;i<addkeys.length;i++)//addkeys
			table.addkey(addkeys[i]);	
		String output=table.toString();//output result
		System.out.println("1.)	"+output);
		for(int i=0;i<deletekeys.length;i++)//delete keys
			table.deletekey(deletekeys[i]);	
		output=table.toString();
		System.out.println("2.)	"+output);//output part 2
		int check[]= {2,4,28},loc;//array to search for keys, variable for return from search function.
		for(int i=0;i<3;i++)
			if((loc=table.searchkey(check[i]))==-1)//searchkey returns -1 if the value is not in table else
				//returns the location of the key.
				System.out.println("Key "+check[i]+" not found." );
			else
				System.out.println("Key "+check[i]+" found at: "+loc);
		
	}
	//constructor
	HashLab(){
		hasharray = new Bucket[13];
		for(int i =0; i<13; i++){
			hasharray[i]= new Bucket();//initialize objects.
		}
		size = 0;
	}
	/**
	 * Method to add a key to the hash table
	 * @param key
	 * @return location
	 */
	public int addkey(int key){//add key to table returns location.
		int location;
		location = key%13;
		if(size>12){//return -1 if table is full to avoid overwrite.
			return -1;
		}
		while(!(hasharray[location].getvalue()=='\0')&&size<13){//any out of bounds error starts here.
			location++;
			location=location%13;//makes sure that key size does not extend beyond 12
		}		
		hasharray[location].addvalue(key);
		size++;
		return location;
	}
	/**
	 * delete key returns type boolean indicating whether or not the key was deleted.
	 * @param key
	 * @return boolean
	 */
	public boolean deletekey(int key){
		int location;
		location = key%13;
		while(!(key==hasharray[location].getvalue())&&hasharray[location].getused()==false){
			location++;
			location=location%13;
		}
		hasharray[location].deletevalue();	
		size--;
		return true;
	}
	/**
	 * 
	 * @param key
	 * @return location in array or -1 if not found.
	 */
	public int searchkey(int key){
		int location;
		location = key%13;
		for(int i=0; i<13; i++){
			if(hasharray[location].getvalue()==key)
				return location;
			else
				location++;
				location=location%13;
		}
		return -1;
	}
	
	public String toString(){
		String array = new String();
		int current;
		
		for(int i=0; i<13; i++){
			if((current=hasharray[i].getvalue())!='\0')
				array+=current;
			else
				array+=' ';//if element is empty add a space
			if(i!=12)
				array+=',';//added commas to clearly distinguish elements in the array.
		}
			
		
		return array;
	}
	public int getLength(){
		return hasharray.length;
	}

}
