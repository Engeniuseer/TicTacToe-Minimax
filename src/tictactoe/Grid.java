/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Engeniuseer
 */
public class Grid {
    public int[][] gameboard=new int[3][3];

    public Grid() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.gameboard[i][j]=0;
            }
        }
    }
    
    public int end_game(){
        for(int i=0; i<3; i++){
            if(this.gameboard[i][0]!=0&&this.gameboard[i][0]==this.gameboard[i][1]&&this.gameboard[i][0]==this.gameboard[i][2]){
                return -this.gameboard[i][0];
            }
        }
        for(int i=0; i<3; i++){
            if(this.gameboard[0][i]!=0&&this.gameboard[0][i]==this.gameboard[1][i]&&this.gameboard[0][i]==this.gameboard[2][i]){
                return -this.gameboard[0][i];
            }
        }
        
        if(this.gameboard[0][0]!=0&&this.gameboard[0][0]==this.gameboard[1][1]&&this.gameboard[0][0]==this.gameboard[2][2]){
            return -this.gameboard[0][0];
        }
        if(this.gameboard[0][2]!=0&&this.gameboard[0][2]==this.gameboard[1][1]&&this.gameboard[0][2]==this.gameboard[2][0]){
            return -this.gameboard[0][2];
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(this.gameboard[i][j]==0){
                    return 2;
                }
            }
        }
        return 0;
    }
    
    public void print(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(this.gameboard[i][0]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }
    
    public void random_choice(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(this.gameboard[i][j]==0){
                    this.gameboard[i][j]=-1;
                    return;
                }
            }
        }
    }
    
    public int minimax(int board[][],int depth,boolean max_step){
        int result=this.end_game();
        //If the game is already ended the score is the result.
        if(result!=2){
            return result;
        }
        if(max_step==true){
            int bestScore=-1000;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(board[i][j]==0){
                        board[i][j]=-1;
                        int score=this.minimax(board,depth+1,false);
                        board[i][j]=0;
                        if(score>bestScore){
                            bestScore=score;
                        }
                    }
                }
            }
            return bestScore;
        }
        else{
            int bestScore=1000;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(board[i][j]==0){
                        board[i][j]=1;
                        int score=this.minimax(board,depth+1,true);
                        board[i][j]=0;
                        if(score<bestScore){
                            bestScore=score;
                        }
                    }
                }
            }
            return bestScore;
        }
    }
    
    
    public void minimax_choice(){
        int bestScore=-1000;
        
        int[][] board=new int[3][3];
        board=this.gameboard;
        Position bestChoice=new Position(0,0);
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j]==0){
                    board[i][j]=-1;
                    int score=this.minimax(board,0,false);
                    board[i][j]=0;
                    if(score>bestScore){
                        bestScore=score;
                        bestChoice=new Position(i,j);
                    }
                }
            }
        }
        this.gameboard[bestChoice.x][bestChoice.y]=-1;
        return;
    }
    
    
}
