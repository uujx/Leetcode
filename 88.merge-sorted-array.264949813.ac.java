class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /** Straight forward
        /*
        for (int i = m, j = 0; i < m + n; i++, j++) 
            nums1[i] = nums2[j];
        Arrays.sort(nums1);
        */
        
        /** Use an aux array to store nums1
        /*
        int[] aux = new int[m];
        for (int i = 0; i < m; i++)
            aux[i] = nums1[i];
        
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (aux[i] <= nums2[j]) {
                    nums1[k] = aux[i];
                    i++;
                } else if (aux[i] > nums2[j]) {
                    nums1[k] = nums2[j];
                    j++;
                }
            } else if (i < m) {
                nums1[k] = aux[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            
            k++;
        }
        */
        
        // 反向操作无敌
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else 
                nums1[k--] = nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];
    
    }
}
