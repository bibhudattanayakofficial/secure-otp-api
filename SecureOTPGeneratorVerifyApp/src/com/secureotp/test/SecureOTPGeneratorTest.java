package com.secureotp.test;

import com.secureotp.generate.SecureOTPGenerator;

public class SecureOTPGeneratorTest {

    public static void main(String[] args) {
        /**
         * Test Case 1: Numeric OTP with invalid length (9)
         * - Valid numeric OTP lengths are only 3, 4, or 6
         * - Expected output: "INVALID REQUEST !!!"
         */
        System.out.println("Numeric OTP: " + SecureOTPGenerator.generateOTP(4, true));

        /**
         * Test Case 2: Alphanumeric OTP with invalid length (9)
         * - Valid alphanumeric OTP lengths are only 5, 6, or 8
         * - Expected output: "INVALID REQUEST !!!"
         */
        System.out.println("Alphanumeric OTP: " + SecureOTPGenerator.generateOTP(6, false));
    }
}