package se.miniwa.tribot.task;

import se.miniwa.tribot.AntiBan;

public abstract class AbstractConditionalTask implements ConditionalTask {
    private AntiBan antiBan;
    private boolean started;

    public AbstractConditionalTask(AntiBan antiBan) {
        this.antiBan = antiBan;
        started = false;
    }

    public abstract void onStart();
    public abstract void onExecute();
    public abstract void onReset();

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public void start() {
        if (!started) {
            onStart();
            started = true;
        }
    }

    @Override
    public void execute() {
        if (!started) {
            start();
        }
        onExecute();
    }

    @Override
    public void reset() {
        onReset();
        started = false;
    }

    @Override
    public boolean executeIfUnfulfilled() {
        if (!isFulfilled()) {
            execute();
            return true;
        } else {
            return false;
        }
    }
}
