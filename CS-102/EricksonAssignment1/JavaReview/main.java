package JavaReview;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class main
{
   
    //verifies if an entry exists before printing
    private static void printEntry(Entry[] entries)
    {
        if (entries.length == 0)
        {
            System.out.println("Entry not found");
        }
        else
        {
            for(Entry entry : entries)
            {
                System.out.println(entry);
            }
        }
    }

    //validation
    private static boolean validName(String name)
    {
        return name.split(" ").length == 2;
    }

    private static boolean validAddress(String address)
    {
        return address.matches("\\d+\\s+[A-Za-z\\s]+(#\\d+)?\\s*,\\s*[A-Za-z]+\\s+[A-Z]{2}\\s+\\d{5}");
    }

    private static boolean validPhone(String phone)
    {
        return phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }
    
    public static void main(String[] args)
    {
        //checks if command line argument was used
        if (args.length != 1)
        {
            System.out.println("Argument not used");
            return;
        }

        String filename = args[0];
        Database database = new Database();

        //verifies if the file is valid before adding it to the database
        try (Scanner fScan = new Scanner(new File(filename)))
        {
            while (fScan.hasNextLine())
            {
                String line = fScan.nextLine();
                String[] section = line.split(":");

                if (section.length == 3)
                {
                    String name = section[0];
                    String address = section[1];
                    String phone = section[2];

                    if (validName(name) && validAddress(address) && validPhone(phone))
                    {
                        database.addData(new Entry(name, address, phone));
                    }
                }
            }
        }

        //Catch for filenotfoundexception
        catch (FileNotFoundException e)
        {
            System.out.println(filename +" was not found");
            return;
        }

        Scanner iScan = new Scanner(System.in);

        //While loop that will cycle through all the options until "Q" is chosen
        while(true)
        {
            System.out.println("Choose one of the following options: ");
            System.out.println("P  - print all entries");
            System.out.println("LT - look up an entry given phone number");
            System.out.println("LA - look up an entry given address");
            System.out.println("LN - look up an entry given name");
            System.out.println("A  - add an entry to the database");
            System.out.println("Q  - Quit the program");

            String input = iScan.nextLine().trim();

            if (input.equals("P"))
            {
                System.out.println(database.toString());
            }
            else if (input.equals("LT"))
            {
                System.out.println("Enter a phone number EX:(789-343-3434): ");
                String phone = iScan.nextLine().trim();

                if(validPhone(phone))
                {
                    Entry[] entriesByPhone = database.lookUpPhone(phone);
                    printEntry(entriesByPhone);
                }
                else
                {
                    System.out.println("Invalid format");
                }
            }
            else if (input.equals("LA"))
            {
                System.out.println("Enter an address EX:(1225 KnollWood Drive, Boston MA 43434): ");
                String address = iScan.nextLine().trim();

                if(validAddress(address))
                {
                    Entry[] entriesByAddress = database.lookUpAddress(address);
                    printEntry(entriesByAddress);
                }
                else
                {
                    System.out.println("Invalid format");
                }
            }
            else if (input.equals("LN"))
            {
                System.out.println("Enter a name EX:(John Doe): ");
                String name = iScan.nextLine().trim();
                
                if(validName(name))
                {
                    Entry[] entriesByName = database.lookUpName(name);
                    printEntry(entriesByName);
                }
                else
                {
                    System.out.println("Invalid format");
                }
            }
            else if (input.equals("A"))
            {
                System.out.println("Enter name: ");
                String name = iScan.nextLine().trim();

                System.out.println("Enter address: ");
                String address = iScan.nextLine().trim();

                System.out.println("Enter phone number: ");
                String phone = iScan.nextLine().trim();

                if(validName(name) && validAddress(address) && validPhone(phone))
                {
                    database.addData(new Entry(name, address, phone));
                    System.out.println("Successfully Added ");
                }
                else
                {
                    System.out.println("Invalid Format");
                }
            }
            else if (input.equals("Q"))
            {
                iScan.close();
                break;
            }
            else
            {
                System.out.println("You did not enter a valid option");
            }
        }
    }
}