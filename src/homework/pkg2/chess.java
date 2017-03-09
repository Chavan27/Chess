package homework.pkg2;

import java.util.Scanner;

public class chess {

  public static void main(String[] args) {
     boolean color=true;
             int n;
  
    //Defining the outline of the chessboard.
    String[][] chessboard= {
        {"BlackRook","BlackKnight","BlackBishop","BlackQueen","BlackKing","BlackBishop","BlackKnight","BlackRook"},
            {"BlackPawn","BlackPawn","BlackPawn","BlackPawn","BlackPawn","BlackPawn","BlackPawn","BlackPawn"},
            {"---","---","---","---","---","---","---","---"},
            {"---","---","---","---","---","---","---","---"},
            {"---","---","---","---","---","---","---","---"},
            {"---","---","---","---","---","---","---","---"},
            {"WhitePawn","WhitePawn","WhitePawn","WhitePawn","WhitePawn","WhitePawn","WhitePawn","WhitePawn"},
            {"WhiteRook","WhiteKnight","WhiteBishop","WhiteQueen","WhiteKing","WhiteBishop","WhiteKnight","WhiteRook"}
            
    };
    
    System.out.print("Choose a color (press 1 for White and 2 for Black) : "); //Prompting the user to choose a color.
      Scanner input = new Scanner(System.in);
    n = input.nextInt();
  
    do {
    if (n==1) {
        color = true;
       
    } else if(n==2) {
                color = false ;
   
                }
    else {
        System.out.println("Please enter either 1 for White or 2 for black");
    }
    }while(n!=1 && n!=2);
    
    String str;
    if(color==true) {
        str="White";
    } else{
                str = "Black";
          }
    
    
    System.out.println("The color that you chose is "+str); //Printing the color chosen.
    
    System.out.println("Starting State of the Chess chessboard is : "); //Displaying the starting state of the chessboard.
    print(chessboard);
    input(chessboard,color);
    
 }
  
  //Printing chessboard.
  private static void print(String[][] chessboard) { 
        for(int i=0;i<=7;i++){
            System.out.print("\n");
            for(int j=0;j<=7;j++){
                System.out.printf("%12s ",chessboard[i][j]);
              
            }
    }
        System.out.println("\n");
 }

    //Taking input from the user.
    private static void input(String[][]chessboard,boolean color) {
        Scanner input = new Scanner(System.in);
        int r,c;
        int des1,des2;
        System.out.println("Enter the row number of piece : ");
        r = input.nextInt();
        System.out.println("Enter the column number of piece : ");
        c = input.nextInt();
        if(r>7 || r<0 || c>7 || c<0){
            System.out.println("Please enter row and column number between 0 and 7");
            input(chessboard,color);
        }
         color(r,c,chessboard,color);
        System.out.println("Enter the row number of destination : ");
        des1 = input.nextInt();
        System.out.println("Enter the column number of destination : ");
        des2 = input.nextInt();
        if(des1>7 || des1<0 || des2>7 || des2<0){
            System.out.println("Please enter row and column number between 0 and 7");
            input(chessboard,color);
        }
       
        block(des1,des2,chessboard,color);
        checkpiece(r,c,des1,des2,chessboard,color);
   }

   
   
    
    //Checking which piece did the user enter.
    private static void checkpiece(int r, int c, int des1, int des2, String[][] chessboard, boolean color) {
        if (chessboard[r][c].equals("WhiteKing")||chessboard[r][c].equals("BlackKing"))
{
moveKing(r,c,des1,des2,chessboard,color);
}
        if (chessboard[r][c].equals("WhiteQueen")||chessboard[r][c].equals("BlackQueen")){
moveQueen(r,c,des1,des2,chessboard,color);
        }
        if (chessboard[r][c].equals("WhiteRook")||chessboard[r][c].equals("BlackRook")){
moveRook(r,c,des1,des2,chessboard,color);
        }
        if (chessboard[r][c].equals("WhiteBishop")||chessboard[r][c].equals("BlackBishop")){
moveBishop(r,c,des1,des2,chessboard,color);
        }
        if (chessboard[r][c].equals("WhiteKnight")||chessboard[r][c].equals("BlackKnight")){
moveKnight(r,c,des1,des2,chessboard,color);
        }
        if (chessboard[r][c].equals("WhitePawn")||chessboard[r][c].equals("BlackPawn")){
movePawn(r,c,des1,des2,chessboard,color);
        }
        

        
        
    }

    
    //Checking if the king can move.
    private static void moveKing(int r, int c, int des1, int des2, String[][] chessboard,boolean color) {
        if (des1==r+1 || des1==r-1 || des2==c+1 || des2==c-1){
            performmove(r,c,des1,des2,chessboard,color);
        }
        else{
            System.out.println("King cannot make this move");
            next(chessboard,color);
        }
       
    
        }
    
    //Checking if the queen can move.
    private static void moveQueen(int r, int c, int des1, int des2, String[][] chessboard, boolean color) {
              for(int i=0;i<=7;i++) {
       if (des1==r+i && des2==c+i){
            performmove(r,c,des1,des2,chessboard,color);
       }
       else if(des1==r-i && des2==c-i){
           performmove(r,c,des1,des2,chessboard,color);
       }
           else if (des1==r+i && des2==c-i){
               performmove(r,c,des1,des2,chessboard,color);
           }
           else if (des1==r-i && des2==c+i){
               performmove(r,c,des1,des2,chessboard,color);
    }
        }
                if (des1 == r) {
            for(int i=0;i<=7;i++){
                if(des2==i){
                    performmove(r,c,des1,des2,chessboard,color);
                }
            }
        }else if (des2==c) {
                        for(int i=0;i<=7;i++){
                            if(des1==i){
                    performmove(r,c,des1,des2,chessboard,color);
                }
                    }
        } else{
            System.out.println("Queen cannot make this move");
            next(chessboard,color);
        }           
    
    }
    
