def getMaxAdditionalDinersCount(N: int, K: int, M: int, S: List[int]) -> int:
    if M == 0:
        return calculate(N, K)
    sorted(S)
    header = calculate(max(0, S[0] - K), K)
    footer = calculate(max(0, N - S[-1] - K), K)
    if len(S) == 1:
        return header + footer

    total = header + footer
    for i in range(1, len(S)):
        total += calculate(max(0, S[i] - S[i - 1] - 2 * K), K)
    return total


def calculate(segment_length: int, k: int) -> int:
    return -(segment_length // -(k + 1))


if __name__ == '__main__':
    getMaxAdditionalDinersCount()
