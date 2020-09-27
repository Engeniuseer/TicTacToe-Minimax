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
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicTacToe tic=new TicTacToe();
        //Uncomment next line to let AI start
        //tic.user_turn=false;
        while(tic.g.end_game()==2){
            tic.render();
            if(tic.user_turn==false && tic.g.end_game()==2){
                tic.g.minimax_choice();
                tic.user_turn=true;
            }
        }
        tic.render();
        System.out.println("GAME ENDED!!!");
    }
}
