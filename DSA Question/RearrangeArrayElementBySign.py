# Brute Force Approach
def rearrange_by_sign_brute_force(nums):
    pos = [x for x in nums if x >= 0]
    neg = [x for x in nums if x < 0]
    result = []
    i = j = 0
    while i < len(pos) and j < len(neg):
        result.append(pos[i])
        result.append(neg[j])
        i += 1
        j += 1
    # Append remaining elements if any
    result.extend(pos[i:])
    result.extend(neg[j:])
    return result

# Efficient Approach (O(n) time, O(n) space)
def rearrange_by_sign_efficient(nums):
    n = len(nums)
    result = [0] * n
    pos_idx, neg_idx = 0, 1
    for num in nums:
        if num >= 0:
            result[pos_idx] = num
            pos_idx += 2
        else:
            result[neg_idx] = num
            neg_idx += 2
    return result

# Example usage:
nums = [3, 1, -2, -5, 2, -4]
print("Brute Force:", rearrange_by_sign_brute_force(nums))
print("Efficient:", rearrange_by_sign_efficient(nums))