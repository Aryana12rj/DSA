# LeetCode 80: Remove Duplicates from Sorted Array II

# Brute Force Approach
def remove_duplicates_brute(nums):
    i = 0
    while i < len(nums):
        count = nums.count(nums[i])
        while count > 2:
            nums.remove(nums[i])
            count -= 1
        i += 1
    return len(nums)

# Efficient Approach (Two Pointer)
def remove_duplicates_efficient(nums):
    if len(nums) <= 2:
        return len(nums)
    j = 2
    for i in range(2, len(nums)):
        if nums[i] != nums[j - 2]:
            nums[j] = nums[i]
            j += 1
    return j

# Example usage:
nums1 = [1,1,1,2,2,3]
nums2 = nums1.copy()
print("Brute Force:", remove_duplicates_brute(nums1), nums1)
print("Efficient:", remove_duplicates_efficient(nums2), nums2[:remove_duplicates_efficient(nums2)])