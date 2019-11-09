import java.io.*;

public class Assignment22 {

	public static void main(String[] args) {
		String s1, s2;
		try {
			BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
			s1 = rd.readLine();
			s2 = rd.readLine();
			// ===================== Reading ====================
			
			LList first_number = new LList(s1);
			LList second_number = new LList(s2);
			LList first_check_number = new LList(s1, 0);
			LList second_check_number = new LList(s2, 0);
			LList result = new LList();
			int big_len, small_len;
			// ===================== variable 선언 ====================
			
			if(first_number.length>second_number.length) {
				big_len = first_number.length;
				small_len = second_number.length;
			}
			else if (first_number.length==second_number.length){
				LIter first_check = first_check_number.getIter();
				LIter second_check = second_check_number.getIter();
				
				for(int i=0;i<first_number.length;i++) {
					if(first_check.getData()>second_check.getData()) {
						break;
					}
					else if(first_check.getData()<second_check.getData()) {
						LList tmp = first_number;
						first_number = second_number;
						second_number = tmp;
						break;
					}
					else {
						first_check.next();
						second_check.next();
						continue;
					}
				}
				big_len = first_number.length;
				small_len = second_number.length;
			}
			else {
				LList tmp = first_number;
				first_number = second_number;
				second_number = tmp;
				big_len = first_number.length;
				small_len = second_number.length;
			}
			// ===================== 입력 ====================
			
			LIter first_iter = first_number.getIter();
			LIter second_iter = second_number.getIter();
			LList real = new LList();
			int i;
			for(i=0;i<small_len;i++) {
				result.insert(first_iter.getData() - second_iter.getData());
				first_iter.next();
				second_iter.next();
			}
			for(;i<big_len;i++) {
				result.insert(first_iter.getData());
				first_iter.next();
			}
			// ===================== 연산 ====================
			
			LIter result_iter = result.getIter();
			for(i=0;i<big_len-1;i++) {
				if(result_iter.getData()<0) {
					result_iter.cur.next.data--;
					result_iter.cur.data += 10;
				}
				result_iter.next();
			}
			// ===================== 음수 내림 ====================
			
			LIter get_iter = result.getIter();
			for(i=0;i<big_len;i++) {
				real.insertFront(get_iter.getData());
				get_iter.next();
			}
			// ===================== 출력 리스트 만들기 ====================
			
			LIter set_iter = real.getIter();
			boolean flag = real.checker();
			if(flag) {
				i=0;
				while(set_iter.getData()==0) {
					i++;
					set_iter.next();
				}
				for(;i<big_len;i++) {
					char res = Character.forDigit(set_iter.getData(), 10);
					wr.write(res);
					set_iter.next();
				}
			}
			else {
				wr.write("0");
				System.out.print(0);
			}
			rd.close();
			wr.close();
			// ===================== write ====================
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
