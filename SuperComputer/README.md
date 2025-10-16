You are tasked with creating the "Ship of Supercomputers." This computer will handle critical spaceship operations, including fuel management, trajectory calculations, and various other types of data. Your mission is to write a program that can handle different numeral systems (binary, octal, decimal, and hexadecimal) and perform both arithmetic and bitwise operations between them.

Your program will process a set of operations, where each operation consists of two numbers (possibly in different numeral systems) and an arithmetic or bitwise operator. The goal is to convert both numbers to decimal, perform the operation, and print the result.

The input will first specify the number of operations to perform, followed by the operations themselves. Each operation will include two numbers and an operator. Be aware that the input may sometimes be corrupted, so you need to validate it carefully. Your task is to:

1. Ask for the number of operations.
2. Ask for the operations themselves.
3. Convert the input values to decimal.
4. Perform the specified operation.
5. Print the result in decimal.

Example.
INPUT
4
2 + 3
0b1010 & 0xF
8 << 10
z?[] + 10

OUTPUT 
5
10
8192
Invalid Iput
