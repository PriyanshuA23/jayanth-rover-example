package com.tw.step.rover.commands;

import com.tw.step.rover.boundary.Boundary;
import com.tw.step.rover.boundary.InfinitePlateau;
import com.tw.step.rover.boundary.Plateau;
import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.position.Direction;
import com.tw.step.rover.position.Navigator;
import com.tw.step.rover.rover.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandExecutionTest {
    @Test
    void shouldExecuteSingleCommands() {
        Navigator navigator = Navigator.create();
        InfinitePlateau boundary = new InfinitePlateau();
        Rover rover = new Rover(new Coordinate(0, 0), Direction.N);

        new TurnLeftCommand(navigator, boundary).execute(rover);
        assertEquals("0 0 W", rover.toString());

        new TurnRightCommand(navigator, boundary).execute(rover);
        assertEquals("0 0 N", rover.toString());

        new MoveCommand(navigator, boundary).execute(rover);
        assertEquals("0 1 N", rover.toString());
    }

    @Test
    void stopExecutingWhenRoverBecomeDead() {
        Navigator navigator = Navigator.create();
        Boundary boundary = new Plateau(new Coordinate(0,0), new Coordinate(2,2));
        Rover rover = new Rover(new Coordinate(0, 0), Direction.N);

        new MoveCommand(navigator, boundary).execute(rover);
        assertEquals("0 1 N", rover.toString());

        new MoveCommand(navigator, boundary).execute(rover);
        assertEquals("0 2 N", rover.toString());

        new MoveCommand(navigator, boundary).execute(rover);
        assertEquals("0 3 N", rover.toString());

        new MoveCommand(navigator, boundary).execute(rover);
        assertEquals("0 3 N", rover.toString());
    }
}
