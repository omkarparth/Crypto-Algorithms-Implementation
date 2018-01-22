import javax.crypto.KeyGenerator;

import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class Cryptohash {
		
		void hash(String value) throws Exception {
			Integer i,m;
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			// Generating random number using Secure Random
	//		byte[] values = new byte[32]; //32*8=256 bytes
	  //     random.nextBytes(values);
	        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	        keyGen.init(256,random);  //Generating key for MD5 hash
	        SecretKey secretKey = keyGen.generateKey(); // 256 bit key for MD5
	        //generating random and next key for SHA1 hash
	        SecureRandom random1 = SecureRandom.getInstance("SHA1PRNG");
			//byte[] values1 = new byte[32]; //32*8=256 bytes
	       // random.nextBytes(values1); 
	        KeyGenerator keyGen1 = KeyGenerator.getInstance("AES");	     
	        keyGen1.init(256,random1); 
	        SecretKey secretKey2 = keyGen.generateKey(); //256 bit key for SHA1
	        // generating random number and key for SHA256 key
	        SecureRandom random2 = SecureRandom.getInstance("SHA1PRNG"); //// 256 bit key for SHA256
			//byte[] values2 = new byte[32]; //32*8=256 bytes
	        //random2.nextBytes(values2);
	        KeyGenerator keyGen2 = KeyGenerator.getInstance("AES");
	     
	        keyGen.init(256,random2); 
	        SecretKey secretKey3 = keyGen2.generateKey();
	      // Reading the input.txt file and converting it into string
	        String content = new Scanner(new File(value)).useDelimiter("\\Z").next();
		    // double arrays for storing time for computing various hashes.
	        double[] secmd=new double[100];
		    double sum=0.0,mean=0.0;
		    double[] secsha1=new double[100];
		    double[] secsha256=new double[100];
		     System.out.println("MD5 hundred times");
		    
			for(i=0;i<100;i++)  
			{		
				System.out.print("["+i+"] MD5 ");
				secmd[i]=(hmac(content, secretKey, "HmacMD5"));
				System.out.println();
				 
				sum+=secmd[i];
		    
			}
			Arrays.sort(secmd); //sorting the array of MD5 computing time hash
			m=secmd.length/2; // calculating the position for median
			double x=(secmd[48]+secmd[49])/2;
		        System.out.println("\n Median for MD5 " +x);
			 
			
			mean=sum/100;
			System.out.println("\n Mean of MD5 "+mean);
			sum=0.0;
			
			System.out.println("SHA 1 hundred times");
			//computing hash using SHA1
			for(i=0;i<100;i++)
			{System.out.print("["+i+"] SHA1 ");
				secsha1[i]=(hmac(content, secretKey2, "HmacSHA1")); //call hmac function to compute the hash
			  System.out.println();
			sum+=secsha1[i];
			}
			
			
			mean=sum/100;
			System.out.println("Mean of SHA1 "+mean);
			Arrays.sort(secsha1);//sorting the array of SHA1 computing time hash
			m=secsha1.length/2; //calculating median position
			double y=(secsha1[48]+secsha1[49])/2;
		        System.out.println("Median for SHA1 " +y);
			 			sum=0.0;
			
			System.out.println("SHA256 hundred times");
			//computing hash using SHA256
			for(i=0;i<100;i++)
			{ 	System.out.print("["+i+"] SHA256 ");
			 secsha256[i]=(hmac(content, secretKey3, "HmacSHA256"));
		
			System.out.println();
			sum+=secsha256[i];
			}
			mean=sum/100;
			
			System.out.println("Mean of SHA256 "+mean);
			Arrays.sort(secsha256); //sorting the array of SHA256 computing time hash
			
			m=secsha256.length/2; //computing median position
			double z=(secsha256[48]+secsha256[49])/2;
		        System.out.println("Median for SHA256 " +z);
			 
			
		     }
		
		

		  public static double hmac(String msg, SecretKey secret, String algo) {
		    String hashvalue= null;
             double Seconds=0.0;
		    try {
		    	  long startTime = System.nanoTime();
		    	
		    	
		    	// the computation of hash starts here 

		  
		      Mac mac = Mac.getInstance(algo);
		      mac.init(secret);

		      byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

		      StringBuffer hash = new StringBuffer();
		      for (int i = 0; i < bytes.length; i++) {
		        String hex = Integer.toHexString(0xFF & bytes[i]); //converting the bytes message into hexadecimal
		        if (hex.length() == 1) {
		          hash.append('0');
		        }
		        hash.append(hex);
		      }
		      hashvalue = hash.toString(); //hash value is converted to string 
		      //hash computation ends here
		    
		      long diff = System.nanoTime() - startTime;
		     
		      Seconds = (double)diff/ 1000000000.0;
		     
		      System.out.print(" Elapsed time: " +Seconds);	    
		      //System.out.println( hashvalue);
	            
		    } catch (Exception e) {
		    }
		    
			return Seconds;
		   
	       
			
	    	
	    	
		  }

		// TODO Auto-generated method stub

	}


