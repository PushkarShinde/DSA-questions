// User function Template for Java

//  public static int H[]=new int[10009];
//  public static int s=-1;
// 1. parent(i): Function to return the parent node of node i
// 2. leftChild(i): Function to return index of the left child of node i
// 3. rightChild(i): Function to return index of the right child of node i
// 4. shiftUp(int i): Function to shift up the node in order to maintain the
// heap property
// 5. shiftDown(int i): Function to shift down the node in order to maintain the
// heap property.
// int s=-1, current index value of the array H[].

// You have to make a class of GFG to access the above functionalities like this - GFG
// obj=new GFG(); You can check the driver code for better understanding.
class Solution {
    public int extractMax() {
        if(GFG.s<0) return -1;
        int maxVal=GFG.H[0];
        GFG.H[0]=GFG.H[GFG.s];
        GFG.s--;
        shiftDown(0);
        // GFG obj=new GFG();
        return maxVal;
    }
    private void shiftDown(int i){
        int maxInd=i;
        int left=leftChild(i);
        int right=rightChild(i);
        if(left<=GFG.s && GFG.H[left]>GFG.H[maxInd]){
            maxInd=left;
        }
        if(right<=GFG.s && GFG.H[right]>GFG.H[maxInd]){
            maxInd=right;
        }
        if(i!=maxInd){
            swap(i, maxInd);
            shiftDown(maxInd);
        }
        
    }
    private int leftChild(int i){
        return (2*i)+1;
    }
    private int rightChild(int i){
        return (2*i)+2;
    }
    private void swap(int a, int b){
        int temp=GFG.H[a];
        GFG.H[a]=GFG.H[b];
        GFG.H[b]=temp;
    }
};
