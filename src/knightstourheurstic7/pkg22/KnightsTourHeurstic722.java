/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package knightstourheurstic7.pkg22;

/**
 *
 * @author Salah
 */
public class KnightsTourHeurstic722 {

    /**
     * @param args the command line arguments
     */
    public static int currentI = 3; // 3.4
    public static int currentJ = 4;
    
    public static int Chess [][] = new int [8][8];
    
    public static int moves = 0;
    
    
    public static final int possibleI[] = {2, 1, -1, -2, -2, -1, 1, 2};
   
    public static final int possibleJ[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    
    
    public static final int eightPossibilities = 8;
    
    public KnightsTourHeurstic722()
    
    {
        for ( int i = 0; i < 8; i++ )
        {
            for (int j = 0; j < 8; j++)
            {
                Chess[i][j] = 0; 
            }
        }
        
    }
       
    public static void move()
    
    {
        int     i,
                j,
                k;
        
        boolean moved;
        
        for ( i = 1; i <= 64; i++ )
        {
            moved = checkPossibleMove();
            
            if ( moved == true)
            moves++;
            
            else
            {
                System.out.printf("@@@ Heurstic move, Move no: %d, I = %d, j = %d ", moves, currentI, currentJ);
                moved = Heuristic.getSequare();
            
            
            if ( moved == true)
            
                
                moves++;
            }
            System.out.printf("Move no: %d, I = %d, J = %d%n", moves, currentI, currentJ );
        }   
    }
    
    
    public static boolean checkPossibleMove()
    {
        int     i ,
                row = 0,
                coulmn = 0,
                i1,
                j1,
                rowTrueI=0;
        
        boolean rowTrue = false,
                coulmnTrue = false,
                k = false;
        
        for ( i = 0; i < 8; i++)
        {
   
             try 
        {
            
            if ( (currentI + possibleI[i]) >= 0 && (currentI + possibleI[i]) <= 7 )
            {
                
                rowTrue = true;
                rowTrueI = i;
            }
            
            if ((currentJ+ possibleJ[i]) >=0 && (currentJ+ possibleJ[i]) <=7 && rowTrue==true&& rowTrueI ==i )
            {
                row = currentI + possibleI[i];
                
                coulmn = currentJ+ possibleJ[i];
                coulmnTrue = true;
            }
                if (Chess[row][coulmn] == 0 && rowTrue == true && coulmnTrue == true)
                    
                {
                    Chess[row][coulmn] = 1;
                    
                    k = true;
                
                    currentI = row;
                    
                    currentJ = coulmn;
                    break;
                }
                
                else
                    k= false;
        }
        
        catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(e);
                       
                       System.out.printf("   Chess[%d] = %d\n\n", i, Chess[i]);                
                }
        }

        return k;
    }

    
    public static void display()
    
    {
        System.out.printf("The knights moves = %d%n", moves);
        for (int i = 0; i < 8; i++)
        {
            System.out.println();
            for ( int j = 0; j < 8; j++)
            {
                System.out.printf("%d ", Chess[i][j]);
            }
        }
        
    }
 
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        KnightsTourHeurstic722 KT = new KnightsTourHeurstic722();
        
        KT.move();   
     
        KT.display();
    }   
}
