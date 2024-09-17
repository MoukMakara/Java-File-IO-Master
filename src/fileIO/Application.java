package fileIO;

import fileIO.view.StudentDashboard;


public class Application {
//
    public static void main(String[] args) {
        String reset = "\u001B[0m";  // Reset color
        String cyanBold = "\u001B[1;36m"; // Cyan color and bold

        System.out.println(cyanBold +"");
        System.out.println(cyanBold +" ".repeat(43) +" ██████╗███████╗████████╗ █████╗ ██████╗     ███████╗███╗   ███╗███████╗");
        System.out.println(cyanBold +" ".repeat(43) +"██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗    ██╔════╝████╗ ████║██╔════╝");
        System.out.println(cyanBold +" ".repeat(43) +"██║     ███████╗   ██║   ███████║██║  ██║    ███████╗██╔████╔██║███████╗");
        System.out.println(cyanBold +" ".repeat(43) +"██║     ╚════██║   ██║   ██╔══██║██║  ██║    ╚════██║██║╚██╔╝██║╚════██");
        System.out.println(cyanBold +" ".repeat(43) +"╚██████╗███████║   ██║   ██║  ██║██████╔╝    ███████║██║ ╚═╝ ██║███████║");
        System.out.println(cyanBold +" ".repeat(43) +" ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝     ╚══════╝╚═╝     ╚═╝╚══════╝"+ reset);
        System.out.println(cyanBold +" ".repeat(53) +"មជ្ឈមណ្ឌលអភិវឌ្ឍន៍វិទ្យាសាស្រ្ត និង បច្ចេកទេសវិទ្យាកម្រិតខ្ពស់");
        System.out.println(cyanBold +" ".repeat(50) +"Center Of Science and Technology Advanced Development-CSTAD"+reset);
//        System.out.println(cyanBold +" ".repeat(53)+"Advanced"+" ".repeat(2)+ " Development-CDTSD"+ reset);
        StudentDashboard.view();
    }
}