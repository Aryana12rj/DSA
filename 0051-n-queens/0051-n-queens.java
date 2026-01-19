class Solution 
{
    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> result = new ArrayList<>();
        char [][] board = new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        helper(board,0,result);
        return result;
    }
    public static void helper(char [][] board,int row,List<List<String>> result)
    {
        int n=board.length;
        if(row==n)
        {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }
        for(int j=0;j<n;j++)
        {
            if(isSafe(board,row,j))
            {
                board[row][j]='Q';
                helper(board,row+1,result);
                board[row][j]='.';
            }
        }
    }
    public static boolean isSafe(char[][]board,int row,int col)
    {
        int n =board.length;
        for(int i=0;i<n;i++)
        {
            if(board[i][col]=='Q') return false;
        }
        for(int j=0;j<n;j++)
        {
            if(board[row][j]=='Q') return false;
        }
        int i=row;
        int j=col;
        while(i>=0 && j>=0)
        {
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
        i= row;
        j=col;
        while(i>=0 && j<n)
        {
            if(board[i][j]=='Q') return false;
            i--;
            j++;
        }
        return true;
    }
}
 