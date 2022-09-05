package com.util;


import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;


public class GetBase64 {
	
	public static Blob StringToBlob(String s) {
		System.out.println(s);
		String[] split = s.split(",");
		
		return getBlob(split[1]);
	}
	
	public static Blob getBlob(String s) {
		 Blob blobData =null;
		try {
			blobData = new SerialBlob(s.getBytes());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blobData;
	}
}
