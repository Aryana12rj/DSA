# Brute Force Approach (Inefficient)
class NumArrayBruteForce:
    def __init__(self, nums):
        self.nums = nums

    def sumRange(self, left, right):
        return sum(self.nums[left:right+1])

# Efficient Approach using Prefix Sum
class NumArray:
    def __init__(self, nums):
        self.prefix_sum = [0]
        for num in nums:
            self.prefix_sum.append(self.prefix_sum[-1] + num)

    def sumRange(self, left, right):
        return self.prefix_sum[right+1] - self.prefix_sum[left]

# Example usage:
nums = [-2, 0, 3, -5, 2, -1]
obj = NumArray(nums)
print(obj.sumRange(0, 2))  # Output: 1
# print(obj.sumRange(2, 5))  # Output: -1
# print(obj.sumRange(0, 5))  # Output: -3