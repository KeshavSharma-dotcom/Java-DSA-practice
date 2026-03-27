// Finding the largest rectangle in a histogram
int[] NSl(int[] h){
    if(h.length <= 1){
        return h;
    }
    Stack<Integer> st = new Stack<>();
    int[] SL = new int[h.length];
    for(int i=0;i<h.length;i++){
        while(!st.isEmpty() && h[st.peek()]>=h[i]){
            st.pop();
        }
        SL[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i);
    }
    return SL;
}
int[] NSr(int[] h){
    if(h.length <= 1){
        return h;
    }
    Stack<Integer> st = new Stack<>();
    int[] SR = new int[h.length];
    for(int i=h.length-1;i>=0;i--){
        while(!st.isEmpty() && h[st.peek()]>=h[i]){
            st.pop();
        }
        SR[i] = st.isEmpty() ? h.length : st.peek();
        st.push(i);
    }
    return SR;
}
int getLargestRec(int[] heights){
    int[] RSmallest = NSr(heights);
    int[] LSmallest = NSl(heights);
    int maxArea = 0;
    for(int i=0;i< heights.length;i++){
        int width = RSmallest[i] - LSmallest[i] -1;
        int area = heights[i] * width;
        maxArea = Math.max(maxArea,area);
    }
    return maxArea;
}

void main(){
    int[] a = {8,2,9,1,0,6,7,4,3,5};
    System.out.println("Largest Rectangle Area : "+getLargestRec(a));
}