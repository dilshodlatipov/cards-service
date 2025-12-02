package com.example.cardsservice.common;

/**
 * Created by dilshodlatipov748@gmail.com on 01/12/2025
 */
public class PanGenerator {
    public static String generatePan(String bin) {
        int length = 16;
        StringBuilder sb = new StringBuilder(bin);

        while (sb.length() < length - 1) {
            sb.append(CommonUtils.random.nextInt(10));
        }

        sb.append(calculateLuhn(sb.toString()));
        return sb.toString();
    }

    public static Integer calculateLuhn(String number) {
        int sum = 0;
        boolean alternate = true;

        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));

            if (alternate) {
                n *= 2;
                if (n > 9) n -= 9;
            }

            sum += n;
            alternate = !alternate;
        }

        return (10 - (sum % 10)) % 10;
    }
}
