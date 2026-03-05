=> Binary Search : Faults :- 
   1. mid = (left + right)/2; can overflow after : mid = left + (right - left)/2;

=> Merge Sort : Faults i made :-
   1. Recursion ending condition : arr.length == 0; after : arr.length <= 0
   2. Over engineering trap : checking mid == 1 even though the while loops can easily fix them
   3. j starting with : arr.length - mid -1; after : j = mid;
      
