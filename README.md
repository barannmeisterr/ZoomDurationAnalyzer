# ZoomDurationAnalyzer
 Java program that reads, processes, and displays attendance records by using linear probing hash table in a Zoom meeting report provided as a txt file so that the total duration of all participants can be tracked.

Sample txt file:
İnput 1 :
Join Time,Leave Time,Duration(Minutes),Name,Email
02/28/2020 10:54:38,02/28/2020 12:56:38,122.0,Feyza Nur Duman,fnur.duman@tedu.edu.tr
02/28/2020 10:57:09,02/28/2020 10:58:28,2.0,Eda Nur YILMAZ,enur.yilmaz@tedu.edu.tr
02/28/2020 10:59:19,02/28/2020 12:56:28,118.0,Serhat Gokhan YAMAC,sgokhan.yamac@tedu.edu.tr
02/28/2020 10:59:27,02/28/2020 12:56:11,117.0,Duru Yamac,
02/28/2020 10:59:28,02/28/2020 12:56:38,118.0,Asya Hale Gencel,ahale.gencel@tedu.edu.tr
02/28/2020 10:59:30,02/28/2020 12:33:32,95.0,Eda Nur YILMAZ,enur.yilmaz@tedu.edu.tr
02/28/2020 11:00:12,02/28/2020 11:00:24,1.0,Taner Ceyhun,taner.ceyhun@tedu.edu.tr
02/28/2020 11:00:33,02/28/2020 12:21:07,81.0,Sevil TERZI,sevil.terzi@tedu.edu.tr
02/28/2020 11:00:30,02/28/2020 12:56:26,116.0,Taner Ceyhun,taner.ceyhun@tedu.edu.tr
02/28/2020 10:58:44,02/28/2020 12:56:29,118.0,Ilhan Tekin,
02/28/2020 10:56:49,02/28/2020 12:56:38,120.0,Aytekin Safak,
02/28/2020 12:27:50,02/28/2020 12:55:37,28.0,Sevil Terzi,
02/28/2020 12:58:30,02/28/2020 12:59:30,1.0,Sevil TERZI,sevil.terzi@tedu.edu.tr,

Sample Output:
Duru Yamac 117.0
Sevil TERZI 110.0
Ilhan Tekin 118.0
Eda Nur YILMAZ 97.0
Feyza Nur Duman 122.0
Aytekin Safak 120.0
Asya Hale Gencel 118.0
Serhat Gokhan YAMAC 118.0
Taner Ceyhun 117.0

All txt files are in resources folder.
The first line of the input file is a header line which includes title of each column of the data file:
 Join Time: Date and time when participants join the meeting
 Leave Time: Date and time when participants leave the meeting
 Duration: Duration (in terms of minutes) passed between join and leave time
 Name: Name & surname
 Email: Email address
Each of the remaining lines includes a record for a connection of an attendee to the meeting where attendees are uniquely recognized by their name & surname. Name of an attendee might include more than one word but surname is always a single word at the end of name & surname. 

Name & surname refer to the same attendee if they are the same without considering uppercase/lowercase distinction of the letters. For example:
Eda Nur Yilmaz and EDA NUR YILMAZ refer to the same attendee.
Eda Nur Yilmaz and Eda Nur YILMAZ refer to the same attendee.
Of course, order and number of the words in name & surname matters. For example:
Eda Nur Yilmaz and Nur Eda Yilmaz refer to different attendees.
EDA NUR YILMAZ and EDA YILMAZ refer to different attendees.
Assume that there is a single space character between words in name & surname column of input file. For example:
EDA NUR YILMAZ and EDANUR YILMAZ refer to different attendees.
Of course, if there is a difference between surnames or names, they refer to different attendees. For example:
EDANUR YILMAZ and EDA YILMAZ refer to different attendees.
EDA YILMAZ and EDA YILMAZCAN refer to different attendees.
Notice that it is possible that e-mail address is not provided in some records.
Also, notice that there might be more than one record for some of attendees as they leave and join the meeting multiple times. Assume that there is no time overlap between multiple connections made by each attendee. That means each attendee has at most one connection at each moment of the meeting.

What the program is expected to do:
Your program is supposed to do the following tasks:
 Read input file so that, for each connection, store name & surname of the corresponding attendee along with duration of the connection.
 If there are multiple connections made by the same attendee:

Update duration value of key(name surname of participant) by adding durations of the duration value of the key .
