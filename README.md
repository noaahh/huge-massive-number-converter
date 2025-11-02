# Huge Massive Number Converter
A GUI for converting any number with base higher than 2 and lower than or equal to 65536 to a number with base higher than 2 and lower than or equal to 65536.

## Features

- **Wide Base Support**: Supports conversion between bases 2 to 65536 (inclusive)
- **Base65536 Support**: Full Unicode support for base 65536 using the Unifont font
- **Large Number Handling**: Can handle arbitrarily large numbers using BigInteger
- **User-Friendly GUI**: Simple interface for inputting numbers and selecting bases

## Base65536

Base65536 uses Unicode characters to represent values from 0 to 65535. Each character in base 65536 represents a single "digit" in that base system. For example:
- The number 1000 in base 10 converts to "Ϩ" (U+03E8) in base 65536
- The number 65535 in base 10 converts to "￿" (U+FFFF) in base 65536
- Large numbers are represented as sequences of Unicode characters

The application uses the Unifont font to properly display all Unicode characters needed for base 65536 representation.
