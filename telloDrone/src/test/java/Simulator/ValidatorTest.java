package Simulator;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class ValidatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void validateCommands() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }

    @Test
    public void validateSequence() {


    }
}