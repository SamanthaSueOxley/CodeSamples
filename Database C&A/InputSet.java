import java.io.*;
/**
*	InputSet
*  InputSet encapulsates the methods needed to convert the input text file
*     to the output import file.
*     Console object is imported and available in reformatLine for debugging use<BR>
*  throws: IO_Exception<BR>
*/
public class InputSet {
	private String	thisSet;		// the name of the input file
	private char theDelim;		// holds delimiter
	private int	inputCount;		// control counters
	private int	importCount;
	private int	blankCount;
	private String	inputStrIn;		// input/output string buffers
	private String	importStrOut;

	/** MUTATOR store name of the input file */
	public void putThisSet(String ts) {
		thisSet = ts;
	}
   /** ACCESSOR return the name of the input file */
	public String getThisSet() {
      return thisSet;
	}
   /** MUTATOR store the desired field delimiter */
	public void putDelim(char ts) {
      theDelim = ts;
	}
	/** ACCESSOR return the set field delimiter */
	public char getDelim() {
      return theDelim;
	}
	/** ACCESSOR return the total number of records read from input file */
	public int getInputReadIn() {
      return inputCount;
	}
	/** ACCESSOR return the number of records written to the output file */
	public int getImportWritten() {
      return importCount;
	}
	/** ACCESSOR return the number of blank lines processed */
	public int getInputBlank() {
      return blankCount;
	}
/**
	get 1st/next non-empty line from input file 
   parameters: Object of class FileIn 
	returns: true if EOF; false if not @ EOF 
*/
	public boolean getNextLine( FileIn fi ) throws IOException {
		boolean want;	//record keep/skip switch
      do {
			inputStrIn = fi.readline();		//read next line
			if ( inputStrIn == null) break;	//exit if EOF
			inputCount++;						//count records read
			//count & skip blank/empty lines
			want = true;
			if (inputStrIn.length() == 0 || inputStrIn.trim().equals("")) {
				blankCount++;
				want = false;
			}
		}while(!want);	//only return non-blank lines
		return(inputStrIn == null);
	}
/** write the re-formatted record to the (output) IMPORT file<BR>
      parameters: fo - filename of file to be written (the database import file)<BR>
	   returns: Object of FileOut, Input String<BR>
*/
	public void writeToImport( FileOut fo ) throws IOException {

		fo.write( importStrOut + "\r" + "\n" );
		importCount++;								       //count output records written
	}

/**   Reformat - convert input line to import output format 
*     
*     FINISH THIS ALGORITHM 
*
*/
	public void reformatLine() throws ArrayIndexOutOfBoundsException, IOException {
      final int RESPONSES  = 22;	//max # user responses on questionaire
      char buffer[] = new char[RESPONSES*2];
		String		employeeID;
		String		quarter;
		String		initials;
		String		response;
      employeeID = inputStrIn.substring(0, 1);
      quarter = inputStrIn.substring(7, 10);
      initials = inputStrIn.substring(20, 23);
      response = inputStrIn.substring(23, 24);
      importStrOut = employeeID + ":19" + quarter + ":" + initials + ":" + response + ":";
      for(int i=0; i < (inputStrIn.length()-25); i++){
         if(inputStrIn.charAt(24+i) == ' '){
            importStrOut += ":";
         }else{
            buffer[i] = inputStrIn.charAt(24+i);
            importStrOut += buffer[i] + ":"; 
         }    
      }
   } //end reformatLine
}

