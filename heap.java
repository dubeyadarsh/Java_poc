
//Heap is the Balanced Binary tree 
// Min heap is the heap having minimum element at top and vice-versa for max heap.

// Two type of question can be asked :
// Convert unorder array into heap
// b) Implement Dynamic Heap , ( we have this implementation below)

// Heapify is the method we used there we pass array and index and we expect from heap function to make heap starting from given index.

// In Implementation , 
//	a) Insert : We have used heapify up
//	b) remove : We have used heapify down

// We generally consider Heapify down as default

// Converting unordered array into heap , we use heapify down (starting from leaf-1 index to 0th index)
	
import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        // TODO : Implement min heap
        MinHeap mp =new MinHeap();
        mp.insert(4);
        mp.insert(5);
        mp.insert(3);
        mp.insert(2);
        System.out.println(mp.remove());
    }
    
    static class MinHeap{
        List<Integer> list = new ArrayList<>();
        
        void insert(int num){
            // insert at leaf and keep comparing with parent.
            int index = list.size();
            list.add(num);
            while((index - 1)/2>=0){
                int parent = (index - 1)/2;
                int parentValue = list.get((index - 1)/2);
                if(num < parentValue){
                    list.set(parent,num);
                    list.set(index, parentValue);
                    index = (index - 1)/2;
                }else break;
            }
        }
        int remove(){
            // remove parent node ,
            // add last data to parent Node and make heap
             if (list.size() == 0) {
                throw new NoSuchElementException("Heap is empty");
            }
            // remove the root node and replace it with the last element
            int retData = list.get(0);
            int leafData = list.remove(list.size() - 1);
            if (list.size() == 0) {
                return retData; // If the heap is empty after removal, return the root
            }
            
            list.set(0, leafData);
            int index = 0;
            while (true) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int smallest = index;
                
                // Check left child
                if (left < list.size() && list.get(left) < list.get(smallest)) {
                    smallest = left;
                }
                
                // Check right child
                if (right < list.size() && list.get(right) < list.get(smallest)) {
                    smallest = right;
                }
                
                if (smallest == index) {
                    break; // If the smallest is already at the current index, stop
                }
                
                // Swap with smallest child
                int temp = list.get(index);
                list.set(index, list.get(smallest));
                list.set(smallest, temp);
                
                index = smallest;
            }
            return retData;
        }
    }
}