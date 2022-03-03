//################ Find minimum and maximum element in an array with minimum comparison. ##################

class pair
{
    long first, second;
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class Compute 
{
    static pair getMinMax(long a[], long n)  
    {
       long first = a[0];
       long second = a[0];
       
       pair minmax = new pair(first , second);
       int i;
       
       //1st case : only n = 1;
       if(n == 1)
       {
           minmax.second = a[0];
           minmax.first = a[0];
           return minmax;
       }
       
       //2nd case : if you have two value;
       if(a[0] > a[1])
       {
           minmax.second = a[0];
           minmax.first = a[1];
       }
       
       else
       {
           minmax.second = a[1];
           minmax.first = a[0];
       }
       
       for(i = 2; i < n; i++)
       {
           if(a[i] > minmax.second)
           {
               minmax.second = a[i];
           }
           else if(a[i] < minmax.first)
           {
               minmax.first = a[i];
           }
       }
       
       return minmax;
    }
}




//################### Check if array is sorted or not ####################################

class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        if(n == 0 || n == 1)
        {
            return true;
        }
        
        for(int i = 1; i < n; i++)
        {
            if(arr[i - 1] > arr[i])
            {
                return false;
            }
        }
        
        return true;
    }
}



//##################### Leaders in an Array ##############################################

    class Solution{
        static ArrayList<Integer> leaders(int arr[], int n){
            ArrayList<Integer> leaderlist = new ArrayList<Integer>();
            
            leaderlist.add(arr[n - 1]);
            int right_side = arr[n - 1];
            
            for(int i = n - 2; i >= 0; i--)
            {
                if(arr[i] >= right_side)
                {
                    right_side = arr[i];
                    leaderlist.add(0 , arr[i]);
                }
            }
            
            return leaderlist;
        }
    }
    


//######################### Frequencies in sorted Array #####################################

class Solution {
    int count(int[] arr, int n, int x) {
        int i;
        int j;
        
        i = first(arr , 0, n - 1, x, n);
        
        if(i == -1)
        {
            return 0;
        }
        
        j = last(arr , i, n - 1, x, n);
        
        return j - i + 1;
    }
    
    int first(int[] arr , int low, int high, int x, int n)
    {
        if(low <= high)
        {
            int mid = (low + high) / 2;
            if((mid == 0 || arr[mid - 1] < x) && arr[mid] == x)
            {
                return mid;
            }
            else if(arr[mid] < x)
            {
                return first(arr , (mid + 1) , high , x , n);
            }
            else
            {
                return first(arr , low , (mid - 1) , x , n);
            }
        }
        
        return -1;
    }
    
    int last(int[] arr , int low, int high, int x, int n)
    {
        if(low <= high)
        {
            int mid = (low + high) / 2;
            if((mid == n - 1 || arr[mid + 1] > x) && arr[mid] == x)
            {
                return mid;
            }
            else if(arr[mid] > x)
            {
                return last(arr , low , (mid - 1) , x , n);
            }
            else
            {
                return last(arr , (mid + 1), high , x , n);
            }
        }
        
        return -1;
    }
} 

//###################### Maximum difference in an array ##################################

class Solution {
    public int maximumDifference(int[] a) {
        int diff = a[1] - a[0];
        int curr_sum = diff;
        int max_sum = curr_sum;
        
        for(int i = 1; i < a.length - 1; i++)
        {
            diff = a[i + 1] - a[i];
            
            if(curr_sum > 0)
            {
                curr_sum = curr_sum + diff;
            }
            else
            {
                curr_sum = diff;
            }
            
            if(curr_sum > max_sum)
            {
                max_sum = curr_sum;
            }
        }
        
        return max_sum > 0 ? max_sum : -1;
    }
}