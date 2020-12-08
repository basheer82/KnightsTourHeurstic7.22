/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstourheurstic7.pkg22;

/**
 *
 * @author Salah
 */ // check in the next example the nearest new sequare and try to move to nearest sequare of it 
public class Heuristic {
  
    
    public static int currentRow ;
    public static int currentCoulmn ;
    
    public static final int possibleRow[] = {2, 1, -1, -2, -2, -1, 1, 2};
   
    public static final int possibleCoulmn[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    
    public  static final int Heur[][] = { {2, 3, 4, 4, 4, 4, 3, 2} , 
                                          {3, 4, 6, 6, 6, 6, 4, 3} , 
                                          {4, 6, 8, 8, 8, 8, 6, 4} , 
                                          {4, 6, 8, 8, 8, 8, 6, 4} ,
                                          {4, 6, 8, 8, 8, 8, 6, 4} , 
                                          {4, 6, 8, 8, 8, 8, 6, 4} , 
                                          {3, 4, 6, 6, 6, 6, 4, 3} , 
                                          {2, 3, 4, 4, 4, 4, 3, 2}};
    
    public static int [][] Accessability = new int [8][8]; 
    
    
    
   public static boolean k = false;
    public Heuristic()
    {  
    
    }
    
    public static boolean  getSequare()
    {
        for ( int a = 0; a < 8; a++)
        
            System.arraycopy(KnightsTourHeurstic722.Chess[a], 0, Accessability[a], 0, 8);
        
         currentRow = KnightsTourHeurstic722.currentI;
         currentCoulmn = KnightsTourHeurstic722.currentJ;
         
         
        System.out.printf("%n^^^^^Heurstic, current row = %d current coulmn = %d%n^^^^", currentRow, currentCoulmn);  
         k = checkPossibility();
         return k;
    
    }
    
    
    public static boolean checkPossibility()
    {
        
        int     i ,
                row = 0,
                coulmn = 0,
                i1,
                j1,
                rowTrueI=0;
        
        boolean rowTrue = false,
                coulmnTrue = false;
        
        for ( i = 0; i < 8; i++)
        {

            
            if ( (currentRow + possibleRow[i]) >= 0 && (currentRow + possibleRow[i]) <= 7 )
            {
                
                rowTrue = true;
                rowTrueI = i;
            }
            
            if ((currentCoulmn+ possibleCoulmn[i]) >=0 && (currentCoulmn+ possibleCoulmn[i]) <=7 && rowTrue==true&& rowTrueI ==i )
            {
                row = currentRow + possibleRow[i];
                
                coulmn = currentCoulmn+ possibleCoulmn[i];
                coulmnTrue = true;
            }
                if ((KnightsTourHeurstic722.Chess[row][coulmn] <= Heur[row][coulmn]) && rowTrue == true && coulmnTrue == true)
                    
                {
                    KnightsTourHeurstic722.Chess[row][coulmn]++;
                    
                    k = true;
                
                    currentRow = row;
                    
                    currentCoulmn = coulmn;
                    
                    KnightsTourHeurstic722.currentI = row ;
                    KnightsTourHeurstic722.currentJ = coulmn;
                    break;
                }
        
        }
        
        return k;
    }
    
}