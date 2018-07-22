package se.miniwa.tribot.task;

public interface ConditionalTask {
    boolean isFulfilled();
    boolean isStarted();
    void start();
    void execute();
    void reset();
    boolean executeIfUnfulfilled();

}