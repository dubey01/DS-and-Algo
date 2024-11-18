// To find an element in a rotated sorted array
// Used modified binary search for finding the element

class Main {
    public static void main(String[] args) {
        int [] arr = new int[] {4,5,6,7,8,9,10,1,2,3};
        
        System.out.println(findTarget(arr, 2));
    }
    
    static int findTarget(int [] arr, int target){
        int start = 0, end = arr.length-1;
        
        while(start < end){
            int mid = start + (end - start)/2;
            
            if(arr[mid] == target){
                return mid;
            }
            
            if(arr[start] < arr[mid]){
                if(arr[start]<= target && target < arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(arr[mid] < target && target < arr[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
