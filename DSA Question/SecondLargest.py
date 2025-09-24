# Efficient code to find the second largest element in an array
def second_largest_efficient(arr):
    if len(arr) < 2:
        return None  # Not enough elements
    largest = second = float('-inf')
    for num in arr:
        if num > largest:
            second = largest
            largest = num
        elif largest > num > second:
            second = num
    return second if second != float('-inf') else None

# Brute force code to find the second largest element in an array
def second_largest_bruteforce(arr):
    if len(arr) < 2:
        return None  # Not enough elements
    unique_arr = list(set(arr))
    if len(unique_arr) < 2:
        return None  # All elements are the same
    unique_arr.sort(reverse=True)
    return unique_arr[1]

# Example usage
if __name__ == "__main__":
    arr = [10, 20, 4, 45, 99, 99]
    print("Efficient:", second_largest_efficient(arr))
    print("Brute Force:", second_largest_bruteforce(arr))