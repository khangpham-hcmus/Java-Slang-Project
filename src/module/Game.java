/**
 * 
 */
package module;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author PHAM VO HOANG KHANG
 *
 */
public class Game{
	private Set<String> _keySet;
	private List<String> ListKey=new ArrayList<String>();
	public Game(HashMap<String,String >dt)
	{
		_keySet=dt.keySet();
		
		for(String k:_keySet)
		{
			ListKey.add(k);
		}
		
	}
	public String GET_RANDOM_KEY()
	{
		double _randNUMBER=Math.random();
		int RANDOM_INDEX=(int)(_randNUMBER*1000);
		return ListKey.get(RANDOM_INDEX);
	}
	public void GUESS_DEFINATION(HashMap<String,String> hm)
	{
		//get the random key and value;
		String KEYS=new String(this.GET_RANDOM_KEY());
		String VALUES=new String(hm.get(KEYS));
		//get 4 random keys,values
		String k1=this.GET_RANDOM_KEY();
		String k2=this.GET_RANDOM_KEY();
		String k3=this.GET_RANDOM_KEY();
		String k4=this.GET_RANDOM_KEY();
		double randNum=Math.random();
		int _randInt=(int)(randNum*100);
		_randInt%=4;
		
		//save these things to String array
		String []arr=new String [4];
		arr[0]=hm.get(k1);
		arr[1]=hm.get(k2);
		arr[2]=hm.get(k3);
		arr[3]=hm.get(k4);
		//overwrite the value to random
		arr[_randInt]=VALUES;
		int count=0;
		System.out.println("GUESS THE DEFINATION OF `"+KEYS+"`:");
		System.out.println("CHOSE 1 IN 4 ANSWER:");
		while(true)
		{
			System.out.println(++count+":"+arr[count-1]);
			if(count==4)break;
		}
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("PRESS: ");
				String _temp=br.readLine();
				int CHOSE=0;
				CHOSE=Integer.parseInt(_temp);
				if(CHOSE>=1&&CHOSE<=4) {
					if(arr[CHOSE-1].equals(VALUES))
						System.out.println("CORRECT RESULT");
					else {
						System.out.println("=====>>>>INCORRECT RESULT");
						System.out.println("=====>>>>THE CORRECT RESULT IS: "+VALUES);
						}
					break;
				}
				System.out.println("INVALID CHOSEN. CHOSE AGAIN PLEASE.");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
	}
	public void GUESEE_SLANG_WORD(HashMap<String,String> hm)
	{
		//get the random key and value;
				String KEYS=new String(this.GET_RANDOM_KEY());
				String VALUES=new String(hm.get(KEYS));
				//get 4 random keys,values
				String k1=this.GET_RANDOM_KEY();
				String k2=this.GET_RANDOM_KEY();
				String k3=this.GET_RANDOM_KEY();
				String k4=this.GET_RANDOM_KEY();
				double randNum=Math.random();
				int _randInt=(int)(randNum*100);
				_randInt%=4;
				
				//save these things to String array
				String []arr=new String [4];
				arr[0]=k1;
				arr[1]=k2;
				arr[2]=k3;
				arr[3]=k4;
				//overwrite the value to random
				arr[_randInt]=KEYS;
				int count=0;
				System.out.println("GUESS THE SLANG OF `"+VALUES+"`:");
				System.out.println("CHOSE 1 IN 4 ANSWER:");
				while(true)
				{
					System.out.println(++count+":"+arr[count-1]);
					if(count==4)break;
				}
				try {
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					while(true) {
						System.out.println("PRESS: ");
						String _temp=br.readLine();
						int CHOSE=0;
						CHOSE=Integer.parseInt(_temp);
						if(CHOSE>=1&&CHOSE<=4) {
							if(arr[CHOSE-1].equals(KEYS))
								System.out.println("CORRECT RESULT");
							else {
								System.out.println("=========>>>>INCORRECT RESULT");
								System.out.println("========>>>>>THE CORRECT RESULT IS: "+KEYS);
								}
							break;
						}
						System.out.println("INVALID CHOSEN. CHOSE AGAIN PLEASE.");
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				catch(NumberFormatException e)
				{
					e.printStackTrace();
				}
	}
	
	
}
