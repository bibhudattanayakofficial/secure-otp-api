package com.secureotp.generate;

import java.security.SecureRandom;

public class SecureOTPGenerator {

	// Allowed characters for numeric OTP
    private static final String DIGITS_FOR_OTP = "0123456789";
    
    // Allowed characters for alphanumeric OTP
    private static final String ALPHANUMERIC_FOR_OTP = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // SecureRandom ensures stronger randomness compared to Random
    private static final SecureRandom random = new SecureRandom();
    
    // Holds the generated OTP or error message
    static String otpMessage = "";

    /**
     * Generates a secure OTP (Numeric or Alphanumeric) based on user requirements.
     *
     * Rules:
     *  - Numeric OTP length must be 3, 4, or 6
     *  - Alphanumeric OTP length must be 5, 6, or 8
     *
     */
	public static String generateOTP(long otpLength, boolean isNumeric) {
		String characters = null; // Characters pool used to generate OTP
		boolean otpFlag = false; // Flag to validate if input rules are correct
		
		// Validate Numeric OTP: allowed lengths are 3, 4, or 6
		if (isNumeric && (otpLength == 3 || otpLength == 4 || otpLength == 6)) {
			otpFlag = true;
		}
		
		// Validate Alphanumeric OTP: allowed lengths are 5, 6, or 8
		if (!isNumeric && (otpLength == 5 || otpLength == 6 || otpLength == 8)) {
			otpFlag = true;
		}

		// If valid input -> Generate OTP
		if (otpFlag) {
			characters = isNumeric ? DIGITS_FOR_OTP : ALPHANUMERIC_FOR_OTP;
			StringBuilder otp = new StringBuilder();
			
			// Loop runs until OTP of required length is generated
			for (long i = 0; i < otpLength; i++) {
				int index = random.nextInt(characters.length()); // Pick random index
				otp.append(characters.charAt(index)); // Append character to OTP
			}

			otpMessage = otp.toString(); // Store generated OTP
			
		} else {
			// Invalid input (length/type combination not allowed)
			otpMessage = "INVALID REQUEST !!!";
		}

		return otpMessage;
	} //generateOTP(-,-) end
}// class