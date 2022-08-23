public class MedianSortedArrays {
    public static void main(String[] args) {

        int[] nums1 = {1,2};
        int[] nums2 = {3, 4, 5};
        System.out.println(sort(nums1, nums2));
    }

    public static double sort(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 > length2) {
            return sort(nums2, nums1);
        }

        int start = 0;
        int end = length1;

        int left1 = 0, left2 = 0, right1 = 0, right2 = 0;
        while (start <= end) {
            int partition1 = (start + end) / 2;
            int partition2 = (length1 + length2) / 2 - partition1;

            left1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            right1 = (partition1 == length1) ? Integer.MAX_VALUE : nums1[partition1];
            left2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            right2 = (partition2 == length2) ? Integer.MAX_VALUE : nums2[partition2];

            if (left1 > right2) {
                end = partition1 - 1;
            }
            else if (left2 > right1) {
                start = partition1 + 1;
            }
            else {
                return (length1 + length2) % 2 == 0 ? (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0 : Math.min(right1, right2);
            }
        }
        return -1;
    }
}
