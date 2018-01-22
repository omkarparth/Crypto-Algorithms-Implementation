import java.io.File;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.KeyGenerator;

class Key //Key class for public and private key
{
    PublicKey pk;
    PrivateKey pr;
}

public class Dsign {
	 void sign(String value) throws Exception {
		 Integer i,j,m;
		// Read the entire content into string and sign using the string
		 String content = new Scanner(new File(value)).useDelimiter("\\Z").next();
		
		 // double arrays for storing signing time and verifying time
		 try {
			 double seconds=0.0,secondv=0.0;
			 double[] secs=new double[100];
			 double[] secv=new double[100];
			 double mean1=0.0,mean=0.0;
			 System.out.println("Generated the required Sign key");
	   		 System.out.println("Public and Private keyparir is ready");
	   		 System.out.println("---------------------------------------");
			 for(j=0;j<100;j++)
				{ // creating a random value using SecureRandom
			 SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
	        	 //byte[] values = new byte[256];
	        	//random.nextBytes(values);
			 // Keypair is generated i.e public and private key using KeypairGenerator
	        	KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
	   		 kpg.initialize(4096,random); //RSA-4096 bits
	   		 KeyPair kp = kpg.genKeyPair();
	   		 Key k = new Key();
	   		 k.pk = kp.getPublic();
	   		 k.pr = kp.getPrivate();
	   		//calculating time for signing
	   		 //starts here
	   		 long startTime = System.nanoTime();
             // SHA256 is used here for signing along with RSA4096
		    Signature privateSignature = Signature.getInstance("SHA256withRSA");
		    privateSignature.initSign(k.pr);
		    
		    
		    privateSignature.update(content.getBytes()); //signature done
		    byte[] signature = privateSignature.sign();
		    long diff = System.nanoTime() - startTime; // signing process ends here
		     
		      seconds = (double)diff/ 1000000000.0;
		      secs[j]=seconds;
		      
		      
		      
		      
		      System.out.println("["+j+"] Signing time"+seconds);
		      
		     //verifying time for the signature 
		      
		      long startTime1 = System.nanoTime();
		   Signature signature1 = Signature.getInstance("SHA256withRSA");
	        signature1.initVerify(k.pk);
	        signature1.update(content.getBytes()); 
	        
	      
	        boolean result = signature1.verify(signature); // verifying ends here
	        long diff1 = System.nanoTime() - startTime1;
	        secondv = (double)diff1/ 1000000000.0;
	        secv[j]=secondv;
		    
		      System.out.println("["+j +"] verifying time"+secondv);

	   
	        System.out.println("result = "+result);
		 }
			
			 double s2 = 0.0;
			 for(i=0;i<100;i++)
			 {
				 s2 += secs[i];
			 }
			
			 double s1 = 0.0;
			
			 for(i=0;i<100;i++)
			 {
				 s1 += secv[i];
			
			 }
			
		mean=s2/100.0; // calculating mean for signing
		
		
		System.out.println("Mean signing time" +mean );
		Arrays.sort(secs); //sorting the signing time array
		double ans=secs[49]; //median for signing
		System.out.println("Median for signing " );
		System.out.print(ans);
		 
		
		mean1=s1/100; // calculating mean for verifying
		System.out.println("Mean verifying time" +mean1 );
		Arrays.sort(secv); // sorting the verifying time array
		double ans1=secv[49]; // median for verifying
		System.out.println("Median for verifying " +ans1);
		 }
	 
	 catch(Exception e) {
	 }
	 }
	 }

		   

		    

		    

		    
		 
		
	 


