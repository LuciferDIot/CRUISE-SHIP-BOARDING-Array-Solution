import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] name = new String[4];
//        to add the all cabin details.15/03/2022
        String[][] shipCabins;
        Scanner scanner = new Scanner(System.in);
        String[][] shipCabin_x = new String[12][3];
        System.out.print("""
                    
                    
                    
                    
                    
                    |--------------------------------------------------|
                    |          WELCOME TO CRUISE SHIP BOARDING         |
                    |--------------------------------------------------|
                    | would you like to continue the program with the  |
                    | previous file record? [Y/N]                      |
                    |--------------------------------------------------|
                    | ANS :                                            |""");
        if (scanner.next().equalsIgnoreCase("N")) {
            shipCabins= initialise(shipCabin_x,"N");
        }else {
            shipCabins= initialise(shipCabin_x,"file.txt");
        }

        while (true) {
            System.out.print("""
                    |--------------------------------------------------|
                    | CHOOSE OPTION AND ENTER                          |
                    | A: Add a customer to a cabin                     |
                    | V: View all cabins                               |
                    | E: Display Empty cabins                          |
                    | D: Delete customer from cabin                    |
                    | F: Find cabin from customer name                 |
                    | S: Store program data into file                  |
                    | L: Load program data from file                   |
                    | O: View passengersOrdered alphabetically by name |
                    | T: To STOP the program                           |
                    |--------------------------------------------------|
                    | ANS :                                            |""");
            String answer = scanner.next();
            System.out.println("|--------------------------------------------------|");
            if (answer.equalsIgnoreCase("A")){
                addCustomer(shipCabins,scanner,name);
            }
            else if (answer.equalsIgnoreCase("V")) {
                viewAllCabins(shipCabins);
            }
            else if (answer.equalsIgnoreCase("E")) {
                emptyCabins(shipCabins);
            }
            else if (answer.equalsIgnoreCase("D")) {
                deleteCustomer(shipCabins,scanner,name);
            }
            else if (answer.equalsIgnoreCase("F")) {
                findCabinByName(shipCabins,scanner);
            }
            else if (answer.equalsIgnoreCase("S")) {
                intoFile(shipCabins, scanner);
            }
            else if (answer.equalsIgnoreCase("L")) {
                loadFile(scanner,shipCabin_x);
            }
            else if (answer.equalsIgnoreCase("O")) {
                passengersOrder(shipCabins);
            }
            else if (answer.equalsIgnoreCase("T")) {
                print(  "|                   FINISHED                       |");
                break;
            }
            else {print("| INPUT IS NOT CORRECT. TRY AGAIN                  |");
            }
        }
    }

    private static void loadFile(Scanner scanner, String[][] shipCabin_x) {
        /*
        * You have two options as below. If your input is one it will load data from previous file that you saved data."file.txt"
        * if your option is 2 it will give you chance to load data from file, but it must have an order as printed msg when last
        printed msg on txt file when we store the data. If it is the program will load the data from that file. You just
        only have to give the path to txt file and put the .txt extension
        28/03/2022
         */

        System.out.print("""
                    |--------------------------------------------------|
                    | Choose the option what you want                  |
                    | 1: To load the previous stored data              |
                    | 2: To load the New File data                     |
                    | ANS                                             :|""");
        try {int ans1 = Integer.parseInt(scanner.next());
            if (ans1==2){
                System.out.println("|--------------------------------------------------|");
                System.out.print("""
                    ----------------------------------------------------
                    | Enter the path to .txt file                      |
                    | Eg: D:\\CW\\project\\file.txt                       |
                    | PATH                                            :|""");
                String path = scanner.next();
                initialise(shipCabin_x,path);
                System.out.println("|--------------------------------------------------|");
            }
            else if (ans1==1){
                initialise(shipCabin_x,"file.txt");
                System.out.println("|--------------------------------------------------|");}
            else print("| INPUT IS NOT CORRECT. TRY AGAIN                  |");
        } catch (InputMismatchException | FileNotFoundException e) {
            System.out.print("""
                    |                   Wrong input                    |
                        """);
            System.out.println("|--------------------------------------------------|");
        }
    }


    private static String[][] initialise(String[][] cabins, String path) throws FileNotFoundException {
        /*Asking for would you like to continue the program with the previous file record?
         * If he said yes the previous record will be assigned to the cabin objects and passenger objects
         * IF he said No all cabin objects will create with empty cabin details
         15/03/2022
         */

        if (path.equalsIgnoreCase("N")){
//          adding details as ["Cabin num", "customer name", cabin status] and it added to cabin 2D array.
            for (int x = 0; x < 12; x++ ) {
                String[] sub = new String[3];
                sub[0]="Cabin "+(x+1);
                sub[1]=" - ";
                sub[2]= String.valueOf(0);
                cabins[x] = sub;
                System.out.println( "initialise ".concat(sub[0]));}
        }
        else {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            int i=1;
            for (String[] cabin : cabins){
//                read the line by line, and it will split using ":" and add to r1 array
                String[] r1 = scanner.nextLine().replace(" ","").split(":");
                cabin[2] = r1[2].replace(" ","");
                cabin[0] = "Cabin "+i;
                if (Integer.parseInt(cabin[2]) ==0) {
                    cabin[1] = " - ";
                }
                else {
                    cabin[1] = r1[1];
                }System.out.println("|   Initialise: "+ cabin[0]+"   |");
                i++;
            }
        }
    return cabins;}











    private static void intoFile(String[][] shipCabins,Scanner scanner) {
        /*
        * By this method will give you two option
        1: To store data into the previous file
        2: To store data into New File
        * if you entered 1, the previous details recorded file "file.txt" use as the storing file if isn't you can give
        path and enter your file name as you like with .txt extension.At last of print in file, it will show you what is
        the pattern of data view on your txt file
        28/03/2022
        */

        String path = "file.txt";
        System.out.println("|            Store program data into file          |");
        System.out.print("""
                    |--------------------------------------------------|
                    | Choose the option what you want                  |
                    | 1: To store data into the previous file          |
                    | 2: To store data into New File                   |
                    | ANS                                             :|""");

        try {
            int ans = Integer.parseInt(scanner.next());
//          if answer is 2 you can let him/her to decide .txt file path to store data and that path will be assigned to path
//           variable
            if (ans==2) {
                System.out.print("""
                    ----------------------------------------------------
                    | Enter the path to .txt file that you want to store |
                    | Eg: D:\\CW\\project\\file.txt                         |
                    | PATH                                              :|""");
                path=scanner.next();
            }
            FileWriter file = new FileWriter(path);
            String a ="""
                    
                    
                    |----------------------------------------------------|
                    |                       PATTERN                      |
                    |----------------------------------------------------|
                    |     Cabin Num : Passengers Name : Cabin status     |
                    |----------------------------------------------------|
                    """;
            System.out.println(a);
            for (String[] cabin : shipCabins) {

                String writeDown = cabin[0] + " : " + cabin[1] + " : " + cabin[2];
                file.write(writeDown + "\n");
                System.out.println(writeDown);
            }
            file.write("""


                    |----------------------------------------------------|
                    |                       PATTERN                      |
                    |----------------------------------------------------|
                    |Room condition(R.C.): If 1, there is already a guest|
                    |          E: Expenses;         C: Customer          |
                    |   R.C  :  [1st C]  :  [2nd C]  :  [3rd C]  :  [E]  |
                    |----------------------------------------------------|""");
            file.close();
        } catch (NumberFormatException | IOException e) {
            System.out.println("|--------------------------------------------------|");
            System.out.println("|            Wrong Input type                     :|");
            System.out.println("|--------------------------------------------------|");
        }

    }











    private static void findCabinByName(String[][] shipCabins, Scanner scanner) {
        /*
        * Go through entire cabins by loop and checking passengers surname or firstname is equal to the user input name and
        if it's found it will print out
        20/03/2022
        * */

        System.out.println("|           Find cabin from customer name          |");
        System.out.println("|--------------------------------------------------|");
//        ask the name to find
        System.out.print("|            Enter the Customer name              :|");
        String customer = scanner.next().replace(" ","");int i=0;
        System.out.println("|--------------------------------------------------|");
        for (String[] cabin :shipCabins){
//            going through the array by loop and if customer == your input it will go this way and print out
            if (cabin[1].equalsIgnoreCase(customer)){
                System.out.println("|                "+cabin[0] + " owned by " + cabin[1]+"         |");
                i++;
            }
        }// if customer couldn't be able to find out this will print
        if (i==0) System.out.println("|        No customer by this name was found        |");
        System.out.println("|--------------------------------------------------|");

    }












    private static void deleteCustomer(String[][] shipCabins, Scanner scanner, String[] name) {
        /*
        * Go through entire cabins by loop and checking passengers surname or firstname is equal to the user input name and
        if it's found the equal passenger pass set the mainName value to cabinName value
        * If that name customer couldn't be able to find out in cabin it checked by line 183 and print msg
        * After that if you find out the correct passenger from cabin reset the values in whole cabin,using mainName.
        * Eventually is any customers in waiting List they will be added to the deleted cabin.
        28/03/2022
        */

        System.out.println("|             Delete customer from cabin           |");
        int l =0;
        while (l==0){
            String mainName =" - ";
//        Ask the customers name or cabin num for delete from cabin
            System.out.println("|--------------------------------------------------|");
            System.out.print(  "|       Enter the Customer name or cabin num      :|");
            String firstname = scanner.next().replace(" ","");
            String g = firstname.substring(0,1).toUpperCase()+firstname.substring(1);
            System.out.println("|--------------------------------------------------|");
            int a=0;
            for (String[] cabin :shipCabins){
//            going through cabin loop and check the cabin names and cabin numbers for is it equal to input or not
                if (g.equalsIgnoreCase(cabin[1])
                        ||  cabin[0].split("n")[1].replace(" ","").equals(g)) {
                    mainName = cabin[1];
                    a++;
                    break;
                }
            }
            try {
                int k = Integer.parseInt(g);
                if (0>= k || k>= 13){
                    print("|            We have only 12 cabins                |");
                    continue;}
            }catch (NumberFormatException ignored){
            }
            if (a==0) {
//            if customer doesn't find this will print
                print("|        No customer by this name was found        |");
            }
            else {
                System.out.print("| Are you sure you want to delete this passenger (Y/N) :|");
                if (!scanner.next().equalsIgnoreCase("Y")) {
                    l++;
                    print("|           End process without deleting           |");
                    continue;
                }
                for (String[] cabin:shipCabins) {
                    if (cabin[1].equals(mainName)) {
                        cabin[1]=" - ";
                        cabin[2]= String.valueOf(0);
                        print("|            Deleted from this cabin               |");l++;
                        break;
                    }
                }
            }
        }if (waitingListSize(name)>0) init2(shipCabins,name);
    }





    private static int emptyCabins(String[][] shipCabins) {
        /*
         * Go through the loop and check the cabin status. If cabin status is 0 it is empty, and it will print
         03/04/2022*/

        System.out.println("|               Display Empty cabins               |");
        System.out.println("|--------------------------------------------------|");
        int i=12;
        int j=0;
        for (String[] cabin:shipCabins) {
//            going through array of cabins and if the cabin is empty go in this path
            if (cabin[2].equals(String.valueOf(0))) {
                System.out.println("|              " + cabin[0] + " :   empty                   |");
                i--;
            }
        }if (i==12) {
//            if all cabins are fulled this will print
            print("|-------------All Cabins are fulled----------------|");
            j=1;
        }
        return j;
    }










    private static void viewAllCabins(String[][] shipCabins) {
        /*
         * If cabinStatus == 0 it will show cabin is empty if isn't it will show cabin owners name
         01/04/2022
         */

        System.out.println("|                  View all cabins                 |");
        System.out.println("|--------------------------------------------------|");
        for (String[] cabin:shipCabins){
//            going through the array and if cabin is empty this will print and if isn't else option will print out
            if (cabin[2].equals(String.valueOf(0))){
                System.out.println("|              "+cabin[0]+" :   empty                   |");
            }else {
                System.out.println("|              "+cabin[0]+" :   " + cabin[1] +"                 |");
            }
        }
    }










    private static void addCustomer(String[][] shipCabins, Scanner scanner, String[] name) {
        /*04/04/2022*/
        int roomNum;
        System.out.println("|             Add customers to a cabin             |");
        int q;
        do {
            q = 0;
            try {
//              check all the cabins or full or not. If isn't path is here and ask for cabin number they require
                if (emptyCabins(shipCabins)==0) {
                    System.out.println("|--------------------------------------------------|");
                    System.out.print("|           Enter the Cabin number                :|");
                    roomNum = Integer.parseInt(scanner.next());
//                  we have only 12 cabins
                    if (roomNum < 13 && 0 < roomNum) {
                        for (String[] cabin : shipCabins) {
                            if (Integer.parseInt(cabin[0].split("n ")[1]) == roomNum) {
//                                If input cabin is full by customers this will print and if isn't customer add by else option
                                if (cabin[2].equals(String.valueOf(1))) {
                                    print("|----------------The cabin is full-----------------|");
                                    print("|                  Waiting List                    |");
                                    print("""
                                    | you can only add 4 customers to the waiting list |
                                    |   When one customer deleted, You will be added   |""");
                                    System.out.print("|           Enter the Customer's name             :|");
                                    String firstname = scanner.next().replace(" ", "");
                                    String a = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
                                    int b = check(a,shipCabins);
                                    if (b==1) {
                                        q++;
                                        break;
                                    }int j=0;
                                    for (int i=0;i<4;i++){
//                        if this is doesn't exist same name will add to the whole waiting list array.
                                        if (j>=1){continue;}
//                        check the index position is free and adding to the waiting list and adding 1 to j
                                        if (name[i]==null) {
                                            name[i] = a;
                                            j++;
                                        }
                                    }
                                    q=1;
                                    break;
                                }

                                else {
                                    System.out.println("|--------------------------------------------------|");
                                    System.out.print("|           Enter the Customer's name             :|");
                                    String firstName = scanner.next().replace(" ", "");
                                    String a = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
//                                    by going to check method it will find that customer already exists or not. If him/her exists
//                                     program will end.
                                    int d = check(a,shipCabins);
                                    if (d==1) {
                                        q++;
                                        break;
                                    }
                                    cabin[2]=String.valueOf(1);
                                    cabin[1]=a;
                                    System.out.println("|           "+cabin[1]+" added to "+cabin[0]+"               :|");
                                    q++;
                                }
                            }
                        }
                    } else print("|           We have only 12 cabins                 |");

                }// If all cabins are full the customer will add to waiting list

            } catch (NumberFormatException e) {
                print("|                 Wrong Input type                :|");
            }

        }
        while (q == 0);
        if (waitingListSize(name)>0) init2(shipCabins,name);
    }

    private static int check(String a, String[][] shipCabins) {
        for (String[] cabins:shipCabins){
//            find the customer already exists or not
//            05/04/2022
            if (a.equalsIgnoreCase(cabins[1])) {
                System.out.println("|--------------------------------------------------|");
                System.out.println("|------------This customer already exist-----------|");
                return 1;
            }
        }
        return 0;
    }








    public static void passengersOrder(String[][] shipCabins) {
        /*
        * When user enter the one option it will Go through the loop, and it will collect your surname of firstname to array
        as user entered input.
        * And going through the loop, and it will make as an order the list using selection
        Algorithm
        * 4/20/2022*/
        String[] firstNames = new String[36];
        System.out.println("| View passengers Ordered alphabetically by name   |");
        int q =0;
        for (String[] cabin:shipCabins){
            firstNames[q]= cabin[1];
            q++;
        }
        for (int i=0;i<q;i++){
            for (int j=0;j<q;j++) {
                if (firstNames[j].compareTo(firstNames[i]) > 0) {
                    String highNum = firstNames[i];
                    String smallNum = firstNames[j];
                    firstNames[i] = smallNum;
                    firstNames[j] = highNum;
                }
            }
        }
        int d =1;
        System.out.print("|  ");
        for (int j=0;j<q;j++){
            if (firstNames[j].replace(" ","").equals("-")) {
                continue;
            }
            System.out.print("  "+firstNames[j]+"  ");
            d++;
            if (d%5==0) {
                System.out.println(" ");
            }
        }System.out.println("  |");

    }










    public static void init2(String[][] shipCabins, String[] name){
        for (String[] cabin:shipCabins) {
            int i=0;
            if (waitingListSize(name) > 0) {
                for (int j = 0; j < 4; j++) {
                    if (name[j]==null || i>=1) {continue;}
                    if (cabin[2].replace(" ", "").equals(String.valueOf(0))) {
                        cabin[1] = name[j];
                        cabin[2] = String.valueOf(1);
                        name[j]=null;
                        print("|           "+cabin[1]+" added to "+cabin[0]+"                |");
                        i++;
                    }
                }
            }

        }
    }
    private static void print(String expression){
        System.out.println("|--------------------------------------------------|");
        System.out.println(expression);
        System.out.println("|--------------------------------------------------|");
    }

    private static int waitingListSize(String[] name) {
        int j=0;
        for (int i=0; i<4;i++){
            if (!(name[i]==null)) j++;
        }
        return j;
    }
}
