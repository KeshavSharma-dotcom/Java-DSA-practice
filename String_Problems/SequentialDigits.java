//1. nested approach
//public List<Integer> sequentialDigits(int low, int high) {
//    CharSequence c = "123456789";
//    List<Integer> list = new ArrayList<>();
//    int lowLength  = (int) Math.log10(Math.abs(low)) + 1;
//    int highLength  = (int) Math.log10(Math.abs(high)) + 1;
//    for(int l = lowLength;l<=highLength;l++){
//        int i = 0;
//        int j = l;
//        while(j <= c.length()){
//            int num = Integer.parseInt(c,i,j,10);
//            if(num <= high && num >= low){
//                list.add(num);
//            }
//            i++;
//            j++;
//        }
//    }
//    return list;
//}
//2.
public List<Integer> sequentialDigits(int low, int high){
    List<Integer> list = new ArrayList<>();
    CharSequence c = "123456789";
    int lowLength  = (int) Math.log10(Math.abs(low)) + 1;
    int highLength  = (int) Math.log10(Math.abs(high)) + 1;
    int i = 0, j = lowLength;
    while(lowLength <= highLength){
        int num = Integer.parseInt(c,i,j,10);
        if(num >= low && num <= high){
            list.add(num);
        }
        i++;
        j++;
        if(j>c.length()){
            lowLength++;
            i = 0;
            j = lowLength;
        }
    }
    return list;
}
void main() {
    System.out.println(sequentialDigits(10,100000));
}