package sortByCategory.DoublePointer;

/**
 * @author haiboWu
 * @create 2020-02-28 17:27
 */
public class No_88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1;
        int index2=n-1;
        int mergeindex=nums1.length-1;
        while(index1>=0||index2>=0){
            if(index1<0){
                nums1[mergeindex--]=nums2[index2--];
            }else if(index2<0){
                nums1[mergeindex--]=nums1[index1--];
            }else{
                if(nums1[index1]>nums2[index2]){
                    nums1[mergeindex--]=nums1[index1--];
                }else{
                    nums1[mergeindex--]=nums2[index2--];
                }
            }
        }
    }
}
