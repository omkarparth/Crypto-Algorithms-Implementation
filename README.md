# Java-Crypto-Program
Developed a Java crypto program to encrypt/decrypt (using AES-128, AES-256, RSA-1024, RSA-4096), sign (using SHA-256 and RSA-4096) and HMAC (using MD5, SHA1, SHA-256) a file using the javax.crypto libraries. 
Refer https://github.com/omkarparth/Crypto-Algorithms-Implementation/blob/master/CNS_assignment_2_Report.pdf to view a test report specifying the testbed details and comparing the performance of the above specified crypto algorithms.

Readme

To execute the above crypto java program follow the instructions below:
1. Clone the above repository using command: "git clone https://github.com/omkarparth/Crypto-Algorithms-Implementation.git"
2. Change directory and goto the cloned directory: "cd Crypto-Algorithms-Implementation/"
3. Execute the test program jar file using the command: "java -jar ./cryptotest.jar [file_name]"

The jar file basically tests the performance of the above mentioned crypto algorithms by executing each algorithm numerous times as specified below and calculates the mean and median for each algorithm.
1. Encryption/Decryption using AES 128 and AES 256 is performed 100 times.
2. Encryption/Decryption using RSA 1024 and RSA 4096 is performed 2 times.
3. HMAC using MD5, SHA 1 and SHA 256 is performed 100 times.
4. Digital signature and verfication using SHA 256 and RSA 4096 is performed 100 times.

If you wish to change the number of iterations of any of the above mentioned algorithms then you may do so by changing the source code in the desired algorithm .java file. 
On doing it, to recompile and create a new test jar file you can use the following steps:
1. make
2. jar cvfm [new_jar_file_name].jar ./manifest.txt ./*.class
On creating new jar file you can use the above mentioned steps to execute the jar file.
