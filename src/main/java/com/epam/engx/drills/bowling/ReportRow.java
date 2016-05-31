package com.epam.engx.drills.bowling;

import java.util.Date;

/**
 * @author Nurmakanov
 */
public class ReportRow {

    private final String message;
    private final Date date;

    public ReportRow(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
