package jdbc;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrEx {

	public static void main(String[] args) {
		String[] strArr = {"홍", "신", "감"};
		Stream<String> strStr = Arrays.stream(strArr);
		strStr.forEach(n->System.out.println(n)); // strStr 자체가 스트림이라서 바로 forEach씀
		// stream으로 바꾸면 배열도 스트림으로 쓸 수 있다.
	}

}
