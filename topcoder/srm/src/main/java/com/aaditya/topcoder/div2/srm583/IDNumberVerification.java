package com.aaditya.topcoder.div2.srm583;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IDNumberVerification {
    public static String verify(String id, String[] regionCodes) {
        Set<String> regionSet = new HashSet<>(Arrays.asList(regionCodes));
        String regionId = id.substring(0, 6);
        if (!regionSet.contains(regionId)) {
            return "Invalid";
        }
        String birthdayId = id.substring(6, 14);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuuMMdd")
                .withResolverStyle(ResolverStyle.STRICT);
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(birthdayId, dateTimeFormatter);
        } catch (Exception e) {
            // If the date does not exist.
            return "Invalid";
        }
        LocalDate first = LocalDate.of(1900, 1, 1);
        LocalDate last = LocalDate.of(2011, 12, 31);
        if (localDate.isAfter(last) || localDate.isBefore(first)) {
            return "Invalid";
        }

        int sequenceId = Integer.parseInt(id.substring(14, 17));
        if (sequenceId == 0) {
            return "Invalid";
        }

        // Compute checksum.
        long ourChecksum = 0;
        for (int i = 0; i < id.length(); i++) {
            ourChecksum = (ourChecksum << 1) % 11;
            char cur = id.charAt(i);
            int pos;
            if (cur != 'X') {
                pos = id.charAt(i) - '0';
            } else {
                pos = 10;
            }
            ourChecksum = (ourChecksum + pos) % 11;
        }

        if (ourChecksum != 1) {
            return "Invalid";
        }

        if (sequenceId % 2 != 0) {
            return "Male";
        } else {
            return "Female";
        }
    }

    public static void main(String[] args) {
        System.out.println(verify("62012319240507058X",
                new String[]{"620123"}));
    }
}
