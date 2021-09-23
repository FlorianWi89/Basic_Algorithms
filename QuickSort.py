def partition(array, start, end):
    pivotIndex = start
    pivot = array[pivotIndex]

    while start < end:
        while start < len(array) and array[start] <= pivot:
            start += 1

        while array[end] > pivot:
            end -= 1

        if start < end:
            array[start], array[end] = array[end], array[start]

    array[end], array[pivotIndex] = array[pivotIndex], array[end]
    return end


def qSort(array, start, end):
    if start < end:

        p = partition(array, start, end)

        qSort(array, start, p-1)
        qSort(array, p+1, end)
