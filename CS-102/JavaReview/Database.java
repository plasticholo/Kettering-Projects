package JavaReview;

import java.util.Arrays;

public class Database 
{
    private Entry[] entryArray;
    private int currentEntries;
    
    
    public Database()
    {
        entryArray = new Entry[100];
        currentEntries = 0;
    }

    public void addData(Entry entry)
    {
        if(currentEntries<100)
        {
            entryArray[currentEntries] = entry;
            currentEntries++;
        }
        else
        {
            System.out.println("Database is at max entries");
        }
    }

    public Entry[] lookUpName(String name)
    {
        Entry[] names = new Entry[currentEntries];
        int number = 0;
        
        for(int i = 0; i < currentEntries; i++)
        {
            if (entryArray[i].getName().equals(name))
            {
                names[number++] = entryArray[i];
            }
        }
        
        return Arrays.copyOf(names, number);
    }

    public Entry[] lookUpAddress(String address)
    {
        Entry[] addresses = new Entry[currentEntries];
        int number = 0;
        
        for (int i = 0; i < currentEntries; i++)
        {
            if (entryArray[i].getAddress().equals(address))
            {
                addresses[number++] = entryArray[i];
            }
        }
        
        return Arrays.copyOf(addresses, number);
    }

    public Entry[] lookUpPhone(String address)
    {
        Entry[] phones = new Entry[currentEntries];
        int number = 0;
        
        for (int i = 0; i < currentEntries; i++)
        {
            if (entryArray[i].getAddress().equals(address))
            {
                phones[number++] = entryArray[i];
            }
        }
        
        return Arrays.copyOf(phones, number);
    }

    public String toString()
    {
        String result = "There are "+ currentEntries + " entries.\n";

        for (int i = 0; i < currentEntries; i++)
        {
            result = result + entryArray[i].toString() + "\n";
        }

        return result;
    }
}
