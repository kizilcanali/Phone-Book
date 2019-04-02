import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ChainedHashtable table=new ChainedHashtable();
		
		// Tamamen geliþigüzel yazýlmýþtýr.
		Person p = new Person("Ramazan","Lalala","Ýstanbul");
		p.phone[0] ="05447";p.phone[1]="547647";p.phone[2]="244547";
		Person p2= new Person("Ali","Aa","Balýkesir");
		p2.phone[0]="053447";p2.phone[1]="8953447";p2.phone[2]="9893447";
		Person p3= new Person("Sinem","Fellaini","Ýstanbul");
		p3.phone[0]="023447";p3.phone[1]="055747";p3.phone[2]="0568447";
		Person p4= new Person("Ramazan","Memo","Manisa");
		p4.phone[0]="0247";p4.phone[1]="0235747";p4.phone[2]="0568447";
		Person p5= new Person("Furkan","Cello","Edirne");
		p5.phone[0]="0235447";p5.phone[1]="02309747";p5.phone[2]="076447";
		Person p6 = new Person("Ali", "Arkýn","Keþan");
		p6.phone[0]="0546";p6.phone[1]="111";p6.phone[2]="2322";
		Person p7 = new Person("Emre", "Bekir","Muradiye");
		p7.phone[0]="05";p7.phone[1]="11131";p7.phone[2]="2252";
		Person p8 = new Person("Ali", "Cemal","Ankara");
		p8.phone[0]="546";p8.phone[1]="1181";p8.phone[2]="23452";
		Person p9 = new Person("Gamze", "Karar","Antep");
		p9.phone[0]="04";p9.phone[1]="1111";p9.phone[2]="2412";
		Person p10 = new Person("Ali", "Turbo","Harran");
		p10.phone[0]="05546";p10.phone[1]="1210";p10.phone[2]="232";
		Person p11= new Person("Buray","Kamçý","Edirne");
		p11.phone[0]="046";p11.phone[1]="12310";p11.phone[2]="232545";
		Person p12= new Person("Zeliha","Xet","Akhisar");
		p12.phone[0]="0226";p12.phone[1]="10";p12.phone[2]="25";
		Person p13= new Person("Ferit","Kaya","Ankara");
		p13.phone[0]="04786";p13.phone[1]="1";p13.phone[2]="5";
		Person p14= new Person("Tamer","Karadaðlý","Elazýð");
		p14.phone[0]="0";p14.phone[1]="880";p14.phone[2]="2978";
		Person p15= new Person("Özge","Öz","Ardahan");
		p15.phone[0]="997";p15.phone[1]="9987";p15.phone[2]="55647";
		
		
		table.put(p);
		table.put(p2);
		table.put(p3);
		table.put(p4);
		table.put(p5);
		table.put(p6);
		table.put(p7);
		table.put(p8);
		table.put(p9);
		table.put(p10);
		table.put(p11);
		table.put(p12);
		table.put(p13);
		table.put(p14);
		table.put(p15);
		LinkedList<Person> clone = new LinkedList<>();
		
		clone.add(p);
		clone.add(p2);
		clone.add(p3);
		clone.add(p4);
		clone.add(p5);
		clone.add(p6);
		clone.add(p7);
		clone.add(p8);
		clone.add(p9);
		clone.add(p10);
		clone.add(p11);
		clone.add(p12);
		clone.add(p13);
		clone.add(p14);
		clone.add(p15);
		
		
		
		int checker = 1;				//	
		while(checker == 1){			// Provides return
	    menu();
		
		Scanner input = new Scanner(System.in);
		int menuSelect=input.nextInt();
		
		switch(menuSelect){
		case 1:
			
			System.out.println("Please enter name." );
			Scanner s = new Scanner(System.in);
			String nameT = s.next();
			LinkedList<Person> searchN = searchname(nameT,table);
			System.out.println();
			System.out.println("Please select a person who do you want to see numbers.[1,2,3...]");
			int k = s.nextInt()-1;
			System.out.println(searchN.get(k).getName() +" " + searchN.get(k).getSurname()+ " " + searchN.get(k).getAddress());
			System.out.println();
			System.out.println("Work :" + " " + searchN.get(k).phone[0]+" "+"Home :"+" "+searchN.get(k).phone[1]+" "+"Cell: "+" "+searchN.get(k).phone[2]);
			System.out.println();
			System.out.println("Do you want to do new operation. (Y/N)");
			String cont = s.next();
			if(cont.equalsIgnoreCase("Y")){	
				personOperation(table,searchN,k);
	
			}
			else if(cont.equalsIgnoreCase("N")){
				
				checker =1;
			
			}
			break;
			
		case 2:
			System.out.println("Please enter a number.");
			Scanner numTake = new Scanner(System.in);
			String numT = numTake.next();
			LinkedList<Person> searchNum = numberSearch(numT,table);
			System.out.println();
			System.out.println("Do you want to do new operation. (Y/N)");
			String cont1 = numTake.next();
			if(cont1.equalsIgnoreCase("Y")){
				personOperation(table,searchNum,0);
				
				System.out.println("Do you want to continue to the menu?"+ " " +" (Y/N)");
				String a = numTake.next();
				if(a.equalsIgnoreCase("Y")){
					
					checker =1;
				}
				else if(a.equalsIgnoreCase("N")){
					
					checker = 0;
				}	
			}
			else if(cont1.equalsIgnoreCase("N")){
			
				System.out.println("See you!");
				System.exit(0);
			}	
			break;	
		case 3:
			Scanner c = new Scanner(System.in);
			System.out.println("Please enter a name to create a person.");
			String n1 = c.next();
			System.out.println("Enter a surname.");
			String s1 = c.next();
			System.out.println("Enter a address.");
			String a1 = c.next();
			
			Person create = createPerson(n1,s1,a1,table,clone);
			table.put(create);
			System.out.println("Name of new person is: " +table.get(create).getName());
			System.out.println("Surname of the new person is: " +table.get(create).getSurname());
			System.out.println("Address of the new person is: " +table.get(create).getAddress());
			System.out.println();
			System.out.println("Do you want to add phone number. (Y/N)");
			String confirm = c.next();
			
			if(confirm.equalsIgnoreCase("Y")){
				int c2 = 0;                //
				while(c2 == 0){            //  Provides return when you want to add new number to new Person.
				System.out.println("Click [1] to add work number.");
				System.out.println("Click [2] to add home number.");
				System.out.println("Click [3] to add cell number.");
				int phnAdd = c.nextInt();
				switch(phnAdd){
				
				case 1:
					System.out.println("Enter Work numb. to add.");
					String nw = c.next();
					create.phone[0] = nw;
					System.out.println("Work : "+create.phone[0] +" " + " Home: "+ " "+ create.phone[1] +" "+ "Cell : "+ " "+ create.phone[2]);
					break;
					
				case 2:
					System.out.println("Enter Home numb. to add.");
					String nh = c.next();
					create.phone[1] = nh;
					System.out.println("Work : "+create.phone[0] +" " + " Home: "+ " "+ create.phone[1] +" "+ "Cell : "+ " "+ create.phone[2]);

					break;
					
				case 3:
					System.out.println("Enter Cell numb. to add.");
					String nc = c.next();
					create.phone[2]=nc;
					System.out.println("Work : "+create.phone[0] +" " + " Home: "+ " "+ create.phone[1] +" "+ "Cell : "+ " "+ create.phone[2]);
					
				}
				System.out.println("Do you want to add new number.(Y/N)");
				String cont2 = c.next();
				if(cont2.equalsIgnoreCase("Y")){
					c2 =0;
				}	
				 else if(cont2.equalsIgnoreCase("N")){
					c2=1;
					checker=1;
				}	
			}		
				
				}
			else if(confirm.equalsIgnoreCase("N")){
				checker =1;
				
			}
			break;
			
		case 4:
			Scanner j = new Scanner(System.in);
			table.printHashtable();
			System.out.println("Do yo want to do new operation. (Y/N)");
			String j1 = j.next();
			if(j1.equalsIgnoreCase("Y")){
				checker = 1;
			}
			else if(j1.equalsIgnoreCase("N")){
				System.out.println("See you.");
				checker = 2;
						
			}
			break;
			
		case 5:
			System.exit(0);
		}
		}
		
		}
	
	public static LinkedList<Person> searchname(String name,ChainedHashtable table) {//This Function returns 10 element.
		LinkedList<Person> p=table.getList(name);
		LinkedList<Person> returned=new LinkedList<>();	
		int counter =0; 
		for (int i=0;i<p.size();i++) {
			if(p.get(i).getName().equals(name)) { //adds element if they are equal with the searchname
				returned.add(p.get(i));
				counter++;
				System.out.println(counter+"."+p.get(i)+ " "+p.get(i).getAddress());	
			}
		}
		
		return returned;
		}
		
	public static void personOperation(ChainedHashtable table,LinkedList<Person> p,int index) {
			
			Person change=p.get(index);
			
			Scanner take = new Scanner(System.in);
			
			System.out.println("Click [1] to Change Number." +"||"
					+ "Click [2] to Delete Person." +"||"
					+ "Click [3] to Update a Person." +"||"
					+ "Click [4] to EXIT!");
			int firstSelect = take.nextInt();
			if(firstSelect == 1){
				
				System.out.println("Click [0] to change Work Numb." +"||"
						+ "Click [1] to change Home Numb." + "||"
						+ "Click [2] to change Cell Numb."); 
				
				int sel=take.nextInt();
				
				System.out.println("Enter a number to change.");
				String number= take.next();
				
				if(sel==0) {
					change.phone[0]=number;
					System.out.println("New Work numb. is : " + " " + change.phone[0]); 
				}
				else if(sel==1) {
					change.phone[1]=number;
					System.out.println("New Home numb. is : " + " " + change.phone[1]); 
				}
				else if(sel==2) {
					change.phone[2]=number;
					System.out.println("New Cell numb. is : " + " " + change.phone[2]); 
				}
				
			}
			else if (firstSelect == 2){
				
				System.out.println("Click [1] to delete a person ");
				int select = take.nextInt();
				
				if(select==1) {//delete person
					Person removed =table.remove(change);
					p.remove(p.get(index));
					change.phone[0] = null;
					change.phone[1] = null;
					change.phone[2] = null;
					
					System.out.println("Removed person is "+removed.getName() +" " + removed.getSurname());
					
				}
				
				
			}

			else if(firstSelect == 3){
				System.out.println("Click [2] to update a Person.");
				int updt=take.nextInt();
				System.out.println("... and click [0] to change name, click [1] to change surname");	
				int sel=take.nextInt();
				System.out.println("Please enter new word.");
				String newN = take.next();
				
				if(updt==2) {//update person
					
					String nameOrsurname=newN;
					
					if(sel==0) {//change name
						change.setName(nameOrsurname);
						change.phone[0] = p.get(index).phone[0];
						change.phone[1] = p.get(index).phone[1];
						change.phone[2] = p.get(index).phone[2];
						table.put(change);
						System.out.println("New name : " +" "+ change.getName());
					}
					else if(sel==1) {//change surname
						change.setSurname(nameOrsurname);
						change.phone[0] = p.get(index).phone[0];
						change.phone[1] = p.get(index).phone[1];
						change.phone[2] = p.get(index).phone[2];
						table.put(change);
						System.out.println("New surname :" +" " +change.getSurname());
					}
			}		
		}
			else if (firstSelect == 4){
				System.exit(0);
			}
		}
	public static Person createPerson (String n, String s,String a,ChainedHashtable t,LinkedList<Person> create){
		create = new LinkedList<>();
		Person created = new Person(n,s,a);
		Scanner c = new Scanner(System.in);
		
		 for(int i = 0; i<create.size();i++){
			 if(create.get(i) == null){
				 create.add(created);
				 t.put(created);
			 }
			 break;
		 }
		 
		return created;
	}
	
	public static LinkedList<Person> numberSearch(String number, ChainedHashtable table){//searches the number and returns the person who has that phone numbers
		LinkedList<Person> returned=new LinkedList<>();
		for(int i=0;i<table.getsize();i++) {
			for (Person p: table.getBucket(i)) {
				if(p.phone[0].equals(number)||p.phone[1].equals(number)||p.phone[2].equals(number)) {
					returned.add(p);
					System.out.println(p.getName()+" "+p.getSurname()+" "+p.getAddress());
					System.out.println("Work :"+" "+p.phone[0]);
					System.out.println("Home: "+" "+p.phone[1]);
					System.out.println("Cell: "+" "+p.phone[2]);	
				}
				
							
			}
		}
		return returned;
	}
	public static void menu(){
		
		System.out.println();
		System.out.println();
		System.out.println("1. Search a Person with Name.");
		System.out.println("2. Search a Person with Number.");
		System.out.println("3. Create a New Person");
		System.out.println("4. List All People");
		System.out.println("5.EXIT!");
		
	}
	

}