from typing import List


# Write any import statements here

def getMaximumEatenDishCount(N: int, D: List[int], K: int) -> int:
    i = 0
    j = 0
    eaten = set()
    count = 0
    while i < len(D):
        if D[i] not in eaten:
            eaten.add(D[i])
            count += 1
            i += 1
            if len(eaten) > K:
                if D[j] in eaten:
                    eaten.remove(D[j])
                j += 1
                while j < N and D[j] == -1:
                    j += 1

        else:
            D[i] = -1
            i += 1
    # Write your code here
    return count


if __name__ == '__main__':
    print(getMaximumEatenDishCount(N=6, D=[1, 2, 3, 3, 2, 1], K=1))
    print(getMaximumEatenDishCount(N=6, D=[1, 2, 3, 3, 2, 1], K=2))
    print(getMaximumEatenDishCount(N=7, D=[1, 2, 1, 2, 1, 2, 1], K=2))
    print(getMaximumEatenDishCount(N=5, D=[1, 1, 1, 2, 1], K=5))
    print(getMaximumEatenDishCount(N=2, D=[1, 1000000], K=5))
