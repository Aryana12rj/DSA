# Brute Force Approach
def moveZeroes_brute_force(nums):
    n = len(nums)
    result = []
    zero_count = 0
    for num in nums:
        if num != 0:
            result.append(num)
        else:
            zero_count += 1
    result.extend([0] * zero_count)
    for i in range(n):
        nums[i] = result[i]

# Efficient Approach (In-place, O(n) time, O(1) space)
def moveZeroes_efficient(nums):
    last_non_zero = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[last_non_zero], nums[i] = nums[i], nums[last_non_zero]
            last_non_zero += 1

# Example usage:
if __name__ == "__main__":
    arr1 = [0, 1, 0, 3, 12]
    moveZeroes_brute_force(arr1)
    print("Brute Force:", arr1)  # Output: [1, 3, 12, 0, 0]

    arr2 = [0, 1, 0, 3, 12]
    moveZeroes_efficient(arr2)
    print("Efficient:", arr2)    # Output: [1, 3, 12, 0, 0]