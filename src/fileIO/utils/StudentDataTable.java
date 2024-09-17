package fileIO.utils;

import fileIO.model.Student;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.*;

public class StudentDataTable {
    public static void studentDataTable(List<Student> studentList
            , Integer actualRecordNumberInOnce, int navigateStart ,int pageNumber,String...message){
        if(actualRecordNumberInOnce==null || actualRecordNumberInOnce==0|| actualRecordNumberInOnce<0 || actualRecordNumberInOnce>studentList.size() ){
            actualRecordNumberInOnce = Math.min(studentList.size(), 3);
        }
//        System.out.println(".".repeat(40));
        if(studentList.equals(new ArrayList<Student>())){
            System.out.println("\uD83D\uDC8E".repeat(60));
            if(message.length==0){
                System.out.println("\uD83D\uDE45\u200D♂\uFE0F \t\t\t\t\t\t\t\t\t\t> No Data <".toUpperCase(Locale.ROOT));
            }else {
                System.out.println(STR."[!] \{message[0]}".toUpperCase(Locale.CANADA));
            }
            System.out.println("\uD83D\uDC8E".repeat(60));
            SoundUtils.windowsRingSound();

        }else {
            System.out.println("\uD83D\uDCCA Students' Data".toUpperCase(Locale.ROOT));
//
            Table table = new Table(6, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
            String reset = "\u001B[0m";
            String cyanBold = "\u001B[1;36m";

            table.addCell(cyanBold + "ID",new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(cyanBold + "STUDENT'S NAME", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(cyanBold + "STUDENT'S DATE OF BIRTH ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(cyanBold + "STUDENT CLASSROOM", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(cyanBold + "STUDENTS SUBJECT", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(cyanBold + "CREATE AT / UPDATE AT", new CellStyle(CellStyle.HorizontalAlign.CENTER));

            table.setColumnWidth(0,25,40);
            table.setColumnWidth(1,25,40);
            table.setColumnWidth(2,25,40);
            table.setColumnWidth(3,25,40);
            table.setColumnWidth(4,25,40);
            table.setColumnWidth(5,25,40);
//
            for(int i=0;i<5;i++){
                table.setColumnWidth(i,30,50);
            }
//        data
            int i=0;
            if(navigateStart>=studentList.size()){
                navigateStart = studentList.size()-4;
            }
//            if(navigateStart+actualRecordNumberInOnce>studentList.size()){
//                navigateStart = actualRecordNumberInOnce;
//            }
            for(int n=navigateStart;n<studentList.size();n++){
//                table.addCell(studentList.get(n).getId(),new CellStyle(CellStyle.HorizontalAlign.CENTER),1);
//                table.addCell(studentList.get(n).getStudentName(),new CellStyle(CellStyle.HorizontalAlign.CENTER),1);
//                table.addCell(studentList.get(n).getStudentDateOfBirth(),new CellStyle(CellStyle.HorizontalAlign.CENTER),1);
//                table.addCell(Arrays.toString(studentList.get(n).getStudentClasses()),new CellStyle(CellStyle.HorizontalAlign.CENTER),1);
//                table.addCell(Arrays.toString(studentList.get(n).getStudentSubjects()),new CellStyle(CellStyle.HorizontalAlign.CENTER),1);
//                table.addCell(studentList.get(n).getCreatedAt(),new CellStyle(CellStyle.HorizontalAlign.CENTER),1);

                String yellowColor = "\u001B[33m"; //code for colunm
                String resetColor = "\u001B[0m"; // Reset color
                table.addCell(yellowColor+studentList.get(n).getId()+resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+studentList.get(n).getStudentName()+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+studentList.get(n).getStudentDateOfBirth().toString()+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+Arrays.toString(studentList.get(n).getStudentClasses())+resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+Arrays.toString(studentList.get(n).getStudentSubjects())+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+studentList.get(n).getCreatedAt()+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                if(studentList.size()>actualRecordNumberInOnce){
                    i++;
                    if(i==actualRecordNumberInOnce){
                        break;
                    }
                }
            }
            System.out.println(table.render());
//            pagination
            System.out.println("-".repeat(146));
            System.out.print(STR."\uD83D\uDCC4 Page Number: \{pageNumber}\t [*] Actual record: \{actualRecordNumberInOnce}\t[*] All Record: \{studentList.size()}\t\t\t\t\t\t\t\t\t\t [+] Previous (P/p) - [+] Next (n/N) - [+] Back (B/b)\n");
            System.out.println("➖".repeat(80));
        }
    }
    public static void tableFromSearchedResult(List<Student> studentList, String...message){
        System.out.println("\uD83D\uDC8E".repeat(40));
        if(studentList.equals(new ArrayList<Student>())){
            if(message.length==0){
                System.out.println("[!] \t\t\t\t\t\t\t\t\t\t> No Data <".toUpperCase(Locale.ROOT));
                SoundUtils.windowsRingSound();
            }else {
                System.out.println(STR."\uD83D\uDCE9\{message[0]}".toUpperCase(Locale.CANADA));
            }
        }else {
            System.out.println("\uD83C\uDF10 Student's Info.".toUpperCase(Locale.ROOT));
//
//            Table table = new Table(2, BorderStyle.CLASSIC_COMPATIBLE, ShownBorders.ALL);
            Table table = new Table(6, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
//            table.addCell("STUDENT'S INFORMATION", new CellStyle(CellStyle.HorizontalAlign.CENTER));
//            table.addCell("DATA", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            String reset = "\u001B[0m";
            String cyanBold = "\u001B[1;36m";
            String yellowColor = "\u001B[33m"; //code for colunm
            String resetColor = "\u001B[0m"; // Reset color
//            table.addCell(yellowColor+studentList+resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
//            table.addCell(yellowColor+studentList+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
//            table.addCell(yellowColor+studentList+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
//            table.addCell(yellowColor+studentList+resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
//            table.addCell(yellowColor+studentList+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
//            table.addCell(yellowColor+studentList+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));

//
            for (int i = 0; i < 2; i++) {
                table.setColumnWidth(i, 30, 50);
            }
//        data
            for (Student student : studentList) {
//                Table table = new Table(6, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);

                table.addCell(cyanBold + "ID",new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(cyanBold + "STUDENT'S NAME", new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(cyanBold + "STUDENT'S DATE OF BIRTH ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(cyanBold + "STUDENT CLASSROOM", new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(cyanBold + "STUDENTS SUBJECT", new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(cyanBold + "CREATE AT / UPDATE AT", new CellStyle(CellStyle.HorizontalAlign.CENTER));

                table.setColumnWidth(0,25,40);
                table.setColumnWidth(1,25,40);
                table.setColumnWidth(2,25,40);
                table.setColumnWidth(3,25,40);
                table.setColumnWidth(4,25,40);
                table.setColumnWidth(5,25,40);

                table.addCell(yellowColor+student.getId()+resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+student.getStudentName()+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+student.getStudentDateOfBirth()+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+ Arrays.toString(student.getStudentClasses()) +resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+ Arrays.toString(student.getStudentSubjects()) + resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(yellowColor+student.getCreatedAt()+ resetColor, new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());
        }
    }
}
