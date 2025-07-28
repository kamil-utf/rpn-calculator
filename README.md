# Simple RPN Calculator
This project is a straightforward console calculator that handles basic arithmetic operations: addition, subtraction, multiplication, and division. It's designed to work with both positive and negative integers.

### How it Works
The calculator is powered by the efficient Reverse Polish Notation (RPN) algorithm, also known as Postfix Notation. This means that instead of the standard 2 + 3 (infix) format, expressions are converted and processed in the 2 3 + order. This way of representing expressions eliminates the need for parentheses and simplifies the calculation process, as the order of operations is unambiguously determined by the operators' positions.

### Supported Operations
* `+` : Addition
* `-` : Subtraction
* `*` : Multiplication
* `/` : Division

### Requirements
Java Development Kit (JDK) 21 + Maven.

### Example Usage:
```declarative
Infix expression: 2 + 3
RPN: 2 3 +
Result: 5

Infix expression: 2 + 3 * 4
RPN: 2 3 4 * +
Result: 14

Infix expression: 10 - 6 / 2
RPN: 10 6 2 / -
Result: 7

Infix expression: 7 + 8 * 2 - 10 / 5
RPN: 7 8 2 * + 10 5 / -
Result: 21
```

### Error Handling
The calculator includes basic error handling that will inform you about:
* Invalid tokens (e.g., unrecognized characters)
* Invalid expression structure (e.g., missing operands for operators)
* Division by zero

