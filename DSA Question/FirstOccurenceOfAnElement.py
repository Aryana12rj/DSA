# Brute Force Approach
def first_occurrence_brute_force(nums, target):
    for i in range(len(nums)):
        if nums[i] == target:
            return i
    return -1

# Efficient Approach (Binary Search for sorted array)
def first_occurrence_binary_search(nums, target):
    left, right = 0, len(nums) - 1
    result = -1
    while left <= right:
        mid = left + (right - left) // 2
        if nums[mid] == target:
            result = mid
            right = mid - 1  # search towards left for first occurrence
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return result

# Example usage:
nums = [1, 2, 2, 2, 3, 4, 5]
target = 2
print("Brute Force:", first_occurrence_brute_force(nums, target))  # Output: 1
print("Binary Search:", first_occurrence_binary_search(nums, target))  # Output: 1