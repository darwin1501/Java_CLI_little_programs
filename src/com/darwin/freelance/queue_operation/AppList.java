package com.darwin.freelance.queue_operation;/*
 * Sagarino, Weluna Rose A. II - IT2B.1
 * Program Description: This program will display name and age data in a queue data structure using linked list. 
 * Input: Name and age data 
 * Output: Display the following; 
 *         1. Content of the list. 
 *         2. Inserted Elements in the list. 
 *         3. Deleted elements of the list.
 *         4. Front of the list. 
 *         5. Status of the list. 
 *         6. Sorted elements of the list with respect to name or age. 
 */
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.Queue;
import java.util.Collections;
import java.util.Comparator;

public class AppList {
    int Age;        // Initializing age variable
    String Lastname;   // Initializing string for last name
    String Firstname;   // Initializing string for first name
    String Middlename;   // Initializing string for middle name
    public String getLastname(){
        return Lastname;
    }
    public String getFirstname(){
        return Firstname;
    }
    public String getMiddlename(){
        return Middlename;
    }
    public int getAge(){
        return Age;
    }
    public void setLname(String Lastname){
        this.Lastname=Lastname;     
    }
    public void setFname(String Firstname){
        this.Firstname=Firstname;
    }
    public void setMname(String Middlename){
        this.Middlename=Middlename;
    }
    public void setAge(int Age){
        this.Age=Age;
    }
    public AppList(String Lastname, String Firstname, String Middlename, int Age){
        this.Lastname=Lastname;
        this.Firstname=Firstname;
        this.Middlename=Middlename;
        this.Age=Age;
    }
    @Override
    public String toString() {
        return "Name: " + Lastname + ", " + Firstname + " , " + Middlename + "  Age: " + + Age;
    }
    public static void main(String[] args) {
        Queue<AppList> data=new LinkedList<AppList>();
        loop :while(true){
            System.out.println("Operations");
            System.out.println("1.) Display Queue");
            System.out.println("2.) Insert");
            System.out.println("3.) Delete");
            System.out.println("4.) Size of the Queue");
            System.out.println("5.) Peek");
            System.out.println("6.) Sort Name via Ascending");
            System.out.println("7.) Sort Name via Descending");
            System.out.println("8.) Sort Age via Ascending");
            System.out.println("9.) Sort Age via Descending");
            System.out.println("10.) Check Queue");
            System.out.println("0.) Exit Program");
            System.out.println("  ");
            System.out.print("Select an Operation ");
            Scanner scan = new Scanner(System.in);
            String a = scan.nextLine();
            System.out.println();
            switch(a){
                case "1":          
                    DisplayQ(data);
                    break;
                case "2":
                    NQ(data);
                    break;
                case "3":
                    DQ(data);
                    break;
                case "4":
                    QSize(data);
                    break;
                case "5":
                    Peek(data);
                    break;
                case "6":
                    AlphaSortASC(data);
                    break;
                case "7":
                    AlphaSortDSC(data);
                    break;
                case "8":
                    AgeSortASC(data);
                    break;
                case "9":
                    AgeSortDSC(data);
                    break;
                case "10":
                    isEmptyQ(data);
                    break;
                   
                   
                case "0":
                    break loop;    
            }
            System.out.println();
        }
    }
    
    public static void DisplayQ(Queue<AppList> data) { //Display the queue
        if(data.isEmpty()){
            isEmptyQ(data);
        } else {
            for (AppList peeps:data){
                System.out.println(peeps);
            }
        }
    }
    
    public static void NQ(Queue<AppList> data) {// Enqueue. Adds people's names and ages
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter New Queue Size: ");
        int num=Integer.parseInt(scan.nextLine());
        if (num == 0){
            isEmptyQ(data);
        } else {
            System.out.println("Enter "+num+" Data");
            for (int i = 0; i < num; i++) {
                System.out.println("Please Enter Surname, First Names , Middle Initial & Age:");
                data.add(new AppList(scan.next(),scan.next(),scan.next(),Integer.parseInt(scan.next())));
            }
            System.out.println("Current Queue:"+data.size());
        }
    }
    
    public static void DQ(Queue<AppList> data){ //Dequeue. Removes people names and ages
        Scanner scan= new Scanner(System.in);
        if(data.isEmpty()){
            isEmptyQ(data);
        } else {
            System.out.print("Enter Size to be Deleted: ");
            int rmv= Integer.parseInt(scan.nextLine());
            for (int i = 0; i < rmv; i++) {
                data.poll();
            }
        }
    }

    public static void AlphaSortASC(Queue<AppList> data){ //Sorts name by ascending order
        List<AppList> lists = (List<AppList>) data;
        if(data.isEmpty()){
            isEmptyQ(data);
        } else {
            Collections.sort(lists, new Comparator<AppList>() {
            public int compare(AppList t, AppList t1) {
                int comp = t.getLastname().compareTo(t1.getLastname());
                   if (comp != 0) {    // names are different
                    return comp;
                }
                return t.getAge() - t1.getAge();
            }
            });
            System.out.println("Queue Sorted by Name via Ascension");//Displays name
            for (AppList listy:lists) {
                System.out.println(listy);
            }
        }
    }
    
