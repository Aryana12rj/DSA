# LeetCode 26: Remove Duplicates from Sorted Array

# Brute Force Approach
def remove_duplicates_brute(nums):
    i = 0
    while i < len(nums) - 1:
        if nums[i] == nums[i + 1]:
            nums.pop(i + 1)
        else:
            i += 1
    return len(nums)

# Efficient Approach (Two Pointer)
def remove_duplicates_efficient(nums):
    if not nums:
        return 0
    j = 0
    for i in range(1, len(nums)):
        if nums[i] != nums[j]:
            j += 1
            nums[j] = nums[i]
    return j + 1

# Example usage:
nums1 = [1, 1, 2, 2, 3]
length_brute = remove_duplicates_brute(nums1.copy())
print("Brute Force:", nums1[:length_brute])

nums2 = [1, 1, 2, 2, 3]
length_efficient = remove_duplicates_efficient(nums2)
print("Efficient:", nums2[:length_efficient])