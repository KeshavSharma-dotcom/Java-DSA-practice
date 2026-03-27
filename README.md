=> Binary Search : Faults :- 
   1. mid = (left + right)/2; can overflow after : mid = left + (right - left)/2;

=> Merge Sort : Faults i made :-
   1. Recursion ending condition : arr.length == 0; after : arr.length <= 0
   2. Over engineering trap : checking mid == 1 even though the while loops can easily fix them
   3. j starting with : arr.length - mid -1; after : j = mid;

=> Quick Sort : 
   1. Changes outer while(left < right) to while(left <= right)
      -to ensure the left and right pointers crossed.

=> Merging linked list : 
   1. Initially added nodes via insert method.
      - then used in-place method to just change nodes instead creating new nodes.

=> Palindrome in LL :
   1. We can restore the list by reversing the mid to end again.
      - Currnetly slow.next = null; so slow.next = reverseSLL(secondHalf);

=> KGroup reversing :
   1. Used the recursive reversal to k length groups by isolating K_Node.next = null;
   2. Off-by-one problem faced while defining getKth function declaring prevGroupTail.next.
      - Fixed by declaring prevGroupTail starts with a temp node (anchor).

=> Valid Parentheses :
   1. Repeat calling pop() and isEmpty multiple time
      - Now reduced LOC and simplified comparisions.

=> Largest Rectangle in histogram :
   1. Initially used variables for left and right smallest ,later used arrays SL and SR.
      - Using arrays gave advantage of searching for all possible heights of each bar.
