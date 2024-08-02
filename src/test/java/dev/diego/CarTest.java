package dev.diego;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.diego.enums.CarType;
import dev.diego.enums.Color;
import dev.diego.enums.FuelType;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("Toyota", 2022, 2.5, FuelType.GASOLINE, 
                      CarType.SUV, 4, 5, 200, Color.BLUE, true);
    }

    @Test
    public void testAccelerate() {
        car.accelerate(100);
        assertEquals(100, car.getCurrentSpeed());
        car.accelerate(120);
        assertEquals(100, car.getCurrentSpeed()); // Should not change due to fine
        assertTrue(car.hasFines());
    }

    @Test
    public void testDecelerate() {
        car.accelerate(100);
        car.decelerate(50);
        assertEquals(50, car.getCurrentSpeed());
        car.decelerate(60);
        assertEquals(0, car.getCurrentSpeed()); // Should not be negative
    }

    @Test
    public void testBrake() {
        car.accelerate(100);
        car.brake();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void testCalculateEstimatedTime() {
        car.accelerate(100);
        assertEquals(2.0, car.calculateEstimatedTime(200), 0.01);
        car.brake();
        assertThrows(IllegalArgumentException.class, () -> {
            car.calculateEstimatedTime(200);
        });
    }

    @Test
    public void testHasFines() {
        assertFalse(car.hasFines());
        car.accelerate(250);
        assertTrue(car.hasFines());
    }

    @Test
    public void testTotalFineAmount() {
        assertEquals(0, car.totalFineAmount());
        car.accelerate(250);
        assertEquals(100, car.totalFineAmount());
    }
}
