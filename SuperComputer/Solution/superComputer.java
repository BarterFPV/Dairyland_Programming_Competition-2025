package SuperComputer.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class superComputer {
    
    public static int toDecimal(String value) {
        int pos = 0;
        int decimal = 0;

        if (value.charAt(0) == '0') {
            // BINARY
            if (value.charAt(1) == 'b') {
                pos = 2;
                char c = value.charAt(pos);

                while (c == '1' || c == '0') {
                    decimal = (decimal * 2) + Character.getNumericValue(c);
                    pos++;
                    if (pos > value.length() - 1) {
                        return decimal;
                    }
                    c = value.charAt(pos);
                }
            }

            // HEXADECIMAL
            if (value.charAt(1) == 'x') {
                pos = 2;
                char c = value.charAt(pos);

                while ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {
                    if (c >= '0' && c <= '9') {
                        decimal = (decimal * 16) + (c - '0');
                    } else if (c >= 'a' && c <= 'f') {
                        decimal = (decimal * 16) + (c - 'a' + 10);
                    } else {
                        decimal = (decimal * 16) + (c - 'A' + 10);
                    }

                    pos++;
                    if (pos > value.length() - 1) {
                        return decimal;
                    }
                    c = value.charAt(pos);
                }
            }

            // OCTAL        
            if ("1234567890".indexOf(value.charAt(1)) != -1) {
                pos = 1;
                char c = value.charAt(pos);

                while ("1234567890".indexOf(c) != -1) {
                    decimal = (decimal * 8) + Character.getNumericValue(c);
                    pos++;
                    if (pos > value.length() - 1) {
                        return decimal;
                    }
                    c = value.charAt(pos);
                }
            }
        } 
        // DECIMAL            
        else if ("1234567890".indexOf(value.charAt(0)) != -1) {
            char c = value.charAt(pos);

            while ("1234567890".indexOf(c) != -1) {
                decimal = (decimal * 10) + Character.getNumericValue(c);
                pos++;
                if (pos > value.length() - 1) {
                    return decimal;
                }
                c = value.charAt(pos);
            }
        } else {
            throw new IllegalArgumentException();
        }
        return decimal;
    }

    public static void superChip(){
        Scanner scanner = new Scanner(System.in);
        int performs = Integer.parseInt(scanner.nextLine());
        List<String> operations = new ArrayList<>();

        for (int i = 0; i < performs; i++) {
            operations.add(scanner.nextLine());
        }

        for (String item : operations) {
            String[] parts = item.split(" ");
            String fvalueStr = parts[0];
            String sign = parts[1];
            String svalueStr = parts[2];

            try {
                if (!"+-*/%**|&^>><<".contains(sign)) {
                    throw new IllegalArgumentException();
                }
                int fvalue = toDecimal(fvalueStr);
                int svalue = toDecimal(svalueStr);

                switch (sign) {
                    case "+":
                        System.out.println(fvalue + svalue);
                        break;
                    case "-":
                        System.out.println(fvalue - svalue);
                        break;
                    case "*":
                        System.out.println(fvalue * svalue);
                        break;
                    case "/":
                        System.out.println(fvalue / svalue);
                        break;
                    case "%":
                        System.out.println(fvalue % svalue);
                        break;
                    case "**":
                        System.out.println((int) Math.pow(fvalue, svalue));
                        break;
                    case "|":
                        System.out.println(fvalue | svalue);
                        break;
                    case "&":
                        System.out.println(fvalue & svalue);
                        break;
                    case "^":
                        System.out.println(fvalue ^ svalue);
                        break;
                    case ">>":
                        System.out.println(fvalue >> svalue);
                        break;
                    case "<<":
                        System.out.println(fvalue << svalue);
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
        scanner.close();
    }
    public static void main(String[] args) {
        superChip();
    }
}
