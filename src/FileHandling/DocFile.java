/**
 * 
 */
package FileHandling;
import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author PHAM VO HOANG KHANG
 *
 */
public class DocFile {
	public static HashMap<String,String> GET_SLANGS_FROM_DATA(String fileName,String Delimeter)
	{
		HashMap<String, String> hm = new HashMap<>();
		InputStreamReader isr = null;
		BufferedReader br=null;
		try {
			isr = new InputStreamReader(new FileInputStream(fileName));
			br = new BufferedReader(isr);
			String line = br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] arr = line.split(Delimeter);
				if(arr.length==2)
					{
						hm.put(arr[0],arr[1])	;
					}		
				
			}
		}
		catch(Exception ex) {
			System.out.println("WARNING: CAN NOT OPEN THE FILE'S DATA");
		}
		finally {
			try {
				br.close();
				isr.close();
			}
			catch(Exception ex)
			{
				System.out.println("WARNING: CAN NOT CLOSE FILE");
			}
			
		}		
		return hm;
	}
}
