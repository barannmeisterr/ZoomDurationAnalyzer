//-----------------------------------------------------
	// Title: ZoomDurationMain class
	// Author: Arda Baran
	// Description: In this class , desired txt files can be opened by entering its name, the records datas from txt files
	// can be inserted to Participants class and Attendee hash table.
	//-----------------------------------------------------








import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ZoomDurationMain {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	String fileName ;
    	String choice;
    	System.out.print("Enter the input file name:");
    	//the name of the txt file you want to open
    	fileName = sc.nextLine();
    	System.out.print("Do You Want To See Original txt file?(yes/no)(Yes/No):");
    	choice=sc.nextLine();
    	sc.close();
    	System.out.println();
    	
    	
    	// File path        
    	String filePath = "src/resources/"+fileName;
    	Attendee <String,Double> attendee = new Attendee<>(47);   
    	Participants p ;
    	try {
            // read datas from file
            Scanner scanner = new Scanner(new File(filePath));

            // Skip the header line "Join Time,Leave Time,Duration(Minutes),Name,Email"
            if (scanner.hasNext()) {
                scanner.nextLine();
            }

            // read all lines in the file and process
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] record = line.split(",");//split and process datas based on ',' character in the text.
              
                if (record.length >= 4) {
                    String joinTime = record[0].trim();
                    String leaveTime = record[1].trim();
                    double duration = Double.parseDouble(record[2].trim());
                    String nameSurname = record[3].trim();
                   //some records may have not e mail adress so if there is no email in line then email is null
                    String email = (record.length >= 5) ? record[4].trim() : null;
                    //add the components to the Participant
                    p = new Participants(joinTime,leaveTime,duration,nameSurname,email);
                 if(choice.equalsIgnoreCase("yes")||choice.equalsIgnoreCase("Yes")) {
                	 p.printParticipants();
                 }
                  
               //insert datas to the hash table.
                  attendee.putRecord(p.getNameSurname(), p.getDuration());
                  
                }
            }
            if(choice.equalsIgnoreCase("no")||choice.equalsIgnoreCase("No")) {
            attendee.printAttendee();
            }
//close file Scanner 
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
	


	





