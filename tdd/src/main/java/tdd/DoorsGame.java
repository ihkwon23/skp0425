package tdd;

public class DoorsGame {
    private int pass;
    private boolean[] doorsState;
    private int doorCount;

    public DoorsGame(int doorCount) {
        this.doorCount = doorCount;

        doorsState = new boolean[doorCount];
    }

    public boolean[] getDoorsState() {
        return doorsState;
    }

    private void updateDoorsState() {
        for (int doorIndex = pass - 1; doorIndex < doorCount; doorIndex += pass)
            doorsState[doorIndex] = !doorsState[doorIndex];
    }

    public void pass() {
        pass++;
        updateDoorsState();
    }
}
