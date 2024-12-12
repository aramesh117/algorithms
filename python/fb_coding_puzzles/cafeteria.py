from typing import List


def getMaxAdditionalDinersCount(N: int, K: int, M: int, S: List[int]) -> int:
    if M == 0:
        return calculate(N, K)
    S = sorted(S)
    header = calculate(max(0, S[0] - K - 1), K)
    footer = calculate(max(0, N - S[-1] - K), K)
    if len(S) == 1:
        return header + footer

    total = header + footer
    for i in range(1, len(S)):
        total += calculate(max(0, S[i] - 1 - S[i - 1] - 2 * K), K)
    return total


def calculate(segment_length: int, k: int) -> int:
    return -(segment_length // -(k + 1))


if __name__ == '__main__':
    # print(getMaxAdditionalDinersCount(N=10, K=1, M=2, S=[2, 6]))
    print(getMaxAdditionalDinersCount(N=15, K=2, M=3, S=[11, 6, 14]))
