/***********************************************************************************************
 * Class Name: RecieveFile
 * Author's Name: Will Erickson
 * Date: 4/24/2025
 * Description of the class: Class that allows you to recieve a file when used in tandem with SendFile
 ***********************************************************************************************/
package FileSharing;

import java.io.*;
import java.net.*;

public class RecieveFile
{
    //Main Function
    public static void main(String[] args) 
    {
        int portNum = 5000;
        String saveDirectory = "C:\\filepath";

        try(ServerSocket serverSocket = new ServerSocket(portNum))
        {
            System.out.println("Reciever is listening on port: " + portNum + "...");

            while (true)
            {
                //waits for a client to connect to
                Socket socket = serverSocket.accept();
                System.out.println("Connected to sender: "+ socket.getInetAddress());

                //Sets up input stream to recieve data
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                //Reads metadata
                String fileName = dataInputStream.readUTF();
                long fileSize = dataInputStream.readLong();

                //prepraes the output stream to save the file
                FileOutputStream fileOutputStream = new FileOutputStream(saveDirectory + File.separator + fileName);
                byte[] buffer = new byte[4096];
                int read;
                long recieved = 0;


                //reads the file data
                while((read=dataInputStream.read(buffer))>0)
                {
                    fileOutputStream.write(buffer, 0, read);
                    recieved += read;
                    if(recieved >=fileSize) break;
                }

                System.out.println("File Recieved: "+ fileName);
                fileOutputStream.close();
                socket.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}