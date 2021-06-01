/**
 * 
 */
package module;
import java.io.*;
import java.util.*;

/**
 * 
 * @author PHAM VO HOANG KHANG
 *
 */
public class ChucNang {
	private static String SPECIAL_STRING = "--------------------------------------------------------------------------";
	// protected static Set<String,String> stored;
	protected static List<String> LIST_SLANGWORD_FOUNDS = new ArrayList<>();

	// first method
	public static void SEARCH_SLANGWORD(HashMap<String, String> data) {
		System.out.println(SPECIAL_STRING);
		String _slangword = "";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Input slang word want to search: ");
		try {
			_slangword = br.readLine();
			LIST_SLANGWORD_FOUNDS.add(_slangword);
		} catch (IOException e) {
			System.out.println("WARNING: CAN NOT INPUT DATA");
		}
		String result = data.get(_slangword);
		if (result == null)
			System.out.println("STATE: CAN NOT FIND");
		else {
			System.out.println("STATE: DEFINATION IS: " + result);
		}
	}

	// second method
	public static void SEARCH_DEFINATION(HashMap<String, String> data) {
		System.out.println(SPECIAL_STRING);
		List<String> results = new ArrayList<String>();
		String _defination = "";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Input defination: ");
		try {
			_defination = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<String> keysets = data.keySet();
		for (String k : keysets) {
			String s = data.get(k);
			if (s.contains(_defination) == true) {
				results.add(k);
			}
		}
		if (results.size() == 0) {
			System.out.println("NO SLANG WORD IS SUITABLE");
		} else {
			System.out.println("LIST SLANG WORDS CAN FIND: " + results.toString());
		}
	}

	// method_ 3rd
	public static void LIST_SLANGWORDS_HAS_BEEN_FOUND() {
		System.out.println(SPECIAL_STRING);
		if (LIST_SLANGWORD_FOUNDS.size() == 0)
			System.out.println("NO SLANG WORD HAS BEEN SEARCH\n");
		else {
			System.out.println("SLANG WORDS HAS BEEN SEARCH" + LIST_SLANGWORD_FOUNDS.toString());

		}
	}

	// method_ 4th
	public static void ADD_SLANGWORD(HashMap<String, String> data) {
		System.out.println(SPECIAL_STRING);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String _slangword = new String("");
		String _defination = new String("");
		try {
			System.out.println("Input slang word: ");
			_slangword = br.readLine();
			System.out.println("Input defination: ");
			_defination = br.readLine();
		} catch (IOException e) {
			System.out.println("WARNINGS: CAN NOT ENTRY SLANG WORD TO ADD");
		}

		Set<String> keysets = data.keySet();
		boolean _FLAG = false;
		for (String k : keysets) {
			if (_slangword.equals(k)) {
				_FLAG = true;
				break;
			}
		}
		if (_FLAG == true) {
			System.out.println("SLANG WORD HAS BEEN EXISTED");
			System.out.println("1.OVERWRITE");
			System.out.println("2.NO OVERWRITE");
			int CHOSE = 0;
			String _TEMP = "";
			while (true) {
				try {
					_TEMP = br.readLine();
					CHOSE = Integer.parseInt(_TEMP);
				} catch (IOException e) {
					System.out.println("WARNINGS: CAN NOT INPUT");
				} catch (NumberFormatException k) {
					System.out.println("WARNINGS: NUMBER FORMAT INPUT");
				}
				if (CHOSE == 1 || CHOSE == 2) {
					if (CHOSE == 1) {
						String a = data.get(_slangword);
						StringBuffer sb = new StringBuffer(a);
						sb.append("| ");
						sb.append(_defination);
						a = sb.toString();
						data.replace(_slangword, a);
						System.out.println("STATE: OVERWRITE SUCCESSFULLY");
						return;
					} else {
						System.out.println("STATE: NO OVERWRITTEN");
						return;
					}
				}

			}

		}
		data.put(_slangword, _defination);
		System.out.println("STATE: ADDED SUCCESSFULLY");
	}

	// method_ 5th
	public static void EDIT_SLANGWORD(HashMap<String, String> data) {
		System.out.println(SPECIAL_STRING);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String _slangword = new String("");
		String _new_slangword = new String("");
		try {
			System.out.println("Input slang word to edit: ");
			_slangword = br.readLine();
			System.out.println("Input new slang word which want to edit: ");
			_new_slangword = br.readLine();
			String value = data.get(_slangword);
			String check_New = data.get(_new_slangword);
			if (value == null) {
				System.out.println("STATE: SLANG WORD DOES NOT EXIST. EDIT FAILED!!!");
				return;
			} else {
				if (check_New != null) {
					System.out.println("STATE: EDIT FAILED. THE NEW SLANG WORD HAS BEEN EXISTED.");
					return;
				}
				data.remove(_slangword);
				data.put(_new_slangword, value);
				System.out.println("STATE:\nEDITTED SUCCESSFULLY");
				return;
			}

		} catch (IOException e) {
			System.out.println("WARNINGS: CAN NOT INPUT DATA");
		}
	}

	// method 6th
	public static void DELETE_SLANGWORD(HashMap<String, String> data) {
		System.out.println(SPECIAL_STRING);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String _slangword = "";
		String _TEMP = "";
		String _CHECK = null;
		int CHOSE = 0;
		try {
			System.out.println("Input slang word which you want to delete: ");
			_slangword = br.readLine();
			_CHECK = data.get(_slangword);
			if (_CHECK == null) {
				System.out.println("STATE:\nTHE SLANG WORD DOES NOT EXISTING. DELETE FAILED.");
				return;
			} else {
				System.out.println("ARE YOU SURE TO DELETE THIS SLANG WORD:");
				System.out.println("PRESS:");
				System.out.println("1:YES");
				System.out.println("2:NOT SURE AND COME BACK TO MENU");
				System.out.println("Input,please:");
				_TEMP = br.readLine();
				CHOSE = Integer.parseInt(_TEMP);
				if (CHOSE == 2) {

					System.out.println("STATE: THIS SLANG WORD DOES NOT DELETE. STAYING MENU HERE.");
					return;
				} else {
					data.remove(_slangword);
					System.out.println("STATE: THIS SLANG HAS BEEN DELETED");
					return;
				}
			}

		} catch (IOException e) {
			System.out.println("WARNINGS: CAN NOT INPUT DATA");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	// method 7:
	public static void BACK_UP_DATA_ROOT(String _url_backup, String _DELIMETER, HashMap<String, String> hm) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			hm.clear();
			fr = new FileReader(_url_backup);
			br = new BufferedReader(fr);
			String _TEMP = "";
			while (true) {
				_TEMP = br.readLine();
				if (_TEMP == null)
					break;
				String[] arr = _TEMP.split(_DELIMETER);
				if (arr.length == 2) {
					hm.put(arr[0], arr[1]);
				}

			}
			System.out.println("STATE: BACKUP DATA COMPLETELY");
		} catch (IOException e) {
			System.out.println("CAN NOT OPEN FILE BACKUP");
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				System.out.println("CAN NOT CLOSE FILE");
			}
		}
	}

	// method 8
	public static void RANDOM_SLANG_WORD(HashMap<String, String> hm) {
		Game game = new Game(hm);
		String key=game.GET_RANDOM_KEY();
		System.out.println("THE RANDOM SLANG WORD GIVE YOU: " + key +"  { "+hm.get(key)+" }");
		return;

	}

	// method 9
	public static void PLAYGAME_GUESS_DEFINATION(HashMap<String, String> hm) {

		Game game = new Game(hm);
		game.GUESS_DEFINATION(hm);
	}

	// method 10
	public static void PLAYGAME_GUESS_SLANG_WORD(HashMap<String, String> hm) {
		Game game = new Game(hm);
		game.GUESEE_SLANG_WORD(hm);
	}

}
