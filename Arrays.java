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

// ##################### Sort an array 0's, 1's and 2's ###########################

class Solution
{
    public:
    void sort012(int a[], int n)
    {
        int low = 0;
        int mid = 0;
        int high = n - 1;
        int temp;
        
        while(mid <= high)
        {
            if(a[mid] == 0)
            {
              temp = a[mid];
              a[mid] = a[low];
              a[low] = temp;
              low++;
              mid++;
            }
            
            else if(a[mid] == 1)
            {
                mid++;
            }
            
            else if(a[mid] == 2)
            {
                temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }
        
        
        
        // int cnt0 = 0;
        // int cnt1 = 0;
        // int cnt2 = 0;
        
        // for(int i = 0; i < n; i++)
        // {
        //     if(a[i] == 0)
        //     {
        //         cnt0++;
        //     }
        //     else if(a[i] == 1)
        //     {
        //         cnt1++;
        //     }
        //     else if(a[i] == 2)
        //     {
        //         cnt2++;
        //     }
        // }
        
        // for(int i = 0; i < cnt0; i++)
        // {
        //     a[i] = 0;
        // }
        
        // for(int i = cnt0; i < cnt0 + cnt1; i++)
        // {
        //     a[i] = 1;
        // }
        
        // for(int i = cnt0 + cnt1; i < cnt0 + cnt1 + cnt2; i++)
        // {
        //     a[i] = 2;
        // }
    }
    
};


//############################ Move all negative elements to end ###########################################

class Solution {
    
    public void segregateElements(int arr[], int n)
    {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++)
        {
           if(arr[i] >= 0)
           {
               resList.add(arr[i]);
           }
        }
        
        for(int i = 0; i < n; i++)
        {
            if(arr[i] < 0)
            {
                resList.add(arr[i]);
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            arr[i] = resList.get(i);
        }
    }
}


//############################# Move all the negative elements to one side of the array #######################

public class Gfg {
 
    // a utility function to swap two elements of an array
    public static void swap(int[] ar, int i, int j)
    {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
 
    // function to shilf all negative integers to the left
    // and all positive integers to the right
    // using Dutch National Flag Algorithm
    public static void move(int[] ar)
    {
        int low = 0;
        int high = ar.length - 1;
        while (low <= high) {
            if (ar[low] <= 0)
                low++;
            else
                swap(ar, low, high--);
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int[] ar = { 1, 2,  -4, -5, 2, -7, 3,
                     2, -6, -8, -9, 3, 2,  1 };
        move(ar);
        for (int e : ar)
            System.out.print(e + " ");
    }
}


//#################### Cyclic rotate by one #############################

class Compute {
    
    public void rotate(int arr[], int n)
    {
        int last_ele = arr[n - 1];
        for(int i = n - 1; i > 0; i--)
        {
           arr[i] = arr[i - 1];
        }
        arr[0] = last_ele;
    }
}

// ################### Duplicate in an array with constant space #####################

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> resList = new ArrayList<>();
        ArrayList<Integer> minusOne = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            int index = arr[i] % n;
            arr[index] = arr[index] + n;
        }
        
        for(int i = 0; i < n; i++)
        {
            if((arr[i] / n) >= 2)
            {
                count++;
                resList.add(i);
            }
        }
        
        if(count == 0)
        {
            minusOne.add(-1);
            return minusOne;
        }
        
        return resList;
    }
}
