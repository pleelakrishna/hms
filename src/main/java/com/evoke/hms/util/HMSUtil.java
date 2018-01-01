package com.evoke.hms.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class HMSUtil {
	private Random rnd = new Random();
	
	public String GenerateEHRID( ) 
	{
		String hmsId = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder( 13 );
		sb.append("HMS_");
		for( int i = 0; i < 9; i++ ) 
			sb.append( hmsId.charAt( rnd.nextInt(hmsId.length()) ) );
		return sb.toString();
	}

}
