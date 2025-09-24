def linear_search_brute_force(arr, target):
    """
    Brute force linear search: checks every element.
    Returns index if found, else -1.
    """
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1

def linear_search_efficient(arr, target):
    """
    Efficient linear search: uses enumerate for clarity.
    Returns index if found, else -1.
    """
    for idx, val in enumerate(arr):
        if val == target:
            return idx
    return -1

# Example usage:
if __name__ == "__main__":
    arr = [10, 23, 45, 70, 11, 15]
    target = 70
    print("Brute Force:", linear_search_brute_force(arr, target))
    print("Efficient:", linear_search_efficient(arr, target))