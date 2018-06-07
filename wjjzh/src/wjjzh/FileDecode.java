package wjjzh;
import java.io.FileInputStream;
import java.io.IOException;
public class FileDecode {
	static String fileName ="C:\\Users\\lenovo\\Desktop\\source\\H575A1164-171104075438_Binary";
	
	public static byte[] changeBytes(byte[] a){
		byte[] b = new byte[a.length];
		for (int i=0;i<b.length;i++){
			b[i]=a[b.length-i-1];
		}
		return b;
	}	
	public static void main(String[] args) {
		FileInputStream  in;
		try {
			in = new FileInputStream(fileName);
			byte[] bytes = new byte[4]; 
		    byte[] bs = new byte[4]; 
		    StringBuilder str=new StringBuilder();
		   
			in.read(bytes);		
			//反转高低字节
			bs =changeBytes(bytes);
			
			for (int i=0;i<bytes.length;i++){
				if ((bs[i] & 0xff) < 0x10)//0~F前面不零
				str.append("0");
				str.append(Integer.toHexString(bs[i]&0xff));
				
			}
			
			int sequence_in_MSC =Integer.parseInt(str.toString(), 16);
			System.out.println(sequence_in_MSC);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}




