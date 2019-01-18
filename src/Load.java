
//TODO: trial of loading, may have to remove
import java.io.*;
public class Load
{
    public int l;
    public int s;
    public boolean armor;
    public boolean kit;
    public boolean rapid;
    public boolean barrel;
    public boolean mobility;
    public static void main(String[] args)
    {
        try
        {
            //Create a new instance of the FileReader and pass it the
            //file that needs to be read
            FileReader fr = new FileReader("save.txt");

            //Create a new instance of the BufferedReader and
            //add the FileReader to it
            BufferedReader br = new BufferedReader(fr);

            //A string variable that will temporarily what you’re reading
            String line;

            //A dual purpose line! First it reads the next line and then
            //it checks to see if that line was null. If it’s null, then
            //that means you’re at the end of the file.
            int i=0;
            while ((line=br.readLine()) != null)
            {
                i++;
                if (i==1){
                    //l = ((int) line);
                }
            }
            //close the file when you’re done
            br.close();
        }
        catch(IOException e)
        {
            //Error message
        }
    }
}