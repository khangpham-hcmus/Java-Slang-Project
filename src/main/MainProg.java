/**
 * 
 */
package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import FileHandling.DocFile;
import FileHandling.WriteToFile;
import module.ChucNang;
import module.Game;

@SuppressWarnings("unused")
public class MainProg {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO -generated method stub
		String url="./slang.txt";
		String Delimeter="`";
		String url_backup="./BACKUP.txt";
		HashMap<String,String> _data = DocFile.GET_SLANGS_FROM_DATA(url, Delimeter);
		
		HashMap<String ,String> _backup_data=DocFile.GET_SLANGS_FROM_DATA(url_backup, Delimeter);
		
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String _TEMP="";
		Game game=new Game(_backup_data);
		int _CHOSE=0;
		int _CONTINUE=0;
		
		while(true)
		{
			System.out.println("-----------MENU---------------");
			System.out.println("0.STOP PROGRAM");
			System.out.println("1.SEARCH FOLLOW SLANG WORD");
			System.out.println("2.SEARCH FOLLOW DEFINATION WORD");
			System.out.println("3.DISPLAY HISTORY ABOUT SEARCHING KEYS");
			System.out.println("4.ADD A SLANG WORD");
			System.out.println("5.EDIT A SLANG WORD");
			System.out.println("6.DELETE A SLANG WORD");
			System.out.println("7.BACKUP DATA");
			System.out.println("8.RANDOM SLANG WORD");
			System.out.println("9.PLAY GAME : GUESS DEFINATION WITH RANDOM SLANG WORD");
			System.out.println("10.PLAY GAME: GUESS SLANG WORD WITH RANDOM DEFINATION");
			while(true) {
			try {
				System.out.println("Input,please:");
				_TEMP=br.readLine();
				_CHOSE=Integer.parseInt(_TEMP);
				if(_CHOSE>=1 ||_CHOSE<=10)
				{
					switch(_CHOSE) {
					case 0:
						System.out.println("------------------------------THE PROGRAM IS ENDED. THANK YOU---------------------------------------------\n");
						return;
					case 1:
						ChucNang.SEARCH_SLANGWORD(_data);break;
					case 2: 
						ChucNang.SEARCH_DEFINATION(_data);break;
					case 3:
						ChucNang.LIST_SLANGWORDS_HAS_BEEN_FOUND();break;
					case 4:
						ChucNang.ADD_SLANGWORD(_data);break;
					case 5:
						ChucNang.EDIT_SLANGWORD(_data);break;
					case 6: 
						ChucNang.DELETE_SLANGWORD(_data);break;
					case 7: 
						ChucNang.BACK_UP_DATA_ROOT(url_backup, Delimeter,_data);break;
					case 8: 
						ChucNang.RANDOM_SLANG_WORD(_data);break;
					case 9:
						ChucNang.PLAYGAME_GUESS_DEFINATION(_data);break;
					case 10:
						ChucNang.PLAYGAME_GUESS_SLANG_WORD(_data);break;
						
					
					}
					
				}	
				
				System.out.println("-----------------DO YOU WANT TO CONTINUE THE PROGRAM?-------------------");
				System.out.println("PRESS:");
				System.out.println("ANY KEYS TO CONTINUE");
				System.out.println("0 TO STOP PROGRAM");
				_TEMP=br.readLine();
				_CONTINUE=Integer.parseInt(_TEMP);
				
				if(_CONTINUE==0)
					{
					WriteToFile.WriteFile(url, url, _data);
					System.out.println("------------------------------THE PROGRAM IS ENDED. THANK YOU---------------------------------------------\n");
						return ; 
					}
				else
				{
					System.out.println("--------------------------------PROGRAM IS CONTINUE-----------------------------------\n");
				}
				
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
				
			}
			catch(NumberFormatException e) {
				System.out.println("--------------------------------PROGRAM IS CONTINUE---------------------------------------------------------------------------------\n");
			}
		
			break;
		}
		
		
		
		}
		
	}
	
}