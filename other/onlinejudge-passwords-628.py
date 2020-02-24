#!/usr/bin/python3

words = []
rules = []
mode = ''
counter = 0

def replace_zeroes(rule, word):
    zero_count = rule.count('0')
    total = pow(10, zero_count)
    for number in range(total):
        number = str(number)
        zero_missmatch = zero_count - len(number)
        if 0 != zero_missmatch:
            number = '0' * zero_missmatch + number
        zero_position = 0
        target = rule
        for idx in range(zero_count):
            zero_position = rule.find('0', zero_position)
            target = target[0:zero_position] + number[idx] + target[zero_position+1:]
            zero_position += 1
        print(target.replace('#', word))

while True:
    if 0 == counter:
        if 'words' == mode:
            mode = 'rules'
        else:
            # nicht beim ersten durchlauf
            if '' != mode:
                print("--")
                for rule in rules:
                    for word in words:
                        replace_zeroes(rule, word)
                rules = []
                words = []
            mode = 'words'
    line = str(input())
    if "" == line:
        exit()
    elif 0 == counter:
        counter = int(line) + 1
    elif 'words' == mode:
        words.append(line)
    elif 'rules' == mode:
        rules.append(line)
    counter -= 1
