# Brute Force Approach
def pivotIndex_brute(nums):
    n = len(nums)
    for i in range(n):
        left_sum = sum(nums[:i])
        right_sum = sum(nums[i+1:])
        if left_sum == right_sum:
            return i
    return -1

# Efficient Approach (Prefix Sum)
def pivotIndex_efficient(nums):
    total = sum(nums)
    left_sum = 0
    for i, num in enumerate(nums):
        if left_sum == total - left_sum - num:
            return i
        left_sum += num
    return -1

# Example usage:
nums = [1, 7, 3, 6, 5, 6]
print("Brute Force:", pivotIndex_brute(nums))    # Output: 3
print("Efficient:", pivotIndex_efficient(nums))  # Output: 3