import java.util.Random;
import java.util.Scanner;

class Guesser
{
    int guessNum;

    public int guessNumber()
    {
        System.out.print("Guesser guess the number is :- ");
        Random rand = new Random();
        guessNum=rand.nextInt(1,10);
        return guessNum;
    }

}

class Player
{
    int pguessNum;

    public int guessNumber()
    {
        Scanner scan=new Scanner(System.in);
        System.out.print("Player kindly guess the number (between 1 to 10) :- ");
        pguessNum=scan.nextInt();
        return pguessNum;
    }
}

class Umpire
{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    int countp1=0;
    int countp2=0;
    int countp3=0;

    int winner1,winner2;



    public void collectNumFromGuesser()
    {
        Guesser g=new Guesser();
        numFromGuesser=g.guessNumber();
        System.out.println(numFromGuesser);
    }


    public void collectNumFromPlayer()
    {
        Player p1=new Player();
        Player p2=new Player();
        Player p3=new Player();


        numFromPlayer1=p1.guessNumber();
        numFromPlayer2=p2.guessNumber();
        numFromPlayer3=p3.guessNumber();
    }

    void compare() {

        collectNumFromGuesser();    //calling guesser collection method

        for(int i=0; i<4; i++) {

            collectNumFromPlayer();

            if (numFromGuesser == numFromPlayer1) {
                if (numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3) {
                    System.out.println("Game tied all three players guessed correctly");
                    countp1++; countp2++; countp3++;
                } else if (numFromGuesser == numFromPlayer2) {
                    System.out.println("Player 1 and Player2 won the game");
                    countp1++; countp2++;
                } else if (numFromGuesser == numFromPlayer3) {
                    System.out.println("Player 1 and Player3 won ");
                    countp1++;  countp3++;
                } else {
                    System.out.println("Player 1 won the game");
                    countp1++;
                }
            } else if (numFromGuesser == numFromPlayer2) {
                if (numFromGuesser == numFromPlayer3) {
                    System.out.println("Player 2 and Player3 won the game");
                    countp2++; countp3++;
                } else {
                    System.out.println("Player 2 won the game");
                    countp2++;
                }
            } else if (numFromGuesser == numFromPlayer3) {
                System.out.println("Player 3 won the game");
                countp3++;
            } else {
                System.out.println("Game lost! try again");
                countp1+=0;
                countp2+=0;
                countp3+=0;
            }
        }
        System.out.println(countp1);
        System.out.println(countp2);
        System.out.println(countp3);

        int largest = countp3 > (countp1 > countp2 ? countp1 : countp2) ? countp3 : ((countp1 > countp2) ? countp1 : countp2);
//        System.out.println("first largest number is " + largest);

        //checking for the second largest number
        int secondLarger=0;
        if (countp1 > countp2 && countp1 < countp3 || countp1 > countp3 && countp1 < countp2) {
            secondLarger = countp1;
        }
        else if (countp2 > countp1 && countp2 < countp3 || countp2 > countp3 && countp2 < countp1) {
            secondLarger = countp2;
        }
        else {
            secondLarger = countp3;
        }
//        System.out.println();

        System.out.println("largest " + largest);
        System.out.println("second" + secondLarger);


        if(largest==countp1 || secondLarger==countp1)
        {
            if ((largest==countp2 || secondLarger==countp2) && (largest==countp3 || secondLarger==countp3))
            {
                System.out.println("Play again for result.");
                collectNumFromPlayer();
                compare();
            }else if (largest==countp2 || secondLarger==countp2)
            {
                System.out.println("player 1 and 2 enters semi-final match");
                winner1=countp1;  winner2 = countp2;
            }else if (largest==countp3 || secondLarger==countp3){
                System.out.println("player 1 and 3 enter semi-final match");
                winner1=countp1;  winner2 = countp3;
            }else{
                System.out.println("player 1 enter semi-final match");
                winner1=countp1;  winner2 = 0;
            }
        }
        else if (largest==countp2 || secondLarger==countp2)
        {
            if (largest==countp3 || secondLarger==countp3){
                System.out.println("player 2 and 3 enters semi-final match");
                winner1=countp2;  winner2 = countp3;
            }else{
                System.out.println("player 2 enters semi-final match ");
                winner1=countp1;  winner2 = 0;
            }
        }
        else if (largest==countp3 || secondLarger==countp3)
        {
            System.out.println("player 3 enters semi-final match");
            winner2 = countp3;
        }else{
            System.out.println("play again");
            collectNumFromPlayer();
            compare();
        }


    }

    public void collectNumFromWinners()
    {
        collectNumFromGuesser();
        Player win1=new Player();
        Player win2=new Player();


        numFromPlayer1=win1.guessNumber();
        numFromPlayer2=win2.guessNumber();
        winner1=numFromPlayer1;
        winner2=numFromPlayer2;
        compare();
    }
    public void semi_final()
    {

        collectNumFromWinners();

    }



}




public class GuesserGame {
    public static void main(String[] args) {
        Umpire u=new Umpire();
        u.compare();
        u.collectNumFromWinners();
        u.semi_final();

    }
}
