# Brute Force Approach (Check all possible removals - not efficient for large inputs)
def is_valid_brute(s):
    stack = []
    for char in s:
        if char in "({[":
            stack.append(char)
        else:
            if not stack:
                return False
            top = stack.pop()
            if (top == '(' and char != ')') or \
               (top == '{' and char != '}') or \
               (top == '[' and char != ']'):
                return False
    return not stack

# Efficient Approach (Single pass using stack)
def is_valid_efficient(s):
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}
    for char in s:
        if char in mapping.values():
            stack.append(char)
        elif char in mapping:
            if not stack or stack.pop() != mapping[char]:
                return False
    return not stack

# Example usage
if __name__ == "__main__":
    test_str = "{[()]}"
    print("Brute Force:", is_valid_brute(test_str))
    print("Efficient:", is_valid_efficient(test_str))