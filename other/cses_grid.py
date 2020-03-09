#!/usr/bin/python3

# 1 -> 1
# 2 -> 2
# 3 -> 6
# 4 -> 20
# 5 -> 70
# 6 -> 252
# 10 -> 48620
n = 4
grid = ["" for i in range(n)]
# for i in range(n):
#     grid[i] = "." * n

grid[0] = "...."
grid[1] = ".*.."
grid[2] = "...*"
grid[3] = "*..."
# n = int(input())
# grid = ["" for i in range(n)]
# for i in range(n):
#     grid[i] = input()

f = set()
for i in range(n):
    f.add((i, n))
    f.add((n, i))

def calc_paths(pos):
    # print(pos, f)
    if ((n-1, n-1) == pos) and not ('*' == grid[pos[0]][pos[1]]):
        return 1
    if (n == pos[0] and n != pos[1]) \
            or (n != pos[0] and n == pos[1]) \
            or ('*' == grid[pos[0]][pos[1]]):
        f.add(pos)
        return 0
    below = (pos[0], pos[1]+1)
    right = (pos[0]+1, pos[1])
    if below in f:
        return calc_paths(right)
    elif right in f:
        return calc_paths(below)
    else:
        return calc_paths(below) + calc_paths(right)

print(calc_paths((0, 0)))
