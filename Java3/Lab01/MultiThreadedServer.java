/*
Samantha Oxley

Lab04- Multi-Threaded Server
The threaded server for connection
*/
import java.net.*;
import java.io.*;
import java.util.*;

public class MultiThreadedServer{
	//attributes
	private ArrayList<PrintWriter> pwList = new ArrayList<PrintWriter>();
	private ArrayList<String> nameList = new ArrayList<String>();
		public static void main(String []args){ //-- MAIN
			new MultiThreadedServer(); } //-- END MAIN
	//constructor
	public MultiThreadedServer(){
		ServerSocket ss = null;
		try{
			System.out.println("getLocalHost: " + InetAddress.getLocalHost());
			System.out.println("getByName: " + InetAddress.getByName("localhost"));
			//port 1337
			ss = new ServerSocket(1337);
			Socket cs = null;
			while(true){ //run forever
				cs = ss.accept();
				ThreadServer ths = new ThreadServer(cs);
				ths.start();
			}
		}catch(BindException be){
			System.out.println("Server is already running. \nServer is stopping.");
		}catch(IOException ioe){
			System.out.println("IO Exception Error..");
		}
	}
//----BEGIN THREAD SERVER -----
	class ThreadServer extends Thread{
		Socket cs;
		//constructor
		public ThreadServer(Socket cs){
			this.cs = cs; }
		//run method
		public void run(){
			BufferedReader br;
			PrintWriter opw = null;
			String clientName = "";
			String clientMsg;
			try{
				br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
				opw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
				
				clientName = br.readLine();
				if(! (nameList.contains(clientName)) ){
					opw.println("Client " + clientName + " accepted.");
					opw.flush();
					
					pwList.add(opw);
					nameList.add(clientName);
						for(PrintWriter onePw: pwList){
							System.out.println("PrintWriter Object " + onePw);
							onePw.println(clientName + " joined!");
							onePw.flush();
						}
				}
				else{ //name not in array.. deny message and interrupt thread
					opw.println("Deny");
					opw.flush();
					interrupt();
					return;
				}
				while(true){
					clientMsg = br.readLine();
					System.out.println("Server Read " + clientMsg);
					if(clientMsg == null || clientMsg.equals(clientName + "Disconnect")){
						System.out.println("Null as: " + opw);
						System.out.println("pwList size before: " + pwList.size() );
						int count = 0;
						for(Iterator<PrintWriter> it = pwList.iterator(); it.hasNext();){
							if(it.next().equals(opw)){
								System.out.println("Removing object " + opw);
								it.remove();
								nameList.remove(count);
							}
							count++;
						}
						for(PrintWriter onePw: pwList){
							System.out.println("PW Object: " + onePw);
							onePw.println(clientName + " Left");
							onePw.flush();
						}
						System.out.println("pwList size after = " + pwList.size());
						break;
					}//--END of if
					else{
						for(PrintWriter onePw: pwList){
							System.out.println("PW Object: " + onePw);
							onePw.println(clientMsg);
							onePw.flush();
						}
					}//--END if/else
				}//--END while
			}catch(SocketException se){ //if wrong user, remove and alert client of leaving 
				int count = 0;
				for(Iterator<PrintWriter> it = pwList.iterator(); it.hasNext();){
					if(it.next().equals(opw)){
						System.out.println("Removing object " + opw);
						it.remove();
						nameList.remove(count);
					}
					count++;
				}//--END for
				for(PrintWriter onePw: pwList){
					System.out.println("PW Object" + onePw);
					onePw.println(clientName + " has left the chat");
					onePw.flush();
				}
			}catch(IOException ioe){
				System.out.println("IO Exception caught: " + ioe);
			}
		
		
		}//--END run
	}//--END THREAD SERVER CLASS
}