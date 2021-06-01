/**
 * 
 */
package FileHandling;
import java.io.*;
import java.util.HashMap;
import java.util.*;
/**
 * @author PHAM VO HOANG KHANG
 *
 */
public class WriteToFile {
	public static void WriteFile(String filename,String url,HashMap<String,String >hm)
	{
		FileWriter fw=null;
		
		try {
			fw=new FileWriter(url);
			Set<String> keysets=hm.keySet();
			String _TEMP=new String("");
			for(String k: keysets)
			{
				_TEMP=k+"`"+hm.get(k)+"\n";
				fw.write(_TEMP);
			}
		}
		catch(IOException e)
		{
			System.out.println("WARNING: CAN NOT OPEN FILE");
		}
		finally {
			try {
				fw.close();
			}
			catch(Exception e)
			{
				System.out.println("WARNING: CAN NOT CLOSE FILE");
			}
		}
	}

}
