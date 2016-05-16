import java.util.Set;
import java.util.HashSet;

public class Callender2016{
	public static void main(String[] args){
		String week[] = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		String month[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		Set<Integer> thirtyMonth = new HashSet<>();
		thirtyMonth.add(4);
		thirtyMonth.add(6);
		thirtyMonth.add(9);
		thirtyMonth.add(11);
		Set<Integer> twentynineMonth = new HashSet<>();//2016年は閏年である。
		twentynineMonth.add(2);

		int todays_week_pointer=5;//曜日を操作するindex,2016年1月1日は木曜日から始まる。
		for(int m = 0; m < 12; m++){
			System.out.println("["+month[m] + "]");
			for(String week_name:week){
				System.out.print(week_name + "\t");
			}
			System.out.println();
			for(int i = 0; i < todays_week_pointer;i++){
				System.out.print("\t");
			}
			for(int d = 0; d < 31;d++){
				if(thirtyMonth.contains(m+1)){
					if(d==30)
						break;
				}
				if(twentynineMonth.contains(m+1)){
					if(d==29)
						break;
				}
				System.out.print((d+1) + "\t");
				todays_week_pointer=(todays_week_pointer+1)%7;
				if(todays_week_pointer==0)
					System.out.println();
			}
			System.out.println("\n");
		}
	}
}
