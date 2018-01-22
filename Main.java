
public class Main 
{
	public static void main(String[] args) throws Exception
	{
		String path = args[0]; //get the input file
		Cryptohash c = new Cryptohash(); 
		c.hash(path); //perform MD5, SHA1 and SHA256 hashes
		c = null;
		AES128_CTR a = new AES128_CTR();
		a.aes(path); //perform AES 128 encryption and decryption
		a = null;
		Dsign d = new Dsign();
		d.sign(path);//perform digital signature using SHA256 and RSA4096
		d = null;
		AES256_CTR b = new AES256_CTR();
		b.aes(path);//perform AES 256 encryption and decryption
		b = null;
		RSA_1024 r = new RSA_1024();
		r.rsa(path);//perform RSA 1024 encryption and decryption
		r = null;
		RSA_4096 e = new RSA_4096();
		e.rsa(path);//perform RSA 4096 encryption and decryption
		e = null;
	}
}
