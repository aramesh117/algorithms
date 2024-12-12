from typing import List


# Write any import statements here

def getMinCodeEntryTime(N: int, M: int, C: List[int]) -> int:
    C.insert(0, 1)
    total = 0
    for i in range(1, len(C)):
        end = C[i]
        start = C[i - 1]
        clockwise_amount = clockwise(N, start, end)
        counter_amount = counter(N, start, end)
        added = min(clockwise_amount, counter_amount)
        total += added
    return total


def clockwise(N: int, start: int, end: int) -> int:
    if start <= end:
        return end - start
    else:
        return N - start + end


def counter(N: int, start: int, end: int) -> int:
    if start >= end:
        return start - end
    else:
        return start + N - end


if __name__ == '__main__':
    print(getMinCodeEntryTime(3, 3, [1, 2, 3]))
    print(getMinCodeEntryTime(10, 4, [9, 4, 4, 8]))
