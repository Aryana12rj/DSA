# Brute Force Approach
def suffix_sum_brute_force(nums):
    n = len(nums)
    suffix_sum = [0] * n
    for i in range(n):
        total = 0
        for j in range(i, n):
            total += nums[j]
        suffix_sum[i] = total
    return suffix_sum

# Efficient Approach (O(n))
def suffix_sum_efficient(nums):
    n = len(nums)
    suffix_sum = [0] * n
    if n == 0:
        return suffix_sum
    suffix_sum[-1] = nums[-1]
    for i in range(n - 2, -1, -1):
        suffix_sum[i] = nums[i] + suffix_sum[i + 1]
    return suffix_sum

# Example usage
nums = [1, 2, 3, 4]
print("Brute Force:", suffix_sum_brute_force(nums))
print("Efficient:", suffix_sum_efficient(nums))