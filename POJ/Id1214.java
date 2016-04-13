import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String[] a = new String[52];
		String element;
		int i = 0;

		List<String[]> list = new ArrayList<String[]>();

		while(!(element = scan.next()).equals("#")){
			a[i++] = element;
			if(i == 52){
				list.add(a);
				a = new String[52];
//				doAccordion(a);
				i = 0;
			}
		}
		scan.close();
		for(String[] aa:list){
			doAccordion(aa);
		}
	}


	private static boolean matchString(String a,String b){
		if(a.substring(0, 1).equals(b.substring(0,1))||a.substring(1, 2).equals(b.substring(1,2)))
			return true;
		else
			return false;
	}


	private static void doAccordion(String a[]){
		List<LinkedList<String>> list = new LinkedList<LinkedList<String>>();
		for(int i = 0; i < a.length;i++){
			LinkedList<String> list2 = new LinkedList<String>();
			list2.add(a[i]);
			list.add(list2);
		}

		int i = 1;
		while(i!=list.size()){
			if(i-3>=0){
				LinkedList<String> list_b = list.get(i-3);
				LinkedList<String> list_f = list.get(i);
				if(matchString(list_f.getLast(),list_b.getLast())){
					list_b.add(list.get(i).removeLast());
					if(list_f.isEmpty())
						list.remove(i);
					i = i - 3;
					continue;
				}

			}
			if(i-1>=0){
				LinkedList<String> list_b = list.get(i-1);
				LinkedList<String> list_f = list.get(i);
				if(matchString(list_f.getLast(),list_b.getLast())){
					list_b.add(list.get(i).removeLast());
					if(list_f.isEmpty())
						list.remove(i);
					i = i - 1;
					continue;
				}

			}
			i++;
		}



		//_______________最終出力________________________________

		System.out.print(list.size() + " piles remaining:");

		for(i = 0; i < list.size();i++){
			System.out.print(" " + list.get(i).size());
		}
		System.out.println();

	}

}
