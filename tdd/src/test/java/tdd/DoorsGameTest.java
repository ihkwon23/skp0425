package tdd;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DoorsGameTest {

    @Test
    public void oneDoor_And_NoPass() {
        DoorsGame doorsGame = new DoorsGame(1);

        assertArrayEquals(new boolean[]{false},
                doorsGame.getDoorsState());
    }

    @Test
    public void oneDoor_And_OnePass() {
        DoorsGame doorsGame = new DoorsGame(1);

        doorsGame.pass();

        boolean[] doorsState = doorsGame.getDoorsState();

        assertArrayEquals(new boolean[]{true},
                doorsState);
    }

    @Test
    public void twoDoors_And_NoPass() {
        DoorsGame doorsGame = new DoorsGame(2);

        assertArrayEquals(new boolean[]{false, false},
                doorsGame.getDoorsState());
    }

    @Test
    public void twoDoors_And_OnePass() {
        DoorsGame doorsGame = new DoorsGame(2);

        doorsGame.pass();

        assertArrayEquals(new boolean[]{true, true},
                doorsGame.getDoorsState());
    }

    @Test
    public void twoDoors_And_TwoPasses() {
        DoorsGame doorsGame = new DoorsGame(2);

        doorsGame.pass();
        doorsGame.pass();

        assertArrayEquals(new boolean[]{true, false},
                doorsGame.getDoorsState());
    }

    @Test
    public void fourDoors_And_OnePass() {
        DoorsGame doorsGame = new DoorsGame(4);

        doorsGame.pass();

        assertArrayEquals(new boolean[]{true, true, true, true},
                doorsGame.getDoorsState());
    }

    @Test
    public void fourDoors_And_twoPasses() {
        DoorsGame doorsGame = new DoorsGame(4);

        doorsGame.pass();
        doorsGame.pass();

        assertArrayEquals(new boolean[]{true, false, true, false},
                doorsGame.getDoorsState());
    }

    @Test
    public void fourDoors_And_threePasses() {
        DoorsGame doorsGame = new DoorsGame(4);

        doorsGame.pass();
        doorsGame.pass();
        doorsGame.pass();

        assertArrayEquals(new boolean[]{true, false, false, false},
                doorsGame.getDoorsState());
    }

    @Test
    public void fourDoors_And_fourPasses() {
        DoorsGame doorsGame = new DoorsGame(4);

        doorsGame.pass();
        doorsGame.pass();
        doorsGame.pass();
        doorsGame.pass();

        assertArrayEquals(new boolean[]{true, false, false, true},
                doorsGame.getDoorsState());
    }
}
