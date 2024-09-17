package fileIO.view;

import fileIO.controller.StudentController;

import fileIO.model.Student;

import fileIO.utils.DataAction;
import fileIO.utils.SoundUtils;
import fileIO.utils.StudentDataTable;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import javax.xml.transform.sax.SAXSource;
import java.time.LocalDate;
import java.util.*;

public class StudentDashboard {
    private final static StudentController studentController = new StudentController();
    private static String insertStudentDateOfBirth(){
        String year = null;
        String month = null;
        String day = null;
        boolean isInserted = true;
        while (isInserted){
            System.out.print("> Year (number): ");
            year = new Scanner(System.in).nextLine();
            System.out.print("> Month (number): ");
            month = new Scanner(System.in).nextLine();
            System.out.print("> Day (number): ");
            day = new Scanner(System.in).nextLine();
            isInserted = false;
        }
        return LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day)).toString();
    }
    private static Student viewForUpdateStudentInfo(Student student){
//
        String data;
//
        System.out.println("=".repeat(62));
        System.out.println("[+] Update Student's Information: ".toUpperCase(Locale.ROOT));
        System.out.println("--------------------------------------------");
        System.out.println("1. Update Student's Name".toUpperCase());
        System.out.println("2. Update Student's Date of birth".toUpperCase());
        System.out.println("3. Update Student's Class".toUpperCase());
        System.out.println("4. Update Student's Subject".toUpperCase());
        System.out.println(".".repeat(20));
        System.out.print("> Insert option: ");
        SoundUtils.alertSound();
        String opt = new Scanner(System.in).next();
        switch (Integer.parseInt(opt)){
            case 1->{
                System.out.print("[+] Insert NEw student's name: ");
                data = new Scanner(System.in).nextLine();
                student.setStudentName(data);
            }
            case 2->{
                System.out.println("[+] Insert NEw student's date of birth: ");
                student.setStudentDateOfBirth(insertStudentDateOfBirth());
            }
            case 3->{
                System.out.println("[!] You can insert multi classes by splitting [,] symbol (c1,c2).".toUpperCase(Locale.ROOT));
                System.out.print("[+] Insert NEw student's class: ");
                String classStudied = new Scanner(System.in).nextLine();
                String [] classes = classStudied.split(",");
                for(int i=0;i<classes.length;i++){
                    classes[i] = classes[i].trim();
                }
                student.setStudentClasses(classes);
            }
            case 4->{
                System.out.println("[!] You can insert multi subjects by splitting [,] symbol (s1,s2).".toUpperCase(Locale.ROOT));
                System.out.print("[+] Insert NEw student's Subject studied: ");
                String studentSubject = new Scanner(System.in).nextLine();
                // remove space from insert for any subject
                String[] subjects = studentSubject.split(",");
                for(int i=0;i<subjects.length;i++){
                    subjects[i] = subjects[i].trim();
                }
                student.setStudentSubjects(subjects);
            }
            default -> System.out.println("[!] Invalid Option. :(");
        }
        return student;
    }
    private static Student insertNewStudentsInfo(){
        System.out.println("\uD83D\uDCBB Insert student's info".toUpperCase(Locale.ROOT));
        System.out.print("➕ Insert student's name: ");
        String name = new Scanner(System.in).nextLine();
//
        System.out.println("➕ Student date of birth ".toUpperCase(Locale.ROOT));
        String dateOfBirth = insertStudentDateOfBirth();
//
        System.out.println("➗ You can insert multi classes by splitting [,] symbol (c1,c2).".toUpperCase(Locale.ROOT));
        System.out.print("➕ Student's class: ");
        String studentClass = new Scanner(System.in).nextLine();
        String[] classes  = studentClass.split(",");
//
        for(int i=0;i<classes.length;i++){
            classes[i] = classes[i].trim();
        }
        System.out.println("➗ You can insert multi subjects by splitting [,] symbol (s1,s2).".toUpperCase(Locale.ROOT));
        System.out.print("➕ Subject studied: ");
        String studentSubject = new Scanner(System.in).nextLine();
        // remove space from insert for any subject
        String[] subjects = studentSubject.split(",");
        for(int i=0;i<subjects.length;i++){
            subjects[i] = subjects[i].trim();
        }
        return new Student(STR."\{new Random().nextInt(10000)}CSTAD",name, dateOfBirth,classes,subjects,LocalDate.now().toString());
    }
    private static void options(){
        // Add new Code Today
        String reset = "\u001B[0m";
        String cyanBold = "\u001B[1;36m";
        String redColor = "\u001B[31m"; // Red color
        String resetColor = "\u001B[0m"; // Reset color
        //The End Code For Today
        //Menu
        System.out.println("\uD83D\uDFF0".repeat(156));
        Table table = new Table(3, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
        table.addCell(cyanBold + "1. ADD NEW STUDENT "+reset, new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell(cyanBold + "2. LIST ALL STUDENTS"+reset, new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell(cyanBold + "3. COMMIT DATA TO FILE"+reset, new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell(cyanBold + "4. SEARCH FOR STUDENT"+reset, new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell(cyanBold + "5. UPDATE STUDENT'S INFO BY ID"+reset, new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell(cyanBold + "6. DELETE STUDENT'S DATA"+reset, new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell(cyanBold + "7. GENERATE DATA TO FILE"+reset, new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell(cyanBold + "8. DELETE/CLEAR ALL DATA FROM DATA STORE"+reset, new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell(cyanBold + "0,99. EXIT"+reset,new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.setColumnWidth(0,51,70);
        table.setColumnWidth(1,51,70);
        table.setColumnWidth(2,51,70);

        System.out.println(table.render());
        System.out.println(" \t".repeat(30) + redColor +"©\uFE0FCopyright-CSTAD-2024" + resetColor);
        System.out.println("\uD83D\uDFF0".repeat(156));
    }
//    clear data from file
    private static void clearDataFromFile(){
    DataAction.addDataToTransaction(null,"transaction-addNew.dat");
    DataAction.addDataToTransaction(null,"transaction-update.dat");
    DataAction.addDataToTransaction(null,"transaction-delete.dat");
}
//
    private static void checkInTransaction(){
        if(studentController.checkDataIsAvailableInTransaction()){
            boolean isCommitted = true;
            SoundUtils.alertSound();
            while (isCommitted){
                System.out.print(STR."> Commit your \{DataAction.numberOfDataHasBeenStoredInTransactionFile} data record before hand [Y/N]: ");
                String opt = new Scanner(System.in).nextLine();
                if(opt.equalsIgnoreCase("Y")){
                    studentController.commitDataFromTransaction();
                    isCommitted = false;
                    clearDataFromFile();
                }else if(opt.equalsIgnoreCase("n")){
                    isCommitted = false;
                    clearDataFromFile();
                }else {
                    SoundUtils.windowsRingSound();
                }
            }
        }
    }
//    pagination
    private static void pagination(List<Student> studentList){
        int numberOfRecordForEachPage = 4;
        if(studentList.size()<=numberOfRecordForEachPage){
            System.out.println("[!] LAST PAGE <<");
        }
        StudentDataTable.studentDataTable(studentList,4,0,1, "No such a student found");
        try{
            int start = 0;
            if(!studentList.isEmpty()){
                int page=1; // page number
                while (true) {
                    System.out.print("[+] Insert to Navigate [p/N]: ");
                    String op = new Scanner(System.in).nextLine();
                    if(op.isEmpty()){
                        SoundUtils.windowsRingSound();
                    }
                    if(op.equalsIgnoreCase("b") || op.equalsIgnoreCase("back")){
                        break;
                    }else if(op.isEmpty()){
                        SoundUtils.windowsRingSound();
                        continue;
                    }
                    if(op.equalsIgnoreCase("n") || op.equalsIgnoreCase("next")){
                        start+=4;
                        if(start<studentList.size()){
                            start = start;
                        }
                        else if(start+numberOfRecordForEachPage>studentList.size()){
                            start-=4;
                            System.out.println("[!] LAST PAGE <<");
                            SoundUtils.windowsRingSound();
                        }else {
                            start = studentList.size()-1;
                        }
                        StudentDataTable.studentDataTable(studentList,numberOfRecordForEachPage, start,page, "No such a student found");
                        page++;
                    }else if ((op.equalsIgnoreCase("p")) || op.equalsIgnoreCase("previous") ){
                        if(start!=0){
                            start-=4;
                        }
                        if(page>1){
                            page--;
                        }
                        StudentDataTable.studentDataTable(studentList,numberOfRecordForEachPage, start,page,"No such a student found");
                    }
                }
            }
        }catch (VirtualMachineError | Exception problem){
            SoundUtils.windowsRingSound();
            System.out.println("[!] Problem during listing data.".toUpperCase(Locale.ROOT));
        }
    }

    public static void view(){
        checkInTransaction();
        while (true){
            options();
            System.out.print("➕ Insert option: ");
            String opt = new Scanner(System.in).nextLine();
            System.out.println(".".repeat(30));
            switch ((opt.trim())){
//                System.out.println(".".repeat(30));
                case "0", "99"->{
                    checkInTransaction();
                    System.out.println("\uD83D\uDD12 System closed !!! :)".toUpperCase(Locale.ROOT));
                    System.exit(0);
                }
                case "1"-> studentController.addNewStudent((insertNewStudentsInfo()));
                case "2"->{
                    List<Student> studentList = studentController.listAllStudents();
                    pagination(studentList);
                }
                case "3"-> {
                    studentController.commitDataFromTransaction();
                    clearDataFromFile();
                    SoundUtils.alertSound();
                }
                case "4"->{
                    boolean isFour = true;
                    while (isFour){
                        System.out.println("\uD83D\uDD0E Searching student".toUpperCase(Locale.CANADA));
                        System.out.println("\uD83D\uDC8E".repeat(20));
                        System.out.println("1\uFE0F⃣. Search by Name".toUpperCase());
                        System.out.println("2\uFE0F⃣. Search by ID".toUpperCase());
                        System.out.println("\uD83D\uDD19 (back/b) to Back".toUpperCase());
                        System.out.println("\uD83D\uDFE2".repeat(20));
                        System.out.print("➕ Insert option: ");
                        String o = new Scanner(System.in).nextLine();
                        o = o.toLowerCase(Locale.CANADA);
                        System.out.println("\uD83D\uDC8E\uD83D\uDC8E\uD83D\uDC8E");
                        switch (o){
                            case "1"->{
                                System.out.println("\uD83D\uDD0E Search student by Name".toUpperCase(Locale.ROOT));
                                System.out.print("➕ Insert student's NAME: ");
                                String name = new Scanner(System.in).nextLine();
                                pagination(studentController.searchStudentByName(name));
                            }
                            case "2"->{
                                System.out.println("\uD83D\uDD0E Search student by ID".toUpperCase(Locale.ROOT));
                                System.out.print("➕ Insert student's ID: ");
                                String id = new Scanner(System.in).nextLine();
                                try{
                                    StudentDataTable.tableFromSearchedResult(new ArrayList<>(
                                            List.of(studentController.searchStudentById(id.trim()))
                                    ));
                                    SoundUtils.alertSound();
                                    System.out.print("➡\uFE0F Press Enter to continue...".toLowerCase(Locale.ROOT));
                                    new Scanner(System.in).nextLine();
                                }catch (NoSuchElementException exception){
                                    StudentDataTable.studentDataTable(new ArrayList<>(),null,0,1, "No such a student found".toUpperCase(Locale.CANADA));
                                    SoundUtils.windowsRingSound();
                                }
                            }
                            case "b","back"->{
                                isFour = false;
                            }
                            default -> {
                                System.out.println("\uD83D\uDE45\u200D♂\uFE0F No Option :(.".toUpperCase(Locale.ROOT));
                                System.out.println("\uD83D\uDC8E".repeat(20));
                                SoundUtils.windowsRingSound();
                            }
                        }
                    }

                }
                case "5"->{
                    System.out.println("\uD83C\uDD95 Update student by ID".toUpperCase(Locale.ROOT));
                    System.out.print("➕ Insert student's ID: ");
                    String id = new Scanner(System.in).nextLine();
                    try{
//                        System.out.println("[*] Student's Info.".toUpperCase(Locale.ROOT));
                        Student student  = studentController.searchStudentById(id.trim());
                        if(student!=null){
                            StudentDataTable.tableFromSearchedResult(new ArrayList<>(
                                    List.of(studentController.searchStudentById(id.trim())
                                    )));
                            StudentDataTable.tableFromSearchedResult(new ArrayList<>(
                                    List.of(studentController.updateStudentById(id.trim(),viewForUpdateStudentInfo(student)))
                            ));
                        }
                        System.out.print("✅ Updated successfully \uD83C\uDF89\uD83E\uDD73, press to continue...".toUpperCase(Locale.ROOT));
                        SoundUtils.alertSound();
                        new Scanner(System.in).nextLine();
                    }catch (NoSuchElementException exception){
                        StudentDataTable.studentDataTable(new ArrayList<>(),null,1,0,STR." No such a student you found with ID \"\{id}\"".toUpperCase(Locale.CANADA));
                    }
                }
                case "6"->{
                    System.out.println("\uD83D\uDDD1\uFE0F Delete student by ID".toUpperCase(Locale.ROOT));
                    System.out.print("➕ Insert student's ID: ");
                    String id = new Scanner(System.in).nextLine();
                    try{
                        StudentDataTable.tableFromSearchedResult(new ArrayList<>(
                                List.of(studentController.searchStudentById(id.trim()))
                        ));
                        id = id.trim();
                        studentController.deleteStudentById(id);
                    }catch (NoSuchElementException exception){
                        SoundUtils.windowsRingSound();
                        StudentDataTable.studentDataTable(new ArrayList<>(),null,1,0 ,STR." No such a student you found with ID \"\{id}\"".toUpperCase(Locale.CANADA));
                    }
                }
                case "7"-> studentController.generateObjects();
//                case "8"->{
//                    System.out.println("[+] BackUp date process".toUpperCase(Locale.ROOT));
//                    System.out.println("......");
//                    System.out.print("[+] Insert file backup name: ");
//                    SoundUtils.alertSound();
//                    String fileName = new Scanner(System.in).nextLine();
//                    studentController.backUp(fileName);
//                }
//                case "9"->{
//                    if(!studentController.restoreFile().isEmpty()){
//                        System.out.println("[+] List of Restoring File".toUpperCase(Locale.ROOT));
//                        System.out.println("........");
//                        System.out.println(                        studentController.restoreFile().get(2));
//                    }else {
//                        System.out.println(">> No restoring file ".toUpperCase(Locale.ROOT));
//                        SoundUtils.windowsRingSound();
//                    }
//                }
                case "8"->{
                    SoundUtils.alertSound();
                    studentController.destroyData();
                }
                default -> {
                    SoundUtils.windowsRingSound();
                    System.out.println("\uD83D\uDE45\u200D♂\uFE0F No Option :(.".toUpperCase(Locale.ROOT));
                }
            }
        }
    }
}
