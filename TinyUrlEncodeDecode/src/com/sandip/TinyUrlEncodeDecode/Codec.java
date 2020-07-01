/*
 Here issue is in case of collision what you do ? Included educative.io design pdf file, where it suggest to
 add a seq number and user number until you make URL encoded value unique (hash).

 geekforgeek did it simply using DB entry unique ID for encoding: https://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
  Problem is how to get this, without record insert.

  So may be educative.io looks good ?
 */


package com.sandip.TinyUrlEncodeDecode;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Codec {
	private String getHashOf(String stringToEncrypt) {
		MessageDigest messageDigest;
		String encryptedString = null;
		try {
			String newDigest = "";
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset();
			messageDigest.update(stringToEncrypt.getBytes("UTF-8"));
			// Sandip:
			encryptedString = new String(messageDigest.digest());
			// System.out.printf("stringToEncrypt:%s msgDigestLen:%d, digest:%s\n", stringToEncrypt, messageDigest.getDigestLength(), encryptedString);
			for(int i = 0; i < encryptedString.length(); i++) {
				char ch = encryptedString.charAt(i);
				if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
					newDigest = newDigest + ch;
				}
			}
			encryptedString = newDigest;
			// System.out.printf("  alpha msgDigestLen:%d, digest:%s\n", encryptedString.length(), encryptedString);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String("http://tinyurl.com/" + encryptedString);
	}

	private class UrlList {
		UrlList next;
		String tinyUrl;
		String url;
		UrlList(String url, String tinyUrl) {
			this.url = url;
			this.tinyUrl = tinyUrl;
		}
	}
	private Map<String, UrlList> url2TinyUrlDb = new HashMap<String, UrlList>();
	private Map<String, String> tinyUrl2UrlDb = new HashMap<String, String>();

	/* private String findTinyUrl(String url, String hash) {
		UrlList tinyUrlList = url2TinyUrlDb.get(hash);
		UrlList urlEntry = tinyUrlList;
		while (urlEntry != null) {
			if (urlEntry.url == url) {
				return urlEntry.tinyUrl;
			}
			urlEntry = urlEntry.next;
		}
		return null;
	} */

    // Encodes a URL to a shortened URL.
	public String encode(String url) {
		String hash = getHashOf(url);
		//Sandip:
		// System.out.printf("Hash:%s\n", hash);
		String tinyUrl = null;
		/* Add new entry */
		UrlList urlEntry = url2TinyUrlDb.get(hash);
		if (urlEntry == null) {
			tinyUrl = hash;
			urlEntry = new UrlList(url, tinyUrl);
			url2TinyUrlDb.put(hash, urlEntry);
			tinyUrl2UrlDb.put(tinyUrl, url);
		} else {
			UrlList currEntry = urlEntry;
			UrlList lastEntry = urlEntry;
			int i = 0;
			boolean found = false;
			while (currEntry != null) {
				if (currEntry.url == url) {
					found = true;
					tinyUrl = currEntry.tinyUrl;
					break;
				}
				lastEntry = currEntry;
				currEntry = currEntry.next;
				i++;
			}
			if (!found) {
				/* Add at the end */
				tinyUrl = hash + String.valueOf(i);
				UrlList newUrlEntry = new UrlList(url, tinyUrl);
				newUrlEntry.next = null;
				lastEntry.next = newUrlEntry;
				tinyUrl2UrlDb.put(tinyUrl, url);
			}
		}
		return tinyUrl;
	}

    // Decodes a shortened URL to its original URL.
    public String decode(String tinyUrl) {
       return tinyUrl2UrlDb.get(tinyUrl);
    }
}
