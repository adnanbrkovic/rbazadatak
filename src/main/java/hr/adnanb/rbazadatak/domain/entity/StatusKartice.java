package hr.adnanb.rbazadatak.domain.entity;

public enum StatusKartice {

    PENDING,
    APPROVED,
    REJECTED;

    public static boolean exists(String value) {
        try {
            StatusKartice.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