    public static void AlphaSortDSC(Queue<AppList> data){//Sorts name by descending order
        List<AppList> lists = (List<AppList>) data;
        if(data.isEmpty()){
            isEmptyQ(data);
        } else {
            Collections.sort(lists, new Comparator<AppList>() {
            public int compare(AppList t1, AppList t) {
                int comp = t.getLastname().compareTo(t1.getLastname());
                if (comp != 0) { 
                    return comp;
                }
                return t.getAge() - t1.getAge();
            }
            });
            System.out.println("Queue Sorted by Name via Descension"); // Displays name
            for (AppList listy:lists) {
                System.out.println(listy);
            }
        }
    }

    public static void AgeSortASC(Queue<AppList> data){ //Sorting age by ascending order
        List<AppList> lists = (List<AppList>) data;
        if(data.isEmpty()){
            isEmptyQ(data);
        } else {
            Collections.sort(lists, new Comparator<AppList>() {
                @Override
                public int compare(AppList t, AppList t1) {
                return t.getAge() - t1.getAge();
            }
            });
            System.out.println("Queue Sorted by Age via Ascension"); // Displays age
            for (AppList listy:lists)
            {
                System.out.println(listy);
            }
        }
    }

    public static void AgeSortDSC(Queue<AppList> data){//Sorts age by descending order
        List<AppList> lists = (List<AppList>) data;
        if(data.isEmpty()){
            isEmptyQ(data);
        } else {
            Collections.sort(lists, new Comparator<AppList>() {
            @Override
            public int compare(AppList t1, AppList t) {
                return t.getAge() - t1.getAge();
            }
            });
            System.out.println("Queue Sorted by Age via Descension");//Displays age
            for (AppList listy:lists) {
                System.out.println(listy);
            }
        }
    }

    public static void QSize(Queue<AppList> data) {//Determines the size of the queue
        if(data.isEmpty()){
            isEmptyQ(data);
        } else {
            System.out.println("Current Queue: "+data.size());
        }
    }
    
    public static void Peek(Queue<AppList> data) { //Shows the head of the queue
        if(data.isEmpty()){
            isEmptyQ(data);
        } else {
            System.out.println(data.peek());
        }
    }
    
    public static void isEmptyQ(Queue<AppList> data) {//Determines if queue isEmpty is true or false
        System.out.println("Queue is Empty: " + data.isEmpty());
    }
}

/*
 * Algorithm for Displaying in the content of the list 
 * Input: 
 * Output:  
 * Steps: 
 * 
 * 1.  
 * 2.  
 * 3.  
 * 4. 
 * 5. Stop
 * 
 */

/*
 * Algorithm for Displaying the inputted element
 * Input: 
 * Output: 
 * Steps: 
 * 
 * 1.  
 * 2. 
 * 3. 
 * 4.
 * 5. Stop
 * 
 */

/*
 * Algorithm for Displaying the inserted elements in the list.
 * Input: 
 * Output:  
 * Steps: 
 * 
 * 1. 
 * 2. 
 * 3. 
 * 4. 
 * 5. Stop
 * 
 *
 *
 * Algorithm for Displaying the deleted elements in the list.
 * Input: 
 * Output: 
 * Steps: 
 * 
 * 1. 
 * 2.  
 * 3. 
 * 4. 
 * 5. Stop
 *
 * Algorithm for Displaying the Deleted elements in the list.
 * Input: 
 * Output:  
 * Steps: 
 * 
 * 1.  
 * 2.  
 * 3. 
 * 4. Stop
 * 
 *
  *
 * Algorithm for Displaying the status of the list
 * Input: 
 * Output:  
 * Steps: 
 * 
 * 1.  
 * 2.  
 * 3. 
 * 4. Stop
 * 
 */

/*
 * Algorithm for Displaying the sorted elements of the list with respect to name or age
 * Input: 
 * Output:  
 * Steps: 
 * 
 * 1. 
 * 2. 
 * 3. 
 * 4. 
 * 5. 
 * 6. 
 * 7. 
 * 8. Stop. 
 * 
 */

/* 
 * Program Algorithm
 * Steps: 
1.)  Initialize each data for name and age. 
2.)  Separate the data for each datatype using different methods.
3.)  Override to get the data from each method to return.
4.)  Make Queue Linked List. 
5.)  Display Available Operations.
6.)  Using switch statement to call either of the operations.
7.)  Display queue with import queue utility, peeps the queue LinkedList then display queue’s entries.
8.)  Insert queue, enter integer for maximum iteration of scanner per data entry.
9.)  Delete queue, enter integer for maximum iteration of deletion from queue LinkedList poll.
10.) Display queue size, indicated the queue LinkedList size by counting the data of the queue.
11.) Display peek,  indicate the front/head from the queue LinkedList by showing the front queue.
12.) Sort the name via ascending, get and compare data t’s last name to t1’s last name via comparator.
13.) Sort the name descending, get and compare data t1’s last name to t’s last name via comparator. 
14.) Sort the age via ascending, get and compare data t’s age to t1’s age via comparator.
15.) Sort the age via descending, get and compare data t1’s age to t’s age via comparator.
16.) Display the inputted operation.
17.) Display the current state of the queue.
18.) If operation inputted is empty, show Boolean result.
19.) Terminate the program.
20.) End.
*/