package pacmann;
import java.util.Scanner;
public class peciman {
    public static Scanner input = new Scanner (System.in);
    public static String[][] peci = new String[10][10];
    public static String move, nabrak="\033[31mSILAHKAN CARI JALAN LAIN!\033[0m";
    public static int sisamove=18, xPos=1, yPos=7, point=0, makanan=3;
    public static void Map(){
        for (int x = 0; x < peci.length; x++) {
            for (int y = 0; y < peci.length; y++) {
                peci[x][0]="#";
                peci[x][9]="#";
                peci[0][y]="#";
                peci[9][y]="#";                
            }
            for (int y = 5; y < peci.length ; y++) {
                peci [2][y]="#";
                peci [5][y]="#";
            }
        }
        peci[4][1]="#";
        peci[4][5]="#";
        peci[2][1]="#";
        peci[6][7]="#";
        peci[7][3]="#";
        peci[7][4]="#";
        peci[8][4]="#";
        peci[8][5]="#";
        peci[xPos][yPos]=">";
    }
    public static void Makanan() {
        peci[1][6]="♡";
        peci[4][7]="♡";
        peci[1][1]="♡";
    }
    public static void Move(String move) {
        if (move.equalsIgnoreCase("w")){
            if (peci[xPos-1][yPos]==" "){
                peci[xPos-1][yPos]="V";
                peci[xPos][yPos]=" ";
                xPos-=1;
                sisamove-=1;
            }    
            else if (peci[xPos-1][yPos]=="♡"){
                peci[xPos-1][yPos]="V";
                peci[xPos][yPos]=" ";
                xPos-=1;
                sisamove-=1;
                point+=1;
            }   
            else
                System.out.println(nabrak);
        }
        if (move.equalsIgnoreCase("a")){
            if (peci[xPos][yPos-1]==" "){
                peci[xPos][yPos-1]=">";
                peci[xPos][yPos]=" ";
                yPos-=1;
                sisamove-=1;
            }    
            else if (peci[xPos][yPos-1]=="♡"){
                peci[xPos][yPos-1]=">";
                peci[xPos][yPos]=" ";
                yPos-=1;
                sisamove-=1;
                point+=1;
            }   
            else
                System.out.println(nabrak);
        }
        if (move.equalsIgnoreCase("s")){
            if (peci[xPos+1][yPos]==" "){
                peci[xPos+1][yPos]="^";
                peci[xPos][yPos]=" ";
                xPos+=1;
                sisamove-=1;
            }
            else if (peci[xPos+1][yPos]=="♡"){
                peci[xPos+1][yPos]="^";
                peci[xPos][yPos]=" ";
                xPos+=1;
                sisamove-=1;
                point+=1;                   
            }
            else
                System.out.println(nabrak);
        }
        if (move.equalsIgnoreCase("d")){
            if (peci[xPos][yPos+1]==" "){
                peci[xPos][yPos+1]="<";
                peci[xPos][yPos]=" ";
                yPos+=1;
                sisamove-=1;
            }
            else if (peci[xPos][yPos+1]=="♡"){
                peci[xPos][yPos+1]="<";
                peci[xPos][yPos]=" ";
                yPos+=1;
                sisamove-=1;
                point+=1;                   
            }
            else
                System.out.println(nabrak);
        }
    }
    public static void Tampil(){
        for (int x = 0; x < peci.length; x++) {
            for (int y = 0; y < peci.length; y++) {
                if (peci[x][y]==null){
                    peci[x][y]=(" ");
                }
                System.out.print(peci[x][y]);
            }
            System.out.println("");
        }
        if (point==makanan){
            System.out.println("\033[32m(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧    ASYIK, KAMU MENANG!!\033[0m");
            System.exit(0);
        }
        System.out.println("Sisa Move   : "+sisamove);
        System.out.println("Point       : "+point);
        System.out.print("Jalan dengan menggunakan W A S D >> ");
        move = input.next();
        peciman.Move(move);
    }
    public static void main(String[] args) {
        peciman.Map();
        peciman.Makanan();
        while (sisamove != 0){
            peciman.Tampil();
        }
        if ((sisamove==0)&&(point!=makanan)){
            System.out.println("\033[31m(づ￣ ³￣)づ     YAH, KAMU KALAH\033[0m");
            System.exit(0);
        }
    }       
}
