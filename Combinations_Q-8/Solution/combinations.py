def print_combinations(n, path=[]):
    if n == 0:
        print('+'.join(map(str, path)))
        return
    if n < 0:
        return

    for step in [1, 2, 3]:
        print_combinations(n - step, path + [step])

def main():
    nInput = int(input())
    print_combinations(nInput)
    
main()