    //Checking if the rook can move.
    private static void moveRook(int r, int c, int des1, int des2, String[][] chessboard,boolean color) {
        if (des1 == r) {
            for(int i=0;i<=7;i++){
                if(des2==i){
                    performmove(r,c,des1,des2,chessboard,color);
                }
            }
        }else if (des2==c) {
                        for(int i=0;i<=7;i++){
                            if(des1==i){
                    performmove(r,c,des1,des2,chessboard,color);
                }
                    }
        }
        else{
            System.out.println("Rook cannot make this move");
            next(chessboard,color);
        }
                    
                
               }
    
    //Checking if bishop can move.
    private static void moveBishop(int r, int c, int des1, int des2, String[][] chessboard,boolean color) {
        for(int i=0;i<=7;i++) {
       if (des1==r+i && des2==c+i){
           performmove(r,c,des1,des2,chessboard,color);
       }
       else if(des1==r-i && des2==c-i){
           performmove(r,c,des1,des2,chessboard,color);
       }
           else if (des1==r+i && des2==c-i){
               performmove(r,c,des1,des2,chessboard,color);
           }
           else if (des1==r-i && des2==c+i){
               performmove(r,c,des1,des2,chessboard,color);
               
    }
        }
    }  
        
        
        
           
        
    //Checking if the knight can move.
    private static void moveKnight(int r, int c, int des1, int des2, String[][] chessboard,boolean color) {
        if (des1==r+2 && des2==c+1){
            performmove(r,c,des1,des2,chessboard,color);
        }
            else if (des1==r+2 && des2==c-1){
                    performmove(r,c,des1,des2,chessboard,color);
            }

            else if(des1==r-2 && des2==c+1){
                performmove(r,c,des1,des2,chessboard,color);
            }
            else if(des1==r-2 && des2==c-1){
                performmove(r,c,des1,des2,chessboard,color);
            }
            else if(des1==r+1 && des2==c+2){
                performmove(r,c,des1,des2,chessboard,color);
            }
            else if(des1==r-1 && des2==c+2){
                performmove(r,c,des1,des2,chessboard,color);
            }
            else if(des1==r+1 && des2==c-2){
                performmove(r,c,des1,des2,chessboard,color);
            }
            else if(des1==r-1 && des2==c-2){
                performmove(r,c,des1,des2,chessboard,color);
            }
            else{
            System.out.println("Knight cannot make this move");
            next(chessboard,color);
        }
    }
    //Checking if the pawn can move.
    private static void movePawn(int r, int c, int des1, int des2, String[][] chessboard,boolean color) {
        if (des1==r+1 && des2==c ){
            performmove(r,c,des1,des2,chessboard,color);
        } else if(des1==r-1 && des2==c){
                    performmove(r,c,des1,des2,chessboard,color);
                    }
          else{
            System.out.println("Pawn cannot make this move");
            next(chessboard,color);
        }
        
    }
    
    //Performs the move.
    private static void performmove(int r,int c,int des1,int des2,String[][] chessboard,boolean color){
       
        chessboard[des1][des2]=chessboard[r][c];
        chessboard[r][c]="---";
     print(chessboard);  
     next(chessboard,color);
    }

    //Asks the user if he wishes to make another move.
    private static void next(String[][] chessboard,boolean color) {
        int n;
        Scanner input= new Scanner(System.in);
       System.out.println("Do you want to make another move ? (press 1 for yes and 2 for no)");
       n=input.nextInt();
       if (n==1){
           if(color==true){
               System.out.println("Your color now is Black");
               color=false;
           }
               else{
                       System.out.println("Your color now is White");
                       color=true;
                       }
           
           
           input(chessboard,color);
       }
       
       else if (n==2){
           System.out.println("Thank You !");
    }
       else {
           System.out.println("Please enter 1 or 2");
       }
    }

    


 //Checks if there is already a piece on the destination.
 private static void block(int des1, int des2,String[][] chessboard, boolean color) {
        if (chessboard[des1][des2]!= "---"){
            System.out.println("A piece is blocking it");
            input(chessboard,color);
        }
    }
  
  //Checks the color.
  private static void color(int r, int c,String[][]chessboard,boolean color) {
    if(color==true){
        if (chessboard[r][c].equals("WhiteRook")||chessboard[r][c].equals("WhiteKnight")||chessboard[r][c].equals("WhiteBishop")||
                chessboard[r][c].equals("WhiteQueen")||chessboard[r][c].equals("WhiteKing")||chessboard[r][c].equals("WhitePawn")) {
            System.out.println("You have selected a White piece");
        }
    else {
            System.out.println("You have not selected a White piece");
            input(chessboard,color);
                    }
                    }
    else 
    if(chessboard[r][c].equals("BlackRook")||chessboard[r][c].equals("BlackKnight")||chessboard[r][c].equals("BlackBishop")||
                chessboard[r][c].equals("BlackQueen")||chessboard[r][c].equals("BlackKing")||chessboard[r][c].equals("BlackPawn")) {
                    System.out.println("You have selected a Black piece");
                    }
            else {
            System.out.println("You have not selected a Black piece");
            input(chessboard,color);
                    }   
            
            
        }

}
