## Upday Algorithm Exercise

Write some code, that will flatten an array of arbitrarily nested arrays of integers into a flat array of
integers. e.g. [[1,2,[3]],4] -> [1,2,3,4].

## Solution

The implemented solution uses a recursive approach of flattening each level (the lowest possible level being an Integer itself). This can also be implemented running a loop and alternately using Java 8 stream APIs (as in the Application class).

## Building and testing

Maven is used as the build system. So to build, use:

    ./mvnw clean install

To run the tests, use:

    ./mvnw clean test