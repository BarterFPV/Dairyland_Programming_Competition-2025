import sys

def toDecimal(value):
    pos = 0
    decimal = 0
    
    if value[0] == '0': 
        # BINARY
        if value[1] == 'b':
            pos = 2
            c = value[pos]
            
            while c == '1' or c == '0':
                decimal = (decimal * 2) + int(c)
                pos += 1
                if pos > len(value) - 1:
                    return decimal
                c = value[pos] 
        
        # HEXADECIMAL
        if value[1] == 'x':
            pos = 2
            c = ord(value[pos])
            
            while (c >= 48 and c <= 57) or (c >= 97 and c <= 102) or (c >= 65 and c <= 70):
                if c >= 48 and c <= 57:
                    decimal = (decimal * 16) + c - 48
                elif c >= 97 and c <= 102:
                    decimal = (decimal * 16) + c - 87
                else:
                    decimal = (decimal * 16) + c - 55
                
                pos += 1
                if pos > len(value) - 1:
                    return decimal
                c = ord(value[pos])
        
        # OCTAL        
        if value[1] in ['1','2','3','4','5','6','7','8','9','0']:
            pos = 1
            c = value[pos]
            
            while c in ['1','2','3','4','5','6','7','8','9','0']:
                decimal = (decimal * 8) + int(c)
                pos += 1
                if pos > len(value) - 1:
                    return decimal
                c = value[pos]
                
    # DECIMAL            
    elif value[0] in ['1','2','3','4','5','6','7','8','9','0']:
        c = value[pos]
        
        while c in ['1','2','3','4','5','6','7','8','9','0']:
            decimal = (decimal * 10) + int(c)
            pos += 1
            if pos > len(value) - 1:
                return decimal
            c = value[pos]
            
    else:
        raise TypeError()

def superChip ():
    performs = int(input(""))
    operations = []

    for i in range(performs):
        operations.append(input(""))

    for item in operations:
        fvalue, sign, svalue = item.split(" ")
        
        try:
            if sign not in ["+","-","*","/","%","**","|","&","^",">>","<<"]:
                raise TypeError()
            fvalue = toDecimal(fvalue)
            svalue = toDecimal(svalue)
            
            if sign == "+":
                print(fvalue + svalue)
            elif sign == "-":
                print(fvalue - svalue)
            elif sign == "*":
                print(fvalue * svalue)
            elif sign == "/":
                print(fvalue // svalue)
            elif sign == "%":
                print(fvalue % svalue)
            elif sign == "**":
                print(fvalue ** svalue)
            elif sign == "|":
                print(fvalue | svalue)
            elif sign == "&":
                print(fvalue & svalue)
            elif sign == "^":
                print(fvalue ^ svalue)
            elif sign == ">>":
                print(fvalue >> svalue)
            elif sign == "<<":
                print(fvalue << svalue)
            else:
                print("Invalid Input")
        except:
            print("Invalid Input")
    
def main():
    superChip()
        
        
main()
    