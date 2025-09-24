# Brute Force Approach
def spiralOrderBruteForce(matrix):
    if not matrix or not matrix[0]:
        return []
    m, n = len(matrix), len(matrix[0])
    visited = [[False]*n for _ in range(m)]
    result = []
    dirs = [(0,1), (1,0), (0,-1), (-1,0)]  # right, down, left, up
    x = y = d = 0
    for _ in range(m*n):
        result.append(matrix[x][y])
        visited[x][y] = True
        nx, ny = x + dirs[d][0], y + dirs[d][1]
        if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny]:
            x, y = nx, ny
        else:
            d = (d + 1) % 4
            x, y = x + dirs[d][0], y + dirs[d][1]
    return result

# Efficient Approach
def spiralOrder(matrix):
    if not matrix or not matrix[0]:
        return []
    result = []
    top, bottom, left, right = 0, len(matrix)-1, 0, len(matrix[0])-1
    while top <= bottom and left <= right:
        for j in range(left, right+1):
            result.append(matrix[top][j])
        top += 1
        for i in range(top, bottom+1):
            result.append(matrix[i][right])
        right -= 1
        if top <= bottom:
            for j in range(right, left-1, -1):
                result.append(matrix[bottom][j])
            bottom -= 1
        if left <= right:
            for i in range(bottom, top-1, -1):
                result.append(matrix[i][left])
            left += 1
    return result

# Example usage:
if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    print("Brute Force:", spiralOrderBruteForce(matrix))
    print("Efficient:", spiralOrder(matrix))