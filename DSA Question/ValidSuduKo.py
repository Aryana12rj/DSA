# Brute Force Approach
def isValidSudoku_brute(board):
    for i in range(9):
        for j in range(9):
            num = board[i][j]
            if num == '.':
                continue
            # Check row and column
            for k in range(9):
                if k != j and board[i][k] == num:
                    return False
                if k != i and board[k][j] == num:
                    return False
            # Check 3x3 box
            box_row, box_col = 3 * (i // 3), 3 * (j // 3)
            for r in range(box_row, box_row + 3):
                for c in range(box_col, box_col + 3):
                    if (r != i or c != j) and board[r][c] == num:
                        return False
    return True

# Efficient Approach
def isValidSudoku_efficient(board):
    rows = [set() for _ in range(9)]
    cols = [set() for _ in range(9)]
    boxes = [set() for _ in range(9)]
    for i in range(9):
        for j in range(9):
            num = board[i][j]
            if num == '.':
                continue
            box_index = (i // 3) * 3 + (j // 3)
            if num in rows[i] or num in cols[j] or num in boxes[box_index]:
                return False
            rows[i].add(num)
            cols[j].add(num)
            boxes[box_index].add(num)
    return True

# Example usage:
if __name__ == "__main__":
    board = [
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
    ]
    print(isValidSudoku_brute(board))     # Output: True
    print(isValidSudoku_efficient(board)) # Output: True