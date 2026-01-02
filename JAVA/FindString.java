public class FindString {

    private static final char array[][] =   {
                                                {'Q', 'Z', 'R'},
                                                {'Q', 'R', 'E'},
                                                {'T', 'F', 'E'}
                                            };
    
    public static final void main(String[] args)
    {
        
        System.out.println(find("TREE"));
    }
    
    public static int find(String key)
    {
        char keyArray[] = key.toCharArray();
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[i].length; j++)
            {
                int ret = checkAround(array, key.toCharArray(), i, j, -1, -1, 0);
                if(ret == 1)
                {
                    return ret;
                }
            }
        }
        return 0;
    }
    
    public static int checkAround(char[][] array, char[] search, int x, int y, int prevX, int prevY, int pos)
    {
        for(int i = -1; i <= 1;  i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                int newX = x+i;
                int newY = y+j;
                
                if(!(i == 0 && j == 0) 
                    &&
                    (newX >= 0 && newY >= 0 && newX < array.length && newY < array[newX].length )
                    &&
                    !(newX == prevX && newY == prevY)
                   )
                    {
                        System.out.println(array[newX][newY] + " == " + search[pos] + "?");
                        if(array[newX][newY] == search[pos])
                        {
                            System.out.println("TRUE");
                            if((pos == search.length-1) || (checkAround(array, search, newX, newY, x, y, pos+1) == 1))
                            {
                                return 1;
                            }
                        }
                    }
            }
        }
        return 0;
    }
}