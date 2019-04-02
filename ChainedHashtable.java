import java.awt.Color;
import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {

    private LinkedList<Person>[] hashtable;

    public ChainedHashtable() {
        hashtable = new LinkedList[6];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<Person>();
        }
    }

    public void put(Person p) {
    	boolean flag=true;
     int index=hashKey(p.getName());
     if(hashtable[index].size()==0) {
        hashtable[index].add(p);
       
        flag=false;
       
        }
    else {
    	for (Person per : hashtable[index]) {
			if(per.equals(p)) {
				System.out.println("person already exist");
				flag=false;		
			}
		} 	
    }
     if(flag) {
    	 hashtable[index].add(p);
     }

    }
    public LinkedList<Person> getBucket(int index){
    	if( hashtable[index]!=null)
    		return  hashtable[index];
    	else
    		return null;
    	
    }
    public LinkedList<Person> getList(String key){
    	 int hashedKey = hashKey(key);
    	 if(hashtable[hashedKey].size()!=0) {
    		 return hashtable[hashedKey];
    	 }
    	 return null;
    }

    public Person get(Person p) {
        int hashedKey = hashKey(p.getName());
        int hashedKey1 = hashKey(p.getSurname());
        ListIterator<Person> iterator = hashtable[hashedKey].listIterator();
        Person person = null;
   
        while (iterator.hasNext()) {
            person = iterator.next();
            if (p.equals(person)) {
                return person;
            }
        }
       

        return null;
    }

    public Person remove(Person p) {
        int hashedKey = hashKey(p.getName());
        ListIterator<Person> iterator = hashtable[hashedKey].listIterator();
        Person person = null;
        int index = -1;
        while (iterator.hasNext()) {
        	person = iterator.next();
            index++;
            if (person.equals(p)) {
                break;
            }
        }

        if (person == null) {
            return null;
        }
        else {
            hashtable[hashedKey].remove(index);
            return person;
        }
    }

    private int hashKey(String key) {
       char index=key.charAt(0);
       if(index>='A'&&index<='D') {
    	   return 0;
    	   }
      
       else  if(index>='E'&&index<='H') {
    	   return 1;
    	   }
       else  if(index>='I'&&index<='M') {
    	   return 2;
    	   }
       else if(index>='N'&&index<='P') {
    	   return 3;
    	   }
       else if(index>='R'&&index<='T') {
    	   return 4;
    	   }
       else {
    	   return 5;
       }
    }
    public int getsize() {
    	return hashtable.length;
    }

    public void printHashtable() {
    	
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
            }
            else {
                ListIterator<Person> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next()+"\n");
                }  
            } 
        }
    }
}