
public class HTable {
	public HEntry[] table;
	public HTable() {
		table = new HEntry[262139];
	}
	public boolean insert(int i, String s) {
		int index = i % 262139;
		if(table[index] == null) { // empty
			table[index] = new HEntry();
			table[index].i = i;
			table[index].s = s;
			table[index].deleted = false;
			return true;
		}
		else if (table[index].deleted) { // preoccupied but deleted
			table[index].i = i;
			table[index].s = s;
			table[index].deleted = false;
			return true;
		}
		else { // preoccupied
			while(table[index] != null && table[index].deleted != true) { // index which is empty for the first time
				index = (index + 1) % 262139; // index++
				if(index == i % 262139) { // 한바퀴 돌아서 더이상 삽입할 수 없는 경우
					return false;
				}
			}
			// empty index 찾은 경우
			if(table[index] == null) {
				table[index] = new HEntry();
			}
			table[index].i = i;
			table[index].s = s;
			table[index].deleted = false;
			return true;
		}
	}

	
	public boolean delete(int i) {
		int index = i % 262139;
		if(table[index] == null) { // no data
			return false;
		}
		else {
			while(true) {
				if(table[index] == null) { // no data
					return false;
				}
				else if(table[index].i == i && table[index].deleted == true) {
					index = (index + 1) % 262139;
					if(index == i % 262139) {
						return false;
					}
				}
				else if(table[index].i == i && table[index].deleted == false) {
					table[index].deleted = true;
					return true;
				}
				else {
					index = (index + 1) % 262139;
					if(index == i % 262139) {
						return false;
					}
				}
			}
		}
	}
	
	public String query(int i) {
		String ans;
		int index = i % 262139;
		if(table[index] == null) { // no data
			return null;
		}
		else {
			while(true) {
				if(table[index] == null) { // no data
					return null;
				}
				else if(table[index].i == i && table[index].deleted == true) {
					index = (index + 1) % 262139;
					if(index == i % 262139) {
						return null;
					}
				}
				else if(table[index].i == i && table[index].deleted == false) {
					ans = table[index].s;
					return ans;
				}
				else {
					index = (index + 1) % 262139;
					if(index == i % 262139) {
						return null;
					}
				}
			}
		}
	}
}
