# Brute Force Approach
def running_sum_brute_force(nums):
    result = []
    for i in range(len(nums)):
        total = 0
        for j in range(i + 1):
            total += nums[j]
        result.append(total)
    return result

# Efficient Approach (O(n) time)
def running_sum_efficient(nums):
    result = []
    total = 0
    for num in nums:
        total += num
        result.append(total)
    return result

# Example usage:
if __name__ == "__main__":
    nums = [1, 2, 3, 4]
    print("Brute Force:", running_sum_brute_force(nums))
    print("Efficient:", running_sum_efficient(nums))