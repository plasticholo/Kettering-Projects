/***********************************************************************************************
 * Class Name: SendFile
 * Author's Name: Will Erickson
 * Date: 4/24/2025
 * Description of the class: Class that allows you to send a file when used in tandem with RecieveFile
 ***********************************************************************************************/
package FileSharing;

import java.io.*;
import java.net.*;
import java.util.*;

public class SendFile 
{
    //main function
    public static void main(String[] args) 
    {
        //creates scanner
        Scanner scan = new Scanner(System.in);
        
        //ask for IP
        System.out.println("Enter the IP address for the reciever: ");
        String serverIp = scan.nextLine();

        //ask for filepath
        System.out.println("Enter the filepath: ");
        String filePath = scan.nextLine();

        //sets the port number
        int portNum = 5000;

        try(Socket socket = new Socket(serverIp, portNum))
        {
            File file = new File(filePath);


            //prepares input and output streams
            FileInputStream fileInputStream = new FileInputStream(file);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            //sends metadata
            dataOutputStream.writeUTF(file.getName());
            dataOutputStream.writeLong(file.length());

            //sends file content
            byte[] buffer = new byte[4096];
            int read;
            while((read = fileInputStream.read(buffer)) > 0)
            {
                dataOutputStream.write(buffer, 0, read);
            }

            System.out.println("File Sent: " + file.getName());
            fileInputStream.close();
        }
        //catches IO Exceptions
        catch(IOException e)
        {
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        //closes scanner
        scan.close();
    }
}
