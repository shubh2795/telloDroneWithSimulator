package Flier;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class FlierTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Test
    public void fly() {
        System.out.print("Enter the number of retries");
        assertEquals("Enter the number of retries", outContent.toString());

    }
}