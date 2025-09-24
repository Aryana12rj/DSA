# Brute Force Approach
def prefix_sum_brute_force(nums):
    n = len(nums)
    prefix = []
    for i in range(n):
        s = 0
        for j in range(i + 1):
            s += nums[j]
        prefix.append(s)
    return prefix

# Efficient Approach (O(n) time)
def prefix_sum_efficient(nums):
    prefix = []
    current_sum = 0
    for num in nums:
        current_sum += num
        prefix.append(current_sum)
    return prefix

# Example usage:
nums = [1, 2, 3, 4]
print("Brute Force:", prefix_sum_brute_force(nums))
print("Efficient:", prefix_sum_efficient(nums))