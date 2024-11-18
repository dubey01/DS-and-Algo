// Binary Search on a sorted rotated array to find the unknown pivot point around which the array has been rotated.

class Main {
    public static void main(String[] args) {
        int [] arr = new int[] {4,5,6,7,8,9,10,1,2,3};
        
        System.out.println(findPivot(arr));
    }
    
    static int findPivot(int [] arr){
        int start = 0, end = arr.length-1;
        
        while(start < end){
            int mid = start + (end - start)/2;
            
            if(arr[mid] > arr[mid+1]){
                return mid+1;
            }
            else if(arr[mid-1] > arr[mid]){
                return mid;
            }
            
            
            if(arr[start] <= arr[mid]){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        
        return 0;
    }
}
