# Base code: Using a dictionary to count occurrences (O(n) time, O(n) space)
def majority_element_base(nums):
    counts = {}
    for num in nums:
        counts[num] = counts.get(num, 0) + 1
        if counts[num] > len(nums) // 2:
            return num
    return None

# Efficient code: Boyer-Moore Voting Algorithm (O(n) time, O(1) space)
def majority_element_efficient(nums):
    count = 0
    candidate = None
    for num in nums:
        if count == 0:
            candidate = num
        count += (1 if num == candidate else -1)
    # Optional: Verify candidate is actually the majority
    if nums.count(candidate) > len(nums) // 2:
        return candidate
    return None

# Example usage:
if __name__ == "__main__":
    nums = [2,2,1,1,1,2,2]
    print("Base:", majority_element_base(nums))
    print("Efficient:", majority_element_efficient(nums))