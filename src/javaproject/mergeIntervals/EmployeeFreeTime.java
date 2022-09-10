package javaproject.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}

};

public class EmployeeFreeTime {

	public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> list = new ArrayList<>();
		for (List<Interval> inp : schedule) {
			for (Interval intv : inp) {
				list.add(intv);
			}
		}
		System.out.println("list: "+list);
		Collections.sort(list, (a, b) -> a.start - b.start);
		List<Interval> ans = new ArrayList<>();
		int start = list.get(0).start;
		int end = list.get(0).end;
		// [[1,3], [5,6], [2,3], [6,8]]
		int n = list.size();
		for (int i = 1; i < n; i++) {
			if (end > list.get(i).start) {
				end = Math.max(end, list.get(i).end);
			} else {
				if (list.get(i).start - end > 0)
					ans.add(new Interval(end, list.get(i).start));
				start = list.get(i).start;
				end = list.get(i).end;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		List<List<Interval>> input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
		List<Interval> freeTime = findEmployeeFreeTime(input);
		System.out.println("freeTime : " + freeTime);
	}

}
