import java.util.ArrayList;

public class SortedArrayList <E extends Comparable <E>>  extends ArrayList<E> {

//    //Selection Sort Algorithm
//    public void selctionSort() {
//        E temp;
//        int minIndex;
//
//        for (int j=0; j<this.size()-1; j++)
//        {
//            // this is the outer loop
//            minIndex = j;
//            for (int k=j+1; k<this.size(); k++)
//            {
//                if (this.get(k).compareTo(this.get(minIndex))<0)
//                {
//                    minIndex = k;
//                }
//            }
//            temp = this.get(minIndex);
//            this.set(minIndex, this.get(j));
//            this.set(j,temp);
//        }

        //Insertion Sort Algorithm

    public void insertionSort() {
        for (int i = 1; i <this.size(); i++)
        {
            E value = this.get(i);
            int j;
            for (j = i; j > 0; j--)
            {
                if (this.get(j-1).compareTo(value)<0)
                {
                    break;
                }
                else
                {
                    //a[j] = a[j-1];
                    this.set(j, this.get(j-1));
                }
            }
            //a[j] = value;
            this.set(j,value);
        }

    }

}


