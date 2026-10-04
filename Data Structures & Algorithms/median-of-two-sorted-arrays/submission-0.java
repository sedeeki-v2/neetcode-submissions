class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }

        List<Integer> listSorted = new ArrayList<>(set);
        int middle = listSorted.size() / 2;

        if (listSorted.size() % 2 == 0) {
            return (double)(listSorted.get(middle - 1) + listSorted.get(middle)) / 2;
        } 

        return listSorted.get(middle);
    }
}
