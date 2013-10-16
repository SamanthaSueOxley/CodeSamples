import java.net.*;
import java.io.*;

public class CaesarServer implements CaesarConstants{
	private static int shift;
	String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String []args){
		if(args.length == 1){
			try{
				if((Integer.parseInt(args[0]) > 0) && (Integer.parseInt(args[0]) < 26)){
					shift = Integer.parseInt(args[0]);
				}else{
					System.out.println("Argument shift value must be between 1-25, shift has been set to default value of (3).");
					shift = DEFAULT_SHIFT;
				}
			}catch(NumberFormatException fe){
				System.out.println("Argument may only be numbers 1-25, shift set to 3");
				shift = DEFAULT_SHIFT;
			}
		}else{
			shift = DEFAULT_SHIFT;
		}
		new CaesarServer();
	}
	public CaesarServer(){
		try{
			ServerSocket ss = new ServerSocket(PORT_NUMBER);
			while(true){
				Socket cs = ss.accept();
				ThreadServer ts = new ThreadServer(cs);
				ts.start();
			}
		}catch(BindException be){
			System.out.println(be.toString());
		}catch(IOException ioe){
			System.out.println(ioe.toString());
		}
	}
	class ThreadServer extends Thread{
		Socket cs;
		BufferedReader br;
		PrintWriter pw;
		public ThreadServer(Socket cs){
			this.cs = cs;
			try{
				br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
			}catch(IOException ioe){
				System.out.println(ioe.toString());
			}
		}
		public void run(){
			try{
				while(br.ready()){
					String firstMessage = br.readLine();
					if(firstMessage.equals("ENCRYPT")){
						pw.println("OK");
						pw.flush();
						
						String message = br.readLine();
						message = message.toLowerCase();
						String cipher = "";
						for(int i=0; i<message.length(); i++){
							int charPosition = ALPHABET.indexOf(message.charAt(i));
							int changeValue = (shift+charPosition)%26;
							char replaceChar = ALPHABET.charAt(changeValue);
							cipher += replaceChar;
						}
						pw.println(cipher);
						pw.flush();
					}else if(firstMessage.equals("DECRYPT")){
						pw.println("OK");
						pw.flush();
							String message = br.readLine();
							message = message.toLowerCase();
							String cipher = "";
							for(int i=0; i<message.length(); i++){
								int charPosition = ALPHABET.indexOf(message.charAt(i));
								int changeValue = (charPosition-shift)%26;
								if(changeValue<0){
									changeValue = ALPHABET.length() + changeValue;
								}
								char replaceChar = ALPHABET.charAt(changeValue);
								cipher += replaceChar;
							}
							pw.println(cipher);
							pw.flush();
					}else {
						pw.println("");
						pw.flush();	
					}//end ifs
					pw.flush();
					
				}//end while
			}catch(NumberFormatException fe){
				System.out.println(fe.toString());
			}catch(NullPointerException npe){
				System.out.println(npe.toString() + "whaaattt");
			}catch(IOException e){
				System.out.println(e.toString());
			}
		}
	}
	
}