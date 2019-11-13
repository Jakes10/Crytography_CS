import java.util.Scanner; 

class CaesarCipher
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1) Encrypt \n2) Decrypt");
		String option= sc.nextLine();
		
		if(option=="1") {
			Encrypt();
		}else {
			Decrypt();
		}
	}
	
	public static void Encrypt() {
		Scanner sc=new Scanner(System.in);
		int i,n;
		String str;
		String str1="";
		String str2="";
		System.out.println("Enter the plaintext");
		str=sc.nextLine();
		str=str.toLowerCase();
		n=str.length();
		char ch1[]=str.toCharArray();
		char ch3,ch4;

		int shift=3;

		// System.out.println("Enter the value by which each letter of the string is to be shifted");
		// shift=sc.nextInt();

		System.out.println();
		System.out.println("Encrypted text is");
		for(i=0;i<n;i++)
		{
			if(Character.isLetter(ch1[i]))
			{
				ch3=(char)(((int)ch1[i]+shift-97)%26+97);
				//System.out.println(ch1[i]+" = "+ch3);
				str1=str1+ch3;
			} 
			else if(ch1[i]==' ')
			{
				str1=str1+ch1[i];
			} 
		}
		System.out.println(str1);

		System.out.println();
		System.out.println("Decrypted text is");

		char ch2[]=str1.toCharArray();
		for(i=0;i<str1.length();i++)
		{
			if(Character.isLetter(ch2[i]))
			{
				if(((int)ch2[i]-shift)<97)
				{
					ch4=(char)(((int)ch2[i]-shift-97+26)%26+97);

				}
				else
				{
					ch4=(char)(((int)ch2[i]-shift-97)%26+97);
				}
				str2=str2+ch4;
			} 

			else if(ch2[i]==' ')
			{
				str2=str2+ch2[i];
			} 
		}
		System.out.println(str2);
	}
	
	public static void Decrypt() {
		String message, encryptedMessage = "";
		int key;
		char ch;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a message: ");
		message = sc.nextLine();
		
		System.out.println("Enter key: ");
		key = sc.nextInt();
 
		for(int i = 0; i < message.length(); ++i){
			ch = message.charAt(i);
			
			if(ch >= 'a' && ch <= 'z'){
	            ch = (char)(ch + key);
	            
	            if(ch > 'z'){
	                ch = (char)(ch - 'z' + 'a' - 1);
	            }
	            
	            encryptedMessage += ch;
	        }
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch + key);
	            
	            if(ch > 'Z'){
	                ch = (char)(ch - 'Z' + 'A' - 1);
	            }
	            
	            encryptedMessage += ch;
	        }
	        else {
	        	encryptedMessage += ch;
	        }
		}
		
		System.out.println("Encrypted Message = " + encryptedMessage);
	}
}