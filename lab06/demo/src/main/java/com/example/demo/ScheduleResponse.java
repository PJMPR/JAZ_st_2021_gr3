package com.example.demo;

public class ScheduleResponse {
    public ScheduleResponse(LoanRepaymentSchedule schedule, Iterable<ScheduleRow> scheduleRows) {
        this.schedule = schedule;
        this.scheduleRows = scheduleRows;
    }

    public LoanRepaymentSchedule getSchedule() {
        return schedule;
    }

    public Iterable<ScheduleRow> getScheduleRows() {
        return scheduleRows;
    }

    private LoanRepaymentSchedule schedule;
    private Iterable<ScheduleRow> scheduleRows;

    @Override
    public String toString() {
        return "ScheduleResponse{" +
                "schedule=" + schedule +
                ", scheduleRows=" + scheduleRows +
                '}';
    }
}
