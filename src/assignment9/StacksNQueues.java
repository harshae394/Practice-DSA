package assignment9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StacksNQueues {

    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	changeDirectories();
    }

    public static String firstNonCharInStream(String str) {
	if (str == null)
	    return str;
	int p1 = 0;
	int p2 = 0;
	int n = str.length();
	// abadbc
	int arr[] = new int[26];
	Stack<String> stck = new Stack<String>();
	for (int i = n - 1; i >= 0; i--) {
	    stck.push(str);
	}
	String str2 = "";
	for (int i = 0; i < n; i++) {
	    str2 = str.charAt(i) + str2;
	    for (int j = 0; j < str2.length(); i++) {

	    }
	}

	return null;
    }

    public static void changeDirectories() throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int tests = Integer.parseInt(br.readLine());
	for (int it = 0; it < tests; it++) {
	    int queries = Integer.parseInt(br.readLine());
	    Deque<String> deque = new ArrayDeque<String>();
	    for (int q = 0; q < queries; q++) {
		String str = br.readLine();
		if (str.equalsIgnoreCase("pwd")) {
		    Deque<String> dequePrint = new ArrayDeque<String>(deque);
		    bw.write("/");
		    while (!dequePrint.isEmpty()) {
			bw.write(dequePrint.removeFirst() + "/");
		    }
		    bw.write("\n");
		} else {
		    String val[] = str.split("\\/");
		    for (int i = 0; i < val.length; i++) {
			if (val[i].equals("cd ")) {
			    while (!deque.isEmpty())
				deque.removeLast();
			} else if ((val[i].equals("..") || val[i].equals("cd ..")) && !deque.isEmpty()) {
			    deque.removeLast();
			} else {
			    String add = val[i];
			    if (add.contains("cd ")) {
				add = add.replace("cd ", "");
			    }
			    deque.addLast(add);
			}
		    }
		}
	    }
	    bw.write("\n");
	    bw.flush();
	}
    }
}
