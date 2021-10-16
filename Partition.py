# Partition problem is to determine whether a given set can be partitioned
# into two subsets such that the sum of elements in both subsets is the same.

# approach one: recursion

# time of O(2^n)
def partitionWithRecursion(arr, n, sum):

    # define base cases
    if sum == 0:
        return True
    if n == 0 and sum != 0:
        return False

    # if last elem is greater than sum -> ignore it
    if arr[n-1] > sum:
        return partitionWithRecursion(arr, n-1, sum)

    # else check if sum can be obtaind by
    # 1) including last elem
    # 2) exclude last elem

    return partitionWithRecursion(arr, n-1, sum) or partitionWithRecursion(arr, n-1, sum-arr[n-1])


def partition(arr, n):

    sum = 0
    for i in range(0, n):
        sum += arr[i]

    if sum % 2 != 0:
        return partitionWithRecursion(arr, n, sum//2)


# now we use DP with bottom up technique. We create an array of [sum//2+1]*[n-1]
# and build up the solution from the bottom

# This is the essential idea
# part[i][j] = true if a subset of {arr[0], arr[1], ..arr[j-1]} has sum
#            equal to i, otherwise false

def partitionWithDP(arr, n):
    sum = 0
    i, j = 0, 0

    # calc the sum of all items
    for i in range(n):
        sum += arr[i]

    if sum % 2 != 0:
        return False

    part = [[True for i in range(n+1)] for j in range(sum//2+1)]

    # initialize top row as True
    for i in range(0, n+1):
        part[0][i] = True

    # initialize leftmost col, except [0][0] as False
    for i in range(1, sum//2+1):
        part[i][0] = False

    # fill the table bottom up
    for i in range(1, sum//2+1):
        for j in range(1, n+1):

            part[i][j] = part[i][j-1]

            if i >= arr[j-1]:
                part[i][j] = (part[i][j] or part[i-arr[j-1]][j-1])

    return part[sum//2][n]
