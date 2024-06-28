public class Attendee<Key, Value> {
	//-----------------------------------------------------
		// Title: Attendee class
		// Author: Arda Baran
		// Description: This class purposes to insert Participants records from a zoom meeting to hash table. 
		// Ýf a key occurs more than one,the value of occurences of same key added to the original value of key such as
		//if occurence of Sevil Terzi is three times and values for each occurences are 81.0 ,1.0 and 28.0 then the value of
	     // Sevil Terzi which is key value of this hashtable updates to 110.0.
	     //    (81.0 + 1.0 + 28.0) = 110.0
		//-----------------------------------------------------
		
int tableSize;
Key[]keys;
Value[]vals;
@SuppressWarnings("unchecked")
public Attendee(int tableSize) {
	this.tableSize=tableSize;
this.keys=(Key[]) new Object[tableSize];
this.vals=(Value[])new Object[tableSize];
}
public int hash(Key key) {
//if key in this hastable is a type of String:
	//Step 1 : convert key to string variable then convert this string to the lowercase string
	//Step 2 : hash the converted string key
 if(key instanceof String) {
	String sKey=((String) key).toLowerCase();
   return (sKey.hashCode() & 0x7fffffff) % tableSize;
}
//if key in this hashtable is not type of String,this part works.
 return (key.hashCode() & 0x7fffffff)%tableSize;	
}
@SuppressWarnings("unchecked")
public void putRecord(Key key,Value val) {
	 String lowerCaseInsertedKey = key.toString().toLowerCase();//in order to compare keys correctly, convert inserted key to 
	int i;                                                      //a lowercase string
	for(i=hash(key);keys[i]!=null; i = (i+1) % tableSize) {		
		String currKeys = keys[i].toString().toLowerCase();//in order to compare keys correctly, convert keys in the table to 
		                                                   // lowercase strings.
		if(isSameAttendee(currKeys, lowerCaseInsertedKey)) {
			
			if(vals[i] instanceof Integer && val instanceof Integer) {
			
				//if insterted key is same with one of the keys in this hash table 
				//And if value is a type of Integer,add inserted value to the current value of key				
				
				Integer currVal = (Integer) vals[i];
			    Integer newVal =currVal+(Integer)val;
			    vals[i] = (Value)(Object) newVal;
			
			}else if(vals[i] instanceof Double && val instanceof Double) {
				
				//if insterted key is same with one of the keys in this hash table 
				//And if value is a type of Double,add inserted value to the current value of key
				
				Double currVal = (Double) vals[i];
				Double newVal = currVal +(Double) val;
				vals[i]= (Value) (Object) newVal;
			}
			return ;
		}
	
		}
    for (i = hash(key); keys[i] != null; i = (i + 1) % tableSize) {
        
    }	
keys[i]=key;
vals[i]=val;
}
public Value getValueByKey(Key key) {//returns the value of the key
	int i ;
	for(i=hash(key);keys[i]!=null;i=(i+1)%tableSize) {
		if(key.equals(keys[i])) {
			return vals[i];
		}
	}
return null;
}
public boolean contains(Key key) {//checks key exists in the table
	  return (getValueByKey(key)!=null);
	}
	public void deleteRecordByKey(Key key)  { //deletes record by key 
	    if (!contains(key)) {
	        return;
	    }

	    int i = hash(key);

	    while (keys[i] != null) {
	        if (key == keys[i]) {
	           
	            keys[i] = null;
	            vals[i] = null;

	           
	            int j = (i + 1) % tableSize;
	            while (keys[j] != null) {
	                Key tempKey = keys[j];
	                Value tempValue = vals[j];
	                keys[j] = null;
	                vals[j] = null;
	                putRecord(tempKey, tempValue);
	                j = (j + 1) % tableSize;
	            }
	            return; 
	        }

	        
	        i = (i + 1) % tableSize;
	    }
	}

public void printAttendee() {
	for(int i = 0; i<tableSize;i++) {
		if(keys[i]!=null) {
		System.out.println(keys[i] + " " +vals[i]);
	}
	}
}
public boolean isSameAttendee(String name1, String name2) {
    String[] parts1 = name1.split(" ");
    String[] parts2 = name2.split(" ");
//the last word of nameSurname string is always be surname , the other parts can be considered as name of person.
    for (String part1 : parts1) {
        for (String part2 : parts2) {
            if (part1.equalsIgnoreCase(part2)) {
                return true;
            }
        }
    }

    return false;
}









}

