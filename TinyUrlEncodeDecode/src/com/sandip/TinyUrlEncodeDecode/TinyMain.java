package com.sandip.TinyUrlEncodeDecode;

public class TinyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://leetcode.com/problems/encode-and-decode-tinyurl/#/description";
		Codec codec = new Codec();
		// System.out.printf("URL %s ->%s\n", url, codec.encode(url));
		// url = "https://leetcode.com/problem/encode-and-decode-tinyurl/#/description";
		// System.out.printf("URL %s ->%s\n", url, codec.encode(url));
		System.out.printf("URL:%s retrival of URL:%s\n", url, codec.decode(codec.encode(url)));
	}

}
