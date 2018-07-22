package se.miniwa.tribot;

import org.tribot.api.General;
import org.tribot.script.Script;

public abstract class LoopedScript extends Script {
    private int loopDelay;
    private boolean shouldExit;

    public LoopedScript() {
        loopDelay = 10;
    }

    @Override
    public void run() {
        while (!shouldExit) {
            onLoop();
            General.sleep(loopDelay);
        }
    }

    public abstract void onLoop();

    public int getLoopDelay() {
        return loopDelay;
    }

    public void setLoopDelay(int loopDelay) {
        this.loopDelay = loopDelay;
    }

    public boolean shouldExit() {
        return shouldExit;
    }

    public void exit() {
        shouldExit = true;
    }
}
